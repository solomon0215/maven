package Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import Command.AnswerBoard.AnswerBoardReplyCommand;

public class AnswerBoardValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return AnswerBoardReplyCommand.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		System.out.println("-----------------------target-------------------------------------");
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "boardCommand.boardName", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardCommand.boardSubject", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardCommand.boardContent", "required");
		ValidationUtils.rejectIfEmpty(errors, "boardCommand.boardPass", "required");
	}

}
