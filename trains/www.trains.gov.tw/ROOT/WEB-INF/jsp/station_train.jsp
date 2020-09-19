<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.tutorialspoint.*"%>
<%@ page import="tw.com.common.*"%>
<%@ page import="com.tutorialspoint.StationItem"%>
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
		<%
			String id = (String) request.getAttribute("id");
			SelectStationBillBoards station = new SelectStationBillBoards();
			ArrayList<SelectStationBillBoardItem> lists = station.getTrainSelectList(id);
		%>
		<div id="topbackgroundStat">

			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>

			<%
				SelectTrainCode stations = new SelectTrainCode();
				ArrayList<StationItem> items = stations.Selectstation(id);
				if (items != null) {
					StationItem item = items.get(0);
					String date = (String) request.getParameter("date");
					if (date == null || date.equals("null")) {
						date = SysUtil.nowDate("yyyy-MM-dd");
					}
			%>
			<div id="station_train">
				<div class="container">
					<div class="topdata">
						<h3><%=item.getWebsiteName()%></h3>
						<p><%=date%></p>
						<div class="phone">
							<div>電話</div>
							<span><%=item.getTelephone()%></span>
						</div>
						<div class="address">
							<div>地址</div>
							<span><%=item.getChineseAddress()%></span>
						</div>


					</div>
					<%
						}
					%>

					<table class="rwd-table">
						<thead>
							<tr>
								<th>詳細資料</th>
								<th>經由</th>
								<th>開車時間</th>
								<th>誤點</th>
								<th></th>
								<th>終點站</th>
							</tr>
						</thead>
						<tbody>

							<%
								for (int i = 0; i < lists.size(); i++) {
									SelectStationBillBoardItem list = (SelectStationBillBoardItem) lists.get(i);

									String type = list.getTripLine();
									switch (type) {
									case "0":
										type = "";
										break;
									case "1":
										type = "山線";
										break;
									case "2":
										type = "海線";
										break;
									}
							%>
							<tr>
								<td data-th="詳細資料"><h3 class="trainName"><%=stations.SelectTrainClass(list.getTrainClassificationID())%></h3>
									<div class="Trips"><%=list.getTrainNo()%></div></td>
								<td data-th="經由"><span class="alongType"><%=type%></span></td>
								<td data-th="開車時間"><%=list.getScheduledDepartureTime()%></td>
								<%
									if (list.getDelayTime().equals("0")) {
								%>
								<td data-th="誤點">準點</td>
								<%
									} else {
								%>
								<td data-th="誤點">晚<%=list.getDelayTime()%>分
								</td>
								<%
									}
								%>
								<td data-th="往"><span
									class="glyphicon glyphicon-arrow-right"></span></td>
								<td data-th="終點站"><%=list.getEndingStationName()%></td>
							</tr>
							<%
								}
							%>

						</tbody>
					</table>
				</div>
			</div>


			<!-- pagefooter -->

			<%@include file="../../include/foot.jsp"%>


		</div>

	</div>

</body>
</html>