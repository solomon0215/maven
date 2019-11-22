package Model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import Model.DTO.AnswerBoardDTO;

public class AnswerBoardDAO {
private JdbcTemplate jdbcTemplate;
private String sql;
private final String COLUMN = "BOARD_NUM,USER_ID, BOARD_PASS, BOARD_NAME, BOARD_SUBJECT," 
						+ "BOARD_CONTENT, BOARD_READCOUNT, BOARD_RE_LEV, BOARD_RE_REF, BOARD_RE_SEQ," 
						+ "ORIGINAL_FILENAME, STORE_FILENAME, BOARD_DATE, FILE_SIZE" ;	
	private RowMapper<AnswerBoardDTO> boardRowMapper = 
			new RowMapper<AnswerBoardDTO>() {
		public AnswerBoardDTO mapRow(ResultSet rs, int rowNum) 
				throws SQLException {
			// TODO Auto-generated method stub
			AnswerBoardDTO board = new AnswerBoardDTO();
			board.setBoardNum(rs.getLong("BOARD_NUM"));
			board.setUserId(rs.getString("USER_ID"));
			board.setBoardPass(rs.getString("BOARD_PASS"));
			board.setBoardName(rs.getString("BOARD_NAME"));
			board.setBoardSubject(rs.getString("BOARD_SUBJECT"));
			board.setBoardContent(rs.getString("BOARD_CONTENT"));
			board.setBoardReadcount(rs.getLong("BOARD_READCOUNT"));
			board.setBoardReLev(rs.getLong("BOARD_RE_LEV"));
			board.setBoardReRef(rs.getLong("BOARD_RE_REF"));
			board.setBoardReSeq(rs.getLong("BOARD_RE_SEQ"));
			board.setOriginalFilename(rs.getString("ORIGINAL_FILENAME"));
			board.setStoreFilename(rs.getString("STORE_FILENAME"));
			board.setBoardDate(rs.getTimestamp("BOARD_DATE"));
			board.setFileSize(rs.getString("FILE_SIZE"));
			return board;
		}
	};
	@Autowired
	public AnswerBoardDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public AnswerBoardDTO boardDetail(Long boardNum) {
		sql = "select "+ COLUMN +" from boarder where BOARD_NUM = ?";
		List<AnswerBoardDTO> list = jdbcTemplate.query(sql, boardRowMapper, boardNum);
		AnswerBoardDTO dto = list.isEmpty()? null : list.get(0);
		return dto;
	}
	public void boardInsert(AnswerBoardDTO answerBoardDTO) {
		sql = "insert into boarder("
				+ COLUMN + ") "
				+ "values("
						+ "board_seq.nextval,?,?,?,?,"
						+ "?,0,0,board_seq.CURRVAL,0,"
						+ "?,?,sysdate,?)";
		jdbcTemplate.update(sql, 
				answerBoardDTO.getUserId(),answerBoardDTO.getBoardPass(),answerBoardDTO.getBoardName(),answerBoardDTO.getBoardSubject(),
				answerBoardDTO.getBoardContent(),
				answerBoardDTO.getOriginalFilename(),answerBoardDTO.getStoreFilename(),answerBoardDTO.getFileSize());
	}
	
	public List<AnswerBoardDTO> boardListAll(int page, int limit){
		//page = 1; 1 ~ 10 ,  page =2 ; 11~ 20, 
		sql = "select rn, " +COLUMN + " from ("
					+ "select rownum rn, "+COLUMN + " from ("
							+ "select "+ COLUMN+ " from boarder order by BOARD_RE_REF desc, BOARD_RE_SEQ asc"
							+ ")"
					+ ") "
			+ " where rn >= ?  and rn <= ?";
		int startRow= (page-1) * limit +1;
		int endRow= startRow + limit - 1;
		List<AnswerBoardDTO> list= jdbcTemplate.query(sql,boardRowMapper,startRow, endRow);
		return list;
	}
	public void boardReadCountUpdate(Long boardNum) {
		sql = "update boarder set BOARD_READCOUNT= BOARD_READCOUNT+1 where BOARD_NUM =?";
		jdbcTemplate.update(sql,boardNum);
	}
	public Integer getBoardCount() {
		sql = "select count(*) from boarder ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	public void boardReplyInsert(AnswerBoardDTO dto) {
		sql = "update boarder set board_re_seq = board_re_seq +1 "
				+ "where board_re_ref=? and board_re_seq>?";
		jdbcTemplate.update(sql,dto.getBoardReRef(), dto.getBoardReSeq());
		sql = "insert into boarder("
				+ COLUMN + ") "
				+ "values("
						+ "board_seq.nextval,?,?,?,?,"
						+ "?,0,?,?,?,"
						+ "?,?,sysdate,?)";
		Long seq = dto.getBoardReSeq() +1;
		Long lev = dto.getBoardReLev() +1;
		jdbcTemplate.update(sql, 
				dto.getUserId(),dto.getBoardPass(),dto.getBoardName(),dto.getBoardSubject(),
				dto.getBoardContent(),lev,dto.getBoardReRef(),seq,
				dto.getOriginalFilename(),dto.getStoreFilename(),dto.getFileSize());
		
	}
}
