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
<c:if test="${mmm!=null }">
	<script> alert('정확한 주소를 입력해 주세요.');</script>
</c:if>
	<!-- css파일 불러오기 -->
	<link rel="stylesheet" href="./javafoodCSS/main.css">
</head>
<body>
	<jsp:include page="/menu.jsp" />
	<br>
	<br>
	<br>

	<div class="topArea">
        <a class="topButton" href="javafood?javafood=7"><span>최신 음악</span></a>
        <a class="topButton" href="javafood?javafood=2"><span>차트</span></a>
        <a class="topButton" href="javafood?javafood=6"><span>장르</span></a>
    </div>
    
    <br>
    <br>
    
    <div class="hitList">
    	<div class="subtitle">
    		인기곡
    		<div class="hitListController">
    			<p class="point prev"><</p>
    			<p class="point next">></p>
    		</div>
    	</div>
    </div>
    
    <br>
    
    <div class="songContent">
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count<=4 }">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>

    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=5 && vs.count<=8}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=9 && vs.count<=12}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=13 && vs.count<=16}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=17 && vs.count<=20}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=21 && vs.count<=24}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=25 && vs.count<=28}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
	
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=29 && vs.count<=32}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=33 && vs.count<=36}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
	    <div id="hitListLine">
	    	<c:forEach var="hitList" items="${hitList }" varStatus="vs">
		    	<c:if test="${vs.count>=37 && vs.count<=40}">
		            <div class="hitListViewerContent">
		                <div class="hitListViewerThumnail">
		                    <img class="thumnail" src="${hitList.imglink }">
		                </div>
		    
		                <div class="hitListRank">${hitList.songnumber }</div>
		    
		                <div class="songContentInfo">
		    
		                    <div class="hitListViewerSongTitle">
		                        <a href="${hitList.link }">${hitList.songname }</a>
		                    </div>
		                    <div class="hitListViewerSongInfo">
		                    <!-- 곡 정보와 앨범 정보 DB가 생기면 링크를 수정할 것. -->
		                        <a href="javascript:void(0)">${hitList.artistname }</a>·<a href="javascript:void(0)">${hitList.album }</a>
		                    </div>
		                </div>
		            </div>
		    	</c:if>
	    	</c:forEach>
	    </div>
    
<script>
	(function (){  
	    document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
	    document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
	 }());
</script>
</body>
</html>