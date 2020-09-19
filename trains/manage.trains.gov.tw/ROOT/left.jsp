<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 資源檔 -->
<%@include file="include/resources.jsp"%>
</head>
</HEAD>
<BODY>

	<div class="menu">
		<div class="grounp">
			<span id="top">系統管理
				<div class="down"></div>
			</span>
			<div class="inner">
				<a href="user.jsp" target="content">管理者系統維護</a> <a href="new.jsp"
					target="content">最新消息維護</a><a href="FAQ.jsp" target="content">Q&A維護</a>
				<a href="train.jsp" target="content">車次&車位維護</a>
			</div>
		</div>
	</div>
</BODY>

</HTML>