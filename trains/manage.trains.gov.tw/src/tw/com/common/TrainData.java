package tw.com.common;

import java.io.IOException;
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

public class TrainData {
	// 資料庫連線資訊
	String url = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String password = "zxcvbnm0351";
	String url2 = "jdbc:mysql://localhost:2222/traininfo";
	String password2 = "root";

	public static void main(String[] args) {

	}

	// 新增最新消息
	public boolean AddNews(String Subject, String Content, String Link, String Picture) {
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
				String sql = "insert into news(Date1,Subject1,Content1,Link,Picture) values (CURDATE(),'" + Subject
						+ "','" + Content + "','" + Link + "','" + Picture + "')";
				System.out.println("資料庫:" + sql);
				stmt.executeUpdate(sql);
				System.out.println("資料庫新增成功");
				save = true;
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

	// 查詢多筆最新消息
	public ArrayList<NewsItem> SelectNews(String keyword, String start, String end) {
		ArrayList<NewsItem> result = new ArrayList<NewsItem>();

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
						sql.append("select * from news ");

						if (keyword != null && !keyword.equals("")) {
							sql.append(" where Subject1 like '%" + keyword.trim() + "%'");
						}

						if (start != null && end != null && !start.equals("") && !end.equals("")) {
							// 把字串2017-06-04格式轉成資料庫的格式20170604
							String s1 = start.substring(0, 4);
							String s2 = start.substring(5, 7);
							String s3 = start.substring(8, 10);
							String s4 = s1 + s2 + s3;
							String c1 = end.substring(0, 4);
							String c2 = end.substring(5, 7);
							String c3 = end.substring(8, 10);
							String c4 = c1 + c2 + c3;
							if (keyword != null && !keyword.equals("")) {
								sql.append(" and Date1 BETWEEN '" + s4 + "' AND '" + c4 + "'");
							} else {
								sql.append(" where Date1 BETWEEN '" + s4 + "' AND '" + c4 + "'");
							}
						}

						sql.append(" order by Id desc");
						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							NewsItem tmpQuery1 = new NewsItem();
							tmpQuery1.setId(rs.getString("Id"));
							tmpQuery1.setDate1(rs.getString("Date1"));
							tmpQuery1.setSubject(rs.getString("Subject1"));
							tmpQuery1.setContent(rs.getString("Content1"));
							tmpQuery1.setLink(rs.getString("Link"));
							tmpQuery1.setPicture(rs.getString("Picture"));
							result.add(tmpQuery1);
						}

						stmt.close();
						conn.close();

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

	// 查詢單筆最新消息
	public ArrayList<NewsItem> SelectNew(String id) {
		ArrayList<NewsItem> result = new ArrayList<NewsItem>();
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
						sql.append("select * from news where Id='" + id + "'");

						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							NewsItem tmpQuery1 = new NewsItem();
							tmpQuery1.setId(rs.getString("Id"));
							tmpQuery1.setDate1(rs.getString("Date1"));
							tmpQuery1.setSubject(rs.getString("Subject1"));
							tmpQuery1.setContent(rs.getString("Content1"));
							tmpQuery1.setLink(rs.getString("Link"));
							tmpQuery1.setPicture(rs.getString("Picture"));
							result.add(tmpQuery1);
						}

						stmt.close();

						conn.close();

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

	// 刪除最新消息
	public boolean DelNews(String Id) {
		boolean check = false;
		ArrayList<NewsItem> result = new ArrayList<NewsItem>();
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

						String sql = "DELETE FROM news WHERE Id='" + Id + "'";
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

	// 更新最新消息
	public boolean UpdateNews(String Id, String Subject, String Content, String Link, String Picture) {
		boolean s = false;
		ArrayList<NewsItem> result = new ArrayList<NewsItem>();
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
							ResultSet.CONCUR_UPDATABLE);

					try

					{

						// 建立SQL更新

						String sql = "update news set Subject1='" + Subject + "',Content1='" + Content + "', Link='"
								+ Link + "', Picture='" + Picture + "'  where Id='" + Id + "'";
						System.out.print(sql);
						int totle = stmt.executeUpdate(sql);
						if (totle > 0) {
							s = true;
						}
						return s;

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
		return s;
	}

	// 增加管理者
	public boolean AddUser(String Name, String User, String Password) {
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
				String sql = "insert into user(UserName,UserKey,password1,permission) values ('" + Name + "','" + User
						+ "','" + Password + "','N')";
				System.out.println("資料庫:" + sql);
				stmt.executeUpdate(sql);
				System.out.println("資料庫新增成功");
				save = true;
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

	// 增加問與答
	public boolean AddFAQ(String Question, String Answer) {
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
				String sql = "insert into fq(Question,Answer) values ('" + Question + "','" + Answer + "')";
				System.out.println("資料庫:" + sql);
				stmt.executeUpdate(sql);
				System.out.println("資料庫新增成功");
				save = true;
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

	// 查詢多筆管理者
	public ArrayList<UserItem> SelectUsers(String keyword) {
		ArrayList<UserItem> result = new ArrayList<UserItem>();

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
						StringBuilder sql = new StringBuilder();

						sql.append("select * from User");
						if (keyword != null && !keyword.equals("")) {
							// 建立SQL查詢

							sql.append(" where UserName like '%" + keyword.trim() + "%'");
						}

						sql.append(" order by Id desc");
						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							UserItem tmpQuery1 = new UserItem();
							tmpQuery1.setId(rs.getString("Id"));
							tmpQuery1.setUserName(rs.getString("UserName"));
							tmpQuery1.setUserKey(rs.getString("UserKey"));
							tmpQuery1.setPassword1(rs.getString("password1"));
							tmpQuery1.setPermission(rs.getString("permission"));

							result.add(tmpQuery1);
						}

						stmt.close();
						conn.close();

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

	// 查詢多筆問與答
	public ArrayList<FAQiItem> SelectFAQs(String keyword) {
		ArrayList<FAQiItem> result = new ArrayList<FAQiItem>();

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

						sql.append("select * from fq");
						if (keyword != null && !keyword.equals("")) {
							// 建立SQL查詢

							sql.append(" where Question like '%" + keyword.trim() + "%'");
						}

						sql.append(" order by Id desc");
						System.out.println(sql.toString());
						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							FAQiItem tmpQuery1 = new FAQiItem();
							tmpQuery1.setId(rs.getString("Id"));
							tmpQuery1.setQuestion(rs.getString("Question"));
							tmpQuery1.setAnswer(rs.getString("Answer"));

							result.add(tmpQuery1);
						}

						stmt.close();
						conn.close();

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

	// 查詢單筆管理者
	public ArrayList<UserItem> SelectUser(String id) {
		ArrayList<UserItem> result = new ArrayList<UserItem>();
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
						sql.append("select * from user where Id='" + id + "'");

						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							UserItem tmpQuery1 = new UserItem();
							tmpQuery1.setId(rs.getString("Id"));
							tmpQuery1.setUserName(rs.getString("UserName"));
							tmpQuery1.setUserKey(rs.getString("UserKey"));
							tmpQuery1.setPassword1(rs.getString("password1"));
							tmpQuery1.setPermission(rs.getString("permission"));

							result.add(tmpQuery1);
						}

						stmt.close();

						conn.close();

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

	// 查詢單筆問題
	public ArrayList<FAQiItem> SelectFAQ(String id) {
		ArrayList<FAQiItem> result = new ArrayList<FAQiItem>();
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
						sql.append("select * from fq where Id='" + id + "'");

						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						for (int i = 0; rs.next(); i++) {
							FAQiItem tmpQuery1 = new FAQiItem();
							tmpQuery1.setId(rs.getString("Id"));
							tmpQuery1.setQuestion(rs.getString("Question"));
							tmpQuery1.setAnswer(rs.getString("Answer"));

							result.add(tmpQuery1);
						}

						stmt.close();

						conn.close();

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

	// 刪除問題
	public boolean DelFAQS(String Id) {
		boolean check = false;
		ArrayList<NewsItem> result = new ArrayList<NewsItem>();
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

						String sql = "DELETE FROM fq WHERE Id='" + Id + "'";
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

	// 刪除管理者
	public boolean Delusers(String Id) {
		boolean check = false;
		ArrayList<UserItem> result = new ArrayList<UserItem>();
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

						String sql = "DELETE FROM user WHERE Id='" + Id + "'";
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

	// 更新問與答
	public boolean UpdateFAQ(String Id, String Question, String answer) {
		boolean s = false;
		ArrayList<NewsItem> result = new ArrayList<NewsItem>();
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
							ResultSet.CONCUR_UPDATABLE);

					try

					{

						// 建立SQL更新

						String sql = "update fq set Question='" + Question + "',answer='" + answer + "' where Id='" + Id
								+ "'";
						System.out.print(sql);
						int totle = stmt.executeUpdate(sql);
						if (totle > 0) {
							s = true;
						}
						return s;

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
		return s;
	}

	// 更新管理者
	public boolean UpdateUser(String Id, String UserName, String UserKey, String password1, String permission) {
		boolean s = false;
		ArrayList<NewsItem> result = new ArrayList<NewsItem>();
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
							ResultSet.CONCUR_UPDATABLE);

					try

					{

						// 建立SQL更新

						String sql = "update user set UserName='" + UserName + "',UserKey='" + UserKey
								+ "', password1='" + password1 + "', permission='" + permission + "'  where Id='" + Id
								+ "'";
						System.out.print(sql);
						int totle = stmt.executeUpdate(sql);
						if (totle > 0) {
							s = true;
						}
						return s;

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
		return s;
	}

	// 查詢多筆車次
	public ArrayList<Station_trainItem> SelectTrainSeats(String TrainNo, String TrainTypeName) {
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
						sql.append("select * from trainsseat");

						if (TrainTypeName != null && !TrainTypeName.equals("")) {
							sql.append(" where TrainTypeName like '%" + TrainTypeName.trim() + "%'");
						}
						if (TrainNo != null && !TrainNo.equals("")) {
							sql.append(" and TrainNo like '%" + TrainNo.trim() + "%'");
						}

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

	// 查詢單筆車次座位
	public ArrayList<Station_trainItem> SelectTrainSeat(String Id) {
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
						sql.append("select * from trainsseat where Id='" + Id + "'");

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

	// 更新管理者
	public boolean UpdateTrains(String Id, Map<String, String> seat) {
		boolean s = false;
		// 存進資料庫
		Properties prop = new Properties();
		prop.setProperty("user", user);
		prop.setProperty("password", password);
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/demo", prop)) {

			PreparedStatement pstmt = conn.prepareStatement("update trainsseat set Seat=? WHERE ID=?");
			pstmt.setObject(1, seat);
			pstmt.setString(2, Id);

			pstmt.executeUpdate();

			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}

		return true;
	}

}
