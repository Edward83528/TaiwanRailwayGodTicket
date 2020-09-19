package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

public interface TrainsDAO {

	// 設定資料庫
	public void setDataSource(DataSource ds);

	// 新增news資料
	public void create(String Subject1, String Content1, String Link);

	// 查詢單筆
	public TrainsItem getTrain(Integer id);

	// 查詢多筆
	public List<TrainsItem> listTrains();

	// 查詢指定多筆
	public List<TrainsItem> listTrains(String d);

	public void update(String id, Integer age);

}
