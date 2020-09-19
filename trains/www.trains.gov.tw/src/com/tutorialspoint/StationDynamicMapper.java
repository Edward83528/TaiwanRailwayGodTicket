package com.tutorialspoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StationDynamicMapper implements RowMapper<StationDynamicItem> {
	public StationDynamicItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		StationDynamicItem stationDynamic = new StationDynamicItem();
		stationDynamic.setId(rs.getString("Id"));
		stationDynamic.setStationID(rs.getString("StationID"));
		stationDynamic.setTrainNo(rs.getString("TrainNo"));
		stationDynamic.setDirection(rs.getString("Direction"));
		stationDynamic.setTrainClassificationID(rs.getString("TrainClassificationID"));
		stationDynamic.setTripLine(rs.getString("TripLine"));
		stationDynamic.setEndingStationID(rs.getString("EndingStationID"));
		stationDynamic.setScheduledArrivalTime(rs.getString("ScheduledArrivalTime"));
		stationDynamic.setScheduledDepartureTime(rs.getString("ScheduledDepartureTime"));
		stationDynamic.setDelayTime(rs.getString("DelayTime"));
		stationDynamic.setSrcUpdateTime(rs.getString("SrcUpdateTime"));
		stationDynamic.setUpdateTime(rs.getString("UpdateTime"));

		return stationDynamic;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
