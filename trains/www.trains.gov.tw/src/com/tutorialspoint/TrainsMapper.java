package com.tutorialspoint;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class TrainsMapper implements RowMapper<TrainsItem> {
	public TrainsItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, String> seat = new HashMap<String, String>();
		TrainsItem trains = new TrainsItem();
		trains.setId(rs.getString("Id"));
		trains.setTrainNumber(rs.getString("TrainNo"));
		trains.setTrainTypeID(rs.getString("TrainTypeID"));
		trains.setTrainTypeName(rs.getString("TrainTypeName"));
		trains.setDirection(rs.getString("Direction"));
		trains.setTripLine(rs.getString("TripLine"));
		trains.setNote(rs.getString("Note"));
		trains.setStopSequence(rs.getString("StopSequence"));
		trains.setStationName(rs.getString("StationName"));
		trains.setStationID(rs.getString("StationID"));
		trains.setStartingStationID(rs.getString("StartingStationID"));
		trains.setStartingStationName(rs.getString("StartingStationName"));
		trains.setEndingStationID(rs.getString("EndingStationID"));
		trains.setEndingStationName(rs.getString("EndingStationName"));
		trains.setArrivalTime(rs.getString("ArrivalTime"));
		trains.setDepartureTime(rs.getString("DepartureTime"));
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(rs.getBinaryStream("Seat"));
			seat = (Map<String, String>) (in.readObject());
			trains.setSeat(seat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return trains;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
