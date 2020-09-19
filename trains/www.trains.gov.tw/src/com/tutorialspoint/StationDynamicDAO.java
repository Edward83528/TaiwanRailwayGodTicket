package com.tutorialspoint;

import java.util.List;

import javax.sql.DataSource;

public interface StationDynamicDAO {

	// 設定資料庫
	public void setDataSource(DataSource ds);

	// 新增news資料
	public void create(String Subject1, String Content1, String Link);

	// 查詢單筆
	public StationDynamicItem getStationDynamic(Integer id);

	// 查詢多筆
	public List<StationDynamicItem> listStationDynamic();

	public void update(String id, Integer age);

}
