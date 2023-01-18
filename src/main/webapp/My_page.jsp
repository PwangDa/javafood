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
 		div{text-align: center;     width: 100%; height: 100%; display: inline-block;    }
        .head{ height: 100px; background-color: antiquewhite; }
        .body{cursor: url("https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcIwR9P%2FbtraRjIi6El%2FofkcHd4wk3BWMKZorWGH0k%2Fimg.png"), auto; height: 500px; text-align: center;margin: 30px;}
        .left{width: 88%;float: left; font-size: 60px;}
        .right{width: 11%;float: right; background-image:url(https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2F20100623_29%2Fduchest_1277244964920QJ0WY_jpg%2Fdailysculpt_100622_cristiano_ronaldo02_duchest.jpg&type=sc960_832); background-repeat: no-repeat; background-size: contain; }
        .tbody{ height: 40px; font-size: 0;}
        .butt{ background-image: url(https://www.codingfactory.net/wp-content/uploads/button_search.png); background-repeat: no-repeat;background-size: contain;width: 40px;height: 40px;}
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
	<div>
        <div class="head">
            <div class="left"><strong>My pages</strong></div>
            <div class="right"></div>
        </div>
        <div class="tbody">
            <td><img src="https://www.codingfactory.net/wp-content/uploads/button_search.png"></td>
            <td><input type="text" class="text"></td>
            <td>
                <select style="height: 30px;">
                    <option>노래검색</option>
                    <option>옵션2</option>
                    <option>옵션3</option>
                </select>
            </td>
        </div>
        <div class="body">
            <h2>최근재생목록</h2>
            <table border="1">
                
                <tr>
                    <th> 재생 순서 </th>
                    <th> 아티스트 이름 </th>
                    <th> 노래 제목</th>
                </tr>
                <% List<vod> vo = db.list();
                for(int i=0; i<vo.size(); i++) { %>
                <tr class="low">
                    <td><%= i+1%></td>
                    <td><%= vo.get(i).getArtistname() %></td>
                    <td><a href="<%= vo.get(i).getLink() %>"  class="at"><%= vo.get(i).getSongname() %></a></td>
                </tr>
                <%
                	}
                %>
            </table>
        </div>
    </div>
</body>
</html>