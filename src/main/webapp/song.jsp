<%-- <%@page import="java.util.*"%> --%>
<%-- <%@page import="java.sql.Date"%> --%>
<%-- <%@ page import="java.sql.ResultSet"%> --%>
<%-- <%@ page import="java.sql.Statement"%> --%>
<%-- <%@ page import="java.sql.Connection"%> --%>
<%-- <%@ page import="javafood_DTO.login_DTO"%> --%>
<%-- <%@ page import="java.sql.DriverManager"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="My_Page.*" import="javafood_DTO.*"
	import="SecondProject.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<%
	JavaFood_DAO dao;
	dao = new JavaFood_DAO();
	%>

	<%
	List<javafood_DTO.song_DTO> list = dao.listSong();
	%>

	<meta charset="UTF-8">
	<title>JavaFood Music</title>

	<script type="text/javascript">
		function refresh() {

			setTimeout('location.reload()', 300000);

		}

		function nowtime() {
			let now = new Date();

			let hour = now.getHours();
			let minute = now.getMinutes();
			let second = now.getSeconds();

			if (hour < 10) {
				hour = "0" + hour;
			}
			if (minute < 10) {
				minute = "0" + minute;
			}
			if (second < 10) {
				second = "0" + second;
			}

			document.getElementById("timebox").value = hour + ":" + minute
					+ ":" + second;
		}

		window.onload = function() {
			//HTML이 다 load가 완료 됐을 때 실행됨
			nowtime();
			setInterval(function() {

				nowtime();
			}, 1000); //1초 단위

			refresh();
		}
	</script>

<style>
header {
	top: 0;
}

body {
	margin: 0 auto;
	background-color: black;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	
}

.table {
	border: 1px solid black;
	
}
.table2 {
	color: white;
	border: 2px solid white;
	font-size: 20px;
}

.table3 {
	color: white;
	border: 2px solid white;
	font-size: 15px;
}

 td {
	text-align: center;
	background-color: black;
	color: white;
	border: 1px solid white;
}

.time {
	width : 100%;
	margin : 60px;
	text-align : right;
}

.list {
	margin : -51px;
	width : 100%;
}
</style>
</head>
	<jsp:include page="/menu.jsp"></jsp:include>
<body>
<div class="time">
	<input type="text" size="10" id="timebox"> 현재시각 기준
</div>
	<div class="list">
		<table class="table">
			<tr class="table2">
				<td style="width:50px;">번호</td>
				<td style="width:50px;">순위</td>
				<td style="width:120px;">인기점수</td>
				<td>앨범</td>
				<td style="width:350px;">제목</td>
				<td style="width:400px;">가수</td>
				<td style="width:60px;">장르</td>
				<td style="width:90px;">조회수</td>
				<td style="width:80px;">좋아요</td>
				<td style="width:120px;">재생 시간</td>
			</tr>
			<c:forEach var="dao" items="${ list_login}">
				<tr class="table3">
					<td>${dao.songnumber }</td>
					<td>${dao.ranking }</td>
					<td>${dao.famous }</td>
					<td><img src="${dao.imglink }" style="width:80px;"></td>
					<td>${dao.songname }</td>
					<td>${dao.artistname }</td>
					<td>${dao.bygenre }</td>
					<td>${dao.hits }</td>
					<td>${dao.likes }</td>
					<td>${dao.playtime }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>