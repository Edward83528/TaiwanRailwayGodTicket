<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
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
			String messages = (String) request.getAttribute("messages");
			String start = (String) request.getAttribute("start");
			String end = (String) request.getAttribute("end");
			String TrainTypeName = (String) request.getAttribute("TrainTypeName");
			String seats = (String) request.getAttribute("seats");
			String start1 = start.substring(0, 1);
			String start2 = start.substring(1, 2);
			String end1 = end.substring(0, 1);
			String end2 = end.substring(1, 2);
			String TrainTypeName1 = TrainTypeName.substring(0, 1);
			String TrainTypeName2 = TrainTypeName.substring(1, 2);
			String seats1 = seats.substring(0, 1);
			String seats2 = seats.substring(1, 2);
			String seats3 = seats.substring(2, 3);
		%>

		<div id="topbackgroundOr3">


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
					<div class="progress-bar progress-bar-info" role="progressbar"
						aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
						style="width: 35%">
						<label class="control-label ">2. 取票資訊 </label>
					</div>
					<div
						class="progress-bar progress-bar-success progress-bar-striped active"
						role="progressbar" aria-valuenow="40" aria-valuemin="0"
						aria-valuemax="100" style="width: 30%">
						<label class="control-label ">3. 完成訂位 </label>
					</div>
				</div>
			</div>
			<!-- 完成訂位 -->
			<div id="order-3">
				<div class="container">
					<fieldset class="order">
						<legend>
							<label class="control-label ">完成訂位</label>
						</legend>


						<label class="control-label "><h2>恭喜您已完成訂位!!!訂票張數${total}張</h2></label>
						<br><label class="control-label "><h2>電腦代碼:9756</h2></label>

						<div class="overlay">
							<img src="<c:url value="/image/ticket.jpg" />">
							<div>
								<br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${date}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;台灣鐵路局<br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=TrainTypeName1%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=TrainTypeName2%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${trainid}&nbsp;次<br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=start1%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=start2%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&rarr;<%=end1%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=end2%><br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${ArrivalTime}開&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${DepartureTime}到<br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=seats1%>&nbsp;&nbsp;&nbsp;車&nbsp;&nbsp;&nbsp;<%=seats3%>&nbsp;&nbsp;&nbsp;號&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cars.&nbsp;<%=seats1%>&nbsp;&nbsp;Seat.&nbsp;&nbsp;<%=seats3%><br>
								<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=messages%><br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;NT&nbsp;$&nbsp;300元<br>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;087465-0284-389&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限當日當次車有效

							</div>


						</div>

						<div class="submit">
							<button type="button" class="btn btn-success btn-lg"
								onclick="location.href='../index.jsp'">返回首頁</button>
						</div>
					</fieldset>
				</div>
			</div>

			<!-- pagefooter -->


			<%@include file="../../include/foot.jsp"%>




		</div>
	</div>
</body>
</html>