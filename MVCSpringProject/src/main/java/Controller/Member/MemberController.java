package Controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {
	@RequestMapping("/register/agree")
	public String agree() {
		System.out.println("/register/agree");
		return "member/agree";
	}
	
	@RequestMapping("/register/regist")
	public String memberForm() {
		System.out.println("/register/agree");
		return "member/memberForm";
	}
}
