package com.tutorialspoint;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FAQMapper implements RowMapper<FAQItem> {
	public FAQItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		FAQItem FAQ = new FAQItem();
		FAQ.setId(rs.getString("Id"));
		FAQ.setQuestion(rs.getString("Question"));
		FAQ.setAnswer(rs.getString("Answer"));
		return FAQ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
