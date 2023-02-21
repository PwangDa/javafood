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
	String id = (String)request.getAttribute("id");

	String doAddList = request.getParameter("doAddList");
	String doDeleteList = request.getParameter("doDeleteList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=id %>님의 플레이 리스트</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<br>
	<div class="title"><h1> <%=id %>님의 플레이 리스트 </h1></div>
    <br>
    <hr>
    <img class="addList" src="https://c11.kr/1asbg"> <span class="addList">리스트 추가</span>
    
    <div class="search hidden">
        <form name = "PL_addList">
        	<input type="hidden" name="javafood" value="3_2">
        	<input type="hidden" name="id" value="<%=id %>">
            <input type="text" name="addList_title" class="addList_textbar" placeholder="플레이리스트 제목을 입력해주세요."> <br>
            <input type="text" name="addList_explain" class="addList_ex_textbar" placeholder="플레이리스트 설명을 입력해주세요."> <br>
            <input type="button" name="addList_btn" class="addList_btn" value="추가">
        </form>
    </div>
    
    <br>
    
   	<c:choose>
   		<%-- 해당 유저의 플레이 리스트가 아무것도 없다면 --%>
		<c:when test="${empty playList }">
			<div class="noList">등록된 리스트가 없습니다. 리스트를 추가해 주세요.</div>
		</c:when>
		
		<%-- 해당 유저의 플레이 리스트가 하나라도 존재한다면 --%>
		<c:when test="${!empty playList }">
			<c:forEach var="list" items="${playList }">
			<a href="javafood?javafood=3_3&PL_ID=${list.pl_id }">
				<div class="playList">
					<!-- 앨범 표지가 추가되면 해당 부분의 scr를 수정할 것. -->
					<img class="album" src="https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined">
					<div class="plText">${list.listTitle }</div>
				</div>
			</a>
			</c:forEach>
		</c:when>
   	</c:choose>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	<script>
        document.querySelector("img.addList").addEventListener('click', ()=>
        {
            document.querySelector("div.search").classList.toggle("hidden");
        });
        document.querySelector("span.addList").addEventListener('click', ()=>
        {
            document.querySelector("div.search").classList.toggle("hidden");
        });

        function fn_addList()
        {
            let title = PL_addList.addList_title.value;
            let explain = PL_addList.addList_explain.value;

            if(title.length == 0 || title == "")
            {
				alert("플레이리스트 제목을 입력해주세요.")
            }
            else
            {
                PL_addList.method='get';
                PL_addList.action='javafood';
                PL_addList.submit();
            }
        }
        document.querySelector("input.addList_btn").addEventListener('click', ()=>
        {
            fn_addList();
        });
        
        (function (){  
            document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
            document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in'>");
         }());
    </script>

	<style>
        body
        {
            background-color: black;
            color:white;
        }

        div.title
        {
            text-align:center;
            margin:5% 0% 0% 0%;
            text-shadow:2px 2px 2px gray;
            color:whitesmoke;
        }
        

        img.addList
        {
            width: 30px;
            height: 30px;
            /* border-right:1px solid rgb(184, 184, 184); */
            margin-bottom: 1%;
        }


        div.playList
        {
            font-size:100%;
            text-align:center;

            display:inline-block;

            /* border:1px solid black; */
            width:19%;
            margin:0% 3% 10% 2%;
        }
        div.plText
        {
            display:block;
            margin-top:3%;
            /* border-top:1px solid rgb(184, 184, 184); */
        }
        img.album
        {
            height: 100%;
            width: 100%;
            box-shadow: 5px 5px 5px 5px gray;
        }

        a
        {
            text-decoration: none; /* 링크의 밑줄 제거 */
            color: inherit; /* 링크의 색상 제거 */
        }

        input.addList_textbar
        {
            border:hidden;
            border-radius: 5px;

            margin:0 0 1% 1%;

            background-color: rgb(63, 63, 63);
            color:rgb(247, 212, 147);
            
            width:50%;
            height: 30px;
        }

        input.addList_ex_textbar
        {
            border:hidden;
            border-radius: 5px;

            margin:0 0 1% 1%;

            background-color: rgb(63, 63, 63);
            color:rgb(247, 212, 147);
            
            width:50%;
            height: 150px;
        }

        input.addList_btn
        {
            border:hidden;

            background-color:black;
            color:white;

            width:6%;
            height: 32px;
        }

        .hidden
        {
            display:none;
        }

        span.addList
        {
            vertical-align: top;
        }

        div.noList
        {
        	color:white;
        	padding:25%;
        	text-align:center;
        }
    </style>
</body>
</html>