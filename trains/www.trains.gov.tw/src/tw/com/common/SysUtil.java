
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

	// 把時間轉成毫秒
	public static long fromDateStringToLong(String inVal) { // 此方法计算时间毫秒
		Date date = null; // 定义时间类型
		SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm");
		try {
			date = inputFormat.parse(inVal); // 将字符型转换成日期型
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date.getTime(); // 返回毫秒数
	}

	public static long difftime(String start, String end) {
		long startT = fromDateStringToLong(start); // 定義起始時間
		long endT = fromDateStringToLong(end); // 定義截止時間

		long ss = (startT - endT); // 共計秒數
		if (ss < 0) {
			ss = ss * (-1);
		}

		int MM = (int) ss / 60; // 共計分鐘數
		int hh = (int) ss / 3600; // 共計小時數
		int dd = (int) hh / 24; // 共計天數
		return ss;
	}

	// 把毫秒轉成幾小時幾分幾秒
	public static String formatDuring(long mss) {
		long days = mss / (1000 * 60 * 60 * 24);
		long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		long seconds = (mss % (1000 * 60)) / 1000;
		return "" + hours + "小時又" + minutes + "分";
	}

	public static void main(String[] args) {

	}

}
