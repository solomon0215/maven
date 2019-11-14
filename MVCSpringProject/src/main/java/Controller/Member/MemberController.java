package Controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
}
