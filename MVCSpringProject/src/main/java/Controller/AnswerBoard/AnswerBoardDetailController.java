package Controller.AnswerBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.AnswerBoard.AnswerBoardDetailService;

@Controller
public class AnswerBoardDetailController {
	@Autowired
	AnswerBoardDetailService answerBoardDetailService;
	
	@RequestMapping("/board/answerBoardDetail")
	public String boardView(@RequestParam(value="num") Long boardNum , Model model) {
		answerBoardDetailService.boardView(model, boardNum);
		return "AnswerBoard/board_view";
	}

}
