package com.tutorialspoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StationMapper implements RowMapper<StationItem> {
	public StationItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		StationItem station = new StationItem();
		station.setSerno(rs.getString("Serno"));
		station.setChineseAddress(rs.getString("ChineseAddress"));
		station.setGps(rs.getString("Gps"));
		station.setStation_Code_1(rs.getString("Station_Code_1"));
		station.setStation_Code_2(rs.getString("Station_Code_2"));
		station.setTelephone(rs.getString("Telephone"));
		station.setWebsiteName(rs.getString("WebsiteName"));
		return station;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
