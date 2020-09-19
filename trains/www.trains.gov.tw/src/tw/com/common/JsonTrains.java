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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

//取得所有車次的定期時刻表資料
public class JsonTrains {

	public static void main(String[] args) {
		Map<String, String> seat = new HashMap<>();
		// 第一節車廂
		seat.put("1A1", "N");
		seat.put("1A2", "N");
		seat.put("1A3", "N");
		seat.put("1A4", "N");
		seat.put("1A5", "N");
		seat.put("1A6", "N");
		seat.put("1A7", "N");
		seat.put("1A8", "N");
		seat.put("1A9", "N");
		seat.put("1A10", "N");

		seat.put("1B1", "N");
		seat.put("1B2", "N");
		seat.put("1B3", "N");
		seat.put("1B4", "N");
		seat.put("1B5", "N");
		seat.put("1B6", "N");
		seat.put("1B7", "N");
		seat.put("1B8", "N");
		seat.put("1B9", "N");
		seat.put("1B10", "N");

		seat.put("1C1", "N");
		seat.put("1C2", "N");
		seat.put("1C3", "N");
		seat.put("1C4", "N");
		seat.put("1C5", "N");
		seat.put("1C6", "N");
		seat.put("1C7", "N");
		seat.put("1C8", "N");
		seat.put("1C9", "N");
		seat.put("1C10", "N");

		seat.put("1D1", "N");
		seat.put("1D2", "N");
		seat.put("1D3", "N");
		seat.put("1D4", "N");
		seat.put("1D5", "N");
		seat.put("1D6", "N");
		seat.put("1D7", "N");
		seat.put("1D8", "N");
		seat.put("1D9", "N");
		seat.put("1D10", "N");
		// 第二節車廂
		seat.put("2A1", "N");
		seat.put("2A2", "N");
		seat.put("2A3", "N");
		seat.put("2A4", "N");
		seat.put("2A5", "N");
		seat.put("2A6", "N");
		seat.put("2A7", "N");
		seat.put("2A8", "N");
		seat.put("2A9", "N");
		seat.put("2A10", "N");

		seat.put("2B1", "N");
		seat.put("2B2", "N");
		seat.put("2B3", "N");
		seat.put("2B4", "N");
		seat.put("2B5", "N");
		seat.put("2B6", "N");
		seat.put("2B7", "N");
		seat.put("2B8", "N");
		seat.put("2B9", "N");
		seat.put("2B10", "N");

		seat.put("2C1", "N");
		seat.put("2C2", "N");
		seat.put("2C3", "N");
		seat.put("2C4", "N");
		seat.put("2C5", "N");
		seat.put("2C6", "N");
		seat.put("2C7", "N");
		seat.put("2C8", "N");
		seat.put("2C9", "N");
		seat.put("2C10", "N");

		seat.put("2D1", "N");
		seat.put("2D2", "N");
		seat.put("2D3", "N");
		seat.put("2D4", "N");
		seat.put("2D5", "N");
		seat.put("2D6", "N");
		seat.put("2D7", "N");
		seat.put("2D8", "N");
		seat.put("2D9", "N");
		seat.put("2D10", "N");
		boolean save = false;

		// 存進資料庫
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "zxcvbnm0351");
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", prop)) {

			// FAQiItem s1 = new FAQiItem();

			// Bike b1 = new Bike();
			// ArrayList<FAQiItem> a = new ArrayList<FAQiItem>();
			// FAQiItem student = new FAQiItem();
			// student.setId("1");
			// a.add(student);
			// 取得資料
			JsonTrains jsonTrains = new JsonTrains();
			ArrayList<Station_TrainItem> lists = jsonTrains.getTainsList();

