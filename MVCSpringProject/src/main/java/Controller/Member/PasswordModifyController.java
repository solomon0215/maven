package Controller.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.Member.ChangePwdCommand;
import Service.Member.PasswordModifyService;
import Validator.ChangePwdCommandValidator;

@Controller
public class PasswordModifyController {
	@Autowired
	PasswordModifyService passwordModifyService;
	@RequestMapping(value="/edit/pwModifyPro", 
			method = RequestMethod.POST)
	public String pwModify(ChangePwdCommand changePwdCommand,
			Errors errors,HttpSession session, HttpServletRequest request) {
	   new ChangePwdCommandValidator().validate(changePwdCommand, errors);
		if(errors.hasErrors()) {
			return "member/memberPwModify";
		}
		Integer result = passwordModifyService.updatePassword(
				changePwdCommand,session);
		System.out.println("pwModify : " + result);
		if(result > 0) {
			return "redirect:"+ request.getContextPath() +"/main";
		}else{
			System.out.println("pwModify : " + result);
			errors.rejectValue("currentPassword", "notCurrent");
			return "member/memberPwModify";
		}
	}
}
