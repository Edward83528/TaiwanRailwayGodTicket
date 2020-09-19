package tw.com.common;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrainData2 {
	// 資料庫連線資訊
	String url = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String password = "zxcvbnm0351";
	String url2 = "jdbc:mysql://localhost:2222/traininfo";
	String password2 = "root";

	public static void main(String[] args) {

		TrainData2 trainData = new TrainData2();
		trainData.SelectStation();
		// trainData.SelectTrains("1319");

	}

	// 搜尋車站(經過哪些車次)
	public ArrayList<StationItem> SelectStation() {
		String driver = "com.mysql.jdbc.Driver";

		Connection conn = null;

		try {

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null && !conn.isClosed()) {

				System.out.println("資料庫連線測試成功！");

				// 建立 statment 物件

				Statement stmt = conn.createStatement();

				// 執行 SQL 指令

				ResultSet rs = stmt
						.executeQuery("select * from stations where Station_Code_2='146' or Station_Code_2='144'");
				ArrayList<StationItem> result = new ArrayList<StationItem>();

				for (int i = 0; rs.next(); i++) {
					StationItem lists = new StationItem();
					// System.out.println(rs.getString("WebsiteName"));
					System.out.println(rs.getString("Station_Code_1"));
					// System.out.println(SelectTrains(rs.getString("Station_Code_1")));
					// result.add(lists);
				}
				stmt.close();
				conn.close();
				return result;
			}

		} catch (ClassNotFoundException e) {

			System.out.println("找不到驅動程式類別");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;

	}

	// 搜尋車次
	public String SelectTrains(String Station_Code_1) {
		String train = "";
		String driver = "com.mysql.jdbc.Driver";

		Connection conn = null;

		try {

			Class.forName(driver);

			conn = DriverManager.getConnection(url, user, password);

			if (conn != null && !conn.isClosed()) {

				System.out.println("資料庫連線測試成功！");

				// 建立 statment 物件

				Statement stmt2 = conn.createStatement();

				// 執行 SQL 指令

				ResultSet rs = stmt2.executeQuery("select * from trains where Station='" + Station_Code_1 + "'");
				ArrayList<TrainItem> result = new ArrayList<TrainItem>();

				for (int i = 0; rs.next(); i++) {
					train = rs.getString("TrainNumber");

				}
				stmt2.close();
				conn.close();
				return train;
			}

		} catch (ClassNotFoundException e) {

			System.out.println("找不到驅動程式類別");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return train;

	}

	// 新增車次
	public boolean AddTrains(String TrainNumber, String Mserno, String Station, String DepartureTime,
			String ArrivalsTime) {
		boolean save = false;
		String driver = "com.mysql.jdbc.Driver";

		Connection conn = null;

		try {

			Class.forName(driver);

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", user, password);

			if (conn != null && !conn.isClosed()) {

				System.out.println("資料庫連線測試成功！");

				// 建立 statment 物件

				Statement stmt = conn.createStatement();

				// 執行insert語法

				stmt.executeUpdate(
						"insert into trains(TrainNumber,Mserno,Note,Station,DepartureTime,ArrivalsTime,Seat)values('"
								+ TrainNumber + "','" + Mserno + "','每天行駛','" + Station + "','" + DepartureTime + "','"
								+ ArrivalsTime + "','50')");
				// 執行 SQL 指令
				save = true;
				ResultSet rs = stmt.executeQuery("select * from enter");

				// 取出資料庫中的資料

				stmt.close();

				conn.close();

			}

		} catch (ClassNotFoundException e) {

			System.out.println("找不到驅動程式類別");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return save;

	}

	// 新增最新消息
	public boolean add(String Id, String Subject, String Content, String Link, String Pitcure) {
		boolean save = false;
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

				stmt.executeUpdate("insert into enter(Id,Date1,Subject,Content,Link,Pitcure) values ( '" + Id
						+ "',CURDATE(),'" + Subject + "','" + Content + "','" + Link + "','" + Pitcure + "')");
				// 執行 SQL 指令
				save = true;
				ResultSet rs = stmt.executeQuery("select * from enter");

				// 取出資料庫中的資料

				stmt.close();

				conn.close();

			}

		} catch (ClassNotFoundException e) {

			System.out.println("找不到驅動程式類別");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return save;

	}

}
