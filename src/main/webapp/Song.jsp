<%--
설명 : SONG 테이블에서 자료 가져와서 웹에 출력
--%>

<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@page import="java.sql.Date" %>
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
<%!String dbhost = "jdbc:oracle:thin:@todair.synology.me:51521:xe";
	String dbuser = "javafood";
	String dbpass = "javafood";
	String query = "SELECT * FROM SONG";
	String title = "인기차트";

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	List<vod> vo = null;
	dbon db = new dbon();%>

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>인기차트</title>
<% 		SongDAO dao = new SongDAO();

		/* String command = request.getParameter("command"); 
		
		if("songcomment".equals(command)) {
			String songname = request.getParameter("songname");
			String artistname = request.getParameter("artistname");
			
			vod vo = new vod();
			vo.setSongname(songname);
			vo.setArtistname(artistname);
			
			dao.listsong().add(vo);
		}else if("notsongcomment".equals(command)) {
			
			String songname2 = request.getParameter("songname");
			System.out.println("리스트에 없습니다"+songname2);
			dao.songlist(null);
		} */
		
		
		%>
		
		
 <script>
	
 </script>
<style>
	body{
		margin : 0 auto;
		background-color: black;
		display : flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		width: 100%;
	}
	.table {
		border:1px solid black;
		
	}
	.table2 {
		color: white;
	}
	
header{
      color: white;
        }
     
        
    td{
    	text-align : center;
    	background-color: black;
    	color: white;
    	border: 1px solid white;
    }

</style>
</head>
<header align="center" colspan="8">인기차트</header>
<body>
	<table class="table">
		<tr class="table2">
			<th>번호</th>
			<th>순위</th>
			<th>노래 제목</th>
			<th>아티스트 명</th>
			<th>장르</th>
			<th>조회수</th>
			<th>좋아요</th>
			<th>재생 시간</th>
		</tr>

<%
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
%>

<%
		try {
			Connection conn = DriverManager.getConnection(dbhost,dbuser, dbpass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				
				String songnumber = rs.getString("songnumber");
				String ranking = rs.getString("ranking");
				String songname = rs.getString("songname");
				String artistname = rs.getString("artistname");
				String bygenre = rs.getString("bygenre");
				String hits = rs.getString("hits");
				String likes = rs.getString("likes");
				String playtime = rs.getString("playtime");
				
				
				
				out.print("<tr>" + "<td>" + songnumber +"</td>" + "<td>" + ranking + "</td>" +"<td>" + songname + "</td>" + "<td>" + artistname + "</td>" + "<td>" + bygenre + "</td>" +"<td>" + hits +"</td>" + "<td>" + likes +"</td>" + "<td>" + playtime +"</td>"
				+"</tr>");
				
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
		} %>
</table>
</body>
</html>