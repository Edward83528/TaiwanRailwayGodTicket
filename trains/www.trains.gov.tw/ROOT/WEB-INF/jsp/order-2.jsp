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
<%@ page import="java.util.List"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>
<!-- 資源檔 -->
<%@include file="../../include/resources.jsp"%>

<script type="text/javascript">
	function save() {

		document.mform.action = "/HelloWeb/addorder2";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>


</head>
<body>
	<div class="anibg">
		<img src="<c:url value="/image/anilogo.png" />">
		<div class="backA"></div>
		<div class="backB"></div>
	</div>
	<div id="all">
		<div id="topbackgroundOr2">

			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>


			<!-- 訂票欄 -->
			<div class="container">
				<label class="control-label ">您所在的訂位步驟：</label>
				<div class="progress">
					<div class="progress-bar" role="progressbar" aria-valuenow="40"
						aria-valuemin="0" aria-valuemax="100" style="width: 35%">
						<label class="control-label ">1. 選擇車次 </label>
					</div>
					<div
						class="progress-bar progress-bar-info progress-bar-striped active"
						role="progressbar" aria-valuenow="40" aria-valuemin="0"
						aria-valuemax="100" style="width: 35%">
						<label class="control-label ">2. 取票資訊 </label>
					</div>
				</div>
			</div>

			<%
				SelectTrainCode selectTrainCode = new SelectTrainCode();
				String Start = selectTrainCode.SelectStatinName((String) request.getAttribute("start"));
				String End = selectTrainCode.SelectStatinName((String) request.getAttribute("end"));
				String total = (String) request.getAttribute("total");
				String Twid = (String) request.getAttribute("Twid");
				String date = (String) request.getAttribute("date");
				String check = (String) request.getAttribute("check");
				ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
				TrainsJDBCTemplate trainsJDBCTemplate = (TrainsJDBCTemplate) context.getBean("TrainsJDBCTemplate");
				List<TrainsItem> trains = trainsJDBCTemplate.listTrains(check);
				TrainsItem train = (TrainsItem) trains.get(0);
				TrainsItem train2 = (TrainsItem) trains.get(9);
			%>

			<!-- 訂位明細 -->
			<div id="order-2">
				<form:form method="POST" action="/HelloWeb/addorder2" name="mform">
					<input type="hidden" name="total" value="<%=total%>">
					<input type="hidden" name="trainid"
						value="<%=train.getTrainNumber()%>">
					<input type="hidden" name="TrainTypeName"
						value="<%=train.getTrainTypeName()%>">
					<input type="hidden" name="date" value="<%=date%>">
					<input type="hidden" name="start" value="<%=Start%>">
					<input type="hidden" name="end" value="<%=End%>">
					<input type="hidden" name="ArrivalTime"
						value="<%=train.getArrivalTime()%>">
					<input type="hidden" name="DepartureTime"
						value="<%=train2.getArrivalTime()%>">
					<input type="hidden" name="Twid" value="<%=Twid%>">
					<div class="container">
						<fieldset class="order">
							<legend>
								<label class="control-label ">訂位明細</label>
							</legend>

							<table class="rwd-table">
								<tr>
									<th>日期</th>
									<th>車次</th>
									<th>出發時間</th>
									<th>到達時間</th>
									<th>起程站</th>
									<th>到達站</th>
									<th>全票</th>
								</tr>
								<tr>
									<td data-th="日期">${date}</td>
									<td data-th="車次"><%=train.getTrainNumber()%></td>
									<td data-th="出發時間"><%=train.getArrivalTime()%></td>
									<td data-th="到達時間"><%=train2.getArrivalTime()%></td>
									<td data-th="起程站"><%=Start%></td>
									<td data-th="到達站"><%=End%></td>
									<td data-th="全票">${total}張</td>
								</tr>
							</table>



							<div class="submit">
								<div class="left">
									<button type="button" class="btn btn-warning btn-lg"
										onclick="location.href='/HelloWeb/order1' ">
										上一步</a>
									</button>
								</div>

								<div class="right">
									<button type="button" class="btn btn-warning btn-lg"
										onclick="javascript:save()">
										完成訂位</a>
									</button>
								</div>

							</div>

						</fieldset>
					</div>
				</form:form>
			</div>

			<!-- pagefooter -->
			<%@include file="../../include/foot.jsp"%>

		</div>
	</div>
</body>
</html>