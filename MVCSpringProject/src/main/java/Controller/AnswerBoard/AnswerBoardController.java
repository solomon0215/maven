package Controller.AnswerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.AnswerBoard.BoardCommand;
import Service.AnswerBoard.BoardListService;
import Service.AnswerBoard.BoardWriteService;

@Controller
public class AnswerBoardController {
	@Autowired
	BoardWriteService boardWriterService;
	@Autowired
	BoardListService boardListService;
	
	@RequestMapping("/board/answerBoard")
	public String form(BoardCommand boardCommand) {
		return "AnswerBoard/board_wirte";
	}
	
	@RequestMapping(value="/board/answerBoardWritePro", method = RequestMethod.POST)
	public String write(BoardCommand boardCommand, HttpServletRequest request, HttpSession session) {
		boardWriterService.boardWrite(boardCommand,session,request);
		return "redirect:/board/answerBoardList";
	}
	@RequestMapping("/board/answerBoardList")
	public String boardList(Model model, @RequestParam(value="page", required = false) Integer page) {
		boardListService.getBoardList(model, page);
		return "AnswerBoard/board_list";
	}
}
