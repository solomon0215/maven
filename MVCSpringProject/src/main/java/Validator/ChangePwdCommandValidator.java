package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Member.ChangePwdCommand;
import Command.Member.MemberCommand;

public class ChangePwdCommandValidator implements Validator{
	
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ChangePwdCommand.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ChangePwdCommand regReq = (ChangePwdCommand) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, 
				"currentPassword", "required");
		ValidationUtils.rejectIfEmpty(errors,"newPassword","required");
		if (!regReq.getNewPassword().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("reNewPassword", "reNewPwdnomatch");
			}
		}
	}


}
