package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class FAQJDBCTemplate implements FAQDAO {
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
	public FAQItem getFAQ(Integer id) {
		String SQL = "select * from FQ where id = ?";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		FAQItem FAQ = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new FAQMapper());
		return FAQ;
	}

	// 查詢多筆
	public List<FAQItem> listFAQ() {
		String SQL = "select * from FQ order by Id desc";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<FAQItem> FAQs = jdbcTemplateObject.query(SQL, new FAQMapper());
		return FAQs;
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
