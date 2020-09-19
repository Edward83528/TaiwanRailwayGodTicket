<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>

<%@ page import="tw.com.common.JsonTrainBillBoards"%>

<%
	//到網路上撈車站電子勘版
	JsonTrainBillBoards jsonTrainBillBoards = new JsonTrainBillBoards();
	out.print(jsonTrainBillBoards.getJSONString("http://ptx.transportdata.tw/MOTC/v2/Rail/TRA/LiveBoard/1008?&$format=JSON"));
%>

