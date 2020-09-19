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
<%@ page import="tw.com.common.*"%>
<%@ page import="java.util.*"%>
<%
	String id = request.getParameter("id");
%>
<script type="text/javascript">
	function save() {

		document.mform.action = "FAQUpdateSave.jsp?id=<%=id%>";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>
</head>
<body>
	<%
		TrainData trainDate = new TrainData();
		ArrayList<FAQiItem> lists = trainDate.SelectFAQ(id);
		if (lists != null) {
			FAQiItem list = lists.get(0);
	%>

	<form action='FAQAddSave.jsp' method='post' name="mform">
		<div class="main" id="main">
			<fieldset>
				<legend>問與答維護</legend>
				<div id="addback">
					<div class="title">
						<label for="backtitle">問題:</label><input type="text"
							id="backtitle" name='Question' value="<%=list.getQuestion()%>"
							onFocus="javascript: if (this.value=='請輸入問題') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入問題';">
					</div>

					<div class="content">
						<label for="backcontent">答案:</label>
						<textarea id="backcontent" rows="15" cols="31" name='answer'><%=list.getAnswer()%></textarea>
					</div>

					<button type="button" onclick="javascript:save()">更新</button>
				</div>



			</fieldset>

		</div>
	</form>
	<%
		}
	%>
</body>
</html>