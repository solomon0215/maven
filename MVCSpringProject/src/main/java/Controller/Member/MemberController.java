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

@Controller
public class MemberController {
	/*
	// http://localhost:8080/MVCSpringProject/register/agree
	//                        url
	//                      /             uri               /
	//         도메인         /
	//                      /   contextPath  /
	//                                       /우리가 원하는 주소  /
	HttpServletRequest request;
	String RequestURI = request.getRequestURI();
	String contextPath = request.getContextPath();
	String command = RequestURI.substring(
			contextPath.length());
	// http://localhost:8080/MVCSpringProject/register/agree
	 */
	@Autowired
	private MemberJoinService memberJoinService;
	
	@RequestMapping("/register/agree")
	public String agree() {
		System.out.println("aaaa");
		return "member/agree";
	}
	@RequestMapping("/register/regist")
	public String  memberForm(
			@RequestParam(value="agree",defaultValue ="false" )
			Boolean agree, Model model) {
		if(!agree) {
			return "member/agree";
		}
		model.addAttribute("memberCommand", new MemberCommand());
		return "member/memberForm";
	}
	@RequestMapping(value= "/register/memberJoinAction", 
			method=RequestMethod.POST)
	public String  memberJoin(MemberCommand memberCommand, Model model
			,Errors errors) {
		new MemberCommandValidator().validate(memberCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberForm";
		}
			Integer i = memberJoinService.execute(memberCommand, model);
			if(i == null) {
				errors.rejectValue("userId", "duplicate");
				return "member/memberForm";
			}
			return "member/memberWelcome";
	}
	@RequestMapping(value= "/register/memberJoinAction", 
			method=RequestMethod.GET)
	public String  memberJoinGet(MemberCommand memberCommand) {
		
		return "redirect:agree";
	}
}











