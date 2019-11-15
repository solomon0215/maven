package Model.DTO;

import java.sql.Timestamp;

public class MemberDTO {
	Timestamp userRegister;
	String userPw;
	String userPh2;
	String userPh1;
	String userName;
	String userId;
	String userGender;
	String userEmail;
	Timestamp userBir;
	String userAddr;
	String checkNum;
	
	
	public MemberDTO() {
	}
	public MemberDTO(Timestamp userRegister, String userPw, String userPh2, String userPh1, String userName,
			String userId, String userGender, String userEmail, Timestamp userBir, String userAddr, String checkNum) {
		super();
		this.userRegister = userRegister;
		this.userPw = userPw;
		this.userPh2 = userPh2;
		this.userPh1 = userPh1;
		this.userName = userName;
		this.userId = userId;
		this.userGender = userGender;
		this.userEmail = userEmail;
		this.userBir = userBir;
		this.userAddr = userAddr;
		this.checkNum = checkNum;
	}
	public Timestamp getUserRegister() {
		return userRegister;
	}
	public void setUserRegister(Timestamp userRegister) {
		this.userRegister = userRegister;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserPh2() {
		return userPh2;
	}
	public void setUserPh2(String userPh2) {
		this.userPh2 = userPh2;
	}
	public String getUserPh1() {
		return userPh1;
	}
	public void setUserPh1(String userPh1) {
		this.userPh1 = userPh1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Timestamp getUserBir() {
		return userBir;
	}
	public void setUserBir(Timestamp userBir) {
		this.userBir = userBir;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public String getCheckNum() {
		return checkNum;
	}
	public void setCheckNum(String checkNum) {
		this.checkNum = checkNum;
	}
	
	
}
