package Service.AnswerBoard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.AnswerBoard.AnswerBoardReplyCommand;
import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;

@Service
public class AnswerBoardDetailService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;
	
	public void boardView(Model model, Long boardNum) {
		
		answerBoardDAO.boardReadCountUpdate(boardNum);
		AnswerBoardDTO dto  = answerBoardDAO.boardDetail(boardNum);
		String [] origial = dto.getOriginalFilename().split("-");
		String [] store = dto.getStoreFilename().split("-");
		String [] fileSize = dto.getFileSize().split("-");
		
		model.addAttribute("original", origial);
		model.addAttribute("store", store);
		model.addAttribute("fileSize", fileSize);
		model.addAttribute("board", dto);
	}
}
