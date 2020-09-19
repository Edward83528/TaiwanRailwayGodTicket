<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>

</head>
<%
	String user = (String) session.getAttribute("user");
%>
<body>
	<input type="checkbox" id="togglebar" class="check">
	<header id="header">
		<div class="logo">
			<img src="image/logo.png"> <span>台鐵神票手後台</span>
		</div>
		<div class="center">
			<label class="hamburger" for="togglebar"> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</label>
		</div>
		<div class="login">
			<span> 歡迎&nbsp;<%=user%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				href="loginout.jsp" target="_parent">登出</a>
			</span>
		</div>
	</header>
</body>


</html>
