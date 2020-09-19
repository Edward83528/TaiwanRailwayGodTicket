<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>
<!-- 資源檔 -->
<%@include file="../../include/resources.jsp"%>
<%@ page import="com.tutorialspoint.*"%>
<%@ page import="tw.com.common.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>

<script type="text/javascript">
	function save() {
		document.mform.action = "/HelloWeb/addrefund2";
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
		<div id="topbackgroundRefund">


			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>

			<!-- 退票 -->
			<div id="refund-2">
				<div class="container">
					<form:form method="POST" action="/HelloWeb/addrefund" name="mform">

						<fieldset class="order">
							<legend>
								<label class="control-label ">取消訂票確認</label>
							</legend>
							<label class="control-label"><h2>請確認您的退票資訊 :</h2></label>
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
								<%
									String twid = (String) request.getAttribute("twid");
										SelectTrainCode selectTrainCode = new SelectTrainCode();
										ArrayList<OrderList> lists = selectTrainCode.SelectOrderRecord(twid);
										if (lists != null && lists.size() > 0) {
											OrderList list = (OrderList) lists.get(0);
								%>
								<tr>
									<td data-th="日期"><%=list.getDate()%></td>
									<td data-th="車次"><%=list.getTrainNumber()%></td>
									<td data-th="出發時間"><%=list.getArrivalTime()%></td>
									<td data-th="到達時間"><%=list.getDepartureTime()%></td>
									<td data-th="起程站"><%=list.getStart()%></td>
									<td data-th="到達站"><%=list.getEnd()%></td>
									<td data-th="全票"><%=list.getTotal()%>張</td>
								</tr>
								<input type="hidden" name="TrainNumber"
									value="<%=list.getTrainNumber()%>">
								<%
									}
								%>
							</table>

							<div class="submit">
								<button type="button" class="btn btn-danger btn-lg"
									onclick="javascript:save()">確定取消</button>
							</div>
							<input type="hidden" name="Twid" value="<%=twid%>">

						</fieldset>
					</form:form>
				</div>
			</div>


			<!-- pagefooter -->

			<%@include file="../../include/foot.jsp"%>


		</div>
	</div>
</body>
</html>