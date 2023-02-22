<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   
    import = "SecondProject.JavaFood_DAO"
    import = "java.util.ArrayList"
    import = "java.util.List"
    import = "javafood_DTO.PlayListDTO"
    import = "SecondProject.JavaFood_Controller" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String id = (String)request.getAttribute("id"); //아이디
// 	String listTitle = request.getParameter("listTitle"); //플레이 리스트 제목
// 	String doDeleteSong = request.getParameter("deDeleteSong");
	
// 	//곡 삭제하기
// 	if("doDelete".equals(doDeleteSong) )
// 	{
// 		String deleteNumber = request.getParameter("res.ListNumber"); //지울 곡의 리스트 순서
// 	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=id %>님의 ${playListContent[0].listTitle }</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<c:choose>
		<%-- 해당 플레이 리스트의 내용이 하나도 없다면 --%>
		<c:when test="${empty playListContent }">
			<div class="noList">등록된 곡이 없습니다. 곡을 추가해 주세요.</div>
		</c:when>
		
		<%-- 해당 플레이 리스트의 내용이 하나라도 존재한다면 --%>
		<c:when test="${!empty playListContent }">
			<div class="album_info">
				<!-- 아래 코드는 플레이 리스트의 대표 앨범사진 코드. 좀 더 고민해보기. -->
				<img class="list_thumnail" src="https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined">
				<br>
				<br>
				<h2 style="text-shadow:2px 2px 2px gray; color:whitesmoke;">${playListContent[0].listTitle }</h2>
				<br>
				<div class="ablum_explain">
					${playListContent[0].listExplain }
				</div>
			</div>
				
			<span class="delete">
				<form name="deleteList">
					<input type="hidden" name="pl_id" value="${playListContent[0].pl_id }">
					<input type="hidden" name="id" value="<%=id %>">
					<input type="hidden" name="javafood" value="3_5">
					<img class="delete_icon" src="https://popcat.click/twitter-card.jpg" width="50">
					<img class="delete_icon2 hidden" src="https://play-lh.googleusercontent.com/ID5wHCs0FsgS018pX0e0My5z3u4cBG7dAYAr2owB9gwylWaNZTJ0pWAKl9It7ys5iEM" width="50">
					<div style="font-size:12px; text-align:center;">삭제하기</div>
				</form>
 			</span>
 				
			<div class="list_parent">
			<c:forEach var="list" items="${playListContent }">
				<div class="list_child">
					<img class="album" src="${list.imgLink }">
					<div class="list_info">
						<span class="song_title">${list.songName }</span>
						<br>
						<br>
						${list.artistName }
						<br>
						${list.album }
					</div>
					<span class="deleteSong">
						<form class="deleteSong">
							<img class="sDelete_icon" src="https://popcat.click/twitter-card.jpg" width="25">
							<img class="sDelete_icon2 hidden" src="https://play-lh.googleusercontent.com/ID5wHCs0FsgS018pX0e0My5z3u4cBG7dAYAr2owB9gwylWaNZTJ0pWAKl9It7ys5iEM" width="25">
							<input type="hidden" name="javafood" value="3_4">
							<input type="hidden" name="listNumber" value="${list.listNumber }">
							<input type="hidden" name="PL_ID" value="${list.pl_id }">
						</form>
					</span>
				</div>
				<form name="PLC_delete_list">
					<input type="hidden" name="doDeleteList" value="doDelete">
					<input type="hidden" name="res.PL_ID" value="${list.pl_id }">
				</form>
			</c:forEach>
			</div>
		</c:when>
	</c:choose>

<style>
	body
    {
        display:flex;
        margin:0;
        background-color: black;
        color:white;
    }
    
    div.album_info
    {
        /* border:1px solid black; */
        display:inline-block;
        width:20%;
        height: 100%;
        margin-top:7%;
        vertical-align: top;
        text-align: center;
        font-size: 14px;
        color:thistle;
    }
    div.album_explain
    {
        margin:5%;
    }
    div.list_parent
    {
        /* border:1px solid red; */
        
        margin-top:70px;
        border-left:1px dotted gray;
        /* display:inline-block; */
        width:78%;
        height: 100%;
    }
    div.list_child
    {
        /* border:1px solid blue; */
        border-bottom: 1px solid gray;
        margin:1%;
        /* display:inline-block; */
    }
    img.list_thumnail
    {
        height: 85%;
        width: 85%;
        box-shadow: 2px 2px 2px 2px gray;
    }
    img.album
    {
        width:100px;
        height:100px;
    }
    div.list_number
    {
        /* border:1px solid green; */
        display:inline-block;
        vertical-align: top;
    }
    div.list_info
    {
        /* border:1px solid rebeccapurple; */
        display:inline-block;
        vertical-align: top;
        /* line-height: 180%; */
    }
    span.song_title
    {
        /* border:1px solid red; */
        font-size:20px;
        font-weight: bold;
    }
    input.search_textbar
    {
        border:hidden;
        border-radius: 5px;
        margin:1% 0 1% 1%;
        background-color: rgb(63, 63, 63);
        color:rgb(247, 212, 147);
        
        width:80%;
        height: 30px;
    }
    input.search_btn
    {
        border:hidden;
        background-color:black;
        color:white;
        width:6%;
        height: 32px;
    }
    div.noList
    {
        color:white;
        padding:37%;
        text-align:center;
    }
    button.add_btn
    {
        background-color: black;
        color:white;
        margin:2%;
    }
    span.delete
    {
        color:white;
        margin:0.3%;
        margin-top: 60px;
        height: 5%;
    }
    
    .hidden
    {
       display: none;
    }
    span.deleteSong
    {
        float:right;
    }
</style>

<script>
    document.querySelector("img.delete_icon").addEventListener("mouseover", ()=>
    {
        document.querySelector("img.delete_icon").classList.toggle("hidden");
        document.querySelector("img.delete_icon2").classList.toggle("hidden");
    });

    document.querySelector("img.delete_icon").addEventListener("mouseout", ()=>
    {
        document.querySelector("img.delete_icon").classList.toggle("hidden");
        document.querySelector("img.delete_icon2").classList.toggle("hidden");
    });

    
    document.querySelector("span.delete").addEventListener('click', ()=>
    {
        if(confirm("정말로 해당 플레이 리스트를 삭제하겠습니까?") )
        {

        	deleteList.method='get';
        	deleteList.action='javafood';
        	deleteList.submit();
        }
    });
    for(let i = 0; i < document.querySelectorAll("img.sDelete_icon").length; i++)
    {
        document.querySelectorAll("img.sDelete_icon")[i].addEventListener("mouseover", ()=>
        {
            document.querySelectorAll("img.sDelete_icon")[i].classList.toggle("hidden");
            document.querySelectorAll("img.sDelete_icon2")[i].classList.toggle("hidden");
        });

        document.querySelectorAll("img.sDelete_icon")[i].addEventListener("mouseout", ()=>
        {
            document.querySelectorAll("img.sDelete_icon")[i].classList.toggle("hidden");
            document.querySelectorAll("img.sDelete_icon2")[i].classList.toggle("hidden");
        });
    }
    for(let i = 0; i < document.querySelectorAll("span.deleteSong").length; i++)
    {
        document.querySelectorAll("span.deleteSong form")[i].addEventListener('click', (event)=>
        {
            if(confirm("정말로 해당 곡을 리스트에서 삭제하겠습니까?") )
            {
                event.currentTarget.method='get';
                event.currentTarget.action='javafood';
                event.currentTarget.submit();
            }
        });
    }
    
    (function (){  
        document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
        document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
     }());
</script>

</body>
</html>