			for (int i = 0; i < lists.size(); i++) {
				Station_TrainItem list = lists.get(i);
				// list.getTrainNo();
				// list.getDirection();
				// list.getTrainTypeID();
				// list.getTrainTypeName();
				// list.getTripLine();
				// list.getNote();
				// list.getStartingStationID();
				// list.getStartingStationName();
				// list.getEndingStationID();
				// list.getEndingStationName();
				for (int j = 0; j < list.getTrains().size(); j++) {
					// list.getTrains().get(j).getStopSequence();
					// list.getTrains().get(j).getStationID();
					// list.getTrains().get(j).getStationName();
					// list.getTrains().get(j).getArrivalTime();
					// list.getTrains().get(j).getDepartureTime();
					PreparedStatement pstmt = conn.prepareStatement(
							"insert into trains(TrainNo,Direction,TrainTypeID,TrainTypeName,TripLine,Note,StopSequence,StationID,StationName,StartingStationID,StartingStationName,EndingStationID,EndingStationName,ArrivalTime,DepartureTime,Seat) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1, list.getTrainNo());
					pstmt.setString(2, list.getDirection());
					pstmt.setString(3, list.getTrainTypeID());
					pstmt.setString(4, list.getTrainTypeName());
					pstmt.setString(5, list.getTripLine());
					pstmt.setString(6, list.getNote());
					pstmt.setString(7, list.getTrains().get(j).getStopSequence());
					pstmt.setString(8, list.getTrains().get(j).getStationID());
					pstmt.setString(9, list.getTrains().get(j).getStationName());
					pstmt.setString(10, list.getStartingStationID());
					pstmt.setString(11, list.getStartingStationName());
					pstmt.setString(12, list.getEndingStationID());
					pstmt.setString(13, list.getEndingStationName());
					pstmt.setString(14, list.getTrains().get(j).getArrivalTime());
					pstmt.setString(15, list.getTrains().get(j).getDepartureTime());
					pstmt.setObject(16, seat);
					pstmt.executeUpdate();
				}
			}
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ArrayList<Station_TrainItem> getTainsList() {
		ArrayList<Station_TrainItem> train = new ArrayList<Station_TrainItem>();
		// http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/LiveBoard/1008?$format=JSON"
		// http://ptx.transportdata.tw/MOTC/版號/運具/台鐵(TRA)高鐵(THSR)/電子刊版/車站代碼?$format=JSON"
		String strUrl = "http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/GeneralTimetable?&$format=JSON";
		String json = getJSONString(strUrl);

		// PreparedStatement pstmt = conn.prepareStatement(sql);

		// TrainNo (string): 車次代碼 ,
		// Direction (string): 順逆行 = ['0: 順行', '1: 逆行'],
		// StartingStationID (string, optional): 列車起點車站代號 ,
		// StartingStationName (NameType, optional): 列車起點車站名稱 ,
		// EndingStationID (string, optional): 列車終點車站代號 ,
		// EndingStationName (NameType, optional): 列車終點車站名稱 ,
		// TrainTypeID (string): 列車車種代碼 ,
		// TrainTypeCode (string): 列車車種簡碼 ,
		// TrainTypeName (NameType): 列車車種名稱 ,
		// TrainClassificationID (string): 列車車種代碼 ,
		// TripLine (string, optional): 山海線類型 = ['0: 不經山海線', '1: 山線', '2: 海線'],
		// OverNightStationID (string, optional): 跨夜車站代碼 ,
		// WheelchairFlag (boolean): 是否提供輪椅服務 ,
		// PackageServiceFlag (boolean): 是否提供行李服務 ,
		// DiningFlag (boolean): 是否提供餐車服務 ,
		// BikeFlag (boolean): 是否可攜帶自行車 ,
		// BreastFeedingFlag (boolean): 是否設有哺乳室 ,
		// Note (NameType, optional): 附註說明
		// UpdateDate (DateTime): 資料更新日期(格式: yyyy-MM-dd)
		JSONArray root = new JSONArray(json);

		for (int i = 0; i < root.length(); i++) {
			JSONObject row = root.getJSONObject(i);
			Station_TrainItem station_TrainItem = new Station_TrainItem();
			station_TrainItem.setTrainNo(row.getJSONObject("GeneralTrainInfo").getString("TrainNo"));
			// String TrainNo = row.getJSONObject("GeneralTrainInfo").getString("TrainNo");
			station_TrainItem.setDirection(String.valueOf(row.getJSONObject("GeneralTrainInfo").getInt("Direction")));
			// int Direction = row.getJSONObject("GeneralTrainInfo").getInt("Direction");
			station_TrainItem
					.setStartingStationID(row.getJSONObject("GeneralTrainInfo").getString("StartingStationID"));
			// String StartingStationID =
			// row.getJSONObject("GeneralTrainInfo").getString("StartingStationID");
			station_TrainItem.setStartingStationName(
					row.getJSONObject("GeneralTrainInfo").getJSONObject("StartingStationName").getString("Zh_tw"));
			// String StartingStationName =
			// row.getJSONObject("GeneralTrainInfo").getJSONObject("StartingStationName").getString("Zh_tw");
			station_TrainItem.setEndingStationID(row.getJSONObject("GeneralTrainInfo").getString("EndingStationID"));
			// String EndingStationID =
			// row.getJSONObject("GeneralTrainInfo").getString("EndingStationID");
			station_TrainItem.setEndingStationName(
					row.getJSONObject("GeneralTrainInfo").getJSONObject("EndingStationName").getString("Zh_tw"));
			// String EndingStationName =
			// row.getJSONObject("GeneralTrainInfo").getJSONObject("EndingStationName").getString("Zh_tw");
			station_TrainItem.setTrainTypeID(row.getJSONObject("GeneralTrainInfo").getString("TrainTypeID"));
			// String TrainTypeID =
			// row.getJSONObject("GeneralTrainInfo").getString("TrainTypeID");
			station_TrainItem.setTrainTypeName(
					row.getJSONObject("GeneralTrainInfo").getJSONObject("TrainTypeName").getString("Zh_tw"));
			// String TrainTypeName =
			// row.getJSONObject("GeneralTrainInfo").getJSONObject("TrainTypeName").getString("Zh_tw");
			station_TrainItem.setTripLine(String.valueOf(row.getJSONObject("GeneralTrainInfo").getInt("TripLine")));
			// int TripLine = row.getJSONObject("GeneralTrainInfo").getInt("TripLine");
			station_TrainItem.setNote(row.getJSONObject("GeneralTrainInfo").getJSONObject("Note").getString("Zh_tw"));
			// String Note =
			// row.getJSONObject("GeneralTrainInfo").getJSONObject("Note").getString("Zh_tw");
			ArrayList<Station_TrainItem> trains = new ArrayList<Station_TrainItem>();
			for (int j = 0; j < row.getJSONArray("StopTimes").length(); j++) {

				Station_TrainItem station_TrainItem2 = new Station_TrainItem();
				station_TrainItem2.setStopSequence(
						String.valueOf(row.getJSONArray("StopTimes").getJSONObject(j).getInt("StopSequence")));
				// int StopSequence =
				// row.getJSONArray("StopTimes").getJSONObject(j).getInt("StopSequence");
				station_TrainItem2.setStationID(row.getJSONArray("StopTimes").getJSONObject(j).getString("StationID"));
				// String StationID =
				// row.getJSONArray("StopTimes").getJSONObject(j).getString("StationID");
				station_TrainItem2.setStationName(
						row.getJSONArray("StopTimes").getJSONObject(j).getJSONObject("StationName").getString("Zh_tw"));
				// String StationName =
				// row.getJSONArray("StopTimes").getJSONObject(j).getJSONObject("StationName").getString("Zh_tw");
				station_TrainItem2
						.setArrivalTime(row.getJSONArray("StopTimes").getJSONObject(j).getString("ArrivalTime"));
				// String ArrivalTime =
				// row.getJSONArray("StopTimes").getJSONObject(j).getString("ArrivalTime");
				station_TrainItem2
						.setDepartureTime(row.getJSONArray("StopTimes").getJSONObject(j).getString("DepartureTime"));
				trains.add(station_TrainItem2);

				// String DepartureTime =
				// row.getJSONArray("StopTimes").getJSONObject(j).getString("DepartureTime");
				// System.out.println(DepartureTime);
			}
			station_TrainItem.setTrains(trains);
			train.add(station_TrainItem);
			// pstmt.addBatch();

		}
		// pstmt.executeBatch();
		System.out.println("OK");

		return train;

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