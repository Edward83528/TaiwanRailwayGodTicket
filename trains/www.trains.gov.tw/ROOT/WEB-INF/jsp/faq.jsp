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


			<!-- faqS -->
			<div id="innernews">
				<div class="container">
					<a id="back" href="../../index.jsp">返回</a>

					<%
						try {
							String index = (String) request.getAttribute("id");
							int id = Integer.parseInt(index);
							ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
							FAQJDBCTemplate fAQJDBCTemplate = (FAQJDBCTemplate) context.getBean("FAQJDBCTemplate");
							FAQItem faq = fAQJDBCTemplate.getFAQ(id);
					%>

					<div class="news">
						<div class="newstitle">第${id}則常見問答</div>

						<div class="topnews">
							<p></p>
							<span><%=faq.getQuestion()%></span>
						</div>

						<div class="innertext">
							<div class="text">
								<p><%=faq.getAnswer()%></p>
							</div>
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