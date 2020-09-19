package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class StationJDBCTemplate implements StationDAO {
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
	public StationItem getStation(Integer id) {
		String SQL = "select * from News where id = ?";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		StationItem news = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StationMapper());
		return news;
	}

	// 查詢多筆
	public List<StationItem> listStation(String keyword) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from stations");
		if (keyword != null && !keyword.equals("")) {
			sql.append(" where WebsiteName like '%" + keyword + "%'");
		}
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<StationItem> station = jdbcTemplateObject.query(sql.toString(), new StationMapper());
		return station;
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
