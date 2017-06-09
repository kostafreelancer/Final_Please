package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(value="/a_mailsender", method=RequestMethod.GET)
	public void mailsender(@RequestParam("f.f_num") int f_num, Model model) throws Exception{
		
		
		System.out.println(f_num);
		model.addAttribute("freelancer", service.getF_mail(f_num));
		
	}
	@RequestMapping(value="/a_mailsenderSubmit", method=RequestMethod.POST)
	public void sendEmailAction(HttpServletRequest request) throws Exception {
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
		// TODO: handle exception
	}
        
    }
	@RequestMapping(value = "/a_main", method = RequestMethod.GET)
	public void a_mainGET(Model model,HttpSession session)throws Exception{
		
		model.addAttribute("listFreelancer", service.listFreelancer());
		model.addAttribute("listEnterprise", service.listEnterprise());
		model.addAttribute("listEnterprisePermit", service.listEnterprisePermit());
		
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
}
