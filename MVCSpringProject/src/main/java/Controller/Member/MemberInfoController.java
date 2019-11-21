package Controller.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Service.Member.MemberDetailService;

@Controller
public class MemberInfoController {
	@Autowired
	private MemberDetailService memberDetailService;
	@RequestMapping("/member/memberInfo/{id}")
	public String memberInfo(@PathVariable("id") String userId, 
			Model model) {
		AuthInfo authInfo = new AuthInfo();
		authInfo.setId(userId);
		try {
			MemberDTO memberDTO =
					memberDetailService.memberDetail(authInfo);
			model.addAttribute("member",memberDTO);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "member/memberInfo";
	}
}
