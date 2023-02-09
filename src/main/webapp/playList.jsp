<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<% 
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset = utf-8;");
	
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
		PlayListDAO pl_dao = new PlayListDAO();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=id %>님의 플레이 리스트</title>
</head>
<body>
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
    
    <c:forEach 
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

        
    </style>
</body>
</html>