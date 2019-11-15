package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
import Service.Member.MemberJoinService;
import Validator.MemberCommandValidator;

//  http://localhost:8080/MVCSpringProject/register/agree
//						url								/
//						 / 			uri 				/
// 			domain		 /
// 						 / contextPath    /
//										  / 快府啊 盔窍绰 林家 /
@Controller
public class MemberController {
	@Autowired
	private MemberJoinService memberJoinService;

	@RequestMapping("/register/agree")
	public String agree() {
		System.out.println("/register/agree");
		return "member/agree";
	}

	@RequestMapping("/member/regist")
	public String memberForm(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, Model model) {
		System.out.println("/member/agree");
		model.addAttribute("memberCommand", new MemberCommand());
		if (!agree) {
			return "member/agree";
		}
		return "member/memberForm";
	}

	@RequestMapping(value = "/member/memberJoinAction", method = RequestMethod.POST)
	public String join(MemberCommand memberCommand, Model model, Errors errors) {
		System.out.println("/member/memberJoinAction");
		new MemberCommandValidator().validate(memberCommand, errors);
		if (errors.hasErrors()) {
			return "member/memberForm";
		}
		Integer result = memberJoinService.execute(memberCommand, model);
		System.out.println(result);
		if (result == 0) {
			errors.rejectValue("userId", "duplicate");
			return "member/memberForm";
		}
		return "member/memberWelcom";

	}

	@RequestMapping(value = "/member/memberJoinAction", method = RequestMethod.GET)
	public String memberJoinGet() {
		return "redirect:../register/agree";
	}
}
