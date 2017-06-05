package lancer.total.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/c_membercenter/*")
public class c_memberCenterEmailController {

	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/member_centerMain", method=RequestMethod.GET)
	public void getMailSending(){
		System.out.println("^^");
	}
	
	/*@RequestMapping(value="/member_centerMain", method=RequestMethod.POST)
	public String mailSending(HttpServletRequest request){
		
		System.out.println("T.T");
		String setForm = "skidrow0725@gmail.com";
		System.out.println(setForm);
		String tomail = request.getParameter("tomail");
		System.out.println(tomail);
		String title = request.getParameter("title");
		System.out.println(title);
		String content = request.getParameter("content");
		System.out.println(content);
		
		try {
			System.out.println("try");
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setForm);
			messageHelper.setTo(tomail);
			messageHelper.setSubject(title);
			messageHelper.setText(content);
 		} catch (Exception e) {
 			System.out.println("?.?");
			e.printStackTrace();
		}
		System.out.println("메일보내기 성공");
		return "redirect:/c_membercenter/member_centerMain";
	}*/
	
	@RequestMapping(value="/member_centerMain", method=RequestMethod.POST)
	public void sendEmailAction(HttpServletRequest request) throws Exception {
        // 메일 내용을 작성한다
        SimpleMailMessage msg = new SimpleMailMessage();
        //String From = "skidrow0725@gmail.com";
        //System.out.println(From);
        
        // 보내는사람
        
        String From = request.getParameter("tomail");
        System.out.println(From + "보내는사람");
        
        //받는사람
        String setTo = "skidrow0725@gmail.com";
        System.out.println(setTo);
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
            mailSender.send(msg);
        } catch (MailException ex) {
            // 적절히 처리
        }
        
    }

}
