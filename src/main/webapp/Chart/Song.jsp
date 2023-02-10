<%--
설명 : SONG 테이블에서 자료 가져와서 웹에 출력
--%>

<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@page import="java.sql.Date"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="Chart.SongDAO"%>
<%@ page import="Chart.SongServlet"%>
<%@ page import="My_Page.vod"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="My_Page.dbon" import="My_Page.vod"
	import="Chart.SongServlet"%>
<%-- <%!String dbhost = "jdbc:oracle:thin:@todair.synology.me:51521:xe";
	String dbuser = "javafood";
	String dbpass = "javafood";
	//기존 song table과 합산용 table 함께 출력
	String query = " SELECT s.*,songname, (HITS *1) + (LIKES * 1.5) AS RANK2 FROM song s  ORDER BY RANK2 DESC";
	String title = "JavaFood Music";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<vod> vo = null;
	dbon db = new dbon();%> --%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>JavaFood Music</title>
<%-- <%
SongDAO dao = new SongDAO();

%> --%>



<script type="text/javascript">

	function refresh(){
		
		setTimeout('location.reload()',300000);
		
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
	<header>
		<strong>JavaFood Music</strong>
	</header>
	<div id="div">
		<a href='/javafood_team/one/main.jsp'>메인 페이지로 이동</a>
	</div>
	<div id="hour">
		<input type="text" size="10" id="timebox"> 현재시각 기준
	</div>
	<table class="table">
		<tr class="table2">
			<td><strong>번호</strong></td>
			<td><strong>좋아요+조회수 합산</strong></td>
			<td><strong>순위</strong></td>
			<td><strong>노래 제목</strong></td>
			<td><strong>아티스트 명</strong></td>
			<td><strong>장르</strong></td>
			<td><strong>조회수</strong></td>
			<td><strong>좋아요</strong></td>
			<td><strong>재생 시간</strong></td>
		</tr>

		<%-- <%
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		%> --%>

		<%
		try {
			Connection conn = DriverManager.getConnection(dbhost, dbuser, dbpass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			//순위 표시용 변수 i default 값 : 1부터 시작
			int i = 1;
			while (rs.next()) {

				String songnumber = rs.getString("songnumber");
				String rank2 = rs.getString("rank2");
				String ranking = rs.getString("ranking");
				String songname = rs.getString("songname");
				String artistname = rs.getString("artistname");
				String bygenre = rs.getString("bygenre");
				String hits = rs.getString("hits");
				String likes = rs.getString("likes");
				String playtime = rs.getString("playtime");

				// 				out.print("<tr>" + "<td>" + songnumber +"</td>" + "<td>" + rank2 + "</td>" + "<td>" + ranking + "</td>" +"<td>" + songname + "</td>" + "<td>" + artistname + "</td>" + "<td>" + bygenre + "</td>" +"<td>" + hits +"</td>" + "<td>" + likes +"</td>" + "<td>" + playtime +"</td>"
				// 				+"</tr>");
				//기존 ranking 변수 대신 i 값 넣어서 순위 표시
				out.print("<tr>" + "<td>" + songnumber + "</td>" + "<td>" + rank2 + "</td>" + "<td>" + i + "</td>" + "<td>"
				+ songname + "</td>" + "<td>" + artistname + "</td>" + "<td>" + bygenre + "</td>" + "<td>" + hits
				+ "</td>" + "<td>" + likes + "</td>" + "<td>" + playtime + "</td>" + "</tr>");
				//i 1씩 증가
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		%> --%>
	
	</table>
</body>
</html>