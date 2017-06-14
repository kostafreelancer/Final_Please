package lancer.total.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lancer.total.service.VerificationService;
import lancer.total.util.RandomCode;
import lancer.verification.domain.VerificationVO;

@Controller
@RequestMapping("/verification/*")
public class VerificationController {

	@Inject
	private VerificationService verificationService;

	@RequestMapping(value = "/verificationPop", method = RequestMethod.GET)
	public void verificationpopGET() throws Exception {
	}

	@RequestMapping(value = "/verificationPop", method = RequestMethod.POST)
	public String verificationpopPOST(VerificationVO veriVO, Model model) throws Exception {
		veriVO.setEmailAddr(veriVO.getEmailId() + "@" + veriVO.getEmailDomain());

		Integer f_count = verificationService.checking_freelancer(veriVO);
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
	public String verificationpopPOST2(VerificationVO veriVO, Model model) throws Exception {
		veriVO.setEmailAddr(veriVO.getEmailId() + "@" + veriVO.getEmailDomain());

		Integer f_count = verificationService.checking_freelancer(veriVO);
		Integer e_count = verificationService.checking_enterprise(veriVO);

		String page = "";

		if (veriVO.getSort().equals("f")) {// 프리랜서면
			if (f_count == 1) {// 회원이 있는 것으로 판명. 비밀번호 인증페이지로.
				model.addAttribute("emailAddr", veriVO.getEmailAddr());
				page = "redirect:/verification/emailVerification";

			} else {// 그러한 회원이 없습니다.
				model.addAttribute("fail", "true");
				page = "redirect:/verification/verificationPop2";
			}
		} else {// 기업이면
			if (e_count == 1) {// 회원이 있는 것으로 판명. 비밀번호 인증페이지로.
				model.addAttribute("emailAddr", veriVO.getEmailAddr());
				page = "redirect:/verification/emailVerification";
			} else {// 그러한 회원이 없습니다.
				model.addAttribute("fail", "true");
				page = "redirect:/verification/verificationPop2";
			}
		}
		return page;
	}

	@RequestMapping(value = "/emailVerification", method = RequestMethod.GET)
	public void emailVerificationPOST(VerificationVO veriVO, RandomCode randomNum, Model model) throws Exception {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		System.out.println("인증번호 보낼 메일:");
	}
}
