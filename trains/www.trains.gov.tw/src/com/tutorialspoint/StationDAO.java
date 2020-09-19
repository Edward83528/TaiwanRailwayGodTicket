package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

public interface StationDAO {

	// 設定資料庫
	public void setDataSource(DataSource ds);

	// 新增資料
	public void create(String Subject1, String Content1, String Link);

	// 查詢單筆
	public StationItem getStation(Integer id);

	// 查詢多筆
	public List<StationItem> listStation(String keyword);

	public void update(String id, Integer age);

}
