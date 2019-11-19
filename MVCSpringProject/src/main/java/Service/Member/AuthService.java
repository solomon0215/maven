package Service.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

	public AuthInfo authenticate(LoginCommand loginCommand, HttpServletResponse response)throws Exception {
		Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId1());
		Cookie autoLoginId = new Cookie("AUTOLOGINID", loginCommand.getId1());
		Cookie autoLoginPw = new Cookie("AUTOLOGINPW", loginCommand.getPw());
		if(loginCommand.getAutoLogin()) {
			autoLoginId.setMaxAge(60*60*24*30);
			autoLoginPw.setMaxAge(60*60*24*30);
		}else {
			autoLoginId.setMaxAge(0);
			autoLoginPw.setMaxAge(0);
		}
		if(loginCommand.getIdStore()) {
			rememberCookie.setMaxAge(60*60*24*30);
		}else {
			rememberCookie.setMaxAge(0);
		}
		response.addCookie(rememberCookie);
		response.addCookie(autoLoginId);
		response.addCookie(autoLoginPw);
		MemberDTO member = memberDao.selectByUserId(loginCommand);
		
		AuthInfo authInfo = new AuthInfo(member.getUserId(), 
				member.getUserEmail(), member.getUserName(),
				member.getUserPw());
		
		return authInfo;
	}
	
}
