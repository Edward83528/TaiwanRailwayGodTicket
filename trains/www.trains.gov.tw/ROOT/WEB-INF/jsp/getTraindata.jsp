<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tutorialspoint.*"%>
<%@ page import="org.json.*"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		JSONArray array = new JSONArray();

		StringBuilder train = new StringBuilder();
		SelectTrainCode selectTrainCode = new SelectTrainCode();
		String start = selectTrainCode.SelectTrainCode((String) request.getAttribute("start"));
		String end = selectTrainCode.SelectTrainCode((String) request.getAttribute("end"));
		String type = (String) request.getParameter("type");
		orderTicket order = new orderTicket();
		ArrayList<TrainsItem> lists = order.selectTrain(start, end, type);
		JSONObject ob = new JSONObject();
		for (int i = 0; i < lists.size(); i++) {
			TrainsItem list = lists.get(i);
			ob.append("TrainNumber", list.getTrainNumber());
			ob.append("ArrivalTime", list.getArrivalTime());
			ob.append("DepartureTime", list.getDepartureTime());
			ob.append("TrainTypeName", list.getTrainTypeName().substring(0, 2));
			ob.append("Id", list.getId());

		}

		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().print("||" + ob.toString() + "||");
		response.getWriter().flush();
		response.getWriter().close();
	%>
</body>
</html>