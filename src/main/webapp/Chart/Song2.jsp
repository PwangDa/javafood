<%-- <%@page import="java.util.*"%> --%>
<%-- <%@page import="java.sql.Date"%> --%>
<%-- <%@ page import="java.sql.ResultSet"%> --%>
<%-- <%@ page import="java.sql.Statement"%> --%>
<%-- <%@ page import="java.sql.Connection"%> --%>
<%-- <%@ page import="javafood_DTO.login_DTO"%> --%>
<%-- <%@ page import="java.sql.DriverManager"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="My_Page.*"
    import="javafood_DTO.*"
    import="SecondProject.*"
    %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
ㄴㄴㄴㄴㄴㄴ
<%--
dbon db = new dbon();

<%
List<javafood_DTO.login_DTO> dto = null;
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

		document.getElementById("timebox").value = hour + ":" + minute + ":"
				+ second;
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
body {
	margin: 0 auto;
	background-color: black;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	width: 100%;
}

.table {
	border: 1px solid black;
}

.table2 {
	color: white;
	border: 2px solid white;
	font-size: 20px;
}

header {
	text-align: center;
	color: white;
	font-size: 40px;
}

td {
	text-align: center;
	background-color: black;
	color: white;
	border: 1px solid white;
}

#div {
	width: 100%;
	text-align: left;
	font-size: 20px;
}

#hour {
	width: 100%;
	text-align: right;
	color: white;
}
</style>

</head>
<body>
	<div id="div">
		<a href='/javafood_team/one/main.jsp'>메인 페이지로 이동</a>
	</div>
	<div id="hour">
		<input type="text" size="10" id="timebox"> 현재시각 기준
	</div>
		<table class="table">
			<tr class="table2">
				<td>번호
					<a href="/javafood/listsong.do?songnumber=${listsong.songnumber }"></a>
				</td>
				<td>조회수+좋아요 합산</td>
					<a href="/javafood/listsong.do?ranking2=${vo.ranking2 }"></a>
				<td>순위</td>
				<td>노래제목</td>
				<td>아티스트명</td>
				<td>장르</td>
				<td>조회수</td>
				<td>좋아요</td>
				<td>재생 시간</td>
			</tr>
		
		<%
		for (int i = 0; i < dto.size(); i++) {
		%>
			
			dssw
			
		<%
		}
		</table>
	 		--%>
		
</body>
</html>