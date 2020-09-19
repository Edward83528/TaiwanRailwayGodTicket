<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.com.common.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="include/resources.jsp"%>
</head>
<body>

	<%
		//刪掉seddion登出
		session.invalidate();
		response.sendRedirect("index.jsp");
	%>

</body>
</html>
