<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>

<!-- 資源檔 -->
<%@include file="../../include/resources.jsp"%>

</head>
<body>
	<div class="anibg">
		<img src="<c:url value="/image/anilogo.png" />">
		<div class="backA"></div>
		<div class="backB"></div>
	</div>
	<div id="all">
		<div id="topbackgroundRefund">

			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>


			<div id="refund-1">
				<div class="container">

					<fieldset class="order">
						<div class="rule">
							<label class="control-label">寄信成功</label>
						</div>
						<div class="submit">
							<button type="button" class="btn btn-success btn-lg"
								onclick="location.href='../index.jsp'">返回首頁</button>
						</div>
					</fieldset>

				</div>
			</div>

			<!-- pagefooter -->
			<%@include file="../../include/foot.jsp"%>

		</div>
	</div>
</body>
</html>