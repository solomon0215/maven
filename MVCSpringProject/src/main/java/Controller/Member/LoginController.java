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
import Validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	AuthService authService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form(LoginCommand loginCommand) {
		return "Main/main";
	}
	//response 는 페이지의 형태 바꿈, sendRedirect, Cookie 생성 역할
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand loginCommand, Errors errors,
			HttpSession session,Model model, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return "Main/main";
		}
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
		return "Main/main";
	}
}









