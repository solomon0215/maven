package Command.AnswerBoard;

import org.springframework.web.multipart.MultipartFile;

public class AnswerBoardReplyCommand {
	private BoardCommand boardCommand;
	private String boardNum;
	private String boardReRef;
	private String boardReLev;
	private String boardReSeq;
	private MultipartFile [] reports;
	public AnswerBoardReplyCommand() {
		this.boardCommand = new BoardCommand();
	}
	public BoardCommand getBoardCommand() {
		return boardCommand;
	}
	public void setBoardCommand(BoardCommand boardCommand) {
		this.boardCommand = boardCommand;
	}
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardReRef() {
		return boardReRef;
	}
	public void setBoardReRef(String boardReRef) {
		this.boardReRef = boardReRef;
	}
	public String getBoardReLev() {
		return boardReLev;
	}
	public void setBoardReLev(String boardReLev) {
		this.boardReLev = boardReLev;
	}
	public String getBoardReSeq() {
		return boardReSeq;
	}
	public void setBoardReSeq(String boardReSeq) {
		this.boardReSeq = boardReSeq;
	}
	public MultipartFile[] getReports() {
		return reports;
	}
	public void setReports(MultipartFile[] reports) {
		this.reports = reports;
	}
	
}
