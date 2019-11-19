package Service.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.EncryptedPrivateKeyInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Encrypt.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;
                          // dao
//  view --> command --> dto --> db
//                service
@Service
public class MemberJoinService {
	@Autowired
	private MemberDAO memberDAO;
	private MemberDTO memberDTO = new MemberDTO();
	public Integer execute(MemberCommand memberCommand, Model model) {
		Integer result = null;
		try {
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		SimpleDateFormat dt = new SimpleDateFormat("yyMMdd");
		Date date = dt.parse(memberCommand.getUserBirth());
		Timestamp userBirth = new Timestamp(date.getTime());
		memberDTO.setUserBirth(userBirth);
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserGender(memberCommand.getUserGender());
		memberDTO.setUserId(memberCommand.getUserId());
		memberDTO.setUserName(memberCommand.getUserName());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		memberDTO.setUserPw(
				Encrypt.getEncryption(memberCommand.getUserPw()));
		result = memberDAO.insertMember(memberDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}









