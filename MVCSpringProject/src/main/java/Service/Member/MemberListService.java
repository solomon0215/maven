package Service.Member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Command.Member.ListCommand;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberListService {
	@Autowired
	private MemberDAO memberDAO;
	
	public void memberList(Model model, ListCommand listCommand) {
		List<MemberDTO> members = memberDAO.selectList(listCommand);
		if(members != null) {
			model.addAttribute("members", members);
		}
	}
}
