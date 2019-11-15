package Controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;
import Model.DTO.AuthInfo;
import Service.Member.AuthService;
import Validator.LoginCommandValidator;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authService;
	
	private AuthInfo authInfo;
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("command", new LoginCommand());
		return "main/main";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand command, Errors errors,HttpSession session, Model model) {
		model.addAttribute("command", command);
		new LoginCommandValidator().validate(command, errors);
		if(errors.hasErrors()) {
			return "main/main";
		}
		try {
			authInfo = authService.authenticate(command);
			if(authInfo.getPw().equals(Encrypt.Encrypt.getEncryption(command.getPw()))) {
				session.setAttribute("authInfo", authInfo);
			}else {
				errors.rejectValue("pw", "wrongpw");
			}
			return "main/main";
		} catch (Exception e) {
			errors.rejectValue("id1", "wrongid");
			e.printStackTrace();
			return "main/main";
		}
	}
	
	
	
}
