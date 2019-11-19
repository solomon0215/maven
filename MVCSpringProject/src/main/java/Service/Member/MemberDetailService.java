package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;

import Command.Member.LoginCommand;
import Model.DAO.MemberDAO;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;

public class MemberDetailService {
	@Autowired
	MemberDAO memberDAO;
	public MemberDTO memberDetail(AuthInfo authInfo)throws Exception {
		LoginCommand loginCommand = new LoginCommand();
		loginCommand.setId1(authInfo.getId());
		
		MemberDTO member = null;
		member = memberDAO.selectByUserId(loginCommand);
		return member;
	}
}
