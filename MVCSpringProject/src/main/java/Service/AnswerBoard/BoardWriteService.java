package Service.AnswerBoard;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Command.AnswerBoard.BoardCommand;
import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;
import Model.DTO.AuthInfo;

@Service
public class BoardWriteService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;
	String original = null;
	String originalFileExtension = null;
	String store = null;
	String fileSize = null;
	

	public void boardWrite(BoardCommand boardCommand, HttpSession session, HttpServletRequest request) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		AnswerBoardDTO answerBoardDTO = new AnswerBoardDTO();
		answerBoardDTO.setBoardName(boardCommand.getBoardName());
		answerBoardDTO.setBoardPass(boardCommand.getBoardPass());
		answerBoardDTO.setBoardSubject(boardCommand.getBoardSubject());
		answerBoardDTO.setBoardContent(boardCommand.getBoardContent());
		answerBoardDTO.setUserId(authInfo.getId());
		
		String originalTotal= "";
		String storeTotal = ""; 
		String fileSizeTotal="";
		
		for (MultipartFile mf : boardCommand.getReport()) {

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
				e.printStackTrace();
			}
		}
		answerBoardDTO.setOriginalFilename(originalTotal);
		answerBoardDTO.setStoreFilename(storeTotal);
		answerBoardDTO.setFileSize(fileSizeTotal);
		answerBoardDAO.boardInsert(answerBoardDTO);
	}
}
