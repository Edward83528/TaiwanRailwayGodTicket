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
		String areas = (String) request.getAttribute("areas");
		SelectTrainCode selectTrainCode = new SelectTrainCode();
		String s = selectTrainCode.getStationAreas(areas);
		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().print("||" + "'" + s + "'" + "||");
		response.getWriter().flush();
		response.getWriter().close();
	%>
</body>
</html>