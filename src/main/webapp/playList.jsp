<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "SecondProject.JavaFood_DAO"
    import = "java.util.ArrayList"
    import = "java.util.List"
    import = "javafood_DTO.PlayListDTO" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% 
	//DAO 불러오기
	JavaFood_DAO jfDAO = new JavaFood_DAO();
	
	//주소로 넘어 온 id값 받기.
	String id = request.getParameter("id");
	
	//주소로 넘어온 값을 받기.
	String doAddList = request.getParameter("doAddList");
	String doDeleteList = request.getParameter("doDeleteList");
	
	//플레이 리스트 추가하기
	if("doAdd".equals(doAddList) )
	{
		//주소로 넘어 온 값들을 받기
		String addList_title = request.getParameter("addList_title");
		String addList_explain = request.getParameter("addList_explain");
		
		//DAO에서 플레이 리스트를 추가하는 메서드 실행하기.
		jfDAO.addList(addList_title, addList_explain, id);
	}
	//플레이 리스트 삭제하기
	else if("doDelete".equals(doDeleteList) )
	{
		//주소로 넘어온 값들을 받기
		String res_PL_ID = request.getParameter("res.PL_ID");
		
		//DAO에서 플레이 리스트를 삭제하는 메서드 실행하기.
		jfDAO.deleteList(res_PL_ID, id);
	}
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
    <img class="addList" src="https://cdn-icons-png.flaticon.com/512/7598/7598663.png"> <span class="addList">리스트 추가</span>
    
    <div class="search hidden">
        <form name = "PL_addList">
            <input type="text" name="addList_title" class="addList_textbar" placeholder="플레이리스트 제목을 입력해주세요."> <br>
            <input type="text" name="addList_explain" class="addList_ex_textbar" placeholder="플레이리스트 설명을 입력해주세요."> <br>
            <input type="button" name="addList_btn" class="addList_btn" value="추가">
            <input type="hidden" name="doAddList" value="do"> 
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
			<c:forEach items="${playList }">
			<a href="plc?PL_ID="${PL_ID }"&ID="${ID2 }">
				<div class="playList">
					<!-- 앨범 표지가 추가되면 해당 부분의 scr를 수정할 것. -->
					<img class="album" src="https://image.bugsm.co.kr/album/images/original/203228/20322838.jpg?version=undefined">
					<div class="plText">${PL_Title }</div>
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
                PL_addList.method='post';
                PL_addList.action='pl';
                PL_addList.submit();
            }
        }
        document.querySelector("input.addList_btn").addEventListener('click', ()=>
        {
            fn_addList();
        });
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