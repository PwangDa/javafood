<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="javafoodCSS/menuCSS.css?css=css">
</head>
<body>
    <header id ="menu" >
        <span style="font-size: 34px; font-weight: 600; cursor: pointer;">
        <a href="javafood?javafood=m" class="a1"><img src="https://c11.kr/1asbb" class="logo-img">Music</a>
        </span>
        <div class="menu-box">
            <a href="javafood?javafood=m" class="a1"><span class="main main_1" >홈</span></a>
            <a href="javafood?javafood=6" class="a1"><span class="main main_2" >장르별</span></a>
            <a href="javafood?javafood=3" class="a1"><span class="main main_3" >보관함</span></a>
            <div class = "main-box main_4">
                <input class="search-txt" type="text" placeholder="검색">
                <button class="search-btn" type="submit">검색</button>
            </div>
        </div>
        <c:if test="${lo[0].myimg!=null}">
	        <a href="javafood?javafood=5"><img class="menu-img" src=" ${lo[0].myimg }"></a>
        </c:if>
        <c:if test="${lo[0].myimg==null}">
			<a href="javafood?javafood=5"><img class="menu-img" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png"></a>
        </c:if>
        
    </header>
</body>
</html>