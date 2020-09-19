package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class TrainsJDBCTemplate implements TrainsDAO {
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
	public TrainsItem getTrain(Integer id) {
		String SQL = "select * from trains where id = ?";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		TrainsItem train = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new TrainsMapper());
		return train;
	}

	// 查詢多筆
	public List<TrainsItem> listTrains() {
		StringBuilder lists = new StringBuilder();
		lists.append("select * from trains");
		lists.append(" where Id=1 ");
		lists.append(" or Id=5 ");
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<TrainsItem> train = jdbcTemplateObject.query(lists.toString(), new TrainsMapper());
		return train;
	}

	// 查詢指定多筆
	public List<TrainsItem> listTrains(String id) {
		StringBuilder lists = new StringBuilder();
		lists.append("select * from trains ");
		lists.append(" where TrainNo='" + id + "' ");
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<TrainsItem> train = jdbcTemplateObject.query(lists.toString(), new TrainsMapper());
		return train;
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
