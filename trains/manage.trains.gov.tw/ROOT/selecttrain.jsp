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
<script type="text/javascript">
	function select() {

		document.mform.action = "selecttrain.jsp";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>
<body>
	<%
		String Id = request.getParameter("id");
		//選取的車廂
		String box = (String) request.getParameter("box");
		if (box == null || box.equals("null")) {
			box = "1";
		}
		TrainData trainDate = new TrainData();
		ArrayList<Station_trainItem> lists = trainDate.SelectTrainSeat(Id);
		if (lists != null) {
			Map<String, String> seat = lists.get(0).getSeat();
	%>
	<form action='updateTrain.jsp' method='post' name="mform" id="mform">
		<input type="hidden" id="id" name="id"
			value="<%=lists.get(0).getId()%>" />
		<div class="main" id="main">
			<fieldset>
				<legend>車次車位維護</legend>
				<div id="addtrain">
					<div class="carriage">
						<label for="trainCarri">車箱:</label><select id="rainCarri" id="box"
							name="box">
							<option value="1" <%if (box.equals("1")) {%> SELECTED <%}%>>第1節</option>
							<option value="2" <%if (box.equals("2")) {%> SELECTED <%}%>>第2節</option>
							<option value="3" <%if (box.equals("3")) {%> SELECTED <%}%>>第3節</option>
							<option value="4" <%if (box.equals("4")) {%> SELECTED <%}%>>第4節</option>
							<option value="5" <%if (box.equals("5")) {%> SELECTED <%}%>>第5節</option>
							<option value="6" <%if (box.equals("6")) {%> SELECTED <%}%>>第6節</option>
							<option value="7" <%if (box.equals("7")) {%> SELECTED <%}%>>第7節</option>
							<option value="8" <%if (box.equals("8")) {%> SELECTED <%}%>>第8節</option>
							<option value="9" <%if (box.equals("9")) {%> SELECTED <%}%>>第9節</option>
							<option value="10" <%if (box.equals("10")) {%> SELECTED <%}%>>第10節</option>
						</select>
						<button type="button" onclick="javascript:select()">查詢</button>
						<button type="summit">更新</button>
					</div>
					<div class="trainbox">
						<div class="head">
							<div></div>
							<div></div>
						</div>

						<div class="innerTrain">
							<table>
								<thead>
									<tr>
										<th></th>
										<th>1</th>
										<th>2</th>
										<th>3</th>
										<th>4</th>
										<th>5</th>
										<th>6</th>
										<th>7</th>
										<th>8</th>
										<th>9</th>
										<th>10</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>A</td>
										<td><input type="checkbox" name="A1"
											value="<%=seat.get("" + box + "A1")%>"
											<%if (seat.get("" + box + "A1").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A2"
											value="<%=seat.get("" + box + "A2")%>"
											<%if (seat.get("" + box + "A2").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A3"
											value="<%=seat.get("" + box + "A3")%>"
											<%if (seat.get("" + box + "A3").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A4"
											value="<%=seat.get("" + box + "A4")%>"
											<%if (seat.get("" + box + "A4").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A5"
											value="<%=seat.get("" + box + "A5")%>"
											<%if (seat.get("" + box + "A5").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A6"
											value="<%=seat.get("" + box + "A6")%>"
											<%if (seat.get("" + box + "A6").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A7"
											value="<%=seat.get("" + box + "A7")%>"
											<%if (seat.get("" + box + "A7").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A8"
											value="<%=seat.get("" + box + "A8")%>"
											<%if (seat.get("" + box + "A8").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A9"
											value="<%=seat.get("" + box + "A9")%>"
											<%if (seat.get("" + box + "A9").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="A10"
											value="<%=seat.get("" + box + "A10")%>"
											<%if (seat.get("" + box + "A10").equals("Y")) {%> checked
											<%}%>></td>
									</tr>
									<tr>
										<td>B</td>
										<td><input type="checkbox" name="B1"
											value="<%=seat.get("" + box + "B1")%>"
											<%if (seat.get("" + box + "B1").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B2"
											value="<%=seat.get("" + box + "B2")%>"
											<%if (seat.get("" + box + "B2").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B3"
											value="<%=seat.get("" + box + "B3")%>"
											<%if (seat.get("" + box + "B3").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B4"
											value="<%=seat.get("" + box + "B4")%>"
											<%if (seat.get("" + box + "B4").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B5"
											value="<%=seat.get("" + box + "B5")%>"
											<%if (seat.get("" + box + "B5").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B6"
											value="<%=seat.get("" + box + "B6")%>"
											<%if (seat.get("" + box + "B6").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B7"
											value="<%=seat.get("" + box + "B7")%>"
											<%if (seat.get("" + box + "B7").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B8"
											value="<%=seat.get("" + box + "B8")%>"
											<%if (seat.get("" + box + "B8").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B9"
											value="<%=seat.get("" + box + "B9")%>"
											<%if (seat.get("" + box + "B9").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="B10"
											value="<%=seat.get("" + box + "B10")%>"
											<%if (seat.get("" + box + "B10").equals("Y")) {%> checked
											<%}%>></td>
									</tr>
									<tr>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
										<td>-</td>
									</tr>
									<tr>
										<td>C</td>
										<td><input type="checkbox" name="C1"
											value="<%=seat.get("" + box + "C1")%>"
											<%if (seat.get("" + box + "C1").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C2"
											value="<%=seat.get("" + box + "C2")%>"
											<%if (seat.get("" + box + "C2").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C3"
											value="<%=seat.get("" + box + "C3")%>"
											<%if (seat.get("" + box + "C3").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C4"
											value="<%=seat.get("" + box + "C4")%>"
											<%if (seat.get("" + box + "C4").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C5"
											value="<%=seat.get("" + box + "C5")%>"
											<%if (seat.get("" + box + "C5").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C6"
											value="<%=seat.get("" + box + "C6")%>"
											<%if (seat.get("" + box + "C6").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C7"
											value="<%=seat.get("" + box + "C7")%>"
											<%if (seat.get("" + box + "C7").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C8"
											value="<%=seat.get("" + box + "C8")%>"
											<%if (seat.get("" + box + "C8").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C9"
											value="<%=seat.get("" + box + "C9")%>"
											<%if (seat.get("" + box + "C9").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="C10"
											value="<%=seat.get("" + box + "C10")%>"
											<%if (seat.get("" + box + "C10").equals("Y")) {%> checked
											<%}%>></td>
									</tr>
									<tr>
										<td>D</td>
										<td><input type="checkbox" name="D1"
											value="<%=seat.get("" + box + "D1")%>"
											<%if (seat.get("" + box + "D1").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D2"
											value="<%=seat.get("" + box + "D2")%>"
											<%if (seat.get("" + box + "D2").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D3"
											value="<%=seat.get("" + box + "D3")%>"
											<%if (seat.get("" + box + "D3").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D4"
											value="<%=seat.get("" + box + "D4")%>"
											<%if (seat.get("" + box + "D4").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D5"
											value="<%=seat.get("" + box + "D5")%>"
											<%if (seat.get("" + box + "D5").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D6"
											value="<%=seat.get("" + box + "D6")%>"
											<%if (seat.get("" + box + "D6").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D7"
											value="<%=seat.get("" + box + "D7")%>"
											<%if (seat.get("" + box + "D7").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D8"
											value="<%=seat.get("" + box + "D8")%>"
											<%if (seat.get("" + box + "D8").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D9"
											value="<%=seat.get("" + box + "D9")%>"
											<%if (seat.get("" + box + "D9").equals("Y")) {%> checked
											<%}%>></td>
										<td><input type="checkbox" name="D10"
											value="<%=seat.get("" + box + "D10")%>"
											<%if (seat.get("" + box + "D10").equals("Y")) {%> checked
											<%}%>></td>
									</tr>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</fieldset>
		</div>
	</form>
	<%
		}
	%>
</body>
</html>