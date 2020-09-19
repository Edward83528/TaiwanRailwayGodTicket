<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="tw.com.common.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>
</head>
<body>
	<%
		Map<String, String> seat = new HashMap<String, String>();

		//解決編碼問題
		request.setCharacterEncoding("UTF-8");
		//接收參數
		String Id = (String) request.getParameter("id");
		String box = (String) request.getParameter("box");
		String A1 = (String) request.getParameter("A1");
		TrainData trainDate = new TrainData();
		ArrayList<Station_trainItem> lists = trainDate.SelectTrainSeat(Id);
		Map<String, String> seat2 = lists.get(0).getSeat();
		if (A1 != null) {
			A1 = "Y";
		} else {
			A1 = "N";
		}
		String A2 = (String) request.getParameter("A2");
		if (A2 != null) {
			A2 = "Y";
		} else {
			A2 = "N";
		}
		String A3 = (String) request.getParameter("A3");
		if (A3 != null) {
			A3 = "Y";
		} else {
			A3 = "N";
		}
		String A4 = (String) request.getParameter("A4");
		if (A4 != null) {
			A4 = "Y";
		} else {
			A4 = "N";
		}
		String A5 = (String) request.getParameter("A5");
		if (A5 != null) {
			A5 = "Y";
		} else {
			A5 = "N";
		}
		String A6 = (String) request.getParameter("A6");
		if (A6 != null) {
			A6 = "Y";
		} else {
			A6 = "N";
		}
		String A7 = (String) request.getParameter("A7");
		if (A7 != null) {
			A7 = "Y";
		} else {
			A7 = "N";
		}
		String A8 = (String) request.getParameter("A8");
		if (A8 != null) {
			A8 = "Y";
		} else {
			A8 = "N";
		}
		String A9 = (String) request.getParameter("A9");
		if (A9 != null) {
			A9 = "Y";
		} else {
			A9 = "N";
		}
		String A10 = (String) request.getParameter("A10");
		if (A10 != null) {
			A10 = "Y";
		} else {
			A10 = "N";
		}

		String B1 = (String) request.getParameter("B1");
		if (B1 != null) {
			B1 = "Y";
		} else {
			B1 = "N";
		}
		String B2 = (String) request.getParameter("B2");
		if (B2 != null) {
			B2 = "Y";
		} else {
			B2 = "N";
		}
		String B3 = (String) request.getParameter("B3");
		if (B3 != null) {
			B3 = "Y";
		} else {
			B3 = "N";
		}
		String B4 = (String) request.getParameter("B4");
		if (B4 != null) {
			B4 = "Y";
		} else {
			B4 = "N";
		}
		String B5 = (String) request.getParameter("B5");
		if (B5 != null) {
			B5 = "Y";
		} else {
			B5 = "N";
		}
		String B6 = (String) request.getParameter("B6");
		if (B6 != null) {
			B6 = "Y";
		} else {
			B6 = "N";
		}
		String B7 = (String) request.getParameter("B7");
		if (B7 != null) {
			B7 = "Y";
		} else {
			B7 = "N";
		}
		String B8 = (String) request.getParameter("B8");
		if (B8 != null) {
			B8 = "Y";
		} else {
			B8 = "N";
		}
		String B9 = (String) request.getParameter("B9");
		if (B9 != null) {
			B9 = "Y";
		} else {
			B9 = "N";
		}
		String B10 = (String) request.getParameter("B10");
		if (B10 != null) {
			B10 = "Y";
		} else {
			B10 = "N";
		}

		String C1 = (String) request.getParameter("C1");
		if (C1 != null) {
			C1 = "Y";
		} else {
			C1 = "N";
		}
		String C2 = (String) request.getParameter("C2");
		if (C2 != null) {
			C2 = "Y";
		} else {
			C2 = "N";
		}
		String C3 = (String) request.getParameter("C3");
		if (C3 != null) {
			C3 = "Y";
		} else {
			C3 = "N";
		}
		String C4 = (String) request.getParameter("C4");
		if (C4 != null) {
			C4 = "Y";
		} else {
			C4 = "N";
		}
		String C5 = (String) request.getParameter("C5");
		if (C5 != null) {
			C5 = "Y";
		} else {
			C5 = "N";
		}
		String C6 = (String) request.getParameter("C6");
		if (C6 != null) {
			C6 = "Y";
		} else {
			C6 = "N";
		}
		String C7 = (String) request.getParameter("C7");
		if (C7 != null) {
			C7 = "Y";
		} else {
			C7 = "N";
		}
		String C8 = (String) request.getParameter("C8");
		if (C8 != null) {
			C8 = "Y";
		} else {
			C8 = "N";
		}
		String C9 = (String) request.getParameter("C9");
		if (C9 != null) {
			C9 = "Y";
		} else {
			C9 = "N";
		}
		String C10 = (String) request.getParameter("C10");
		if (C10 != null) {
			C10 = "Y";
		} else {
			C10 = "N";
		}

		String D1 = (String) request.getParameter("D1");
		if (D1 != null) {
			D1 = "Y";
		} else {
			D1 = "N";
		}
		String D2 = (String) request.getParameter("D2");
		if (D2 != null) {
			D2 = "Y";
		} else {
			D2 = "N";
		}
		String D3 = (String) request.getParameter("D3");
		if (D3 != null) {
			D3 = "Y";
		} else {
			D3 = "N";
		}
		String D4 = (String) request.getParameter("D4");
		if (D4 != null) {
			D4 = "Y";
		} else {
			D4 = "N";
		}
		String D5 = (String) request.getParameter("D5");
		if (D5 != null) {
			D5 = "Y";
		} else {
			D5 = "N";
		}
		String D6 = (String) request.getParameter("D6");
		if (D6 != null) {
			D6 = "Y";
		} else {
			D6 = "N";
		}
		String D7 = (String) request.getParameter("D7");
		if (D7 != null) {
			D7 = "Y";
		} else {
			D7 = "N";
		}
		String D8 = (String) request.getParameter("D8");
		if (D8 != null) {
			D8 = "Y";
		} else {
			D8 = "N";
		}
		String D9 = (String) request.getParameter("D9");
		if (D9 != null) {
			D9 = "Y";
		} else {
			D9 = "N";
		}
		String D10 = (String) request.getParameter("D10");
		if (D10 != null) {
			D10 = "Y";
		} else {
			D10 = "N";
		}
		if (box.equals("1")) {
			// 第一節車廂
			seat.put("1A1", A1);
			seat.put("1A2", A2);
			seat.put("1A3", A3);
			seat.put("1A4", A4);
			seat.put("1A5", A5);
			seat.put("1A6", A6);
			seat.put("1A7", A7);
			seat.put("1A8", A8);
			seat.put("1A9", A9);
			seat.put("1A10", A10);

			seat.put("1B1", B1);
			seat.put("1B2", B2);
			seat.put("1B3", B3);
			seat.put("1B4", B4);
			seat.put("1B5", B5);
			seat.put("1B6", B6);
			seat.put("1B7", B7);
			seat.put("1B8", B8);
			seat.put("1B9", B9);
			seat.put("1B10", B10);

			seat.put("1C1", C1);
			seat.put("1C2", C2);
			seat.put("1C3", C3);
			seat.put("1C4", C4);
			seat.put("1C5", C5);
			seat.put("1C6", C6);
			seat.put("1C7", C7);
			seat.put("1C8", C8);
			seat.put("1C9", C9);
			seat.put("1C10", C10);

			seat.put("1D1", D1);
			seat.put("1D2", D2);
			seat.put("1D3", D3);
			seat.put("1D4", D4);
			seat.put("1D5", D5);
			seat.put("1D6", D6);
			seat.put("1D7", D7);
			seat.put("1D8", D8);
			seat.put("1D9", D9);
			seat.put("1D10", D10);
			// 第二節車廂
			seat.put("2A1", seat2.get("2A1"));
			seat.put("2A2", seat2.get("2A2"));
			seat.put("2A3", seat2.get("2A3"));
			seat.put("2A4", seat2.get("2A4"));
			seat.put("2A5", seat2.get("2A5"));
			seat.put("2A6", seat2.get("2A6"));
			seat.put("2A7", seat2.get("2A7"));
			seat.put("2A8", seat2.get("2A8"));
			seat.put("2A9", seat2.get("2A9"));
			seat.put("2A10", seat2.get("2A10"));

			seat.put("2B1", seat2.get("2B1"));
			seat.put("2B2", seat2.get("2B2"));
			seat.put("2B3", seat2.get("2B3"));
			seat.put("2B4", seat2.get("2B4"));
			seat.put("2B5", seat2.get("2B5"));
			seat.put("2B6", seat2.get("2B6"));
			seat.put("2B7", seat2.get("2B7"));
			seat.put("2B8", seat2.get("2B8"));
			seat.put("2B9", seat2.get("2B9"));
			seat.put("2B10", seat2.get("2B10"));

			seat.put("2C1", seat2.get("2C1"));
			seat.put("2C2", seat2.get("2C2"));
			seat.put("2C3", seat2.get("2C3"));
			seat.put("2C4", seat2.get("2C4"));
			seat.put("2C5", seat2.get("2C5"));
			seat.put("2C6", seat2.get("2C6"));
			seat.put("2C7", seat2.get("2C7"));
			seat.put("2C8", seat2.get("2C8"));
			seat.put("2C9", seat2.get("2C9"));
			seat.put("2C10", seat2.get("2C10"));

			seat.put("2D1", seat2.get("2D1"));
			seat.put("2D2", seat2.get("2D2"));
			seat.put("2D3", seat2.get("2D3"));
			seat.put("2D4", seat2.get("2D4"));
			seat.put("2D5", seat2.get("2D5"));
			seat.put("2D6", seat2.get("2D6"));
			seat.put("2D7", seat2.get("2D7"));
			seat.put("2D8", seat2.get("2D8"));
			seat.put("2D9", seat2.get("2D9"));
			seat.put("2D10", seat2.get("2D10"));

		} else if (box.equals("2")) {
			// 第二節車廂
			seat.put("2A1", A1);
			seat.put("2A2", A2);
			seat.put("2A3", A3);
			seat.put("2A4", A4);
			seat.put("2A5", A5);
			seat.put("2A6", A6);
			seat.put("2A7", A7);
			seat.put("2A8", A8);
			seat.put("2A9", A9);
			seat.put("2A10", A10);

			seat.put("2B1", B1);
			seat.put("2B2", B2);
			seat.put("2B3", B3);
			seat.put("2B4", B4);
			seat.put("2B5", B5);
			seat.put("2B6", B6);
			seat.put("2B7", B7);
			seat.put("2B8", B8);
			seat.put("2B9", B9);
			seat.put("2B10", B10);

			seat.put("2C1", C1);
			seat.put("2C2", C2);
			seat.put("2C3", C3);
			seat.put("2C4", C4);
			seat.put("2C5", C5);
			seat.put("2C6", C6);
			seat.put("2C7", C7);
			seat.put("2C8", C8);
			seat.put("2C9", C9);
			seat.put("2C10", C10);

			seat.put("2D1", D1);
			seat.put("2D2", D2);
			seat.put("2D3", D3);
			seat.put("2D4", D4);
			seat.put("2D5", D5);
			seat.put("2D6", D6);
			seat.put("2D7", D7);
			seat.put("2D8", D8);
			seat.put("2D9", D9);
			seat.put("2D10", D10);
			// 第一節車廂
			seat.put("1A1", seat2.get("1A1"));
			seat.put("1A2", seat2.get("1A1"));
			seat.put("1A3", seat2.get("1A3"));
			seat.put("1A4", seat2.get("1A4"));
			seat.put("1A5", seat2.get("1A5"));
			seat.put("1A6", seat2.get("1A6"));
			seat.put("1A7", seat2.get("1A7"));
			seat.put("1A8", seat2.get("1A8"));
			seat.put("1A9", seat2.get("1A9"));
			seat.put("1A10", seat2.get("1A10"));

			seat.put("1B1", seat2.get("1B1"));
			seat.put("1B2", seat2.get("1B2"));
			seat.put("1B3", seat2.get("1B3"));
			seat.put("1B4", seat2.get("1B4"));
			seat.put("1B5", seat2.get("1B5"));
			seat.put("1B6", seat2.get("1B6"));
			seat.put("1B7", seat2.get("1B7"));
			seat.put("1B8", seat2.get("1B8"));
			seat.put("1B9", seat2.get("1B9"));
			seat.put("1B10", seat2.get("1B10"));

			seat.put("1C1", seat2.get("1C1"));
			seat.put("1C2", seat2.get("1C2"));
			seat.put("1C3", seat2.get("1C3"));
			seat.put("1C4", seat2.get("1C4"));
			seat.put("1C5", seat2.get("1C5"));
			seat.put("1C6", seat2.get("1C6"));
			seat.put("1C7", seat2.get("1C7"));
			seat.put("1C8", seat2.get("1C8"));
			seat.put("1C9", seat2.get("1C9"));
			seat.put("1C10", seat2.get("1C10"));

			seat.put("1D1", seat2.get("1D1"));
			seat.put("1D2", seat2.get("1D2"));
			seat.put("1D3", seat2.get("1D3"));
			seat.put("1D4", seat2.get("1D4"));
			seat.put("1D5", seat2.get("1D5"));
			seat.put("1D6", seat2.get("1D6"));
			seat.put("1D7", seat2.get("1D7"));
			seat.put("1D8", seat2.get("1D8"));
			seat.put("1D9", seat2.get("1D9"));
			seat.put("1D10", seat2.get("1D10"));

		}
		TrainData trainData = new TrainData();
		boolean check = trainData.UpdateTrains(Id, seat);
		if (check) {
			System.out.println("更新成功");
	%>
	<script>
		alert("更新成功!");
		window.location.href = "train.jsp";
	</script>
	<%
		} else {
			System.out.println("更新失敗");
	%>
	<script>
		alert("更新失敗!");
		window.location.href = "train.jsp";
	</script>
	<%
		}
	%>

</body>
</html>