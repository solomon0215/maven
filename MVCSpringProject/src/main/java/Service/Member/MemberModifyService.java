package Service.Member;

import org.springframework.beans.factory.annotation.Autowired;

import Command.Member.MemberCommand;
import Encrypt.Encrypt;
import Model.DAO.MemberDAO;
import Model.DTO.MemberDTO;

public class MemberModifyService {
	@Autowired
	private MemberDAO memberDAO;
	public Integer memberModify(MemberCommand memberCommand) { 
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setUserEmail(memberCommand.getUserEmail());
		memberDTO.setUserAddr(memberCommand.getUserAddr());
		memberDTO.setUserPh1(memberCommand.getUserPh1());
		memberDTO.setUserPh2(memberCommand.getUserPh2());
		memberDTO.setUserPw(
				Encrypt.getEncryption(memberCommand.getUserPw()));
		memberDTO.setUserId(memberCommand.getUserId());
		Integer result = memberDAO.memberModify(memberDTO);
		return result;
	}
}
