package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

public interface FAQDAO {

	// 設定資料庫
	public void setDataSource(DataSource ds);

	// 新增資料
	public void create(String Subject1, String Content1, String Link);

	// 查詢單筆
	public FAQItem getFAQ(Integer id);

	// 查詢多筆
	public List<FAQItem> listFAQ();

	public void update(String id, Integer age);

}
