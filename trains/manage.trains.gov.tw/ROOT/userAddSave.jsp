<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.com.common.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>
</head>
<body>
	<%
		//解決編碼問題
		request.setCharacterEncoding("UTF-8");
		String Name = request.getParameter("name");
		String User = request.getParameter("user");
		String Password = request.getParameter("password");

		TrainData trainData = new TrainData();
		//存入資料庫密碼採MD5
		boolean check = trainData.AddUser(Name, User, md5.getmd5(Password));
		if (check == true) {
			System.out.println("新增成功");
	%>
	<script>
		alert("新增成功!");
		window.location.href = "user.jsp";
	</script>
	<%
		} else {
			System.out.println("新增失敗");
	%>
	<script>
		alert("新增失敗!");
		window.location.href = "user.jsp";
	</script>
	<%
		}
	%>

</body>
</html>