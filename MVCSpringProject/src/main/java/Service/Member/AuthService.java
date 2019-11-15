package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Command.Member.LoginCommand;
import Model.DAO.MemberDAO;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;
@Service
public class AuthService {
	@Autowired
	private MemberDAO memberDao;
	
	
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}
	
	public AuthInfo authenticate(LoginCommand loginCommand) {
		MemberDTO member = memberDao.selectByUserId(loginCommand);
		if(member != null) {
			AuthInfo authInfo = new AuthInfo(member.getUserId(), member.getUserEmail(), member.getUserName(),member.getUserPw());
			return authInfo;
		}
		return null;
	}
}
