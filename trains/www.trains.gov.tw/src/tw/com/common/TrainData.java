package tw.com.common;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TrainData {
	// 資料庫連線資訊
	String url = "jdbc:mysql://localhost:3306/traininfo";
	String user = "root";
	String password = "zxcvbnm0351";
	String url2 = "jdbc:mysql://localhost:2222/traininfo";
	String password2 = "root";

	public static void main(String[] args) {
		int k = 0;
		boolean check = true;
		boolean check2 = true;
		TrainData trainData = new TrainData();
		ArrayList<TrainItem> lists = trainData.SelectTrains();
		ArrayList<StationItem> lists2 = trainData.SelectStation();
		if (lists != null) {
			ArrayList<TrainItem> result = new ArrayList<TrainItem>();

			for (int i = 0; check2; i++) {
				check = true;
				TrainItem list = lists.get(i);
				System.out.println("車次:" + list.getTrain());
				System.out.println("-------------------");

				for (int j = k + 1; check; j++) {
					StationItem list2 = lists2.get(j);
					StationItem list3 = lists2.get(j + 1);
					System.out.println("車站" + list2.getOrder1() + ":" + list2.getStation());
					trainData.AddTrains(list.getTrain(), list.getCarclass(), list2.getStation(), list2.getDeptime(),
							list2.getArrtime());
					if (list3.getOrder1().equals("1")) {
						k = j;
						check = false;
						if (list.getTrain().equals("5694")) {
							check2 = false;
						}
					}
				}

			}
		}
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

				ResultSet rs = stmt.executeQuery("select * from timeinfo");
				ArrayList<StationItem> result = new ArrayList<StationItem>();

				for (int i = 0; rs.next(); i++) {
					StationItem lists = new StationItem();
					lists.setStation(rs.getString("station"));
					lists.setOrder1(rs.getString("order1"));
					lists.setArrtime(rs.getString("arrtime"));
					lists.setDeptime(rs.getString("deptime"));
					result.add(lists);
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
	public ArrayList<TrainItem> SelectTrains() {
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

				ResultSet rs = stmt2.executeQuery("select * from traininfo");
				ArrayList<TrainItem> result = new ArrayList<TrainItem>();

				for (int i = 0; rs.next(); i++) {
					TrainItem lists = new TrainItem();
					lists.setTrain(rs.getString("train"));
					lists.setCarclass(rs.getString("carclass"));
					result.add(lists);
				}
				stmt2.close();
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
