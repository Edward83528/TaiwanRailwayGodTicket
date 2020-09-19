<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.tutorialspoint.*"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="cn">
<head>
<%
	//讀取spring sql 的Beans.xml
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>

<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>
<script>
	
</script>

</head>
<body>
	<div class="anibg">
		<img src="<c:url value="/image/anilogo.png" />">
		<div class="backA"></div>
		<div class="backB"></div>
	</div>
	<div id="all">
		
		<a id="up"> <span class="glyphicon glyphicon glyphicon-chevron-up"></span></a>

		<div id="topbackground">

			<!-- 導覽列 上方圖片-->

			<%@include file="include/menu.jsp"%>

			<!-- 火車動態時刻 -->
			<div id="timetable">
				<div class="container">
					<div class="row">


						<div class="col-sm-6">
							<div class="left">
								<div class="time">
									<div class="title">
										<label class="control-label">北上車次</label>
									</div>

									<table class="rwd-table">
										<tr>
											<th>車種</th>
											<th>車次</th>
											<th>到達時間</th>
											<th>往</th>
											<th>狀態</th>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box0 haveimg">
													<img src="image/trains/train02.PNG"><span
														class="trainname">自強號</span>
												</div></td>
											<td data-th="車次"><div class="bg box1">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box2">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box3">
													<span class="place">台北</span>
												</div></td>
											<td data-th="狀態"><div class="bg bg0 box4">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box5 haveimg">
													<img src="image/trains/train00.PNG"><span
														class="trainname">普悠瑪號</span>
												</div></td>
											<td data-th="車次"><div class="bg box6">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box7">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box8">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box9">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box10 haveimg">
													<img src="image/trains/train01.PNG"><span
														class="trainname">太魯閣號</span>
												</div></td>
											<td data-th="車次"><div class="bg box11">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box12">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box13">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box14">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box15 haveimg">
													<img src="image/trains/train03.PNG"><span
														class="trainname">莒光號</span>
												</div></td>
											<td data-th="車次"><div class="bg box16">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box17">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box18">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box19">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box20 haveimg">
													<img src="image/trains/train04.PNG"><span
														class="trainname">區間車</span>
												</div></td>
											<td data-th="車次"><div class="bg box21">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box22">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box23">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box24">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
									</table>

								</div>
							</div>
						</div>

						<div class="col-sm-6">
							<div class="right">
								<div class="time">
									<div class="title">
										<label class="control-label">南下車次</label>
									</div>

									<table class="rwd-table">
										<tr>
											<th>車種</th>
											<th>車次</th>
											<th>到達時間</th>
											<th>往</th>
											<th>狀態</th>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box25 haveimg">
													<img src="image/trains/train02.PNG"><span
														class="trainname">自強號</span>
												</div></td>
											<td data-th="車次"><div class="bg box26">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box27">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box28">
													<span class="place">台北</span>
												</div></td>
											<td data-th="狀態"><div class="bg bg0 box29">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box30 haveimg">
													<img src="image/trains/train00.PNG"><span
														class="trainname">普悠瑪號</span>
												</div></td>
											<td data-th="車次"><div class="bg box31">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box32">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box33">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box34">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box35 haveimg">
													<img src="image/trains/train01.PNG"><span
														class="trainname">太魯閣號</span>
												</div></td>
											<td data-th="車次"><div class="bg box36">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box37">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box38">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box39">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box40 haveimg">
													<img src="image/trains/train03.PNG"><span
														class="trainname">莒光號</span>
												</div></td>
											<td data-th="車次"><div class="bg box41">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box42">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box43">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box44">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
										<tr>
											<td data-th="車種"><div class="bg box45 haveimg">
													<img src="image/trains/train04.PNG"><span
														class="trainname">區間車</span>
												</div></td>
											<td data-th="車次"><div class="bg box46">
													<span class="trip">165</span>
												</div></td>
											<td data-th="到達時間"><div class="bg box47">
													<span class="arrivetime">1658</span>
												</div></td>
											<td data-th="往"><div class="bg box48">
													<span class="place">高雄</span>
												</div></td>
											<td data-th="狀態"><div class="bg box49">
													<span class="state">晚3分</span>
												</div></td>
										</tr>
									</table>

								</div>
							</div>
						</div>


					</div>
				</div>

			</div>

		</div>

		<div id="downbackground">
			<!-- News -->
			<div id="news">
				<div class="container">
					<ul class="list-inline">
						<li class="active"><a data-toggle="tab" href="#home">最新消息</a></li>
						<li><a data-toggle="tab" href="#menu1">常見問答</a></li>
					</ul>

					<div class="tab-content">
						<div id="home" class="tab-pane fade in active">

							<%
								try {
									//讀取Template
									NewsJDBCTemplate newsJDBCTemplate = (NewsJDBCTemplate) context.getBean("NewsJDBCTemplate");
									List<News> news = newsJDBCTemplate.listNews();
									for (int i = 0; i < 4; i++) {
										News list = (News) news.get(i);
										String date1 = list.getDate1();
										String date2 = date1.substring(0, 4);
										String date3 = date1.substring(4, 6);
										String date4 = date1.substring(6, 8);
							%>
							<div class="row">
								<div class="col-sm-6">
									<div class="center">
										<a href="/HelloWeb/morein?id=<%=list.getId()%>"> <span>Read
												More</span> <img src="image/news<%=i%>.jpg">
										</a>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="content">
										<div id="date">
											<p><%=date2%>-<%=date3%>-<%=date4%></p>
										</div>
										<div class="message">
											<a href="/HelloWeb/morein?id=<%=list.getId()%>"><%=list.getSubject1()%></a>
										</div>
									</div>
								</div>

							</div>

							<hr>

							<%
								}
								} catch (Exception e) {
									out.print("您沒有MySql Server提供資料");

								}
							%>


							<div id="more">
								<a href="/HelloWeb/more?start=1">更多...</a>
							</div>

						</div>

						<div id="menu1" class="tab-pane fade">

							<%
								try {
									//讀取Template
									FAQJDBCTemplate fAQJDBCTemplate = (FAQJDBCTemplate) context.getBean("FAQJDBCTemplate");
									List<FAQItem> faqs = fAQJDBCTemplate.listFAQ();
									for (int j = 0; j < faqs.size(); j++) {

										FAQItem faq = (FAQItem) faqs.get(j);
							%>
							<div class="question">
								<a href="/HelloWeb/moreinfaq?id=<%=faq.getId()%>"><%=faq.getQuestion()%></a>
							</div>
							<hr>

							<%
								}
								} catch (Exception e) {
									out.print("您沒有MySql Server提供資料");

								}
							%>
							<div id="more">
								<a href="/HelloWeb/morefaq?start=1">更多...</a>
							</div>
						</div>

					</div>
				</div>
			</div>


			<!-- pagefooter -->

			<%@include file="include/foot.jsp"%>

		</div>
	</div>


</body>
</html>