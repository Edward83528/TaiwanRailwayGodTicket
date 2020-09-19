<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="tw.com.common.*"%>
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
<script src="<c:url value="/js/onload.js" />"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
<script src="<c:url value="/js/datepicker.js" />"></script>
<script src="<c:url value="/js/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/js/bootstrap/js/bootstrap-select.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/camera/scripts/jquery.easing.1.3.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/js/camera/scripts/camera.min.js" />"></script>
<script src="<c:url value="/js/animate.js" />"></script>
<!-- ajax送表單指令用到 -->
<script type="text/javascript"
	src="<c:url value="/js/jquery.form.js" />"></script>

<script type="text/javascript">
	function getStationdata() {
		var $Start = $("#Start");
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
		var $End = $("#End");
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

	function save() {
		if (document.getElementById("Start").value == '0') {
			alert("未選擇起程站");
			document.getElementById("Start").focus();
			return;
		}
		if (document.getElementById("End").value == '0') {
			alert("未選擇到達站");
			document.getElementById("End").focus();
			return;
		}

		document.mform.action = "/HelloWeb/selectTrain";
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
		<%
			String date = (String) request.getParameter("date");
			if (date == null || date.equals("null")) {
				date = SysUtil.nowDate("yyyy-MM-dd");
			}
		%>

		<div id="topbackgroundSh1">
			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>

			<!-- 查票 -->
			<div id="search-1">
				<div class="container">
					<form:form method="POST" action="/HelloWeb/addorder" name="mform"
						id="mform">
						<h2>查詢系統</h2>
						<div class="searchbackground">
							<ul class="trainline">

								<li class="work"><input class='radio' id='step1'
									name="steps" type='radio'>
									<div class="relative">
										<label for="step1"><span
											class="glyphicon glyphicon-circle-arrow-right"></span>起程站</label> <span
											class='step'>STEP 1</span> <span class='circle'></span>
									</div>
									<div class='content'>
										<div class="row">
											<div class="col-sm-6">
												<p>區域:</p>
												<select class="selectpicker" data-style="btn-info"
													id="areas" name="areas" onchange="getStationdata()">
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
											<div class="col-sm-6">
												<p>車站:</p>
												<select id="Start" name="Start" class="selectpicker"
													data-style="btn-primary">
													<option value=0 selected>請選擇</option>
												</select>
											</div>
											<button type="button" id="selectbtn1" class="btn btn-warning">下一步</button>

										</div>
									</div></li>

								<li class="work"><input class='radio' id='step2'
									name="steps" type='radio'>
									<div class="relative">
										<label for="step2"><span
											class="glyphicon glyphicon-circle-arrow-right"></span>到達站</label> <span
											class='step'>STEP 2</span> <span class='circle'></span>
									</div>
									<div class='content'>
										<div class="row">
											<div class="col-sm-6">
												<p>區域:</p>
												<select class="selectpicker" data-style="btn-info"
													id="areas2" name="areas2" onchange="getStationdata2()">
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

											<div class="col-sm-6">
												<p>車站:</p>
												<select id="End" name="End" class="selectpicker"
													data-style="btn-primary">
													<option value=0 selected>請選擇</option>
												</select>
											</div>
											<button type="button" id="selectbtn2" class="btn btn-warning">下一步</button>
											<button type="button" id="selectbtn3" class="btn btn-warning">上一步</button>
										</div>
									</div></li>

								<li class="work"><input class='radio' id='step3'
									name="steps" type='radio'>
									<div class="relative">
										<label for="step3"><span
											class="glyphicon glyphicon-bed"></span>車種</label> <span class='step'>STEP
											3</span> <span class='circle'></span>
									</div>
									<div class='content'>
										<div class="row">
											<div class="col-md-8">
												<label class="radio-inline"><input type="radio"
													name="optradio" checked>所有車種</label> <label
													class="radio-inline"><input type="radio"
													name="optradio">對號列車</label> <label class="radio-inline"><input
													type="radio" name="optradio">非對號列車</label>
											</div>
											<div class="col-md-4">
												<button type="button" id="selectbtn4"
													class="btn btn-warning">下一步</button>
												<button type="button" id="selectbtn5"
													class="btn btn-warning">上一步</button>
											</div>
										</div>
									</div></li>

								<li class="work"><input class='radio' id='step4'
									name="steps" type='radio'>
									<div class="relative">
										<label for="step4"><span
											class="glyphicon glyphicon-calendar"></span>日期與時間</label> <span
											class='step'>STEP 4</span> <span class='circle'></span>
									</div>
									<div class='content'>
										<div class="row">
											<div class="col-sm-6">
												<p>日期:</p>
												<input id="datepicker" id="date" name="date"
													class="form-control" type="text" value="<%=date%>"></input>
											</div>
											<div class="col-sm-6">
												<p id="other">時間:</p>
												<br> <select class="select">
													<option>請選擇</option>
													<option>05:00</option>
													<option>06:00</option>
													<option>07:00</option>
													<option>08:00</option>
													<option>09:00</option>
													<option>10:00</option>
													<option>11:00</option>
													<option>12:00</option>
													<option>13:00</option>
													<option>14:00</option>
													<option>15:00</option>
													<option>16:00</option>
													<option>17:00</option>
													<option>18:00</option>
													<option>19:00</option>
													<option>20:00</option>
													<option>21:00</option>
													<option>22:00</option>
													<option>23:00</option>
													<option>24:00</option>
												</select> <span id="and">至</span> <select class="select">
													<option>請選擇</option>
													<option>05:00</option>
													<option>06:00</option>
													<option>07:00</option>
													<option>08:00</option>
													<option>09:00</option>
													<option>10:00</option>
													<option>11:00</option>
													<option>12:00</option>
													<option>13:00</option>
													<option>14:00</option>
													<option>15:00</option>
													<option>16:00</option>
													<option>17:00</option>
													<option>18:00</option>
													<option>19:00</option>
													<option>20:00</option>
													<option>21:00</option>
													<option>22:00</option>
													<option>23:00</option>
													<option>24:00</option>
												</select>
												<button type="button" id="competebtn"
													class="btn btn-success" onclick="javascript:save()">查詢</button>
											</div>
										</div>
									</div></li>

							</ul>
						</div>
					</form:form>
				</div>
			</div>

			<!-- pagefooter -->

			<%@include file="../../include/foot.jsp"%>

		</div>
	</div>
</body>
</html>