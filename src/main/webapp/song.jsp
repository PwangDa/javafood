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

<meta charset="UTF-8">
<title>JavaFood Music</title>

<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<link rel="stylesheet" href="javafoodCSS/songCSS.css?css=css">

<form method="post" action="/javafood_team/javafood?javafood=3_6">
	<input type="hidden" name="songNumber" value="${dao.songnumber }">
	<input type="hidden" name="addWhere" value="song">
	<img id="allsave" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
</form>

</head>
<jsp:include page="/menu.jsp"></jsp:include>
<body>
	<div class="time">
		<input type="text" size="10" id="timebox"> 현재시각 기준
	</div>
	<div class="list">
		<table class="table">
			<tr class="table2">
				<td style="width: 200px;"><input type="checkbox" id="selectbtn" name="checkall" onclick="selectAll(this); getChecked" " value="checkall; ${dao.songnumber }">체크</td>
				<td style="width: 60px;">순위</td>
				<td style="width: 250px;">인기점수</td>
				<td style="width: 100px;">번호</td>
				<td style="width: 100px;">앨범</td>
				<td style="width: 400px;">앨범명</td>
				<td style="width: 400px;">제목</td>
				<td style="width: 400px;">가수</td>
				<td style="width: 100px;">장르</td>
				<td style="width: 100px;">조회수</td>
				<td style="width: 120px;">좋아요</td>
				<td style="width: 120px;">재생 시간</td>
				<td style="width: 50px;">재생</td>
				<td style="width: 80px;">담기</td>
				<td style="width: 150px;">국적</td>
			</tr>
			<c:forEach var="dao" items="${ list}">
				<tr class="table3 table3_${dao.songnumber }">
					<td><input type="checkbox" id="checkbox1" name="check" onclick="checkSelectAll(); getCheckedValue()" value="${dao.songnumber }"></td>
					<td>${dao.ranking }</td>
					<td>${dao.famous }</td>
					<td>${dao.songnumber }</td>
					<td><img src=${ dao.imglink} " style="width: 80px;"></td>
					<td><a
						href="/javafood_team/javafood?javafood=AlbumList&num=${dao.songnumber}">${ dao.album_name}</a></td>
					<td>${dao.songname }</td>
					<td><a
						href="/javafood_team/javafood?javafood=ArtistList&num=${dao.songnumber}">${ dao.artistname}</a></td>

					<td>${dao.bygenre }</td>

					<form method="post" action="/javafood_team/javafood?javafood=2">
						<td>${dao.hits }<input type="hidden" name="addhit"
							value="${dao.songnumber}">
						</td>
					</form>

					<form method="post" action="/javafood_team/javafood?javafood=2">
						<td>${dao.likes }<input type="image"
							src="https://c11.kr/1asbx" value=" " class="like"> <input
							type="hidden" name="good_like" value="${dao.songnumber}">
						</td>
					</form>

					<td>${dao.playtime }</td>

					<td><a href="#"
						onclick="window.open('https://www.youtube.com/results?search_query=${dao.songname }'); addhit('${login}','${dao.songnumber }'); "><img
							class="play" src="https://c11.kr/1asd1"></a></td>

					<td>
						<form method="post" action="/javafood_team/javafood?javafood=3_6">
							<input type="hidden" name="songNumber" value="${dao.songnumber }">
							<input type="hidden" name="addWhere" value="song">
							<img class="save" src="https://c11.kr/1asd6" onmouseover="this.src='https://c11.kr/1asd9'" onmouseout="this.src='https://c11.kr/1asd6'">
						</form>
					</td>

					<td>${dao.country }</td>
				</tr>
			</c:forEach>
		</table>

<%
int totalCount = (int) request.getAttribute("totalCount");
int pageNum = (int) request.getAttribute("pageNum");
int countPerPage = (int) request.getAttribute("countPerPage");
// int / int = int
// double / int = double
int lastPage = (int) Math.ceil((double) totalCount / countPerPage);
int section = 50;

int sec_position = (((int) Math.ceil((double) pageNum / section)) - 1);
int firstSec = (sec_position * section) + 1;
int lastSec = firstSec + section - 1;
if (lastSec > lastPage) {
	lastSec = lastPage;
}
%>

		<c:set var="pageNum2" value="<%=pageNum%>" />
		<div class="paging">

			<c:if test="<%=firstSec != 1%>">
				<a
					href="/javafood_team/javafood?javafood=2&songnumber=${num }&pageNum=<%= firstSec-1 %>"><img
					class="mouse" src="https://c11.kr/1ascb"
					onmouseover="this.src='https://c11.kr/1ascc'"
					onmouseout="this.src='https://c11.kr/1ascb'"></a>
			</c:if>

			<c:forEach var="i" begin="<%=firstSec%>" end="<%=lastSec%>">
				<c:if test="${ i == pageNum2 }">
					<a
						href="/javafood_team/javafood?javafood=2&songnumber=${num }&pageNum=${i }"
						class="number"><strong>${i}</strong></a>
				</c:if>
				<c:if test="${ i != pageNum2 }">
					<a
						href="/javafood_team/javafood?javafood=2&songnumber=${num }&pageNum=${i }"
						class="number">${i}</a>
				</c:if>
			</c:forEach>

			<c:if test="<%=lastSec != lastPage%>">
				<a
					href="/javafood_team/javafood?javafood=2&songnumber=${num }&pageNum=<%= lastSec+1 %>"><img
					class="img" src="https://c11.kr/1ascx"
					onmouseover="this.src='https://c11.kr/1ascy'"
					onmouseout="this.src='https://c11.kr/1ascx'"></a>
			</c:if>

		</div>
	</div>
<script link src="javafoodScript/songScript.js"></script>
</body>
</html>