package com.tutorialspoint;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class NewsJDBCTemplate implements NewsDAO {
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
	public News getNews(Integer id) {
		String SQL = "select * from News where id = ?";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		News news = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new NewsMapper());
		return news;
	}

	// 查詢多筆
	public List<News> listNews() {
		String SQL = "select * from News order by Id desc";
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		List<News> news = jdbcTemplateObject.query(SQL, new NewsMapper());
		return news;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
