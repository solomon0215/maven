package Model.DTO;

public class AuthInfo {
	private String id;
	private String email;
	private String name;
	private String pw;
	public AuthInfo(String id, String email, String name, String pw) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public String getPw() {
		return pw;
	}
}