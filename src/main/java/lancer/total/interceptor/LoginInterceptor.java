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
import lancer.total.service.c_loginService;
import lancer.total.service.c_loginServiceImpl;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	c_loginService service = new c_loginServiceImpl();
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		checking_identity identity = (checking_identity)session.getAttribute("identity");
		if(identity.getIdentity().equals("no")){
			response.sendRedirect("/c_login/login");
		}

		if(session.getAttribute("client") != null){
			logger.info("new login success");
			System.out.println("new login success");
			Object dest = session.getAttribute("dest");
			/*if(identity.getIdentity().equals("freelancer")){
				System.out.println(((c_login_freelancerVO)(session.getAttribute("client"))).getF_num()+"이거이거");
				int chang_num = service.chang_check(((c_login_freelancerVO)(session.getAttribute("client"))).getF_num());
				System.out.println("여기서 에러 나는거야?"+chang_num);
				session.setAttribute("chang_check", chang_num);
			}*/
			
			
			if(dest != null){
				response.sendRedirect((String)dest);
			}else if(identity.getIdentity().equals("freelancer")){
				response.sendRedirect("/f_main/f_main");
			}else if(identity.getIdentity().equals("enterprise")){
				response.sendRedirect("/e_main/e_main");
			}else if(identity.getIdentity().equals("admin")){
				response.sendRedirect("/a_main/a_main");
			}
		}
	}
		
}
