package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//  차단 
public class AuthCheckInterceptor 
					extends HandlerInterceptorAdapter{
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		// session이 없을 때만 Interceptor
		HttpSession session = request.getSession(false);		
		if (session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if (authInfo != null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath()+"/main");
		return false;
	}
}






