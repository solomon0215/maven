package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public String logout(HttpSession session,
			HttpServletResponse response) {
		session.invalidate();
		Cookie autoLoginCookie = new Cookie("AutoLogin","1111");
		autoLoginCookie.setMaxAge(0);
		response.addCookie(autoLoginCookie);
		return "redirect:/main";
	}
}
