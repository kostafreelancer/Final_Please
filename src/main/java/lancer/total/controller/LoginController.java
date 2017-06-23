package lancer.total.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.Location;
import javax.xml.ws.RespectBinding;

/*import org.apache.catalina.util.RequestUtil;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import lancer.c_login.domain.c_loginVO;
import lancer.c_login.domain.c_login_alramVO;
import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_login.domain.c_login_url;
import lancer.c_login.domain.checking_identity;
import lancer.f_mypage.domain.Freelancer;
import lancer.total.service.c_loginService;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;


@Controller
@RequestMapping("/c_login/*")
public class LoginController {
	
	@Inject
	c_loginService service;
	
	@RequestMapping(value = "login", method= RequestMethod.GET)
	public String login(HttpServletResponse response) throws IOException{
		return "/c_login/login";
	}
	@RequestMapping(value="loginpost" , method= RequestMethod.GET)
	public void loginpost(){
		
	}
	@RequestMapping(value="/insert.c_login")
	public String check_login(c_loginVO vo,@ModelAttribute("checking") String checked,Model model,HttpSession session, RedirectAttributes rttr){
		checking_identity identity = new checking_identity();
		
		if(checked.equals("freelancer")){
			
			if(service.select_f_login(vo)!=null){
				identity.setFree(service.select_f_login(vo));
				identity.setIdentity(checked);
				session.setAttribute("client",identity.getFree());
				
			}else{
				if(service.select_f_login_idcheck(vo)==null){
					rttr.addFlashAttribute("msg", "idcheck");
				}else{
					rttr.addFlashAttribute("msg", "no");
				}
				identity.setIdentity("no");
				
				return "redirect:/c_login/login";
			}
			session.setAttribute("identity", identity);
			int chang_num = ((c_login_freelancerVO)(session.getAttribute("client"))).getF_num();
			session.setAttribute("chang_num", service.chang_check(chang_num));
			List<c_login_alramVO> a_list = service.alram_contents(identity.getFree().getF_num());
			session.setAttribute("a_list", a_list);
			for(int i=0;i<a_list.size();i++){
				System.out.println(a_list.get(i).getP_name()+"이거 프로젝트 명 ");
			}
		}else if(checked.equals("enterprise")){
			if(service.select_e_login(vo)!=null){
				identity.setEnter(service.select_e_login(vo));
				identity.setIdentity(checked);
				session.setAttribute("client",identity.getEnter());
				
			}else{
				/*identity.setIdentity("no");
				rttr.addFlashAttribute("msg", "no");
				return "redirect:/c_login/login";*/
				if(service.select_e_login_nocheck(vo)!=null){
					System.out.println("여기 들어 오는거 아냐?");
					rttr.addFlashAttribute("msg", "nocheck");
				}else if(service.select_e_login_idcheck(vo)==null){
					rttr.addFlashAttribute("msg", "idcheck");
				}else{
					rttr.addFlashAttribute("msg", "no");
				}
				identity.setIdentity("no");
				return "redirect:/c_login/login";
			}
			session.setAttribute("identity", identity);
		}else if(checked.equals("admin")){
			if(service.select_a_login(vo)!=null){
				identity.setAdmin((service.select_a_login(vo)));
				identity.setIdentity(checked);
				session.setAttribute("client",identity.getAdmin());
				
			}else{
				identity.setIdentity("no");
				rttr.addFlashAttribute("msg", "no");
				return "redirect:/c_login/login";
			}
			session.setAttribute("identity", identity);
		}
		return "redirect:/c_login/loginpost";
	}
	
	@RequestMapping(value="/logout" ,method= RequestMethod.POST )
	public void logout(HttpServletRequest request, HttpServletResponse response,HttpSession session,@RequestBody c_login_url url) throws IOException{
		session.invalidate();
		
		
	}
	@RequestMapping(value="/e_logout", method= RequestMethod.GET)
	public String logout(HttpSession session){
		System.out.println("여기 e로그아웃 들어 오는거지?");
		session.invalidate();
		return "redirect:/f_main/f_main";
	}
	@RequestMapping(value="/client")
	public String client(){
		return "redirect:http://localhost:8000/client";
	}
	@RequestMapping(value="iframe_remove")
	public void iframe_remove(){
		System.out.println("여기 들어와??");
	}
	
	@ResponseBody
	@RequestMapping(value="/validateRecaptcha", method = RequestMethod.POST)
	public String validateRecaptcha(@RequestParam Map<String, String> paramMap) {
	     
	    String check = "Y";
	     
	    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	    reCaptcha.setPrivateKey("6LfYlSYUAAAAAKDiknP7QAjP2-xrQnbhbC2TR6bj");//Secret key
	 
	    String host = paramMap.get("host");
	    String challenge = paramMap.get("challenge");
	    String res = paramMap.get("response");
	     
	    ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(host, challenge, res);
	 
	    if (reCaptchaResponse.isValid()) {
	        System.out.println("true");
	        check = "Y";
	    } else {
	        System.out.println("false");
	        check = "N";
	    }
	     
	    return check;
	 
	}

}
