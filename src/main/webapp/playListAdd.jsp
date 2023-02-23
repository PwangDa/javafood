<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "SecondProject.JavaFood_DAO"
    import = "java.util.ArrayList"
    import = "java.util.List"
    import = "javafood_DTO.PlayListDTO"
    import = "SecondProject.JavaFood_Controller"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	/* 어느 페이지에서 노래 추가를 요청했는지 판단하는 변수. */
	String addWhere = request.getParameter("addWhere");
	
	/* 요청된 노래의 값을 가져온 변수. */
	int songNumber = Integer.parseInt(request.getParameter("songNumber") );
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트에 노래 추가</title>
	<!-- css파일 불러오기 -->
	<link rel="stylesheet" href="javafoodCSS/playList.css">
</head>
<body>
	<% if(id.equals(null) )
		{%>
			<div class="title">
				<h1>로그인이 필요한 서비스 입니다.</h1>
				<br>
				<a href="javafood?javafood=4">로그인</a>
			</div>
	<%	}
		else
		{%>
	<div class="title"><h1>노래를 추가할 플레이 리스트를 선택하세요.</h1></div>
	<br>
	<hr>
	<c:forEach var="playList" items="${playList }">
		<!-- 누르면 추가하는  -->
		<a href="javafood?javafood=3_7&pl_id=${playList.pl_id }&addWhere=<%=addWhere%>&songNumber=<%=songNumber%>">
			<div class="playList">
				<!-- 앨범 표지가 추가되면 해당 부분의 src를 수정할 것. -->
				<img class="album" src="https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined">
				<div class="plText">${playList.listTitle }</div>
			</div>
		</a>
	</c:forEach>
	<%	} %>
</body>
</html>