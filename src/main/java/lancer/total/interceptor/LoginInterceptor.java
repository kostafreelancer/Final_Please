package lancer.total.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("여기는 언제 들어 오지??");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("idnetity")+"아이덴티티");
		System.out.println(session.getAttribute("client")+"이것도 널이야?");
		if(session.getAttribute("client") != null){
			System.out.println("identity에 들어 오지?");
			logger.info("new login success");
			System.out.println("new login success");
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null ? (String)dest:"/");
		}
	}
		
}
