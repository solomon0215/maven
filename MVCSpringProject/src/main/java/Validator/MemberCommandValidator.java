package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.Member.MemberCommand;

public class MemberCommandValidator implements Validator{
	private static final String emailRegExp =
			"^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
	private Pattern pattern;
	
	public MemberCommandValidator() {
		pattern = Pattern.compile(emailRegExp);
	}
	public boolean supports(Class<?> clazz) {
		return MemberCommand.class.isAssignableFrom(clazz);
	}
	public void validate(Object target, Errors errors) {
		MemberCommand regReq = (MemberCommand) target;
		if (regReq.getUserEmail() == null || 
				regReq.getUserEmail().trim().isEmpty()) {
			/*Errors의 rejectValue()메서드는 
			 * 첫 번째 파라미터로 프로퍼티의 이름을 전달받고, 
			 * 두 번째 파라미터로 프로퍼티의 에러 코드를 설정한다
			 */
			errors.rejectValue("userEmail", "required"); 
		} else {
			Matcher matcher = pattern.matcher(regReq.getUserEmail());
			if (!matcher.matches()) {
				// “userEmail" 프로퍼티의 에러 코드로 ”bad"를 추가
				errors.rejectValue("userEmail", "bad");
			}
		} 
		//ValidationUtils 클래스는 객체의 값 검증코드를 간결하게 작성할 수 있도록 도와준다.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", 
															"required");
		ValidationUtils.rejectIfEmpty(errors, "userPw", "required");
		ValidationUtils.rejectIfEmpty(errors, "userId", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPh1", "required");
		ValidationUtils.rejectIfEmpty(errors, "userAddr", "required");
		ValidationUtils.rejectIfEmpty(errors, "userBirth", "required");
		ValidationUtils.rejectIfEmpty(errors, "userPwCon", "required");
		if (!regReq.getUserPw().isEmpty()) {
			if (!regReq.isPasswordEqualToConfirmPassword()) {
				errors.rejectValue("userPwCon", "nomatch");
			}
		}
	}
}
