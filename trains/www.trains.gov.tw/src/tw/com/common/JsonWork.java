package tw.com.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonWork {

	public static void main(String[] args) {
		String strUrl = "D:/b.json";
		String json = getJSONString(strUrl);
		long start = System.currentTimeMillis();

		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "zxcvbnm0351");

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", prop)) {
			// 3. SQL statement
			String sql = "INSERT INTO Stations (Station_Code_1,Station_Name,Station_EName,Station_Code_2,WebsiteName,EnglishName,ChineseAddress,EnglishAddress,Telephone,Gps)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			JSONArray root = new JSONArray(json);
			for (int i = 0; i < root.length(); i++) {
				JSONObject row = root.getJSONObject(i);

				int Station_Code_1 = row.getInt("Station_Code_4");
				String Station_Name = row.getString("Station_Name");
				String Station_EName = row.getString("Station_EName");
				int Station_Code_2 = row.getInt("Station_Code_3");
				String WebsiteName = row.getString("WebsiteName");
				String EnglishName = row.getString("EnglishName");
				String ChineseAddress = row.getString("ChineseAddress");
				String EnglishAddress = row.getString("EnglishAddress");
				String Telephone = row.getString("Telephone");
				String Gps = row.getString("gps");
				pstmt.setInt(1, Station_Code_1);
				pstmt.setString(2, Station_Name);
				pstmt.setString(3, Station_EName);
				pstmt.setInt(4, Station_Code_2);
				pstmt.setString(5, WebsiteName);
				pstmt.setString(6, EnglishName);
				pstmt.setString(7, ChineseAddress);
				pstmt.setString(8, EnglishAddress);
				pstmt.setString(9, Telephone);
				pstmt.setString(10, Gps);

				pstmt.addBatch();
			}
			pstmt.executeBatch();
			System.out.println("OK");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static String getJSONString(String string) {
		StringBuilder sb = new StringBuilder();
		try {
			// URL url =new URL(string);
			// HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// conn.connect();
			FileInputStream fin = new FileInputStream(new File(string));
			BufferedReader reader = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line.trim());
			}
			reader.close();
			// System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
