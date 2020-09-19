package tw.com.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

import com.tutorialspoint.TrainsItem;

import tw.com.common.StationLineItem;

//取網路上鐵路路線
public class JsonStationLine {

	public static void main(String[] args) {
		getTrainSelectLine();
	}

	public static void getTrainSelectLine() {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "zxcvbnm0351");

		StringBuilder s = new StringBuilder();
		s.append("http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/StationOfLine?&$format=JSON");
		String json = getJSONString(s.toString());

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", prop)) {
			// 3. SQL statement
			String sql = "INSERT INTO StationsLine ( LineNo,LineID,Sequence,StationID,StationName,TraveledDistance)"
					+ " VALUES (?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			JSONArray root = new JSONArray(json);
			for (int i = 0; i < root.length(); i++) {
				StationLineItem StationLineItem = new StationLineItem();
				JSONObject row = root.getJSONObject(i);
				String LineNo = row.getString("LineNo");
				String LineID = row.getString("LineID");

				for (int j = 0; j < row.getJSONArray("Stations").length(); j++) {
					String Sequence = String.valueOf(row.getJSONArray("Stations").getJSONObject(j).getInt("Sequence"));
					String StationID = row.getJSONArray("Stations").getJSONObject(j).getString("StationID");
					String StationName = row.getJSONArray("Stations").getJSONObject(j).getString("StationName");
					String TraveledDistance = String
							.valueOf(row.getJSONArray("Stations").getJSONObject(j).getFloat("TraveledDistance"));
					pstmt.setString(1, LineNo);
					pstmt.setString(2, LineID);
					pstmt.setString(3, Sequence);
					pstmt.setString(4, StationID);
					pstmt.setString(5, StationName);
					pstmt.setString(6, TraveledDistance);
					pstmt.addBatch();

				}

			}

			pstmt.executeBatch();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 得到網路上json串流
	public static String getJSONString(String strUrl) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line.trim());
			}
			reader.close();
			System.out.println(sb);
		} catch (Exception e) {
			System.out.println(e);
		}
		return sb.toString();
	}

}
