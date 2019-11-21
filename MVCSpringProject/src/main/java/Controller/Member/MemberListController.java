package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Member.ListCommand;
import Service.Member.MemberListService;

@Controller
public class MemberListController {
	@Autowired
	MemberListService memberListService;
	
	@RequestMapping("/member/list")
	public String list( ListCommand listCommand, 
			Errors errors , Model model) {
		if (errors.hasErrors()) {
			System.out.println("/member/list");
			return "member/memberList";
		}
		if(listCommand.getFrom() != null && listCommand.getTo() != null) {
			memberListService.memberList(model, listCommand);
		}
		return "member/memberList";
	}
}
