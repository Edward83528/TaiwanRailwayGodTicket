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
	function select() {
		document.mform.action = "train.jsp";
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
		String TrainTypeName = (String) request.getParameter("TrainTypeName");
		if (TrainTypeName == null || TrainTypeName.equals("null")) {
			TrainTypeName = "";
		}
		String TrainNo = (String) request.getParameter("TrainNo");
		if (TrainNo == null || TrainNo.equals("null") || TrainNo.lastIndexOf("請輸入") != -1) {
			TrainNo = "";
		}
		String to = (String) request.getParameter("to");
		if (to == null || to.equals("null")) {
			to = SysUtil.nowDate("yyyy-MM-dd");
		}
	%>

	<form method='post' name="mform" id="mform">
		<div class="main" id="main">

			<fieldset>
				<legend>車次車位維護</legend>
				<div id="train">
					<div class="type">
						<label for="traintpye">車種:</label><select id="traintpye"
							name="TrainTypeName">
							<option value="自強">自強</option>
							<option value="莒光">莒光</option>
							<option value="太魯閣">太魯閣</option>
							<option value="普悠瑪">普悠瑪</option>
						</select> 
					</div>
					<div class="number">
						<label for="trainNum">車次:</label><input type="text" id="trainNum"
							value="請輸入車次" name="TrainNo"
							onFocus="javascript: if (this.value=='請輸入車次') this.value='';"
							onBlur="javascript: if(this.value=='') this.value='請輸入車次';">
					</div>
					<div class="btn">
						<button type="button" onclick="javascript:clean()">清空</button>
						<button type="button" onclick="javascript:select()">查詢</button>
					</div>
					<div class="traintable">
						<table>
							<thead>
								<tr>
									<th>順序</th>
									<th>班次</th>
									<th>車種</th>
								</tr>
							</thead>
							<tbody>
								<%
									TrainData trainDate = new TrainData();
									ArrayList<Station_trainItem> lists = trainDate.SelectTrainSeats(TrainNo, TrainTypeName);
									if (lists != null) {
										for (int i = 0; i < lists.size(); i++) {
											Station_trainItem list = lists.get(i);
								%>
								<tr>
									<td><%=i + 1%></td>
									<td><a href="selecttrain.jsp?id=<%=list.getId()%>"><%=list.getTrainNo()%></a></td>
									<td><%=list.getTrainTypeName()%></td>
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