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
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

//取網路上鐵路動態電子刊版資訊
public class JsonTrainBillBoards {

	public static void main(String[] args) {
		JsonTrainBillBoards a = new JsonTrainBillBoards();
		// http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/LiveBoard/1008?$format=JSON"
		// http://ptx.transportdata.tw/MOTC/版號/運具/台鐵(TRA)高鐵(THSR)/電子刊版/車站代碼?$format=JSON"
		String strUrl = "http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/LiveBoard?&$format=JSON";
		String json = a.getJSONString(strUrl);
		long start = System.currentTimeMillis();

		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "zxcvbnm0351");

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", prop)) {
			// 3. SQL statement
			String sql = "INSERT INTO TrainDnamic(StationID,TrainNo,Direction,TrainClassificationID,TripLine,EndingStationID,ScheduledArrivalTime,ScheduledDepartureTime,DelayTime,SrcUpdateTime,UpdateTime)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			// StationID (string): 車站代碼 ,
			// StationName (NameType): 車站名稱 ,
			// TrainNo (string): 車次代碼 ,
			// Direction (string): 順逆行 = ['0: 順行', '1: 逆行'],
			// TrainClassificationID (string): 列車車種代碼 ,
			// TripLine (string, optional): 山海線類型 = ['0: 不經山海線', '1: 山線', '2: 海線'],
			// EndingStationID (string): 車次終點車站代號 ,
			// EndingStationName (NameType): 車次終點車站名稱 ,
			// ScheduledArrivalTime (string): 表訂到站時間(格式: HH:mm:ss) ,
			// ScheduledDepartureTime (string): 表訂離站時間(格式: HH:mm:ss) ,
			// DelayTime (integer): 誤點時間(0:準點;>=1誤點) ,
			// Platform (string): 月台 ,
			// SrcUpdateTime (DateTime): 來源端平台資料更新時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz) ,
			// UpdateTime (DateTime): 本平台資料更新時間(ISO8601格式:yyyy-MM-ddTHH:mm:sszzz)

			JSONArray root = new JSONArray(json);
			for (int i = 0; i < root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String StationID = row.getString("StationID");
				// String StationName = row.getString("StationName");
				String TrainNo = row.getString("TrainNo");
				String Direction = Integer.toString(row.getInt("Direction"));
				String TrainClassificationID = row.getString("TrainClassificationID");
				String TripLine = Integer.toString(row.getInt("TripLine"));
				String EndingStationID = row.getString("EndingStationID");
				String ScheduledArrivalTime = row.getString("ScheduledArrivalTime");
				String ScheduledDepartureTime = row.getString("ScheduledDepartureTime");
				String DelayTime = Integer.toString(row.getInt("DelayTime"));
				String SrcUpdateTime = row.getString("SrcUpdateTime");
				String UpdateTime = row.getString("UpdateTime");
				// 存進資料庫
				pstmt.setString(1, StationID);
				// pstmt.setString(2, StationName);
				pstmt.setString(2, TrainNo);
				pstmt.setString(3, Direction);
				pstmt.setString(4, TrainClassificationID);
				pstmt.setString(5, TripLine);
				pstmt.setString(6, EndingStationID);
				// pstmt.setString(7, EndingStationName);
				pstmt.setString(7, ScheduledArrivalTime);
				pstmt.setString(8, ScheduledDepartureTime);
				pstmt.setString(9, DelayTime);
				pstmt.setString(10, SrcUpdateTime);
				pstmt.setString(11, UpdateTime);

				pstmt.addBatch();
			}
			pstmt.executeBatch();
			System.out.println("OK");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// 得到網路上json串流
	public String getJSONString(String strUrl) {
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