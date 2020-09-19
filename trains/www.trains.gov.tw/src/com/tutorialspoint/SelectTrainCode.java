package com.tutorialspoint;

import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SelectTrainCode {
	// 資料庫連線資訊
	String url = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String password = "zxcvbnm0351";
	String url2 = "jdbc:mysql://localhost:2222/traininfo";
	String password2 = "root";

	public static void main(String[] args) {

		SelectTrainCode a = new SelectTrainCode();
		String s = a.checkSeat("271", "2A1");
		String s1 = "";
		String s2 = "";
		int index = s.indexOf("_");
		if (!s.equals("")) {
			if (index > 1) {
				s1 = s.substring(0, 2);
				s2 = s.substring(3, 5);
			} else {
				s1 = s.substring(0, 1);
				s2 = s.substring(2, 1);
			}
		}
		System.out.println(s1);

	}

	// 查詢車次編號
	public String SelectTrainCode(String Station_Code_2) {

		String code = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from stations where Station_Code_2='" + Station_Code_2 + "' ");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							code = rs.getString("Station_Code_1");
						}

						stmt.close();
						conn.close();
						return code;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return code;
	}

	// 查詢車站名稱
	public String SelectStatinName(String Station_Code_2) {

		String code = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from stations where Station_Code_2='" + Station_Code_2 + "' ");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							code = rs.getString("Station_Name");
						}

						stmt.close();
						conn.close();
						return code;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return code;
	}

	// 查詢車站資訊
	public ArrayList<StationItem> Selectstation(String Station_Code_1) {
		ArrayList<StationItem> result = new ArrayList<StationItem>();
		String code = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from stations where Station_Code_1='" + Station_Code_1 + "' ");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							StationItem station = new StationItem();
							station.setTelephone(rs.getString("Telephone"));
							station.setChineseAddress(rs.getString("ChineseAddress"));
							station.setWebsiteName(rs.getString("WebsiteName"));
							result.add(station);
						}
						stmt.close();
						conn.close();
						return result;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return result;
	}

	// 查詢車次類別
	public String SelectTrainClass(String Mserno) {

		String mserno = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from trainsclass where ClassNo='" + Mserno + "' ");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							mserno = rs.getString("ClassName");
						}

						stmt.close();
						conn.close();
						return mserno;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return mserno;
	}

	// 新增訂票紀錄
	public boolean AddOrderRecord(String TwNo, String Where1, String Seat, String Total, String TrainNo,
			String ArrivalTime, String DepartureTime, String Start1, String End1) {
		boolean save = false;
		int total = 0;
		String driver = "com.mysql.jdbc.Driver";

		Connection conn = null;

		try {

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null && !conn.isClosed()) {

				System.out.println("資料庫連線測試成功！");

				// 建立 statment 物件

				Statement stmt = conn.createStatement();

				// 執行insert語法
				String sql = "insert into orderrecord(date1,TwNo,Where1,Seat,Total,TrainNo,ArrivalTime,DepartureTime,Start1,End1) values (CURDATE(),'"
						+ TwNo + "','" + Where1 + "','" + Seat + "','" + Total + "','" + TrainNo + "','" + ArrivalTime
						+ "','" + DepartureTime + "','" + Start1 + "','" + End1 + "')";
				System.out.println("資料庫:" + sql);
				total = stmt.executeUpdate(sql);
				if (total > 0) {
					save = true;
					System.out.println("資料庫新增成功");
				}

				stmt.close();
				conn.close();
				return save;
			}

		} catch (ClassNotFoundException e) {

			System.out.println("找不到驅動程式類別");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return save;

	}

	// 查詢訂票資訊
	public ArrayList<OrderList> SelectOrderRecord(String TwNo) {
		ArrayList<OrderList> result = new ArrayList<OrderList>();
		String code = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from orderrecord where TwNo='" + TwNo + "' ");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							OrderList list = new OrderList();
							list.setDate(rs.getString("date1"));
							list.setTwid(rs.getString("TwNo"));
							list.setTotal(rs.getString("Total"));
							list.setTrainNumber(rs.getString("TrainNo"));
							list.setArrivalTime(rs.getString("ArrivalTime"));
							list.setDepartureTime(rs.getString("DepartureTime"));
							list.setStart(rs.getString("Start1"));
							list.setEnd(rs.getString("End1"));
							result.add(list);
						}
						stmt.close();
						conn.close();
						return result;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return result;
	}

	// 刪除訂票紀錄
	public boolean DelOrderRecord(String TwNo) {
		boolean check = false;
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢

						String sql = "DELETE FROM orderrecord WHERE TwNo='" + TwNo + "'";
						System.out.println("資料庫:" + sql);
						int total = stmt.executeUpdate(sql);
						if (total > 0) {
							check = true;
						}
						return check;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return check;
	}

	// 訂票先查詢座位資訊
	public ArrayList<Station_trainItem> SelectTrainSeat(String TrainNo) {
		ArrayList<Station_trainItem> result = new ArrayList<Station_trainItem>();
		Map<String, String> seat = new HashMap<String, String>();

		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from trainsseat where TrainNo='" + TrainNo + "'");

						// if (keyword != null && !keyword.equals("")) {
						// sql.append(" where Subject1 like '%" + keyword.trim() + "%'");
						// }

						sql.append(" order by Id desc");
						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							Station_trainItem station_trainItem = new Station_trainItem();
							station_trainItem.setId(rs.getString("Id"));
							station_trainItem.setTrainNo(rs.getString("TrainNo"));
							station_trainItem.setTrainTypeName(rs.getString("TrainTypeName"));
							ObjectInputStream in = new ObjectInputStream(rs.getBinaryStream("Seat"));
							seat = (Map<String, String>) (in.readObject());
							station_trainItem.setSeat(seat);
							in.close();
							result.add(station_trainItem);
						}
						stmt.close();
						conn.close();
						return result;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return result;
	}

	// 訂票更新座位
	public boolean UpdateTrains(String TrainNo, Map<String, String> seat) {
		boolean s = false;
		// 存進資料庫
		Properties prop = new Properties();
		prop.setProperty("user", user);
		prop.setProperty("password", password);
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", prop)) {

			PreparedStatement pstmt = conn.prepareStatement("update trainsseat set Seat=? WHERE TrainNo=?");
			pstmt.setObject(1, seat);
			pstmt.setString(2, TrainNo);

			pstmt.executeUpdate();

			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

		return true;
	}

	// 查詢使用者從哪訂到哪
	public String whereStart(String TrainNo, String StationName) {

		String StopSequence = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from trains where TrainNo='" + TrainNo + "' ");
						sql.append("  and StationName= '" + StationName + "' ");
						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							StopSequence = rs.getString("StopSequence");
						}

						stmt.close();
						conn.close();
						return StopSequence;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return StopSequence;
	}

	// 查詢where
	public String checkSeat(String TrainNo, String Seat) {
		ArrayList<OrderList> result = new ArrayList<OrderList>();
		String check = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from orderrecord where TrainNo='" + TrainNo + "' ");
						sql.append(" and Seat='" + Seat + "'");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							check = rs.getString("Where1");
						}
						stmt.close();
						conn.close();
						return check;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return check;
	}

	// 查詢座位
	public boolean checkseatitem(String TrainNo, String Seat) {
		ArrayList<OrderList> result = new ArrayList<OrderList>();
		boolean check = false;
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from orderrecord where TrainNo='" + TrainNo + "' ");
						sql.append(" and Seat='" + Seat + "'");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							check = true;
						}
						stmt.close();
						conn.close();
						return check;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return check;
	}

	// 查詢使用者起點車站順序
	public String checkSeatindex(String TrainNo, String StationName) {
		ArrayList<OrderList> result = new ArrayList<OrderList>();
		String check = "";
		try

		{
			// 讀取mysqlDriver驅動程式
			Class.forName("com.mysql.jdbc.Driver");

			try

			{

				// 連接mysql資料庫Demo,帳號：root密碼：zxcvbnm0351

				Connection conn = DriverManager.getConnection(url, user, password);

				try

				{

					// 建立statement

					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);

					try

					{

						// 建立SQL查詢
						StringBuilder sql = new StringBuilder();
						sql.append("select * from trains where TrainNo='" + TrainNo + "' ");
						sql.append(" and StationName='" + StationName + "'");

						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							check = rs.getString("StopSequence");
						}
						stmt.close();
						conn.close();
						return check;

					}

					catch (Exception ex)

					{
						System.out.print("can't read data");

						System.out.print(ex);

					}

				}

				catch (Exception e)

				{
					System.out.print("can't create statement");

					System.out.print(e);

				}

			}

			catch (Exception e)

			{
				System.out.print(e);

			}

		}

		catch (Exception e)

		{
			System.out.print("can't load mysql driver");
			System.out.print(e);

		}
		return check;
	}

	// 車站查詢選擇ajax用到
	public String getStationAreas(String areas) {
		String s = "";
		switch (areas) {
		case "台北":
			s = "<option value=100>100-台北</option><option value=101>101-萬華</option><option value=102>102-板橋</option><option value=103>103-樹林</option><option value=104>104-山佳</option><option value=105>105-鶯歌</option><option value=83>083-褔隆</option><option value=84>084-貢寮</option><option value=85>085-雙溪</option><option value=86>086-牡丹</option><option value=87>087-三貂嶺</option><option value=88>088-猴硐</option><option value=89>089-瑞芳</option><option value=90>090-四腳亭</option><option value=92>092-基隆</option><option value=93>093-八堵</option><option value=94>094-七堵</option><option value=96>096-汐止</option><option value=97>097-南港</option><option value=98>098-松山</option><option value=232>232-十分</option><option value=235>235-平溪</option>";
			break;
		case "桃園":
			s = "<option value=106>106-桃園</option><option value=107>107-內壢</option><option value=108>108-中壢</option><option value=109>109-埔心</option><option value=110>110-楊梅</option><option value=111>111-富岡</option>";
			break;
		case "新竹":
			s = "<option value=115>115-新竹</option><option value=112>112-湖口</option><option value=113>113-新豐</option><option value=114>114-竹北</option><option value=248>248-內灣</option>";
			break;
		case "苗栗":
			s = "<option value=137>137-苗栗</option><option value=139>139-銅鑼</option><option value=140>140-三義</option><option value=118>118-竹南</option><option value=119>119-談文</option><option value=120>120-大山</option><option value=121>121-後龍</option><option value=123>123-白沙屯</option><option value=124>124-新埔</option><option value=125>125-通霄</option><option value=126>126-苑裡</option><option value=135>135-造橋</option>";
			break;
		case "台中":
			s = "<option value=146>146-台中</option><option value=223>223-大慶</option><option value=147>147-烏日</option><option value=280>280-新烏日</option><option value=148>148-成功</option><option value=127>127-日南</option><option value=128>128-大甲</option><option value=129>129-台中港</option><option value=130>130-清水</option><option value=131>131-沙鹿</option><option value=132>132-龍井</option><option value=133>133-大肚</option><option value=134>134-追分</option><option value=142>142-泰安</option><option value=143>143-后里</option><option value=144>144-豐原</option><option value=145>145-潭子</option>";
			break;
		case "彰化":
			s = "<option value=149>149-彰化</option><option value=150>150-花壇</option><option value=151>151-員林</option><option value=153>153-社頭</option><option value=154>154-田中</option><option value=155>155-二水</option>";
			break;
		case "斗六":
			s = "<option value=158>158-斗六</option><option value=159>159-斗南</option><option value=156>156-林內</option>";
			break;
		case "嘉義":
			s = "<option value=163>163-嘉義</option><option value=164>164-水上</option><option value=161>161-大林</option><option value=162>162-民雄</option>";
			break;
		case "台南":
			s = "<option value=175>175-台南</option><option value=176>176-保安</option><option value=177>177-中洲</option><option value=166>166-後壁</option><option value=167>167-新營</option><option value=169>169-林鳳營</option><option value=170>170-隆田</option><option value=171>171-拔林</option><option value=172>172-善化</option><option value=282>282-南科</option><option value=173>173-新市</option><option value=174>174-永康</option>";

			break;
		case "高雄":
			s = "<option value=185>185-高雄</option><option value=186>186-鳳山</option><option value=187>187-後庄</option><option value=188>188-九曲堂</option><option value=178>178-大湖</option><option value=179>179-路竹</option><option value=180>180-岡山</option><option value=181>181-橋頭</option><option value=183>183-楠梓</option><option value=288>288-新左營</option><option value=184>184-左營</option>";
			break;

		case "屏東":
			s = "<option value=190>190-屏東</option><option value=193>193-西勢</option><option value=194>194-竹田</option><option value=195>195-潮州</option><option value=197>197-南州</option><option value=199>199-林邊</option><option value=200>200-佳冬</option><option value=203>203-枋寮</option><option value=204>204-加祿</option>";
			break;
		case "台東":
			s = "<option value=4>004-台東</option><option value=8>008-鹿野</option><option value=9>009-瑞源</option><option value=12>012-關山</option><option value=15>015-池上</option><option value=211>211-大武</option><option value=213>213-瀧溪</option><option value=215>215-金崙</option><option value=217>217-太麻里</option><option value=219>219-知本</option><option value=220>220-康樂</option>";
			break;
		case "花蓮":
			s = "<option value=51>051-花蓮</option><option value=52>052-北埔</option><option value=54>054-新城</option><option value=55>055-崇德</option><option value=56>056-和仁</option><option value=57>057-和平</option><option value=18>018-富里</option><option value=20>020-東竹</option><option value=22>022-東里</option><option value=25>025-玉里</option><option value=29>029-瑞穗</option><option value=31>031-富源</option><option value=34>034-光復</option><option value=35>035-萬榮</option><option value=36>036-鳳林</option><option value=37>037-南平</option><option value=40>040-豐田</option><option value=41>041-壽豐</option><option value=43>043-志學</option><option value=45>045-吉安</option>";
			break;
		case "宜蘭":
			s = "<option value=73>073-宜蘭</option><option value=74>074-四城</option><option value=75>075-礁溪</option><option value=77>077-頭城</option><option value=79>079-龜山</option><option value=80>080-大溪</option><option value=81>081-大里</option><option value=62>062-南澳</option><option value=63>063-東澳</option><option value=66>066-蘇澳</option><option value=67>067-蘇澳新</option><option value=69>069-冬山</option><option value=70>070-羅東</option><option value=72>072-二結</option>";

			break;
		case "車埕":
			s = "<option value=256>256-車埕</option>";
			break;

		}

		return s;
	}
}
