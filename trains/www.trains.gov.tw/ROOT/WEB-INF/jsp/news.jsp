<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.tutorialspoint.NewsJDBCTemplate"%>
<%@ page import="com.tutorialspoint.*"%>
<%@ page import="tw.com.common.*"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>
<!-- 資源檔 -->
<%@include file="../../include/resources.jsp"%>
</head>
<body>

	<div class="anibg">
		<img src="<c:url value="/image/anilogo.png" />">
		<div class="backA"></div>
		<div class="backB"></div>
	</div>
	<div id="all">
		<div id="topbackgroundmore">


			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>


			<!-- NEWS -->
			<div id="innernews">
				<div class="container">
					<a id="back" href="../../index.jsp">返回</a>

					<%
						try {
							String index = (String) request.getAttribute("id");
							int id = Integer.parseInt(index);
							ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
							NewsJDBCTemplate newsJDBCTemplate = (NewsJDBCTemplate) context.getBean("NewsJDBCTemplate");
							News news = newsJDBCTemplate.getNews(id);
					%>

					<div class="news">
						<div class="newstitle">第${id}則最新消息</div>

						<div class="topnews">
							<p><%=news.getDate1()%></p>
							<span><%=news.getSubject1()%></span>
						</div>

						<div class="innertext">
							<div class="text">
								<p><%=news.getContent1()%></p>
							</div>
						</div>

						<div class="newslink">
							<div class="titlelink">
								<span class="glyphicon glyphicon-link">&nbsp;相關連結</span>
							</div>
							<a href="http://typhoon.ws/" target="_blank">台灣颱風資訊中心</a>
						</div>

						<div class="newsimg">
							<div class="imgtitle">
								<span class="glyphicon glyphicon-picture">&nbsp;相關圖片</span>
							</div>
							<img src="<c:url value="/image/news0.jpg" />">

						</div>

					</div>

					<%
						} catch (Exception e) {
							out.print("您沒資料庫");

						}
					%>
				</div>
			</div>

			<%@include file="../../include/foot.jsp"%>

		</div>
	</div>
</body>
</html>