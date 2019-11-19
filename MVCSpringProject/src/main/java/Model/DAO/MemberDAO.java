package Model.DAO;

import java.lang.reflect.Member;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public Integer pwUpdate(String id, String pw, String newPw) {
		String sql = "update member "
				+ "   set user_pw = ?"
				+ "   where USER_ID = ? and USER_PW = ?  ";
		Integer i = jdbcTemplate.update(sql, newPw, id, pw ); 
		return i;
	}
	public Integer memberModify(MemberDTO memberDTO) {
		String sql = "update member "
				+ "   set USER_EMAIL = ?, USER_ADDR = ?, "
				+ "       USER_PH1 = ? , USER_PH2 = ?"
				+ "   where USER_ID = ? and USER_PW = ?  ";
		Integer i = jdbcTemplate.update(sql, 
				memberDTO.getUserEmail(), memberDTO.getUserAddr(),
				memberDTO.getUserPh1(), memberDTO.getUserPh2(),
				memberDTO.getUserId(),memberDTO.getUserPw());
		return i;
	}
	public Integer insertMember(MemberDTO memberDTO) {
		String sql = "insert into MEMBER(USER_ID,USER_PW,USER_NAME,"
				+ " USER_BIRTH, USER_GENDER, USER_EMAIL,USER_ADDR,"
				+ " USER_PH1, USER_PH2, USER_REGIST)"
				+ " values(?,?,?,?,?,?,?,?,?,sysdate) ";
		int i = jdbcTemplate.update(sql,memberDTO.getUserId(),
				memberDTO.getUserPw(),memberDTO.getUserName()
				, memberDTO.getUserBirth(),memberDTO.getUserGender()
				, memberDTO.getUserEmail(), memberDTO.getUserAddr()
				, memberDTO.getUserPh1(), memberDTO.getUserPh2());
		return i;
	}
	public MemberDTO selectByUserId(LoginCommand loginCommand) {
		MemberDTO member = null;
		String sql = "select USER_ID, USER_PW, USER_NAME,"
				+ " USER_BIRTH, USER_GENDER, USER_EMAIL,"
				+ " USER_ADDR, USER_PH1, USER_PH2, USER_REGIST "
				+ " from member where USER_ID = ?";
		List<MemberDTO> results = jdbcTemplate.query(sql, 
				new RowMapper<MemberDTO>() {
					public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						// TODO Auto-generated method stub
						MemberDTO member = new MemberDTO();
						member.setUserId(rs.getString("USER_ID"));
						member.setUserName(rs.getString("USER_NAME"));
						member.setUserEmail(rs.getString("USER_EMAIL"));
						member.setUserPh1(rs.getString("USER_PH1"));
						member.setUserRegist(rs.getTimestamp("USER_REGIST"));
						member.setUserAddr(rs.getString("USER_ADDR"));
						member.setUserBirth(rs.getTimestamp("USER_BIRTH"));
						member.setUserGender(rs.getString("USER_GENDER"));
						member.setUserPh2(rs.getString("USER_PH2"));
						member.setUserPw(rs.getString("USER_pw"));
						return member;
					}
		},loginCommand.getId1());
		member = results.isEmpty()? null: results.get(0);
		return member;
	}
}
