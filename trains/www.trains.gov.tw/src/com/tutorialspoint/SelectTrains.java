package com.tutorialspoint;

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

//取網路上鐵路搜尋車次(給 起驛站和日期回傳list)
public class SelectTrains {

	public static void main(String[] args) {
	}

	public ArrayList<TrainsItem> getTrainSelectList(String start, String end, String date) {
		// http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/LiveBoard/1008?$format=JSON"
		// http://ptx.transportdata.tw/MOTC/版號/運具/台鐵(TRA)高鐵(THSR)/電子刊版/車站代碼?$format=JSON"
		StringBuilder s = new StringBuilder();
		s.append("http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/DailyTimetable/OD/");
		s.append(start);
		s.append("/to/");
		s.append(end);
		s.append("/");
		s.append(date);
		s.append("?&$format=JSON");
		String json = getJSONString(s.toString());

		ArrayList<TrainsItem> train = new ArrayList<TrainsItem>();
		JSONArray root = new JSONArray(json);
		for (int i = 0; i < root.length(); i++) {
			TrainsItem trainsItem = new TrainsItem();
			JSONObject row = root.getJSONObject(i);
			trainsItem.setTrainNumber(row.getJSONObject("DailyTrainInfo").getString("TrainNo"));
			trainsItem.setMserno(row.getJSONObject("DailyTrainInfo").getString("TrainTypeID"));
			trainsItem.setArrivalsTime(row.getJSONObject("OriginStopTime").getString("ArrivalTime"));
			trainsItem.setDepartureTime(row.getJSONObject("DestinationStopTime").getString("ArrivalTime"));
			trainsItem.setStartingStationName(
					row.getJSONObject("DailyTrainInfo").getJSONObject("StartingStationName").getString("Zh_tw"));
			trainsItem.setEndingStationName(
					row.getJSONObject("DailyTrainInfo").getJSONObject("EndingStationName").getString("Zh_tw"));
			trainsItem.setPrice1(String.valueOf(getTrainPrice(start, end)));
			train.add(trainsItem);
		}

		System.out.println("OK");
		return train;

	}

	// 取得票價
	public int getTrainPrice(String start, String end) {
		// http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/LiveBoard/1008?$format=JSON"
		// http://ptx.transportdata.tw/MOTC/版號/運具/台鐵(TRA)高鐵(THSR)/電子刊版/車站代碼?$format=JSON"
		StringBuilder s = new StringBuilder();
		s.append("http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/ODFare/");
		s.append(start);
		s.append("/to/");
		s.append(end);
		s.append("?&$format=JSON");
		String json = getJSONString(s.toString());
		int price = 0;
		ArrayList<TrainsItem> train = new ArrayList<TrainsItem>();
		JSONArray root = new JSONArray(json);
		for (int i = 0; i < root.length(); i++) {
			TrainsItem trainsItem = new TrainsItem();
			JSONObject row = root.getJSONObject(i);
			price = row.getJSONArray("Fares").getJSONObject(0).getInt("Price");
		}

		return price;

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