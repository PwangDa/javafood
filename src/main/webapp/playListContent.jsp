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
	//주소로 넘어온 값들 받기
	//String id = (String)session.getAttribute("id"); //로그인 세션이 완성될 때 사용할 것.
	
	String id = (String)request.getAttribute("id"); //아이디
	String listTitle = request.getParameter("listTitle"); //플레이 리스트 제목
	String doDeleteSong = request.getParameter("deDeleteSong");
	
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
<title><%=id %>님의 <%=listTitle %></title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<br>
	
	




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

    function fn_deleteList()
    {
        PLC_delete_list.method='get';
        PLC_delete_list.action='pl';
        PLC_delete_list.submit();
    }
    document.querySelector("span.delete").addEventListener('click', ()=>
    {
        if(confirm("정말로 해당 플레이 리스트를 삭제하겠습니까?") )
        {

            fn_deleteList();
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
                event.currentTarget.action='plc';
                event.currentTarget.submit();
            }
        });
    }
</script>

</body>
</html>