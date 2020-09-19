<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手後台</title>
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>
<script type="text/javascript">
	function save() {
		if (document.getElementById("account").value == ''
				|| document.getElementById("account").value.indexOf("請輸入") >= 0) {
			alert("【帳號】欄位不可空白，請輸入！");
			document.getElementById("account").focus();
			return;
		}
		if (document.getElementById("password").value == '') {
			alert("【密碼】欄位不可空白，請輸入！");
			document.getElementById("password").focus();
			return;
		}
		if (document.getElementById("insrand").value == ''
				|| document.getElementById("insrand").value.indexOf("請輸入") >= 0) {
			alert("【驗證碼】欄位不可空白，請輸入！");
			document.getElementById("insrand").focus();
			return;
		}

		document.mform.action = "loginsave.jsp";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>
</head>

<body>

	<div id="loginbg">

		<form role="form" action="loginsave.jsp" method="POST" name="mform">
			<div class="loginarea">
				<h1>
					<img src="image/logo.png">台鐵神票手後台登入系統
				</h1>
				<hr>
				<label for="account">帳號:</label><input type="text" id="account"
					name="user" value="請輸入帳號"
					onFocus="javascript: if (this.value=='請輸入帳號') this.value='';"
					onBlur="javascript: if(this.value=='') this.value='請輸入帳號';">
				<label for="password">密碼:</label><input type="password"
					id="password" name="password">
				<div class="code">
					<img src="newImage.jsp"> <input type="text" name="insrand"
						id="insrand" maxlength="4" value="請輸入驗證碼"
						onFocus="javascript: if (this.value=='請輸入驗證碼') this.value='';"
						onBlur="javascript: if(this.value=='') this.value='請輸入驗證碼';">
				</div>
				<button type="button" onclick="javascript:save()">登入</button>
			</div>
		</form>

	</div>

</body>
</html>