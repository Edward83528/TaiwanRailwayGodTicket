package tw.com.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5 {

	public static String getmd5(String msg) {
		String hashtext = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(msg.getBytes());

			BigInteger number = new BigInteger(1, messageDigest);
			hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		} catch (Exception e) {
			System.out.println("md5錯誤");
		}
		return hashtext;

	}

	public static void main(String[] args) {
		String hashtext = null;
		String msg = "123";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(msg.getBytes());

			BigInteger number = new BigInteger(1, messageDigest);
			hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
		} catch (Exception e) {
			System.out.println("md5錯誤");
		}
		System.out.println(hashtext);

	}
}