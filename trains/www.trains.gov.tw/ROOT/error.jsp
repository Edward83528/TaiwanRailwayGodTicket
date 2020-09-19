<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>
</head>
<body>
	<div id="topbackgrounderror">


		<!-- 導覽列 上方圖片-->

		<%@include file="../../include/home_menu.jsp"%>

		<div id="error">
			<div class="container">
				<div class="srollbg">
					<div class="text">
						<p>404</p>
						<span>Page Not Found</span>
					</div>
					<div class="srollImage"></div>
					<img src="<c:url value="/image/movetrain.png" />">
				</div>
			</div>
		</div>
		<%@include file="../../include/foot.jsp"%>

	</div>
</body>
</html>