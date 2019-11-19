package Controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.Member.MemberCommand;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
import Service.Member.MemberDetailService;
import Service.Member.MemberModifyService;
import Validator.MemberCommandValidator;

@Controller
public class MemberDetailController {
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberModifyService memberModifyService;
	
	@RequestMapping("/member/memberDetail")
	public String memberDetail(HttpSession session,Model model) {
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		try {
			MemberDTO member = 
					memberDetailService.memberDetail(authInfo);
			model.addAttribute("member", member);
		}catch(Exception e) { 
			e.printStackTrace();
		}
		return "member/memberDetail";
	}
	@RequestMapping("/member/memberModify")
	public String memberModify(HttpSession session,Model model) {
		AuthInfo authInfo = 
				(AuthInfo)session.getAttribute("authInfo");
		try {
			MemberDTO member = 
					memberDetailService.memberDetail(authInfo);
			model.addAttribute("memberCommand", member);
		}catch(Exception e) { 
			e.printStackTrace();
			model.addAttribute("memberCommand", new MemberDTO());
		}
		return "member/memberModify";
	}
	@RequestMapping("/member/memberModifyPro")
	// memberModify.jsp로 부터 가져온 값을 memberCommand에 저장되어 있다.
	public String memberModifyPro(HttpSession session, 
			MemberCommand memberCommand, Errors errors) {
		System.out.println("memberModifyPro");
		// validate에서 pw와 pwCon을 비교해야 하는데 memeberModify에서 
		// pwCon을 받아오지 못했으므로 pw값을 pwCon에 저장 
		memberCommand.setUserPwCon(memberCommand.getUserPw());
		
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			System.out.println("memberModifyProError");
			return "member/memberModify";
		}
		// memberCommand에는 userId가 저장되어 있지 않으므로 session으로 부터 가져옴
		memberCommand.setUserId(
				((AuthInfo)session.getAttribute("authInfo")).getId());
		// memberCommand가 가지고 있는 값을 update하기 위해 인자로 넘긴다.  
		Integer result = memberModifyService.memberModify(memberCommand);
		if(result > 0) {
			return "redirect:memberDetail";
		}else {
			errors.rejectValue("userPw", "badPw");
			return "member/memberModify";
		}
	}
}













