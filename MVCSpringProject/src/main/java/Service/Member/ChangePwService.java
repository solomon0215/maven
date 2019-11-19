package Service.Member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import Command.Member.ChangePwdCommand;
import Command.Member.LoginCommand;
import Model.DAO.MemberDAO;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;

public class ChangePwService {
	@Autowired
	private MemberDAO  memberDAO;
	public Boolean currentPw(ChangePwdCommand changePwdCommand,
			HttpSession session) {
		LoginCommand loginCommand = new LoginCommand();
		loginCommand.setId1(
				((AuthInfo)session.getAttribute("authInfo")).getId());
		
		MemberDTO member = memberDAO.selectByUserId(loginCommand);
		// CurrentPassword값을 암호화 시
				String pw = Encrypt.Encrypt.getEncryption(
						changePwdCommand.getCurrentPassword());
		// 암호화된 비밀번호를 비교 
		if(member.getUserPw().equals(pw)) {
			return true;
		}
		return false;
	}
}
