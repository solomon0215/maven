package Controller.AnswerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;

import Command.AnswerBoard.AnswerBoardReplyCommand;
import Service.AnswerBoard.AnswerBoardReplyProService;
import Validator.AnswerBoardValidator;

@Controller
public class AnswerBoardReplyProController {
	@Autowired
	AnswerBoardReplyProService answerBoardReplyProService;
	
	@RequestMapping("/board/answerBoardReplyPro")
	public String replyPro(AnswerBoardReplyCommand answerBoardReplyCommand, Errors errors, HttpSession session, HttpServletRequest req) {
		new AnswerBoardValidator().validate(answerBoardReplyCommand, errors);
		if(errors.hasErrors()) {
			System.out.println("submit");
			return "AnswerBoard/board_reply";
		}
		answerBoardReplyProService.replyPro(answerBoardReplyCommand, session, req);
		
		return "redirect:/board/answerBoardList";

	}
}
