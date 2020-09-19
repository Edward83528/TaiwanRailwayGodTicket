<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/error.jsp"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.List"%>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page
	import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@ page import="com.tutorialspoint.*"%>
<%@ page import="tw.com.common.*"%>
<%@ page import="com.tutorialspoint.StationItem"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>台鐵神票手</title>
<!-- 資源檔 -->
<%@include file="../../include/resources.jsp"%>

<script type="text/javascript">
	function save() {

		document.mform.action = "/HelloWeb/station";
		document.mform.method = "post";
		document.mform.submit();
	}
</script>
</head>
<body>
	<div class="anibg">
		<img src="<c:url value="/image/anilogo.png" />">
		<div class="backA"></div>
		<div class="backB"></div>
	</div>
	<div id="all">
		<%
			//接收參數
			String keyword = (String) request.getAttribute("keyword");
			if (keyword == null || keyword.equals("null") || keyword.lastIndexOf("請輸入") != -1) {
				keyword = "";
			}
		%>
		<div id="topbackgroundList">


			<!-- 導覽列 上方圖片-->

			<%@include file="../../include/home_menu.jsp"%>



			<!-- 車站查詢表格 -->
			<div id="stationList">
				<form:form method="POST" action="/HelloWeb/station" name="mform"
					id="mform">
					<div class="container">
					<div class="row">
						<div class="col-sm-11">
							<input name="keyword" id="keyword" type="text"
								class="form-control" value="請輸入關鍵字"
								onFocus="javascript: if (this.value=='請輸入關鍵字') this.value='';"
								onBlur="javascript: if(this.value=='') this.value='請輸入關鍵字';" />
						</div>
						<div class="col-sm-1">
							<button type="button" class="btn btn-warning"
								onclick="javascript:save()">查詢</button>
						</div>
					</div>
						<table class="rwd-table">
							<tr>
								<th>車站</th>
								<th>編號</th>
								<th>電話</th>
								<th>地址</th>
							</tr>

							<%
								ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
									StationJDBCTemplate stationJDBCTemplate = (StationJDBCTemplate) context.getBean("StationJDBCTemplate");
									List<StationItem> stations = stationJDBCTemplate.listStation(keyword);
									//頁數管理
									//起始資料索引
									String start1 = (String) request.getParameter("start");
									if (start1 == null || start1.equals(""))
										start1 = "1";
									int start2 = Integer.parseInt(start1);
									//每頁顯示15筆
									int pagesize = 15;
									//資料總筆數
									int rcount = stations.size();

									//最大頁數
									int maxpage = rcount % pagesize;
									if (maxpage == 0)
										maxpage = rcount / pagesize;
									else
										maxpage = (rcount / pagesize) + 1;

									int startpage = (1 - 1) * pagesize + 1;
									int endpage = start2 + pagesize - 1;
									for (int i = start2 - 1; ((i < endpage) && (i < rcount)); i++) {
										StationItem station = stations.get(i);
							%>

							<tr
								onclick="location.href = '/HelloWeb/stationin?id=<%=station.getStation_Code_1()%>';">
								<td data-th="車站"><%=station.getWebsiteName()%></td>
								<td data-th="編號"><%=station.getStation_Code_2()%></td>
								<td data-th="電話"><%=station.getTelephone()%></td>
								<td data-th="地址"><%=station.getChineseAddress()%></td>

								<%
									}
								%>
							</tr>

						</table>
						<div class="thispagination">
							<ul class="pagination">
								<%
									if (maxpage != 0 && start2 != 1) {
								%>
								<li><a href="/HelloWeb/Found?start=<%=1%>">最前頁</a></li>
								<%
									}
								%>
								<%
									if (start2 != 1) {
								%>
								<li><a href=/HelloWeb/Found?start=<%=start2 - 15%>">上一頁</a>
								</li>
								<%
									}
								%>
								<li>
									<%
										int k = (start2 % 15 == 0 ? (start2 / 15) : (start2 / 15 + 1)) + 9;
											if (k - 9 + 9 < maxpage) {
												for (int y = k - 10; y < k; y++) {
									%> <a href="/HelloWeb/Found?start=<%=y * 15 + 1%>"><%=y + 1%></a>
									<%
										if (y >= maxpage - 1) {
														break;
													}
									%> <%
 	}
 		} else {

 			int p = k - 10;
 			int u = 0;
 			if (maxpage < 10) {
 				u = 10 - maxpage;
 			} else {
 				u = 10 - maxpage;
 			}
 			int maxpage3 = 0;
 			if (maxpage < 10) {
 				maxpage3 = maxpage - 9 + u;
 			} else {
 				maxpage3 = maxpage - 9;
 			}

 			for (int y = maxpage; y >= maxpage - 9; y--) {
 				if (maxpage3 <= maxpage) {
 %> <a href="/HelloWeb/Found?start=<%=(maxpage3 - 1) * 15 + 1%>"><%=maxpage3++%></a>


									<%
										}
												}
											}
									%>

								</li>
								<%
									if (start2 + (rcount % 15) < rcount) {
								%>
								<li><a href="/HelloWeb/Found?start=<%=start2 + 15%>">下一頁
								</a></li>
								<%
									}
								%>
								<%
									if (maxpage != 0 && start2 + (rcount % 15) < rcount) {
								%>
								<li><a href="/HelloWeb/Found?start=<%=maxpage * 15 - 14%>">最末頁</a>
								</li>
								<%
									}
								%>
								<br>
								<br>
								<li>目前第<%=k - 9%>頁
								</li>

							</ul>
						</div>


					</div>
				</form:form>
			</div>


			<!-- pagefooter -->

			<%@include file="../../include/foot.jsp"%>

		</div>

	</div>
	</div>
</body>
</html>