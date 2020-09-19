<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.tutorialspoint.NewsJDBCTemplate"%>
<%@ page import="com.tutorialspoint.*"%>
<%@ page import="tw.com.common.*"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>
<!-- 資源檔 -->
<%@include file="../../include/resources.jsp"%>
<script src="<c:url value="/js/starcanvas.js" />"></script>
</head>
<body>
	<%
		String messages = (String) request.getAttribute("messages");
	%>
	<div class="anibg">
		<img src="<c:url value="/image/anilogo.png" />">
		<div class="backA"></div>
		<div class="backB"></div>
	</div>

	<div id="all">
		<div id="topbackgroundmessage">

			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>

			<div id="message">
				<div class="container">
					<div class="srollbg">
						<canvas id="canvas"></canvas>
						<div class="srollImage"></div>
						<img src="<c:url value="/image/movetrain2.png" />">
						<div class="innerText">
							<p><%=messages%></p>
							<div>
								<a href="../../index.jsp"><button type="button"
										class="btn btn-danger">Home</button></a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- pagefooter -->
			<%@include file="../../include/foot.jsp"%>
		</div>
	</div>
</body>
</html>