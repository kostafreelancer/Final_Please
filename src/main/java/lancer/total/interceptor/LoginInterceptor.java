package lancer.total.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_login.domain.checking_identity;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		checking_identity identity = (checking_identity)session.getAttribute("identity");
		System.out.println("여기 identity가 들어 와야 하는곳인데  순서가?");
		if(identity.getIdentity().equals("no")){
			response.sendRedirect("/c_login/login");
		}
		/*if(identity.getIdentity().equals("enterprise")){
			response.sendRedirect("/f_main/f_main");
		}*/
		if(session.getAttribute("client") != null){
			logger.info("new login success");
			System.out.println("new login success");
			Object dest = session.getAttribute("dest");
			
			if(dest != null){
				response.sendRedirect((String)dest);
			}else if(identity.getIdentity().equals("freelancer")){
				response.sendRedirect("/f_main/f_main");
			}else if(identity.getIdentity().equals("enterprise")){
				response.sendRedirect("/e_main/e_main");
			}
		}
	}
		
}
