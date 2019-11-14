package Controller.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MemberController {
	@RequestMapping("/regeister/agree")
	public String agree() {
		return "member/agree";
	}
}
