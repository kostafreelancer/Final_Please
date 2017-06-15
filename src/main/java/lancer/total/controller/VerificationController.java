package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.total.service.VerificationService;
import lancer.total.util.RandomCode;
import lancer.verification.domain.VerificationVO;

@Controller
@RequestMapping("/verification/*")
public class VerificationController {

	@Inject
	private VerificationService verificationService;
	@Autowired
	JavaMailSender mailsender;

	@RequestMapping(value = "/verificationPop", method = RequestMethod.GET)
	public void verificationpopGET() throws Exception {
	}

	@RequestMapping(value = "/verificationPop", method = RequestMethod.POST)
	public String verificationpopPOST(VerificationVO veriVO, Model model) throws Exception {
		veriVO.setEmailAddr(veriVO.getEmailId() + "@" + veriVO.getEmailDomain());

		Integer f_count = verificationService.checking_freelancer(veriVO);
		System.out.println("체킹프리"+f_count);
		Integer e_count = verificationService.checking_enterprise(veriVO);

		String f_id = verificationService.verifying_freelancer_id(veriVO);
		String e_id = verificationService.verifying_enterprise_id(veriVO);

		if (veriVO.getSort().equals("f")) {// 프리랜서면
			if (f_count == 1) {// 회원이 있는 것으로 판명. 아이디 확인되었습니다.
				model.addAttribute("f_id", f_id);

			} else {// 그러한 회원이 없습니다.
				model.addAttribute("fail", "true");

			}
		} else {// 기업이면
			if (e_count == 1) {// 회원이 있는 것으로 판명. 아이디 확인되었습니다.
				model.addAttribute("e_id", e_id);

			} else {// 그러한 회원이 없습니다.
				model.addAttribute("fail", "true");

			}
		}
		return "/verification/verificationPop";
		
	}

	@RequestMapping(value = "/verificationPop2", method = RequestMethod.GET)
	public void verificationpopGET2() throws Exception {
	}

	@RequestMapping(value = "/verificationPop2", method = RequestMethod.POST)
	public String verificationpopPOST2(VerificationVO veriVO, HttpSession session, Model model) throws Exception {
		veriVO.setEmailAddr(veriVO.getEmailId() + "@" + veriVO.getEmailDomain());

		Integer f_count = verificationService.checking_freelancer(veriVO);
		Integer e_count = verificationService.checking_enterprise(veriVO);

		String page = "";

		if (veriVO.getSort().equals("f")) {// 프리랜서면
			if (f_count == 1) {// 회원이 있는 것으로 판명. 비밀번호 인증페이지로.
				model.addAttribute("id", veriVO.getId());
				model.addAttribute("name", veriVO.getName());
				model.addAttribute("emailAddr", veriVO.getEmailAddr());
				page = "redirect:/verification/emailVerification";

			} else {// 그러한 회원이 없습니다.
				model.addAttribute("fail", "true");
				page = "/verification/verificationPop2";
			}
		} else {// 기업이면
			if (e_count == 1) {// 회원이 있는 것으로 판명. 비밀번호 인증페이지로.
				model.addAttribute("id", veriVO.getId());
				model.addAttribute("name", veriVO.getName());
				model.addAttribute("emailAddr", veriVO.getEmailAddr());
				page = "redirect:/verification/emailVerification";
			} else {// 그러한 회원이 없습니다.
				model.addAttribute("fail", "true");
				page = "/verification/verificationPop2";
			}
		}
		return page;
	}

	@RequestMapping(value = "/emailVerification", method = RequestMethod.GET)
	public void emailVerificationGET(VerificationVO veriVO, Model model) throws Exception {
		System.out.println("이메일 인증번호 주는 페이지에서 이메일 넘어오나?: "+veriVO.getEmailAddr());
		RandomCode randomNum = new RandomCode(); 
		String codeNum = randomNum.start();
		SimpleMailMessage msg = new SimpleMailMessage();
		
		// 보내는사람
        String From = "skidrow0725@gmail.com";
        System.out.println(From + "보내는사람");
        
        //받는사람
        //String To = veriVO.getEmailAddr();
        String To = "cheolsukim001@gmail.com";
        System.out.println(To + "받는사람");
        
        // 제목
        String setSubject = "DreamLancer 비번 찾기 인증입니다.";
        System.out.println(setSubject);
        
        //내용
        String setText = "DreamLancer 비번 찾기 인증 코드입니다. [ ";
        String setText2 = " ] 코드를 정확히 입력해 주세요.";
        String Content = setText + codeNum + setText2;
        
		msg.setFrom(From);
		msg.setTo(new String[] { To });
		msg.setSubject(setSubject);
		msg.setText(Content);

		try {
			mailsender.send(msg);
			System.out.println("메일보내기 성공");
			System.out.println(Content);
		} catch (MailException e) {
			e.printStackTrace();
		}
        
		model.addAttribute(Content);
		model.addAttribute("codeNum", codeNum);
		
		
	}
	
	@RequestMapping(value = "/emailVerification", method = RequestMethod.POST)
	public String emailVerificationPOST(HttpServletRequest request,VerificationVO veriVO, Model model) throws Exception {
		
		
		String f_pwd = verificationService.verifying_freelancer_pwd(veriVO);
		System.out.println("프리 비번: "+f_pwd);
		String e_pwd = verificationService.verifying_enterprise_pwd(veriVO);
		System.out.println("솜이 비번: "+e_pwd);
		
		model.addAttribute("f_pwd", f_pwd);
		model.addAttribute("e_pwd", e_pwd);
		
		return "/verification/verificationPop";
	}
}
