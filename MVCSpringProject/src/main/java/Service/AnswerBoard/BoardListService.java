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
		int nowPage = 1;// ������������ �˱� ���� ����
		if(page != null) {
			nowPage = page;
		}
		int limit = 10; // �� �������� ��µ� �Խñ� ��
		int limitPage = 10 ;// �� �ϴܿ� ���� ������ �� (ex 1 2 3 4 5 6 7 8 9  10 �� ����¡ ��ȣ�� ��)
		// 2page��� ����Ʈ�� 11��° �Խñ� ���� 20��° �Խñ� ����
		List<AnswerBoardDTO> list = answerBoardDAO.boardListAll(nowPage, limit);//�Խñ� limit ���� ��ŭ ������
		
		int totalCount = answerBoardDAO.getBoardCount(); // ����� �Խñ��� ��
		int maxPage = (int)((double)totalCount / limit + 0.95); // �ִ� ������ ��(ex ���� ��ǰ�� 13�� �϶� �ִ� ���������� 2��)
		int startPage = (int)(((double)nowPage/limitPage + 0.9) -1) * 10 +1; // 1~10 ������ �������� ���ý� ��ȣ�� 1
		int endPage =startPage + limitPage -1; // 1~10 ������ �������� ���ý� ��ȣ�� 10
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
