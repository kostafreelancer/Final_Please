package lancer.total.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import org.apache.catalina.util.RequestUtil;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.RequestPartServletServerHttpRequest;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import lancer.c_login.domain.c_loginVO;
import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_login.domain.checking_identity;
import lancer.f_mypage.domain.Freelancer;
import lancer.total.service.c_loginService;


@Controller
@RequestMapping("/c_login/*")
public class LoginController {
	
	@Inject
	c_loginService service;
	
	@RequestMapping(value = "login", method= RequestMethod.GET)
	public void login(){
	
	}
	@RequestMapping(value="loginpost" , method= RequestMethod.GET)
	public void loginpost(){
		
	}
	@RequestMapping(value="/insert.c_login")
	public String check_login(c_loginVO vo,@ModelAttribute("checking") String checked,Model model,HttpSession session){
		checking_identity identity = new checking_identity();
		
		if(checked.equals("freelancer")){
			/*if(service.select_f_login(vo) == null){
				return "redirect:/c_login/login";
			}*/
			identity.setFree(service.select_f_login(vo));
			identity.setIdentity(checked);
			session.setAttribute("client",identity.getFree());
			session.setAttribute("identity", identity);
		}else if(checked.equals("enterprise")){
		/*	if(service.select_e_login(vo) == null){
				
				return "redirect:/c_login/login";
			}*/
			identity.setEnter(service.select_e_login(vo));
			identity.setIdentity(checked);
			session.setAttribute("client",identity.getEnter());
			session.setAttribute("identity", identity);
			
		}
		System.out.println("여기가 실행되고 인터셉터가 실행이 되야 한다!");
		return "redirect:/c_login/loginpost";
	}
	
	@RequestMapping("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws IOException{
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		session.invalidate();
		System.out.println("여기 들어 온거 맞어? 로그아웃으로?");
		
		response.sendRedirect(uri+query);
	}
}
