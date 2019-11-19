package Service.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import Command.Member.LoginCommand;
import Encrypt.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.AuthInfo;
import Model.DTO.MemberDTO;

@Service
public class AuthService {
	@Autowired
	private MemberDAO memberDao;
	private AuthInfo authInfo;
	
	public void authenticate(LoginCommand loginCommand,
			HttpServletResponse response, HttpSession session, Errors errors){
		
		Cookie rememberCookie = 
				new Cookie("REMEMBER",loginCommand.getId1());
		System.out.println("authenticate : "+loginCommand.getIdStore());
		if(loginCommand.getIdStore()) {
			System.out.println("authenticate : true");
			rememberCookie.setMaxAge(60 * 60 * 24 * 30);
		}else{
			System.out.println("authenticate : false ");
			rememberCookie.setMaxAge(0);
		}
		response.addCookie(rememberCookie);
		
		
		MemberDTO member = memberDao.selectByUserId(loginCommand);		
		AuthInfo authInfo = new AuthInfo(member.getUserId(), 
				member.getUserEmail(), member.getUserName(),
				member.getUserPw());
		System.out.println("AuthService : " + member.getUserPw());
		System.out.println("AuthService : " + authInfo.getPw());
		try {
			if(authInfo.getPw().equals(
					Encrypt.getEncryption(loginCommand.getPw()))) {
				session.setAttribute("authInfo",authInfo);
				Cookie autoLoginCookie = 
						new Cookie("AutoLogin",loginCommand.getId1());
				autoLoginCookie.setMaxAge(60 * 60 * 24 * 30);
				response.addCookie(autoLoginCookie);
			}else {
				System.out.println("鍮꾨�踰덊샇媛� ��由쎈땲�떎.");
				errors.rejectValue("pw","wrong");
			}
		}catch(Exception e) {
			System.out.println("�븘�씠�뵒媛� �뾾�뒿�땲�떎.");
			errors.rejectValue("id1","notId");			
		}
		
	}
	
}
