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
<body>

	<%
		//判斷是否新增成功變數
		boolean rtn = false;

		List<FAQiItem> result = new ArrayList<FAQiItem>();
		String[] chk = request.getParameterValues("check");
		String xmlmessage = "";
		if (chk == null) {
			xmlmessage = "||false||您未勾選任何一項，請勾選欲刪除資料！||";
		} else {
			TrainData obj = new TrainData();

			if (chk != null) {
				for (int i = 0; i < chk.length; i++) {
					obj.DelFAQS(chk[i]);
				}
				rtn = true;
			}

			if (rtn) {
				xmlmessage = "||" + rtn + "||";
			} else {
				xmlmessage = "||" + rtn + "||";
			}
		}

		response.setContentType("text/plain; charset=UTF-8");
		response.getWriter().print(xmlmessage);
		response.getWriter().flush();
		response.getWriter().close();
	%>
</body>
</html>