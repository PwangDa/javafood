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
        .tbody{ position: sticky;top: 0px; height: 40px; background: white;}
        input{vertical-align: middle;}
        .butt{font-size: 0px; background: url(https://www.codingfactory.net/wp-content/uploads/button_search.png)no-repeat; border: none;width: 32px;height: 32px;cursor: pointer;}
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
	<%
		if(request.getParameter("good")!=null){
			db.like(request.getParameter("good"));
		}
	%>
	<div style="width: 100%;height: 100%;">
        <div class="head">
            <div class="left"><a href="http://localhost:8080/javafood_team/Lky/My_page.jsp" class="at"><strong>My pages</strong></a></div>
            <div class="right"></div>
        </div>
        <div class="tbody">
       	<form method="get" action="My_page.jsp">
            <td>
                <select name="option" style="height: 30px;">
                    <option  value="sing">노래검색</option>
                    <option  value="man">가수검색</option>
                </select>
            </td>
            <td><input type="text" class="text" name="text"></td>
            <td><input type="submit" class="butt"></td>
        </form>
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
                <% 
                	if(request.getParameter("option")!=null){
						List<vod> vo1 = db.Search(request.getParameter("option"),request.getParameter("text"));
		                	for(int i=0; i<vo1.size(); i++) { %>
		                <tr class="low">
		                    <td><%= i+1%></td>
		                    <td><%= vo1.get(i).getArtistname() %></td>
		                    <td><a href="<%= vo1.get(i).getLink() %>" target="_blank" class="at"><%= vo1.get(i).getSongname() %></a></td>
		                    <td>
		                    	<button type="button" onclick="location.href='http://localhost:8080/javafood_team/Lky/My_page.jsp?id=<%=i%>'">재생</button>
		                    </td>
		                    <form method="get" action="My_page.jsp">
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=vo1.get(i).getSongnumber()%>"> </td>
		                	</form>
		                </tr> <% } 
                	}else if(request.getParameter("option")==null){
                		List<vod> vo = db.list();
		                for(int i=0; i<vo.size(); i++) { %>
		                <tr class="low">
		                    <td><%= i+1%></td>
		                    <td><%= vo.get(i).getArtistname() %></td>
		                    <td><a href="<%= vo.get(i).getLink() %>" target="_blank" class="at"><%= vo.get(i).getSongname() %></a></td>
		                    <td>
		                    	<button type="button" onclick="location.href='http://localhost:8080/javafood_team/Lky/My_page.jsp?id=<%=i%>'">재생</button>
		                    </td>
		                    <form method="get" action="window.location.reload()" target="123">
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=i+1%>"> </td>
		                	</form>
		                	<iframe name="123" style="display:none"></iframe>
		                </tr> <% }
		                } %>
    				<%if(request.getParameter("id")!=null){%><iframe width="560" height="315" src="https://www.youtube.com/embed/<%=db.link1(db.list().get(Integer.parseInt(request.getParameter("id"))))%>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen><%} %>
            </table>
        </div>
    </div>
    <script type="text/javascript">
			
    </script>
</body>
</html>