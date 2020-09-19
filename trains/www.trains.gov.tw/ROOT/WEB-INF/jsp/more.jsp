<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.*"%>
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


			<div id="morenews">
				<div class="container">
					<h2>最新消息</h2>

					<a id="back" href="../../index.jsp">返回</a>

					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">

							<%
								ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
								NewsJDBCTemplate newsJDBCTemplate = (NewsJDBCTemplate) context.getBean("NewsJDBCTemplate");
								List<News> news = newsJDBCTemplate.listNews();

								//頁數管理
								//起始資料索引
								String start1 = (String) request.getParameter("start");
								if (start1 == null || start1.equals(""))
									start1 = "1";
								int start2 = Integer.parseInt(start1);
								//每頁顯示15筆
								int pagesize = 15;
								//資料總筆數
								int rcount = news.size();

								//最大頁數
								int maxpage = rcount % pagesize;
								if (maxpage == 0)
									maxpage = rcount / pagesize;
								else
									maxpage = (rcount / pagesize) + 1;

								int startpage = (1 - 1) * pagesize + 1;
								int endpage = start2 + pagesize - 1;
								for (int i = start2 - 1; ((i < endpage) && (i < rcount)); i++) {
									News record = news.get(i);
							%>
							<div class="row">
								<div class="col-sm-6">
									<div class="center">
										<a href="/HelloWeb/morein?id=<%=record.getId()%>"> <span>Read
												More</span> <img src="<c:url value="/image/news1.jpg" />">
										</a>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="content">
										<div id="date">
											<p><%=record.getDate1()%></p>
										</div>
										<div class="message">
											<a href="/HelloWeb/morein?id=<%=record.getId()%>"><%=record.getSubject1()%></a>
										</div>
									</div>
								</div>
							</div>
							<%
								}
							%>

							<hr>


							<div class="thispagination">
								<ul class="pagination">
									<%
										if (maxpage != 0 && start2 != 1) {
									%>
									<li><a href="/HelloWeb/more?start=<%=1%>">最前頁</a></li>
									<%
										}
									%>
									<%
										if (start2 != 1) {
									%>
									<li><a href="/HelloWeb/more?start=<%=start2 - 15%>">上一頁</a>
									</li>
									<%
										}
									%>
									<li>
										<%
											int k = (start2 % 15 == 0 ? (start2 / 15) : (start2 / 15 + 1)) + 9;
											if (k - 9 + 9 < maxpage) {
												for (int y = k - 10; y < k; y++) {
										%> <a href="/HelloWeb/more?start=<%=y * 15 + 1%>"><%=y + 1%></a>
										<%
											if (y >= maxpage - 1) {
														break;
													}
										%> <%
 	}
 	} else {

 		int p = k - 10;
 		int u = 0;
 		if (maxpage < 10) {
 			u = 10 - maxpage;
 		} else {
 			u = 10 - maxpage;
 		}
 		int maxpage3 = 0;
 		if (maxpage < 10) {
 			maxpage3 = maxpage - 9 + u;
 		} else {
 			maxpage3 = maxpage - 9;
 		}

 		for (int y = maxpage; y >= maxpage - 9; y--) {
 			if (maxpage3 <= maxpage) {
 %> <a href="/HelloWeb/more?start=<%=(maxpage3 - 1) * 15 + 1%>"><%=maxpage3++%></a>


										<%
											}
												}
											}
										%>

									</li>
									<%
										if (start2 + (rcount % 15) < rcount) {
									%>
									<li><a href="/HelloWeb/more?start=<%=start2 + 15%>">下一頁
									</a></li>
									<%
										}
									%>
									<%
										if (maxpage != 0 && start2 + (rcount % 15) < rcount) {
									%>
									<li><a href="/HelloWeb/more?start=<%=maxpage * 15 - 14%>">最末頁</a>
									</li>
									<%
										}
									%>
									<br>
									<br>

									<li>目前第<%=k - 9%>頁
									</li>

								</ul>
							</div>



						</div>
					</div>

				</div>
			</div>

			<%@include file="../../include/foot.jsp"%>


		</div>
	</div>
</body>
</html>