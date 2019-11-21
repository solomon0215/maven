package Model.DTO;

import java.sql.Timestamp;

public class AnswerBoardDTO {
	private Long boardNum;
	private String userId;
	private String boardName;
	private String boardPass;
	private String boardSubject;
	private String boardContent;
	private Long boardReRef;
	private Long boardReLev;
	private Long boardReSeq;
	private Long boardReadcount;
	private Timestamp boardDate;
	private String originalFilename;
	private String storeFilename;
	private String fileSize;
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardPass() {
		return boardPass;
	}
	public void setBoardPass(String boardPass) {
		this.boardPass = boardPass;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Long getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(Long boardReRef) {
		this.boardReRef = boardReRef;
	}
	public Long getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(Long boardReLev) {
		this.boardReLev = boardReLev;
	}
	public Long getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(Long boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
	public Long getBoardReadcount() {
		return boardReadcount;
	}
	public void setBoardReadcount(Long boardReadcount) {
		this.boardReadcount = boardReadcount;
	}
	public Timestamp getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Timestamp boardDate) {
		this.boardDate = boardDate;
	}
	public String getOriginalFilename() {
		return originalFilename;
	}
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}
	public String getStoreFilename() {
		return storeFilename;
	}
	public void setStoreFilename(String storeFilename) {
		this.storeFilename = storeFilename;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	
}
