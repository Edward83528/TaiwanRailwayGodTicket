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
		//接收參數
		String Id = (String) request.getParameter("id");
		String Question = request.getParameter("Question");
		String answer = request.getParameter("answer");
		TrainData trainData = new TrainData();
		boolean check = trainData.UpdateFAQ(Id, Question, answer);
		if (check == true) {
			System.out.println("更新成功");
	%>
	<script>
		alert("更新成功!");
		window.location.href = "FAQ.jsp";
	</script>
	<%
		} else {
			System.out.println("更新失敗");
	%>
	<script>
		alert("更新失敗!");
		window.location.href = "FAQ.jsp";
	</script>
	<%
		}
	%>

</body>
</html>