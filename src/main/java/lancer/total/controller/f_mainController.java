package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_login.domain.checking_identity;
import lancer.f_main.domain.member;
import lancer.f_main.domain.recommendProject;
import lancer.total.service.f_mainService;

@Controller
@RequestMapping("/f_main/*")
public class f_mainController {
	@Autowired
	JavaMailSender mailsender;
	
	@Inject
	f_mainService service;
	
	@RequestMapping(value="/f_main", method = RequestMethod.GET)
	public void f_mainGET(Model model, member m, HttpSession session) throws Exception{
		
		recommendProject rp = new recommendProject();
		service.getF_info(m);
		service.countFreelancer(); // 활동중인 총 프리랜서 숫자
		service.countProject(); // 등록된 총 프로젝트 숫자
		service.f_create();
		
		
		
		System.out.println(service.countFreelancer() + "프리랜서 숫자");
		System.out.println(service.countProject() + "등록된 프로젝트 숫자");
		System.out.println("??");
		model.addAttribute("m", m);
		model.addAttribute("count", service.countFreelancer());
		model.addAttribute("countP", service.countProject());
		model.addAttribute("f_create", service.f_create());
		model.addAttribute("f_design", service.f_design());
		model.addAttribute("f_planner", service.f_planner());
		//model.addAttribute("recommend", service.recommendProject(f_num));
		
		checking_identity identity = (checking_identity) session.getAttribute("identity");
		int f_num = 0;
		
		System.out.println("..?");
		if(session.getAttribute("client") != null){
		if(identity.getIdentity().equals("freelancer")){
			c_login_freelancerVO vo = (c_login_freelancerVO) session.getAttribute("client");
			f_num = vo.getF_num();
			System.out.println(f_num+"프리번호");
			model.addAttribute("alram", service.alram(f_num));
			model.addAttribute("recommend", service.recommendProject(f_num));
			
			/*System.out.println(service.recommendProject(f_num).toString());*/
			model.addAttribute("f_read", service.f_read(f_num));
			
		
			identity.setIdentity("freelancer");
		}
		}
	}
	
/*	@RequestMapping(value="/f_main", method = RequestMethod.POST)
	public void f_mainPOST(member m , Model model) throws Exception{
		service.getF_info(m);
		service.countFreelancer(); // 활동중인 총 프리랜서 숫자
		service.countProject(); // 등록된 총 프로젝트
		
		System.out.println(m.getF_name() + "이름");
		System.out.println(service.countFreelancer() + "프리랜서 숫자");
		System.out.println(service.countProject() + "등록된 프로젝트 숫자");
		
		model.addAttribute("count", service.countFreelancer());
		model.addAttribute("countP", service.countProject());
		model.addAttribute("m", m);
	}*/
	
	// emailTest
	@RequestMapping(value="emailTest", method = RequestMethod.GET)
	public void emailTest()throws Exception{
		System.out.println("메일테스트");
	}
	
	@RequestMapping(value="/testEmail", method = RequestMethod.POST)
	public ModelAndView sendEmailAction(HttpServletRequest request, ModelAndView mv) throws Exception {
        // 메일 내용을 작성한다
        SimpleMailMessage msg = new SimpleMailMessage();
        //String From = "skidrow0725@gmail.com";
        //System.out.println(From);
       
        //인증번호(랜덤)
        String authNum = randomNum();
        //받는사람
        String email = request.getParameter("email");
        System.out.println(email + "이메일받");
        // 보내는사람
        
        String From = "skidrow0725@gmail.com";
        System.out.println(From + "보내는사람");
        
        //받는사람
        String setTo = email;
        System.out.println(setTo + "받는사람");
        //String setTo = request.getParameter("tomail");
       
        // 제목
        String setSubject = "DreamLancer 이메일 인증입니다.";
        System.out.println(setSubject);
        
        //내용
        String setText1 = "DreamLancer 이메일 인증 코드입니다. [";
        String setText2 = authNum;
        String setText3 = "] 코드를 정확히 입력해 주세요.";
        
        
        msg.setFrom(From);
        msg.setTo(new String[] { setTo });
        msg.setSubject(setSubject);
        msg.setText(setText1 + setText2 + setText3);
 
      try {
		mailsender.send(msg);
		System.out.println("메일보내기 성공");
		System.out.println(setText1 + setText2 + setText3);
	} catch (MailException e) {
		e.printStackTrace();
	}
      
      mv.addObject("authNum", setText2);
      mv.addObject("email",email);
      mv.setViewName("/f_main/emailOK");
        return mv;
    }
	
	
	
	@RequestMapping(value="emailOK", method = RequestMethod.GET)
	public void emailOK(){
		System.out.println("인증페이지");
	}
	
	//난수번호 발생함수
	 public String randomNum(){
     	StringBuffer buffer = new StringBuffer();
     	for(int i=0;i<=6;i++){
     		int n = (int)(Math.random()*10);
     		buffer.append(n);
     	}
     	return buffer.toString();
     }
}
