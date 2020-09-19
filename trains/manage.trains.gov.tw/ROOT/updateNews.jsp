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
</head>
<body>
	<div class="main" id="main">
		<%
			String id = request.getParameter("id");
			TrainData trainDate = new TrainData();
			ArrayList<NewsItem> lists = trainDate.SelectNew(id);
			if (lists != null) {
				NewsItem list = lists.get(0);
		%>
		<form action='updateNewsSave.jsp' method='post'>
			<input type="hidden" id="id" name="id" value="<%=id%>" />

			<fieldset>
				<legend>最新消息維護</legend>
				<div id="addback">
					<div class="title">
						<label for="backtitle">標題:</label><input type="text"
							id="backtitle" name='Subject' value="<%=list.getSubject()%>">
					</div>
					<div class="content">
						<label for="backcontent">內容:</label>
						<textarea id="backcontent" rows="15" cols="31" name='Content'><%=list.getContent()%></textarea>
					</div>
					<div class="link">
						<label for="backlink">連結:</label><input type="text" id="backlink"
							name='Link' <%if (list.getLink() != null) {%>
							value="<%=list.getLink()%>" <%}%>>
					</div>
					<div class="img">
						<label for="backimg">圖片:</label><input type='file' id="backimg"
							name='upload' value="<%=list.getPicture()%>">
					</div>
					<button type="summit">更新</button>
				</div>
				<%
					}
				%>
			</fieldset>


		</form>
	</div>
</body>
</html>