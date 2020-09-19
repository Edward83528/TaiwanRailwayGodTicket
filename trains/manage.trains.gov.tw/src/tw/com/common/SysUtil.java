/*
 * 撰寫日期：2015/8/15
 * 程式名稱：SysUtil.java
 * 功能：
 * 撰寫者：chmei
 */

package tw.com.common;

import java.io.UnsupportedEncodingException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import sun.misc.BASE64Decoder;

public class SysUtil {

	/** 加密 */
	public static String encrypt(String encrypt_string) {
		String encrypt_value = null;
		if (encrypt_string != null && !encrypt_string.equals("null") && !encrypt_string.equals("")) {
			try {
				encrypt_value = Base64.getEncoder().encodeToString(encrypt_string.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return encrypt_value;
	}

	/** 解密 */

	// 解密
	public static synchronized String getFromBase64(String s) {
		byte[] b = null;
		String result = null;
		if (s != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(s);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/** 取系統日期，傳入欲呈現的格式，如yyyyMMdd **/
	public static String nowDate(String formatstyle) {
		Format formatter = new SimpleDateFormat(formatstyle);
		Date todayDate = new Date();
		return formatter.format(todayDate);
	}

	/** 計算系統日期前1天的日期 **/
	public static String beforeDate(String beforday) {
		if (beforday == null || beforday.equals("null") || beforday.equals(""))
			beforday = "1";
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate = new Date();
		long beforeTime = (todayDate.getTime() / 1000) - 60 * 60 * 24 * (Integer.parseInt(beforday));
		todayDate.setTime(beforeTime * 1000);
		String beforeDate = formatter.format(todayDate);
		return beforeDate;
	}

	/** 計算系統日期後幾天的日期 **/
	public static String afterDate(String afterday) {
		if (afterday == null || afterday.equals("null") || afterday.equals(""))
			afterday = "180";
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date todayDate = new Date();
		long afterTime = (todayDate.getTime() / 1000) + 60 * 60 * 24 * (Integer.parseInt(afterday));
		todayDate.setTime(afterTime * 1000);
		String afterDate = formatter.format(todayDate);
		return afterDate;
	}

}
