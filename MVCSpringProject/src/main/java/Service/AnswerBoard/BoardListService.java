package Service.AnswerBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DAO.AnswerBoardDAO;
import Model.DTO.AnswerBoardDTO;
@Service
public class BoardListService {
	@Autowired
	AnswerBoardDAO answerBoardDAO;
	
	public void getBoardList(Model model, Integer page) {
		int nowPage = 1;// 현재페이지를 알기 위한 변수
		if(page != null) {
			nowPage = page;
		}
		int limit = 10; // 한 페이지에 출력될 게시글 수
		int limitPage = 10 ;// 뷰 하단에 보일 페이지 수 (ex 1 2 3 4 5 6 7 8 9  10 등 페이징 번호의 수)
		// 2page라면 리스트는 11번째 게시글 부터 20번째 게시글 까지
		List<AnswerBoardDTO> list = answerBoardDAO.boardListAll(nowPage, limit);//게시글 limit 숫자 만큼 가져옴
		
		int totalCount = answerBoardDAO.getBoardCount(); // 출력할 게시글의 수
		int maxPage = (int)((double)totalCount / limit + 0.95); // 최대 페이지 수(ex 나올 상품이 13개 일때 최대 페이지수는 2개)
		int startPage = (int)(((double)nowPage/limitPage + 0.9) -1) * 10 +1; // 1~10 사이의 페이지를 선택시 번호는 1
		int endPage =startPage + limitPage -1; // 1~10 사이의 페이지를 선택시 번호는 10
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		model.addAttribute("boards", list);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("maxPage", maxPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("page", nowPage);
		
	}
}
