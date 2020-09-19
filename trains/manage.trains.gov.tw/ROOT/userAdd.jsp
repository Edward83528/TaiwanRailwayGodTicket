<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手後台</title>
<link rel="shortcut icon" href="image/logo.png">
<link rel="stylesheet" href="css/screen.css">
<script type="text/javascript">
	function save() {

		document.mform.action = "userAddSave.jsp";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>
</head>
<body>

	<form action='userAddSave' method='post' name="mform">
		<div class="main" id="main">
			<fieldset>
				<legend>管理者維護</legend>
				<div id="addback">
					<div class="title">
						<label for="backtitle">姓名:</label><input type="text"
							id="backtitle" name='name' value="請輸入姓名"
							onFocus="javascript: if (this.value=='請輸入姓名') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入姓名';">
					</div>
					<div class="title">
						<label for="backtitle">帳號:</label><input type="text"
							id="backtitle" name='user' value="請輸入帳號"
							onFocus="javascript: if (this.value=='請輸入帳號') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入帳號';">
					</div>
					<div class="title">
						<label for="backtitle">密碼:</label><input type="text"
							id="backtitle" name='password' value="請輸入密碼"
							onFocus="javascript: if (this.value=='請輸入密碼') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入密碼';">
					</div>

					<label for="backtitle">權限:</label><input type="checkbox"
						id="permission" name='permission' value="1"> <br> <br>

					<button type="button" onclick="javascript:save()">新增</button>
				</div>
			</fieldset>
		</div>
	</form>
</body>
</html>