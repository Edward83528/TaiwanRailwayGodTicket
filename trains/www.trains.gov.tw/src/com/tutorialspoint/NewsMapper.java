package com.tutorialspoint;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class NewsMapper implements RowMapper<News> {
	public News mapRow(ResultSet rs, int rowNum) throws SQLException {
		News news = new News();
		news.setId(rs.getString("Id"));
		news.setDate1(rs.getString("Date1"));
		news.setSubject1(rs.getString("Subject1"));
		news.setContent1(rs.getString("Content1"));
		news.setLink(rs.getString("Link"));
		news.setPicture(rs.getString("Picture"));
		return news;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
