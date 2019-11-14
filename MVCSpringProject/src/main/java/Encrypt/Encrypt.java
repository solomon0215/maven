package Encrypt;

import java.security.MessageDigest;

public class Encrypt {
	static MessageDigest md;
	static StringBuffer sb;
	public static String getEncryption(String userPw) {
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (Exception e) {
			e.printStackTrace();
		}
		md.update(userPw.getBytes());
		byte byteData[] = md.digest();
		sb = new StringBuffer();
		for(int i = 0 ; i < byteData.length ; i++) {
			sb.append(
					Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}
}
