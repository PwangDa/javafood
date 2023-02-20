<%-- <%@page import="java.util.*"%> --%>
<%-- <%@page import="java.sql.Date"%> --%>
<%-- <%@ page import="java.sql.ResultSet"%> --%>
<%-- <%@ page import="java.sql.Statement"%> --%>
<%-- <%@ page import="java.sql.Connection"%> --%>
<%-- <%@ page import="javafood_DTO.login_DTO"%> --%>
<%-- <%@ page import="java.sql.DriverManager"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="javafood_ajax.*" import="javafood_DTO.*"
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
	JavaFood_DAO addhit = new JavaFood_DAO();
	%>

	<meta charset="UTF-8">
	<title>JavaFood Music</title>
	
	<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
	<link rel="stylesheet" href="javafoodCSS/songCSS.css?css=css">
	<script link src ="javafoodScript/songScript.js"></script>
	
	
<style>
	
	 커서올리면 체크박스 나오게*/
        <% for(int i=0; i<list.size(); i++) {%>
        .cont2_<%= i+1%>:hover span{
        	display : none;
        }
  
        .cont2_<%= i+1%>:hover .but{
        	display : block;
        }
        <%}%>
        
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
				<td style="width:60px;">체크</td>
				<td style="width:60px;">순위</td>
				<td style="width:250px;">인기점수</td>
				<td style="width:100px;">앨범</td>
				<td style="width:400px;">앨범명</td>
				<td style="width:400px;">제목</td>
				<td style="width:400px;">가수</td>
				<td style="width:100px;">장르</td>
				<td style="width:100px;">조회수</td>
				<td style="width:120px;">좋아요</td>
				<td style="width:120px;">재생 시간</td>
				<td style="width:50px;">재생</td>
				<td style="width:80px;">담기</td>
				<td style="width:150px;">국적</td>
			</tr>
			<c:forEach var="dao" items="${ list_login}" >
				<tr class="table3 table3_${dao.songnumber }">
					<td> <input type="checkbox" class="but btn" ${dao.songnumber }></td>
					<td>${dao.ranking }</td>
					<td>${dao.famous }</td>
					<td><img src=${ dao.imglink}" style="width:80px;"></td>
					<td><a href = "/javafood_team/javafood?javafood=AlbumList&num=${dao.songnumber}">${ dao.album_name}</a></td>
					<td>${dao.songname }</td>
					<td><a href="/javafood_team/javafood?javafood=ArtistList&num=${dao.songnumber}">${ dao.artistname}</a></td>
					
					<td>${dao.bygenre }</td>
					
					<form method="post" action="/javafood_team/javafood?javafood=2" >
					<td>${dao.hits }
						<input type="hidden" name="addhit" value= "${dao.songnumber}">
					</td>
					</form>
					
					<form method="post" action="/javafood_team/javafood?javafood=2">
						<td>
							${dao.likes }<input type="image" src="https://c11.kr/1asbx" value=" " class="like">
							<input type="hidden" name="good_like" value= "${dao.songnumber}">
						</td>
					</form>
					
					<td>${dao.playtime }</td>
					<td><a href="${dao.link }"target='_blank'><img class="play" src="https://c11.kr/1asd1"></a></td>
					<td><img class="save" src="https://c11.kr/1asd6"></td>
					<td>${dao.country }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>