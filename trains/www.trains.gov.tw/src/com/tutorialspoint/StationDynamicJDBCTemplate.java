package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StationDynamicJDBCTemplate implements StationDynamicDAO {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;

	// 設定資料庫
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("getRecord");
	}

	// 新增news資料
	public void create(String Subject1, String Content1, String Link) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "insert into News (Date1,Subject1,Content1,Link) values (CURDATE(),?, ?, ?)";
		jdbcTemplateObject.update(SQL, Subject1, Content1, Link);
		System.out.println("Created Record Subject = " + Subject1 + " Content1 = " + Content1);
		return;
	}

	// 查詢單筆
	public StationDynamicItem getStationDynamic(Integer id) {
		String SQL = "select * from News where id = ?";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		StationDynamicItem news = jdbcTemplateObject.queryForObject(SQL, new Object[] { id },
				new StationDynamicMapper());
		return news;
	}

	// 查詢多筆
	public List<StationDynamicItem> listStationDynamic() {
		String SQL = "select * from traindnamic";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<StationDynamicItem> stationDynamic = jdbcTemplateObject.query(SQL, new StationDynamicMapper());
		return stationDynamic;
	}

	public void update(String id, Integer age) {
		String SQL = "update trains set Seat = ? where Serno = ?";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
