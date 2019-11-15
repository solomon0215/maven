package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Command.Member.LoginCommand;
import Model.DTO.MemberDTO;

public class MemberDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public MemberDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Integer insertMember(MemberDTO memberDTO) {
		String sql = "insert into MEMBER(CHECK_NUM,USER_ADDR,USER_BIR,USER_EMAIL,USER_GENDER,"
				+ "USER_ID,USER_NAME,USER_PH1,USER_PH2,USER_PW,USER_REGISTER) " + "values(?,?,?,?,?,?,?,?,?,?,sysdate)";
		Integer i = null;
		i = jdbcTemplate.update(sql, 1, memberDTO.getUserAddr(), memberDTO.getUserBir(), memberDTO.getUserEmail(),
				memberDTO.getUserGender(), memberDTO.getUserId(), memberDTO.getUserName(), memberDTO.getUserPh1(),
				memberDTO.getUserPh2(), memberDTO.getUserPw());
		return i;
	}

	public MemberDTO selectByUserId(LoginCommand loginCommand) {
		String sql = "select * from member where user_id = ? ";

		List<MemberDTO> result = jdbcTemplate.query(sql, new RowMapper<MemberDTO>() {
			public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MemberDTO member = new MemberDTO(
						rs.getTimestamp("USER_REGISTER"), 
						rs.getString("USER_PW"),
						rs.getString("USER_PH2"), 
						rs.getString("USER_PH1"), 
						rs.getString("USER_NAME"),
						rs.getString("USER_ID"), 
						rs.getString("USER_GENDER"), 
						rs.getString("USER_EMAIL"),
						rs.getTimestamp("USER_BIR"), 
						rs.getString("USER_ADDR"), 
						rs.getString("CHECK_NUM"));
				return member;
			}
		}, loginCommand.getId1());
		
		MemberDTO memberDTO = result.isEmpty() ? null : result.get(0);
		return memberDTO;
	}

}
