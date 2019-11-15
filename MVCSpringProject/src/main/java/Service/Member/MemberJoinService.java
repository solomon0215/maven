package Service.Member;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Command.Member.MemberCommand;
import Encrypt.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

@Service
public class MemberJoinService {
	@Autowired
	private MemberDAO memberDAO; 
	private MemberDTO memberDTO = new MemberDTO();
	public Integer execute(MemberCommand memberCommand,Model model) {
		Integer result = 0;
		try {
			
			SimpleDateFormat dt = new SimpleDateFormat("yyMMdd");
			Date date = dt.parse(memberCommand.getUserBir());
			Timestamp userBir = new Timestamp(date.getTime());
			memberDTO.setUserBir(userBir);
			memberDTO.setUserAddr(memberCommand.getUserAddr());
			memberDTO.setUserName(memberCommand.getUserName());
			memberDTO.setUserId(memberCommand.getUserId());
			memberDTO.setUserGender(memberCommand.getUserGender());
			memberDTO.setUserPh1(memberCommand.getUserPh1());
			memberDTO.setUserPh2(memberCommand.getUserPh2());
			memberDTO.setUserEmail(memberCommand.getUserEmail());
			memberDTO.setUserPw(
					Encrypt.getEncryption(memberCommand.getUserPw())
					);
			result = memberDAO.insertMember(memberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
