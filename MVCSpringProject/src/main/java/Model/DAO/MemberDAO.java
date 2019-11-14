package Model.DAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import Model.DTO.MemberDTO;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;
	@Autowired
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Integer insertMember(MemberDTO memberDTO) {
		String sql = "insert into MEMBER(CHECK_NUM,USER_ADDR,USER_BIR,USER_EMAIL,USER_GENDER,"
				+ "USER_ID,USER_NAME,USER_PH1,USER_PH2,USER_PW,USER_REGISTER) "
				+ "values(?,?,?,?,?,?,?,?,?,?,sysdate)";
		int i = jdbcTemplate.update(
				sql,"a",memberDTO.getUserAddr(),memberDTO.getUserBir(),memberDTO.getUserEmail(),memberDTO.getUserGender()
				,memberDTO.getUserId(),memberDTO.getUserName(),memberDTO.getUserPh1(),memberDTO.getUserPh2(),memberDTO.getUserPw()
				);
		return i;
	}
	
	
}
