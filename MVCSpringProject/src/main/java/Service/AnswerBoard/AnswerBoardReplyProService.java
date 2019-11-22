package Service.AnswerBoard;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Command.AnswerBoard.AnswerBoardReplyCommand;
import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;
import Model.DTO.AuthInfo;

@Service
public class AnswerBoardReplyProService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;

	String original = null;
	String originalFileExtension = null;
	String store = null;
	String fileSize = null;
	Boolean stop = true;

	public void replyPro(AnswerBoardReplyCommand answerBoardReplyCommand, HttpSession session,
			HttpServletRequest request) {
		AnswerBoardDTO dto = new AnswerBoardDTO();
		dto.setBoardNum(Long.valueOf(answerBoardReplyCommand.getBoardNum()));
		dto.setBoardReRef(Long.valueOf(answerBoardReplyCommand.getBoardReRef()));
		dto.setBoardReLev(Long.valueOf(answerBoardReplyCommand.getBoardReLev()));
		dto.setBoardReSeq(Long.valueOf(answerBoardReplyCommand.getBoardReSeq()));
		dto.setBoardName(answerBoardReplyCommand.getBoardCommand().getBoardName());
		dto.setBoardSubject(answerBoardReplyCommand.getBoardCommand().getBoardSubject());
		dto.setBoardContent(answerBoardReplyCommand.getBoardCommand().getBoardContent());
		dto.setBoardPass(answerBoardReplyCommand.getBoardCommand().getBoardPass());
		dto.setUserId(((AuthInfo) session.getAttribute("authInfo")).getId());

		String originalTotal = "";
		String storeTotal = "";
		String fileSizeTotal = "";

		for (MultipartFile mf : answerBoardReplyCommand.getReports()) {

			original = mf.getOriginalFilename();
			originalFileExtension = original.substring(original.lastIndexOf(".")); // 확장자만 추출 하기
			store = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
			fileSize = Long.toString(mf.getSize());

			originalTotal += original + "-";
			storeTotal += store + "-";
			fileSizeTotal += fileSize + "-";

			String path = request.getRealPath("/");
			path += "WEB-INF\\view\\AnswerBoard\\upload\\";
			System.out.println(path);
			File file = new File(path + store);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				// TODO: handle exception
				stop = false;
				e.printStackTrace();
				break;
			}
		}
		if (stop) {
			dto.setOriginalFilename(originalTotal);
			dto.setStoreFilename(storeTotal);
			dto.setFileSize(fileSizeTotal);

			answerBoardDAO.boardReplyInsert(dto);
		}

	}
}
