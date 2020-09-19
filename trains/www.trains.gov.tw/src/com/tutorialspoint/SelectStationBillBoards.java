package com.tutorialspoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

//取網路上指定車站電子刊版
public class SelectStationBillBoards {

	public static void main(String[] args) {
		SelectStationBillBoards a = new SelectStationBillBoards();
		ArrayList<SelectStationBillBoardItem> lists = a.getTrainSelectList("1008");
		SelectStationBillBoardItem list = lists.get(0);
		System.out.println(list.getStationName());
	}

	public ArrayList<SelectStationBillBoardItem> getTrainSelectList(String station) {
		// http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/GeneralTimetable?&$format=JSON"
		// http://ptx.transportdata.tw/MOTC/版號/運具/台鐵(TRA)高鐵(THSR)/電子刊版/車站代碼?$format=JSON"
		StringBuilder s = new StringBuilder();
		s.append("http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/LiveBoard/");
		s.append(station);
		s.append("?&$format=JSON");
		String json = getJSONString(s.toString());
		ArrayList<SelectStationBillBoardItem> train = new ArrayList<SelectStationBillBoardItem>();
		JSONArray root = new JSONArray(json);
		for (int i = 0; i < root.length(); i++) {
			SelectStationBillBoardItem trainsItem = new SelectStationBillBoardItem();
			JSONObject row = root.getJSONObject(i);
			trainsItem.setStationID(row.getString("StationID"));
			trainsItem.setStationName(row.getJSONObject("StationName").getString("Zh_tw"));
			trainsItem.setTrainNo(row.getString("TrainNo"));
			trainsItem.setDirection(String.valueOf(row.getInt("Direction")));
			trainsItem.setTripLine(String.valueOf(row.getInt("TripLine")));
			trainsItem.setTrainClassificationID(row.getString("TrainClassificationID"));
			trainsItem.setEndingStationID(row.getString("EndingStationID"));
			trainsItem.setEndingStationName(row.getJSONObject("EndingStationName").getString("Zh_tw"));
			trainsItem.setScheduledArrivalTime(row.getString("ScheduledArrivalTime"));
			trainsItem.setScheduledDepartureTime(row.getString("ScheduledDepartureTime"));
			trainsItem.setDelayTime(String.valueOf(row.getInt("DelayTime")));
			trainsItem.setPlatform(row.getString("Platform"));
			trainsItem.setSrcUpdateTime(row.getString("SrcUpdateTime"));
			trainsItem.setUpdateTime(row.getString("UpdateTime"));

			train.add(trainsItem);

		}
		return train;
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
			// System.out.println(sb);
		} catch (Exception e) {
			System.out.println(e);
		}
		return sb.toString();
	}

}