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
<%@include file="../../include/resources.jsp"%>
<script type="text/javascript">
	function save() {
		if (document.getElementById("name").value == ''
				|| document.getElementById("name").value.indexOf("請輸入姓名") >= 0) {
			alert("請輸入姓名");
			document.getElementById("name").focus();
			return;
		}
		if (document.getElementById("phone").value == ''
				|| document.getElementById("phone").value.indexOf("請輸入連絡電話") >= 0) {
			alert("請輸入連絡電話");
			document.getElementById("phone").focus();
			return;
		}
		if (document.getElementById("email").value == ''
				|| document.getElementById("email").value.indexOf("請輸入E-mail") >= 0) {
			alert("請輸入E-mail");
			document.getElementById("email").focus();
			return;
		}
		if (document.getElementById("subject").value == ''
				|| document.getElementById("subject").value.indexOf("請輸入主旨") >= 0) {
			alert("請輸入主旨");
			document.getElementById("subject").focus();
			return;
		}

		document.mform.action = "/HelloWeb/send";
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
		<div id="topbackgroundMail">

			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>



			<div id="mail">
				<div class="container">

					<div class="mailbg">

						<h3>局長信箱</h3>
						<div class="innerMail">
							<div class="back"></div>
							<form:form method="POST" action="/HelloWeb/send" name="mform"
								id="mform" class="mail">
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">姓名:</label>
									</div>
									<div class="col-md-9">
										<input type="text" id="name" name="name" class="form-control"
											value="請輸入姓名"
											onFocus="javascript: if (this.value=='請輸入姓名') this.value='';"
											onBlur="javascript: if(this.value=='') this.value='請輸入姓名';" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">連絡電話:</label>
									</div>
									<div class="col-md-9">
										<input type="text" id="phone" name="phone"
											class="form-control" value="請輸入連絡電話"
											onFocus="javascript: if (this.value=='請輸入連絡電話') this.value='';"
											onBlur="javascript: if(this.value=='') this.value='請輸入連絡電話';" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">E-mail:</label>
									</div>
									<div class="col-md-9">
										<input type="text" id="email" name="email"
											class="form-control" value="請輸入E-mail"
											onFocus="javascript: if (this.value=='請輸入E-mail') this.value='';"
											onBlur="javascript: if(this.value=='') this.value='請輸入E-mail';" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">主旨:</label>
									</div>
									<div class="col-md-9">
										<input type="text" id="subject" name="subject"
											class="form-control" value="請輸入主旨"
											onFocus="javascript: if (this.value=='請輸入主旨') this.value='';"
											onBlur="javascript: if(this.value=='') this.value='請輸入主旨';" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">留言:</label>
									</div>
									<div class="col-md-9">
										<textarea id="content" name="content" class="form-control"
											rows="5" value="請輸入留言"
											onFocus="javascript: if (this.value=='請輸入留言') this.value='';"
											onBlur="javascript: if(this.value=='') this.value='請輸入留言';"></textarea>
									</div>
								</div>
								<div class="btnout">
									<button type="button" class="btn btn-success"
										onclick="javascript:save()">寄信</button>
								</div>
							</form:form>
						</div>

					</div>

				</div>
			</div>


			<!-- pagefooter -->

			<%@include file="../../include/foot.jsp"%>



		</div>


	</div>
</body>
</html>