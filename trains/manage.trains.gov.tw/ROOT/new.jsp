<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.com.common.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>

<script type="text/javascript">
	function save() {

		document.mform.action = "addnews.jsp";
		document.mform.method = "post";
		document.mform.submit();
	}

	$(document).ready(function() {
		$('#del').click(function() {
			x = window.confirm("確定執行刪除嗎?");
			if (x) {
				var options = {
					url : "deleteNews.jsp",
					type : "POST",
					success : function(msg) {
						delmessage(msg);
					}
				};
				$('#mform').ajaxSubmit(options);
			}
		});
	});

	function delmessage(msg) {

		ary_msg = msg.split("||");
		if (ary_msg[1] != 'true') {
			var showAlert = "刪除失敗！" + ary_msg[2];
			alert(showAlert);
		} else {
			var showAlert = "刪除成功！";
			alert(showAlert);
		}
		document.mform.action = "new.jsp";
		document.mform.method = "post";
		document.mform.submit();
	}

	function select() {

		document.mform.action = "new.jsp";
		document.mform.method = "post";
		document.mform.submit();
	}
	function clean() {
		document.getElementById("from").value = "";
		document.getElementById("to").value = "";
	}
</script>
</head>
<body>
	<%
		//解決編碼問題
		request.setCharacterEncoding("UTF-8");
		//接收參數
		String keyword = (String) request.getParameter("keyword");
		if (keyword == null || keyword.equals("null") || keyword.lastIndexOf("請輸入") != -1) {
			keyword = "";
		}
		String from = (String) request.getParameter("from");
		if (from == null || from.equals("null")) {
			from = SysUtil.nowDate("yyyy-MM-dd");
		}
		String to = (String) request.getParameter("to");
		if (to == null || to.equals("null")) {
			to = SysUtil.nowDate("yyyy-MM-dd");
		}
	%>

	<form method='post' name="mform" id="mform">
		<div class="main" id="main">
			<fieldset>
				<legend>最新消息維護</legend>
				<div id="backnews">
					<div class="key">
						<label for="keyword">關鍵字:</label><input type="text" id="keyword"
							name="keyword" value="請輸入關鍵字"
							onFocus="javascript: if (this.value=='請輸入關鍵字') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入關鍵字';">
					</div>
					<div class="checkDate">
						<label for="from">選擇日期:</label><input type="text" id="from"
							class="datepicker1" name="from" value="<%=from%>"><label
							for="to">至</label><input type="text" id="to" name="to"
							class="datepicker2" value="<%=to%>">
					</div>

					<div class="btn">
						<button type="button" onclick="javascript:save()">新增</button>
						<button type="button" id="del">刪除</button>
						<button type="button" onclick="javascript:clean()">清空</button>
						<button type="button" onclick="javascript:select()">查詢</button>

					</div>
					<div class="backtable">
						<table>
							<thead>
								<tr>
									<th>刪除</th>
									<th>順序</th>
									<th>標題</th>
									<th>發布日期</th>
								</tr>
							</thead>
							<tbody>
								<%
									TrainData trainDate = new TrainData();
									ArrayList<NewsItem> lists = trainDate.SelectNews(keyword, from, to);
									if (lists != null) {
										for (int i = 0; i < lists.size(); i++) {
											NewsItem list = lists.get(i);
								%>
								<tr>
									<td><input type="checkbox" name="check" id="check"
										value="<%=list.getId()%>" /></td>
									<td><%=i + 1%></td>
									<td><a href="updateNews.jsp?id=<%=list.getId()%>"><%=list.getSubject()%></a></td>
									<td><%=list.getDate1()%></td>
								</tr>

								<%
									}
									}
								%>

							</tbody>
						</table>

					</div>
				</div>
			</fieldset>


		</div>
	</form>
</body>
</html>