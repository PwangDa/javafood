<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@page import="java.sql.Date" %>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="Chart.SongDAO"%>
<%@ page import="Chart.SongServlet"%>
<%@ page import="javafood_DTO.login_DTO"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="My_Page.dbon" import="My_Page.vod"
	import="Chart.SongServlet"%>
<%!String dbhost = "jdbc:oracle:thin:@todair.synology.me:51521:xe";
	String dbuser = "javafood";
	String dbpass = "javafood";
	String query = "SELECT * FROM SONG";
	String title = "인기차트";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<login_DTO> vo = null;
	dbon db = new dbon();%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function fn_sendSong(){
		document.frmSong.method = "post";
		document.frmSong.action = "/javafood_team/song";
		document.frmSong.submit();
	}
</script>
</head>
<body>
	<form name="frmSong">
		<table>
			<th>관리 페이지</th>
			<tr>
				<td>노래제목</td>
				<td>
					<input type="text" name="songname">
				</td>
			</tr>
			<tr>
				<td>아티스트 명</td>
				<td>
					<input type="text" name="artistname">
				</td>
			</tr>
				<tr>
				<td>링크</td>
				<td>
					<input type="text" name="link">
				</td>
			</tr>
		</table>
		<input type="button" value="노래정보 수정" onclick="fn_sendSong()">
		<input type="hidden" name="command" value="UpdateSong">
		<input type="button" value="노래 추가" onclick="fn_sendSong()">
		<input type="hidden" name="command" value="addSong">
	</form>
</body>
</html>