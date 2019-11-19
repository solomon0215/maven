package Controller.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Service.Member.ChangePwService;
import Validator.ChangePwdCommandValidator;

@Controller
@RequestMapping("/edit/changePassword")
public class MemberPasswordController {
	@Autowired
	private ChangePwService changePwService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String memPw(@ModelAttribute("changePwdCommand") 
								ChangePwdCommand pwCmd) {
		return "member/memberPw";
	}
	@RequestMapping(method = RequestMethod.POST)
	// session을 통해서 id값을 가져오기 위해  HttpSession객체 생
	public String changePw(ChangePwdCommand changePwdCommand,
									Errors errors, HttpSession session) {
		changePwdCommand.setNewPassword(changePwdCommand.getCurrentPassword());
		changePwdCommand.setReNewPassword(changePwdCommand.getCurrentPassword());
		new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberPw";
		}
		// id값을 changePwService에서 사용하기 위해서 session을 인자로 전달 
		Boolean result = changePwService.currentPw(changePwdCommand, session);
		if(!result) {
			errors.rejectValue("currentPassword", "notCurrent");
			return "member/memberPw";
		}
		return "member/memberPwModify";
	}
}





