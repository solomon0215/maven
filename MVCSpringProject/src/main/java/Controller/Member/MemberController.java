package Controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.Member.MemberCommand;
//  http://localhost:8080/MVCSpringProject/register/agree
//						url								/
//						 / 			uri 				/
// 			domain		 /
// 						 / contextPath    /
//										  / 快府啊 盔窍绰 林家 /
@Controller
public class MemberController {
	@RequestMapping("/register/agree")
	public String agree() {
		System.out.println("/register/agree");
		return "member/agree";
	}
	
	@RequestMapping("/member/regist")
	public String memberForm(
			@RequestParam(value="agree", defaultValue = "false" ) Boolean agree) {
		System.out.println("/member/agree");
		if(!agree) {
			return "member/agree";
		}
		return "member/memberForm";
	}
	
	@RequestMapping(value="/member/memberJoinAction", method = RequestMethod.POST)
	public String join(MemberCommand memberCommand) {
		System.out.println(memberCommand.getUserBirth());
		System.out.println("/member/memberJoinAction");
		return "member/memberWelcom";
	}
	@RequestMapping(value="/member/memberJoinAction", method = RequestMethod.GET)
	public String memberJoinGet() {
		return "redirect:../register/agree";
	}
}
