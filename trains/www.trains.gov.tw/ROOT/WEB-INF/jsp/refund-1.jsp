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


<script type="text/javascript">
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
		if (document.getElementById("twid").value == ''
				|| document.getElementById("twid").value.indexOf("請輸入身分證字號") >= 0) {
			alert("請輸入身分證");
			document.getElementById("twid").focus();
			return;
		} else {
			if (!twid_check(document.getElementById("twid"))) {
				alert("身分證格式錯誤！");
				document.getElementById("twid").focus();
				return;
			}
		}

		//電腦代碼
		if (document.getElementById("key").value == ''
				|| document.getElementById("key").value.indexOf("請輸入電腦代碼") >= 0) {
			alert("請輸入電腦代碼");
			document.getElementById("key").focus();
			return;
		}

		document.mform.action = "/HelloWeb/addrefund";
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
			<div id="refund-1">
				<div class="container">
					<form:form method="POST" action="/HelloWeb/addrefund" name="mform">
						<fieldset class="order">
							<legend>
								<label class="control-label ">取消訂票紀錄</label>
							</legend>
							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-user"></span> 請輸入身分證字號：
									</label>
								</div>
								<div class="col-sm-9">
									<input type="text" name="twid" id="twid" class="form-control"
										value="請輸入身分證字號"
										onFocus="javascript: if (this.value=='請輸入身分證字號') this.value='';"
										onBlur="javascript: if(this.value=='') this.value='請輸入身分證字號';" />
								</div>

							</div>
							<br>
							<div class="row">
								<div class="col-sm-3">
									<label class="control-label "> <span
										class="glyphicon glyphicon-user"></span> 請輸入電腦代碼：
									</label>
								</div>
								<div class="col-sm-9">
									<input type="text" name="key" id="key" class="form-control"
										value="請輸入電腦代碼"
										onFocus="javascript: if (this.value=='請輸入電腦代碼') this.value='';"
										onBlur="javascript: if(this.value=='') this.value='請輸入電腦代碼';" />
								</div>
							</div>


							<div class="rule">
								<label class="control-label">退票手續費 :</label> <label
									class="control-label">(1)乘車日當天：按每張車票票價20%收取，並不得低於20元。</label> <label
									class="control-label">(2)距乘車日2至3日（首日為乘車日當天，下同）：按每張車</label> <label
									class="control-label">(3)距乘車日4日至12日：按每張車票20元收取。</label> <label
									class="control-label">(4)自距乘車日起第13日以上：按每張車票10元收取。</label>
							</div>
							<div class="submit">
								<button type="button" class="btn btn-danger btn-lg"
									onclick="javascript:save()">取消訂票</button>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>

			<!-- pagefooter -->
			<%@include file="../../include/foot.jsp"%>

		</div>
	</div>
	</div>
</body>
</html>