<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Food</title>
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<br>
	<br>
	<br>
<style>
    body
    {
        background-color: black;
        color:white;
        margin : 0;
    }

    div.topArea
    {
        display:flex;
        justify-content: center;
        
        
    }
    span.topButton
    {
        
    }
    a
    {
        text-align: center;
        text-decoration: none; /* 링크의 밑줄 제거 */
        color: inherit; /* 링크의 색상 제거 */
        /* border:1px solid red; */
        background-color: rgb(46, 46, 46);
        padding:1% 8%;
        width:10%;
        margin:1%;
        font-size:25px;
        font-weight:bolder;
        border-radius: 5px;
        
    }
</style>

    <div class="topArea">
        <a href="javascript:void(0)"><span class="topButton">최신 음악</span></a>
        <a href="javafood?javafood=2"><span class="topButton">차트</span></a>
        <a href="javafood?javafood=6"><span class="topButton">장르</span></a>
    </div>
</body>
</html>