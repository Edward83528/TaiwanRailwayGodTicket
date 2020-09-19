<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String user = request.getParameter("user");
	String password = request.getParameter("password");
	//系統產生的驗證碼
	String rand = (String) session.getAttribute("rand");
	//使用者輸入的驗證碼
	String inputrand = request.getParameter("insrand");
	String memberURL = "indextry.jsp";
	String loginFormURL = "index.jsp";

	if (user == null || password == null) {
%>
<script type="text/javascript">
	alert("登入失敗，請洽系統管理者，謝謝您！");
	window.location.href = "index.jsp";
</script>
<%
	} else if (user.equals("root") && password.equals("123") && rand.equals(inputrand)) {
		session.setAttribute("user", user);
		session.setAttribute("password", password);
%>
<script type="text/javascript">
	alert("登入成功！");
	window.location.href = "indextry.jsp";
</script>
<%
	} else if (user.equals("root") && password.equals("123") && !rand.equals(inputrand)) {
%>
<script type="text/javascript">
	alert("驗證碼錯誤，請重新登入");
	window.location.href = "index.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("登入失敗，請洽系統管理者，謝謝您！");
	window.location.href = "index.jsp";
</script>
<%
	}
%>