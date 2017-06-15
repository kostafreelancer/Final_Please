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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lancer.a_main.domain.Criteria;
import lancer.a_main.domain.PageMaker;
import lancer.a_main.domain.askList;
import lancer.total.service.A_MainService;
import lancer.total.service.C_DropService;

@Controller
@RequestMapping("/a_main/*")
public class A_MainController {

	@Inject
	private A_MainService service;
	@Inject
	private C_DropService dropService;
	@Autowired
	private JavaMailSender mailsender;
	
	
	//관리자 이메일보내기 기능
	
	//이메일 보내기 성공시
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public void success() throws Exception{
		System.out.println("메일보냈당");
	}
	//메일발송 클릭시 새창에서 이메일값 가져오기 (프리랜서)
	@RequestMapping(value="/a_mailsender", method=RequestMethod.GET)
	public void mailsender(@RequestParam("f.f_num") int f_num, Model model) throws Exception{
		
		
		System.out.println(f_num + "프리랜서번호");
		model.addAttribute("freelancer", service.getF_mail(f_num));
		
	}
	//메일발송 클릭시 새창에서 이메일값 가져오기(기업)
	@RequestMapping(value="/a_mailsender_e", method=RequestMethod.GET)
	public void mailsender_e(@RequestParam("e.e_num") int e_num, Model model) throws Exception{
		System.out.println(e_num + "기업번호");
		model.addAttribute("enterprise", service.getE_mail(e_num));
	}
	
	//메일보내기
	@RequestMapping(value="/a_mailsenderSubmit", method=RequestMethod.POST)
	public String sendEmailAction(HttpServletRequest request) throws Exception {
        // 메일 내용을 작성한다
        SimpleMailMessage msg = new SimpleMailMessage();
        //String From = "skidrow0725@gmail.com";
        //System.out.println(From);
        
        // 보내는사람
        
        String From = "skidrow0725@gmail.com";
        System.out.println(From + "보내는사람");
        
        //받는사람
        String setTo = request.getParameter("tomail");
        System.out.println(setTo + "받는사람");
        //String setTo = request.getParameter("tomail");
       
        // 제목
        String setSubject = request.getParameter("title");
        System.out.println(setSubject);
        
        //내용
        String setText = request.getParameter("content");
        System.out.println(setText);
        
        msg.setFrom(From);
        msg.setTo(new String[] { setTo });
        msg.setSubject(setSubject);
        msg.setText(setText);
 
      try {
		mailsender.send(msg);
		System.out.println("메일보내기 성공");
	} catch (MailException e) {
		e.printStackTrace();
	}
        return "redirect:/a_main/success";
    }
	
	
	@RequestMapping(value = "/a_main", method = RequestMethod.GET)
	public void a_mainGET(@ModelAttribute("cri") Criteria cri, Integer tabnum, Model model,HttpSession session)throws Exception{
		model.addAttribute("tabnum", tabnum);
		
		model.addAttribute("listFreelancer", service.listFreelancer(cri));
		model.addAttribute("listEnterprise", service.listEnterprise(cri));
		model.addAttribute("listEnterprisePermit", service.listEnterprisePermit(cri));
		model.addAttribute("askList",service.askList(cri));
		model.addAttribute("answerOK",service.answerOK(cri));
		
		PageMaker pageMakerFreelancer =  new PageMaker();
		pageMakerFreelancer.setCri(cri);
		pageMakerFreelancer.setTotalCount(service.countFreelancer());
		
		PageMaker pageMakerEnterprise =  new PageMaker();
		pageMakerEnterprise.setCri(cri);
		pageMakerEnterprise.setTotalCount(service.countEnterprise());
		
		PageMaker pageMakerEnterprisePermit =  new PageMaker();
		pageMakerEnterprisePermit.setCri(cri);
		pageMakerEnterprisePermit.setTotalCount(service.countEnterprisePermit());
		
		PageMaker pageMakerAskList =  new PageMaker();
		pageMakerAskList.setCri(cri);
		pageMakerAskList.setTotalCount(service.countAskList());
		
		PageMaker pageMakerAnswerOK =  new PageMaker();
		pageMakerAnswerOK.setCri(cri);
		pageMakerAnswerOK.setTotalCount(service.countAnswerOK());
		
		model.addAttribute("pageMakerFreelancer", pageMakerFreelancer);
		model.addAttribute("pageMakerEnterprise", pageMakerEnterprise);
		model.addAttribute("pageMakerEnterprisePermit", pageMakerEnterprisePermit);
		model.addAttribute("pageMakerAskList", pageMakerAskList);
		model.addAttribute("pageMakerAnswerOK", pageMakerAnswerOK);
		
	}
	
	@RequestMapping(value = "/a_deleteF", method = RequestMethod.POST)
	public String a_deleteFPOST(@RequestParam("deleteF_num") int deleteF_num)throws Exception{
		dropService.deleteFreelancer(deleteF_num);
		
		return "redirect:/a_main/a_main";
	}
	
	@RequestMapping(value = "/a_deleteE", method = RequestMethod.POST)
	public String a_deleteEPOST(@RequestParam("deleteE_num") int deleteE_num)throws Exception{
		dropService.deleteEnterprise(deleteE_num);
		
		return "redirect:/a_main/a_main";
	}
	
	@RequestMapping(value = "/a_permit", method = RequestMethod.POST)
	public String a_permitPOST(@RequestParam("permitE_num") int permitE_num)throws Exception{
		service.permitAccount(permitE_num);
		
		return "redirect:/a_main/a_main";
	}
	
	@RequestMapping(value="/a_read", method = RequestMethod.GET)
	public void a_read(@RequestParam("asknum") int asknum, Model model)throws Exception{
		model.addAttribute("askcontents", service.askcontents(asknum));
		System.out.println("asd");
	}
	
	@RequestMapping(value="/updateAnswer", method = RequestMethod.POST)
	public String updateAnswer(askList al, Model model)throws Exception{
		service.doAsk(al);
		return "redirect:/a_main/askSuccess";
	}
	
	@RequestMapping(value="askSuccess")
	public void askSuccess() throws Exception{
		System.out.println("답변했당");
	}
	
	
}
