package Controller.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;
import Encrypt.Encrypt;
import Model.DTO.AuthInfo;
import Service.Member.AuthService;

@Controller
@RequestMapping("/main")
public class MainCotroller {
	@Autowired
	AuthService authService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(LoginCommand loginCommand, @CookieValue(value = "REMEMBER", required = false) Cookie rememberCookie
			,@CookieValue(value = "AUTOLOGINID", required = false) Cookie autoLoginId,
			@CookieValue(value = "AUTOLOGINPW", required = false) Cookie autoLoginPw,
			Errors errors, HttpSession session, HttpServletResponse response) {
		if(rememberCookie != null) {
			loginCommand.setId1(rememberCookie.getValue());
			loginCommand.setIdStore(true);
		}
		if(autoLoginId !=null && autoLoginPw != null) {
			loginCommand.setId1(autoLoginId.getValue());
			loginCommand.setPw(autoLoginPw.getValue());
			loginCommand.setAutoLogin(true);
			try {
				AuthInfo authInfo = 
						authService.authenticate(loginCommand, response);
				if(authInfo.getPw().equals(
						Encrypt.getEncryption(loginCommand.getPw()))) {
					session.setAttribute("authInfo",authInfo);
				}else {
					errors.rejectValue("pw","wrong");
				}
			}catch(Exception e) {
				errors.rejectValue("id1","notId");			
			}
		}
		return "Main/main";
	}
}
