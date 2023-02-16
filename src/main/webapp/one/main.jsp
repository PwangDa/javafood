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
    a.topButton
    {
        /* border:1px solid red; */
        border-radius: 5px;

        text-align: center;
        text-decoration: none; /* 링크의 밑줄 제거 */
        color: inherit; /* 링크의 색상 제거 */

        background-color: rgb(46, 46, 46);

        padding:1% 8%;
        width:10%;
        margin:1%;
        
        font-size:25px;
        font-weight:bolder;
        
    }

    .subtitle
    {
        font-size:25px;
        font-weight:bolder;

        padding-left: 8%;
        padding-top: 5%;
    }

    .hitListParent
    {
        border:1px solid red;
        
        margin-left: 8%;
        
        display:flex;
        align-content:flex-start;
    }

    img.album
    {
        border: 1px solid red;

        width:60px;
        height:60px;

        border-radius: 5px;

        margin-right:1%;
    }

    .songInfo
    {
        border:1px solid red;

        /* vertical-align: middle; */
    }

    .songTitle
    {
        border:1px solid red;
    }

    tr
    {
        border:1px solid red;
    }
    td
    {
        border:1px solid red;
    }
</style>
















	<div class="topArea">
        <a class="topButton" href="javascript:void(0)"><span>최신 음악</span></a>
        <a class="topButton" href="javascript:void(0)"><span>차트</span></a>
        <a class="topButton" href="javascript:void(0)"><span>장르</span></a>
    </div>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
<script>
	(function (){  
	    document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
	    document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
	 }());
</script>
</body>
</html>