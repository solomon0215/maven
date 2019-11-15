package Command.Member;

public class LoginCommand {
	private String id1;
	private String pw;
	private String idStore;
	private String autoLogin;
	public String getId1() {
		return id1;
	}
	public void setId1(String id1) {
		this.id1 = id1;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getIdStore() {
		return idStore;
	}
	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}
	public String getAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(String autoLogin) {
		this.autoLogin = autoLogin;
	}
}
