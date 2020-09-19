package com.tutorialspoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class orderTicket {

	// 資料庫連線資訊
	String url = "jdbc:mysql://localhost:3306/demo";
	String user = "root";
	String password = "zxcvbnm0351";
	String url2 = "jdbc:mysql://localhost:2222/traininfo";
	String password2 = "root";

	public static void main(String[] args) {
		orderTicket order = new orderTicket();
		ArrayList<TrainsItem> lists = order.selectTrain("1238", "1319", "自強");
		for (int i = 0; i < lists.size(); i++) {
			TrainsItem list = lists.get(i);
			String TrainNumber = list.getTrainNumber();
			System.out.println(TrainNumber);

		}
		System.out.println("OK");

	}

	// 使用者訂票搜尋班次
	public ArrayList<TrainsItem> selectTrain(String start, String end, String TrainTypeName) {
		StringBuilder sql = new StringBuilder();
		ArrayList<TrainsItem> result = new ArrayList<TrainsItem>();
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

						if (checkStationLine(start, end)) {

							Integer a = Integer.valueOf(start);
							Integer b = Integer.valueOf(end);

							sql.append("SELECT * FROM demo.trains where StationID='" + start + "' or StationID='" + end
									+ "'");
							if (!TrainTypeName.equals("0")) {

								sql.append(" and TrainTypeName like'%" + TrainTypeName + "%'");
							}
							if (a - b > 0) {
								sql.append("and Direction='0'");

							} else {
								sql.append("and Direction='1'");
							}
							sql.append(" and TrainTypeName <> '區間車'");
							sql.append(" and TrainTypeName <> '區間快'");
							sql.append(" GROUP BY TrainNo  HAVING count(*)>1");
							System.out.println(sql.toString());

						}
						ResultSet rs = stmt.executeQuery(sql.toString());

						for (int i = 0; rs.next(); i++) {
							TrainsItem lists = new TrainsItem();
							lists.setId(rs.getString("TrainNo"));
							lists.setTrainNumber((rs.getString("TrainNo")));
							lists.setArrivalTime(rs.getString("ArrivalTime"));
							lists.setDepartureTime(rs.getString("DepartureTime"));
							lists.setTrainTypeName(rs.getString("TrainTypeName"));
							result.add(lists);
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

	public String selectTraindirection(String start, String end) {

		return "";
	}

	// 檢查起驛站是否為同一路線
	public boolean checkStationLine(String start, String end) {
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
						sql.append("SELECT * FROM demo.stationsline where StationID='" + start + "' or StationID='"
								+ end + "'GROUP BY LineID  HAVING count(*)>1");

						ResultSet rs = stmt.executeQuery(sql.toString());

						// 顯示資料

						while (rs.next()) {

							check = true;
						}

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

		return check;

	}

}
