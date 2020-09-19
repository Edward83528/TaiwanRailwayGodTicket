<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.tutorialspoint.*"%>
<%@ page import="tw.com.common.*"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.tutorialspoint.*"%>
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
		<%
			SelectTrainCode selectTrainCode = new SelectTrainCode();
			String Start = selectTrainCode.SelectTrainCode((String) request.getAttribute("Start"));
			String End = selectTrainCode.SelectTrainCode((String) request.getAttribute("End"));
			String date = (String) request.getAttribute("date");
		%>
		<div id="topbackgroundSh2">


			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>



			<!-- 車次查詢表格 -->
			<div id="search-2">
				<div class="container">
					<table class="rwd-table">
						<caption>查詢資訊</caption>
						<tr>
							<th>車種</th>
							<th>車次</th>
							<th>發車站-終點站</th>
							<th>開車時間</th>
							<th>到達時間</th>
							<th>行駛時間</th>
							<th>票價</th>
						</tr>

						<%
							try {
								SelectTrains Trains = new SelectTrains();
								ArrayList<TrainsItem> lists = Trains.getTrainSelectList(Start, End, date);
								for (TrainsItem list : lists) {
						%>

						<tr>
							<td data-th="車種"><%=selectTrainCode.SelectTrainClass(list.getMserno())%></td>
							<td data-th="車次"><%=list.getTrainNumber()%></td>
							<td data-th="發車站-終點站"><%=list.getStartingStationName()%>&rarr;<%=list.getEndingStationName()%></td>
							<td data-th="開車時間"><%=list.getArrivalsTime()%></td>
							<td data-th="到達時間"><%=list.getDepartureTime()%></td>
							<td data-th="行駛時間"><%=SysUtil.formatDuring(SysUtil.difftime(list.getDepartureTime(), list.getArrivalsTime()))%></td>
							<td data-th="票價"><%=list.getPrice1()%>元</td>
						</tr>

						<%
							}
							} catch (Exception e) {
								out.print("您沒有MySql Server提供資料");
							}
						%>



					</table>

				</div>
			</div>


			<!-- pagefooter -->

			<%@include file="../../include/foot.jsp"%>

		</div>

	</div>
	</div>
</body>
</html>