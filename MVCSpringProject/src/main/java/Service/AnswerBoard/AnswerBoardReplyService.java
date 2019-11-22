package Service.AnswerBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.AnswerBoard.AnswerBoardReplyCommand;
import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

@Service
public class AnswerBoardReplyService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;

	public void boardView(Model model, Long boardNum) {

		answerBoardDAO.boardReadCountUpdate(boardNum);
		AnswerBoardDTO dto = answerBoardDAO.boardDetail(boardNum);
		AnswerBoardReplyCommand answerBoardReplyCommand = new AnswerBoardReplyCommand();
		answerBoardReplyCommand.getBoardCommand().setBoardName(dto.getBoardName());
		answerBoardReplyCommand.getBoardCommand().setBoardSubject("Re : " + dto.getBoardSubject());
		answerBoardReplyCommand.getBoardCommand()
				.setBoardContent(dto.getBoardContent() 
						+ "\n======================================"
						+ "\n======================================"
						+ "\n======================================\n");
		answerBoardReplyCommand.setBoardNum(dto.getBoardNum().toString());
		answerBoardReplyCommand.setBoardReLev(dto.getBoardReLev().toString());
		answerBoardReplyCommand.setBoardReRef(dto.getBoardReRef().toString());
		answerBoardReplyCommand.setBoardReSeq(dto.getBoardReSeq().toString());
		model.addAttribute("answerBoardReplyCommand", answerBoardReplyCommand);
	}
}
