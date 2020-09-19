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

		if (document.getElementById("backtitle").value == ''
				|| document.getElementById("backtitle").value.indexOf("請輸入") >= 0) {
			alert("【標題】欄位不可空白，請輸入！");
			document.getElementById("backtitle").focus();
			return;
		}
		if (document.getElementById("backlink").value == ''
				|| document.getElementById("backlink").value.indexOf("請輸入") >= 0) {
			alert("【連結】欄位不可空白，請輸入！");
			document.getElementById("backlink").focus();
			return;
		}

		document.mform.action = "newsAddSave";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>
</head>
<body>

	<form action='newsAddSave' method='post' enctype="multipart/form-data"
		name="mform">
		<div class="main" id="main">
			<fieldset>
				<legend>最新消息維護</legend>
				<div id="addback">
					<div class="title">
						<label for="backtitle">標題:</label><input type="text"
							id="backtitle" name='Subject' value="請輸入標題"
							onFocus="javascript: if (this.value=='請輸入標題') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入標題';">
					</div>
					<div class="content">
						<label for="backcontent">內容:</label>
						<textarea id="backcontent" rows="15" cols="31" name='Content'></textarea>
					</div>
					<div class="link">
						<label for="backlink">連結:</label><input type="text" id="backlink"
							name='Link' value="請輸入連結"
							onFocus="javascript: if (this.value=='請輸入連結') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入連結';">
					</div>
					<div class="img">
						<label for="backimg">圖片:</label><input type='file' id="backimg"
							name='upload'>
					</div>
					<button type="button" onclick="javascript:save()">新增</button>
				</div>
			</fieldset>
	</form>
	</div>
</body>
</html>