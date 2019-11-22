package Controller.AnswerBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.AnswerBoard.AnswerBoardReplyService;

@Controller
public class AnswerBoardReplyController {
	@Autowired
	AnswerBoardReplyService answerBoardReplyService ;
	
	@RequestMapping("/board/answerBoardReply")
	public String replyView(@RequestParam(value="num") Long boardNum, Model model ) {
		answerBoardReplyService.boardView(model, boardNum);
		return "AnswerBoard/board_reply";
	}
	
}
