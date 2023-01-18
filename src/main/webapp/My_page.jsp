<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "My_Page.dbon"
    import = "My_Page.vod"
    %>
<!DOCTYPE html>
<html>
<head>
	<%
		dbon db = new dbon();
	%>
<meta charset="UTF-8">
<title>My Page</title>
 <style>      
         body{cursor: url("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcIwR9P%2FbtraRjIi6El%2FofkcHd4wk3BWMKZorWGH0k%2Fimg.png"), auto;}
 		 div{text-align: center;     width: 100%; height: 100%; display: inline-block;    }
        .head{ height: 100px; background-color: antiquewhite; }
        .body{height: 100%; text-align: center;margin: 30px;}
        .left{width: 88%;float: left; font-size: 60px;}
        .right{width: 11%;float: right; background-image:url(https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20100623_29%2Fduchest_1277244964920QJ0WY_jpg%2Fdailysculpt_100622_cristiano_ronaldo02_duchest.jpg&type=sc960_832); background-repeat: no-repeat; background-size: cover;background-position: center; }
        .tbody{ position: sticky;top: 0px; height: 40px;}
        input{vertical-align: middle;}
        .butt{ background: url(https://www.codingfactory.net/wp-content/uploads/button_search.png)no-repeat; border: none;width: 32px;height: 32px;cursor: pointer;}
        .text{ height: 30px;width: 350px; margin: 0;}
        table{margin: auto; border: 1px solid black; border-collapse: collapse;}
        th,td{border-top: 1px solid black;}
        th{background-color: cornflowerblue;}
        .low{background-color: darkkhaki;}
        tr.low:hover {background-color: rgb(148, 100, 237); border: 1px solid black;}
        .at{color: black; text-decoration: none;}
   </style>
</head>
<body>
	<div style="width: 100%;height: 100%;">
        <div class="head">
            <div class="left"><strong>My pages</strong></div>
            <div class="right"></div>
        </div>
        <div class="tbody">
            <td>
                <select style="height: 30px;">
                    <option>노래검색</option>
                    <option>가수검색</option>
                </select>
            </td>
            <td><input type="text" class="text"></td>
            <td><input type="button" class="butt"></td>
        </div>
        <div class="body">
            <h2>최근재생목록</h2>
            <table border="1">
                <tr>
                    <th> 재생 순서 </th>
                    <th> 아티스트 이름 </th>
                    <th> 노래 제목</th>
                    <th> 재생 </th>
                    <th> 좋아요 </th>
                </tr>
<!--                 <form method="get" action="http://localhost:8080/javafood_team/My_page.jsp"> -->
                <% List<vod> vo = db.list();
                for(int i=0; i<vo.size(); i++) { %>
                <tr class="low">
                    <td><%= i+1%></td>
                    <td><%= vo.get(i).getArtistname() %></td>
                    <td><a href="<%= vo.get(i).getLink() %>"  class="at"><%= vo.get(i).getSongname() %></a></td>
                    <td><input type="submit" value="재생"></td>
                    <td><input type="submit"></td>
                </tr> <% } %>
    			<iframe width="560" height="315" src="https://www.youtube.com/embed/<%= db.link1(db.list().get(0)) %>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen>
<!-- 				<input type="hidden" name="song" value="1"> -->
				
<!-- 				</form> -->
            </table>
        </div>
    </div>
    
</body>
</html>