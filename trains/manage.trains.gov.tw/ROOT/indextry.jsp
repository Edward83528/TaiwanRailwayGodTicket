<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>

<%
	String loginFormURL = "index.jsp";
	String user = (String) session.getAttribute("user");
	String password = (String) session.getAttribute("password");
	if (user == null || password == null) {
%>
<script type="text/javascript">
	alert("您還沒登入！");
	window.location.href = "index.jsp";
</script>
<%
	} else if (!user.equals("root") && !password.equals("123")) {
%>
<script type="text/javascript">
	alert("登入失敗，請洽系統管理者，謝謝您！");
	window.location.href = "index.jsp";
</script>
<%
	}
%>
</head>

<frameset id="Frame" rows="55,*" framespacing="0" frameborder="no"
	border="0">
	<frame id="topFrame" name="topFrame" scrolling="No" noresize="noresize"
		title="topFrame" src="top.jsp">
	<frameset id="menuFram" cols="300,*" framespacing="0" frameborder="no"
		border="0">
		<frame name="leftFrame" scrolling="No" noresize="noresize"
			src="left.jsp">
		<frame name="content" src="welcome.jsp">
	</frameset>
</frameset>



</html>
