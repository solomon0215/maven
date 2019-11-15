package Controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.LoginCommand;

@Controller
@RequestMapping("/main")
public class MainController {
	@RequestMapping(method = RequestMethod.GET)
	public String form(Model model) {
		model.addAttribute("command", new LoginCommand());
		return "main/main";
	}
	
}
