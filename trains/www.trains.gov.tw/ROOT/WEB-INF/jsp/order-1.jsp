<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.*"%>
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
<link rel="shortcut icon" href="image/logo.png" />
<link rel="stylesheet"
	href="<c:url value="/js/bootstrap/css/bootstrap.min.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
<link rel="stylesheet"
	href="<c:url value="/js/bootstrap/css/bootstrap-select.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/js/camera/css/camera.css" />">
<link
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/themes/redmond/jquery-ui.css"
	rel="stylesheet">
<script src="<c:url value="/js/bootstrap/js/jquery.js" />"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<script src="<c:url value="/js/datepicker.js" />"></script>
<script src="<c:url value="/js/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/js/bootstrap/js/bootstrap-select.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/camera/scripts/jquery.easing.1.3.js" />"></script>
<script src="<c:url value="/js/onload.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/camera/scripts/camera.min.js" />"></script>
<script src="<c:url value="/js/animate.js" />"></script>
<!-- ajax送表單指令用到 -->
<script type="text/javascript"
	src="<c:url value="/js/jquery.form.js" />"></script>


<script type="text/javascript">
	function getStationdata() {
		var $Start = $("#start");
		var options = {
			url : "/HelloWeb/getStationdata",
			type : "POST",
			success : function(msg) {
				$Start.empty();
				ary_msg = msg.split("||");
				$Start.append(ary_msg[1]);
				$('.selectpicker').selectpicker('refresh');

			}
		};
		$('#mform').ajaxSubmit(options);

	}
	function getStationdata2() {
		var $End = $("#end");
		var options2 = {
			url : "/HelloWeb/getStationdata2",
			type : "POST",
			success : function(msg2) {
				ary_msg2 = msg2.split("||");
				$End.empty();
				$End.append(ary_msg2[1]);
				$('.selectpicker').selectpicker('refresh');
			}
		};
		$('#mform').ajaxSubmit(options2);

	}

	function getTraindata() {
		var $employees = $("#employees");
		var options = {
			url : "/HelloWeb/getTraindata",
			type : "POST",
			success : function(msg) {
				ary_msg = msg.split("||");
				var json = JSON.parse(ary_msg[1]);
				//TraindataMessage(msg);
				var num = document.getElementById("employees").rows.length;
				for (i = 0; i < num - 1; i++) {
					document.getElementById("employees").deleteRow(-1);
				}
				for (var i = 0; i < json.ArrivalTime.length; i++) {
					$employees
							.append("<tr><td data-th=\"選擇\"> <input type=\"radio\" value="+json.Id[i]+" name=\"check\" id=\"check\"></td>"
									+ "<td data-th=\"車次\">"
									+ json.TrainNumber[i]
									+ "</td>"
									+ "<td data-th=\"車種\">"
									+ json.TrainTypeName[i]
									+ "</td>"
									+ "<td data-th=\"到站時間\">"
									+ json.ArrivalTime[i]
									+ "</td>"
									+ "<td data-th=\"出發時間\">"
									+ json.DepartureTime[i] + "</td>" + "</tr>");
				}

			}
		};
		$('#mform').ajaxSubmit(options);

	}

	function TraindataMessage(msg) {
		ary_msg = msg.split("||");
		alert(ary_msg[1]);
	}

	function twid_check(obj) {
		twidRule = /^[A-Z]\d{9}$/;
		var twid = obj.value;
		if (!twidRule.test(twid)) {
			return false;
		}
		return true;
	}
	function save() {
		//身分證字號
		if (document.getElementById("Twid").value == ''
				|| document.getElementById("Twid").value.indexOf("請輸入身分證字號") >= 0) {
			$("#alert-content").animate({
				"top" : "0px"
			}, 1000)
			$("#alert-content").css({
				"zIndex" : "9999"
			})
			$("#overlay").animate({
				"opacity" : ".5"
			}, 1000)
			$("#overlay").css({
				"zIndex" : "9998"
			})
			$("#overlay,.alert-close,.close").click(function() {
				$("#alert-content").animate({
					"top" : "-500px"
				}, 1500)
				setTimeout(function() {
					$("#alert-content").css({
						"zIndex" : "-99"
					})
				}, 1000)
				$("#overlay").animate({
					"opacity" : "0"
				}, 1000)
				setTimeout(function() {
					$("#overlay").css({
						"zIndex" : "-99"
					})
				}, 500)
			})
			document.getElementById("Twid").focus();
			return;
		} else {
			if (!twid_check(document.getElementById("Twid"))) {
				alert("身分證格式錯誤！");
				document.getElementById("Twid").focus();
				return;
			}
		}

		document.mform.action = "/HelloWeb/addorder";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>
</head>
<body>
	<!-- alert  -->
	<div id="alert">
		<div id="overlay"></div>
		<div id="alert-content">
			<div id="alert-title">訊息</div>
			<div class="close">
				<a href="#" class="alert-close">x</a>
			</div>
			<div id="alert-data">
				<h2>親愛的民眾</h2>
				<p>請輸入身分證</p>
				<p>
					<button class="alert-close">Close</button>
				</p>
			</div>
		</div>
	</div>

	<div class="anibg">
		<img src="<c:url value="/image/anilogo.png" />">
		<div class="backA"></div>
		<div class="backB"></div>
	</div>
	<div id="all">
		<div id="topbackgroundOr1">
			<form:form method="POST" action="/HelloWeb/addorder" name="mform"
				id="mform">

				<!-- 導覽列 上方圖片-->
				<%@include file="../../include/home_menu.jsp"%>

				<!-- 訂票欄 -->
				<div id="order-1">
					<div class="container">
						<label class="control-label ">您所在的訂位步驟：</label>
						<div class="progress">
							<div class="progress-bar progress-bar-striped active"
								role="progressbar" aria-valuenow="40" aria-valuemin="0"
								aria-valuemax="100" style="width: 35%">
								<label class="control-label ">1. 選擇車次 </label>
							</div>
						</div>
					</div>

					<div class="container">
						<fieldset class="order">
							<legend>
								<label class="control-label ">動態車次查詢</label>
							</legend>

							<table class="rwd-table" id="employees">
								<tr>
									<th>選擇</th>
									<th>車次</th>
									<th>車種</th>
									<th>到站時間</th>
									<th>離站時間</th>
								</tr>


							</table>


						</fieldset>
					</div>

					<div class="container">

						<fieldset class="order">
							<legend>
								<label class="control-label ">車次訂單程票</label>
							</legend>


							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-user"></span> 請輸入身分證字號：
									</label>
								</div>
								<div class="col-sm-9">
									<input name="Twid" id="Twid" type="text" class="form-control"
										value="請輸入身分證字號"
										onFocus="javascript: if (this.value=='請輸入身分證字號') this.value='';"
										onBlur="javascript: if(this.value=='') this.value='請輸入身分證字號';" />
								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-bed"></span> 選擇起站區域:
									</label>
								</div>
								<div class="col-sm-3">
									<select class="selectpicker" data-style="btn-primary"
										data-width="100%" id="areas" name="areas"
										onchange="getStationdata()">
										<option>請選擇</option>
										<option value="台北">台北</option>
										<option value="桃園">桃園</option>
										<option value="新竹">新竹</option>
										<option value="苗栗">苗栗</option>
										<option value="台中">台中</option>
										<option value="彰化">彰化</option>
										<option value="斗六">斗六</option>
										<option value="嘉義">嘉義</option>
										<option value="台南">台南</option>
										<option value="高雄">高雄</option>
										<option value="屏東">屏東</option>
										<option value="台東">台東</option>
										<option value="花蓮">花蓮</option>
										<option value="宜蘭">宜蘭</option>
										<option value="車埕">車埕</option>
									</select>
								</div>
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-road"></span> 選擇起站車站:
									</label>
								</div>
								<div class="col-sm-3">
									<select class="selectpicker" data-style="btn-primary"
										data-width="100%" id="start" name="start"
										data-style="btn-success" onchange="getTraindata()">
										<option>請選擇</option>
									</select>
								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-bed"></span> 選擇到站區域:
									</label>
								</div>
								<div class="col-sm-3">
									<select class="selectpicker" data-style="btn-info"
										data-width="100%" id="areas2" name="areas2"
										onchange="getStationdata2()">
										<option>請選擇</option>
										<option value="台北">台北</option>
										<option value="桃園">桃園</option>
										<option value="新竹">新竹</option>
										<option value="苗栗">苗栗</option>
										<option value="台中">台中</option>
										<option value="彰化">彰化</option>
										<option value="斗六">斗六</option>
										<option value="嘉義">嘉義</option>
										<option value="台南">台南</option>
										<option value="高雄">高雄</option>
										<option value="屏東">屏東</option>
										<option value="台東">台東</option>
										<option value="花蓮">花蓮</option>
										<option value="宜蘭">宜蘭</option>
										<option value="車埕">車埕</option>
									</select>
								</div>
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-road"></span> 選擇到站車站:
									</label>
								</div>
								<div class="col-sm-3">
									<select class="selectpicker" data-style="btn-info"
										data-width="100%" id="end" name="end" data-style="btn-info"
										onchange="getTraindata()">
										<option>請選擇</option>
									</select>
								</div>
							</div>




							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-calendar"></span> 車種:
									</label>
								</div>
								<div class="col-sm-9">
									<select class="selectpicker" id="type" name="type" data-width="30.7%" 
										data-style="btn-warning" onchange="getTraindata()">
										<option value=0 selected>請選擇</option>
										<option value="自強">自強</option>
										<option value="莒光">莒光</option>
										<option value="普悠瑪">普悠瑪</option>
									</select>
								</div>
							</div>
							<%
								String date = (String) request.getParameter("date");
									if (date == null || date.equals("null")) {
										date = SysUtil.nowDate("yyyy-MM-dd");
									}
							%>

							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-calendar"></span> 乘車日期:
									</label>
								</div>
								<div class="col-sm-9">
									<input id="orderdate" name="date" type="text" value="<%=date%>"
										class="form-control" />
								</div>
							</div>

							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-plus"></span> 訂票張數:
									</label>
								</div>
								<div class="col-sm-9">
									<select class="selectpicker" id="total" name="total" data-width="30.7%" 
										data-style="btn-success">
										<option>1</option>
										<option>2</option>
										<option>3</option>
										<option>4</option>
										<option>5</option>
										<option>6</option>
									</select>
								</div>
							</div>

							<div class="submit">						
								<button type="button" class="btn btn-danger btn-lg"
									onclick="javascript:window.document.mform.reset()">清除重填</button>								
								<button type="button" class="btn btn-warning btn-lg"
								onclick="javascript:save()">開始訂票</button>
									
							</div>


						</fieldset>

					</div>
			</form:form>
		</div>

		<!-- pagefooter -->

		<%@include file="../../include/foot.jsp"%>


	</div>


</body>
</html>