<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
	<c:if test="${link!=null }">	<script>location.href='${link }'</script>	</c:if> 
	<c:if test="${login==null }">
		<script>
			alert('로그인을 하셔야합니다.')
            location.href='javafood?javafood=4';
		</script>
	</c:if>
<meta charset="UTF-8">
<title>My Page</title>
 <style>      
         body{background-color :black; cursor: url("https://zrr.kr/Wlm3"), auto;}
 		 div{text-align: center;     width: 100%; height: 100%; display: inline-block;    }
        .head{width: 100%; position: sticky;top:0px; height: 100px; background-color: black; color: white;}
        .body{height: 100%; text-align: center;margin: 30px;}
        .left{width: 88%;float: left; font-size: 60px;}
        .right{line-height: 80px; width: 11%;float: right; background-image:url(${session_user.myimg}); background-repeat: no-repeat; background-size: cover;background-position: center; }
        .tbody{ position: sticky;top: 100px; height: 40px; background: white;}
        input{vertical-align: middle;}
        .butt{font-size: 0px; background: url(https://zrr.kr/Ovva)no-repeat; border: none;width: 32px;height: 32px;cursor: pointer;}
        .text{ height: 30px;width: 350px; margin: 0;}
        table{margin: auto; border: 1px solid black; border-collapse: collapse;}
        th,td{border-top: 1px solid black;}
        th{background-color: cornflowerblue;}
        .low{background-color: darkkhaki;}
        tr.low:hover {background-color: rgb(148, 100, 237); border: 1px solid black;}
        .at{color: white; text-decoration: none;}
   </style>
   <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<div style="width: 100%;height: 100%;">
        <div class="head">
            <div class="left"><a href="javafood?javafood=5" class="at"><strong><c:out value="My pages"/></strong></a></div>
            <div class="right"><strong0> <c:out value="${session_user.nic }"/></strong></div>
        </div>
        <div class="tbody">
       	<form method="get" action="javafood">
           <input type="hidden" name="javafood" value="5">
            <td>
                <select name="option" style="height: 30px;">
                    <option  value="sing"><c:out value="노래검색"/></option>
                    <option  value="man"><c:out value="가수검색"/></option>
                </select>
            </td>
            <td><input type="text" class="text" name="text"></td>
            <td><input type="submit" class="butt"></td>
        </form>
        <div style="color: white;"><a href="?p=1" class="at"><c:out value="${session_user.id } 의 재생기록 확인"/></a> </div>
        </div>
        <div class="body">
            <h2><c:out value="최근재생목록"/></h2>
            <table border="1">
                <tr>
                    <th><c:out value="순위"/></th>
                    <th><c:out value="아티스트 이름"/></th>
                    <th><c:out value="노래 제목"/></th>
                    <th><c:out value="조회수"/></th>
                    <th><c:out value="유튜브 검색"/></th>
                    <th><c:out value="좋아요"/></th>
                </tr>
				<c:if test="${song!=null }">
					<c:forEach items="${song }" var="i">
					<tr class="low">
						<td><c:out value="${i.songnumber}"/></td>
						<td><c:out value="${i.artistname}"/></td>
						<td><c:out value="${i.songname}"/></td>
						<td><c:out value="${i.hits}"/></td>
						<td><a href="${i.link }" target="_blank"><c:out value="검색"/></a></td>
						<td><c:out value="${i.likes}"/></td>
					</tr>
					</c:forEach>
				</c:if>
				<c:if test="${song==null }">
					<c:forEach items="${list }" var="i">
					<tr class="low">
						<td><c:out value="${i.songnumber}"/></td>
						<td><c:out value="${i.artistname}"/></td>
						<td><c:out value="${i.songname}"/></td>
						<td><c:out value="${i.hits}"/></td>
						<td><a class="athe" href="javafood?javafood=5&like=${i.songnumber }&link=${i.link }" target="_blank"><c:out value="검색"/></a></td>
						<td><c:out value="${i.likes}"/></td>
					</tr>
					</c:forEach>
				</c:if>

                <%--
                if(request.getParameter("p")!=null){
                				List<login_DTO> vvo = db.uresong(a.get(0).getId());
                		                	for(int i=0; i<vvo.size(); i++) {
                %>
		                <tr class="low">
		                    <td><%=i+1%></td>
		                    <td><%=vvo.get(i).getArtistname()%></td>
		                    <td><a href="<%=vvo.get(i).getLink()%>" target="_blank" class="at"><%=vvo.get(i).getSongname()%></a></td>
		                    <td><%=vvo.get(i).getHits()%></td>
		                    <td>
		                    	<button type="button" onclick="javafood?javafood=5&id=<%=i%>'">재생</button>
		                    </td>
		                    <form>
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=vvo.get(i).getSongnumber()%>"> </td>
		                	</form>
		                </tr> <%
 } 
                 }else{
                 	if(request.getParameter("option")!=null){
 				List<login_DTO> vo1 = db.Search(request.getParameter("option"),request.getParameter("text"));
 		                	for(int i=0; i<vo1.size(); i++) {
 %>
		                <tr class="low">
		                    <td><%=i+1%></td>
		                    <td><%=vo1.get(i).getArtistname()%></td>
		                    <td><a href="<%=vo1.get(i).getLink()%>" target="_blank" class="at"><%=vo1.get(i).getSongname()%></a></td>
		                    <td><%=vo1.get(i).getHits()%></td>
		                    <td>
		                    	<button type="button" onclick="javafood?javafood=5&id=<%=i%>'">재생</button>
		                    </td>
		                    <form>
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=vo1.get(i).getSongnumber()%>"> </td>
		                	</form>
		                </tr> <%
 } 
                 	}else if(request.getParameter("option")==null){
                 		List<login_DTO> vo = db.list();
 		                for(int i=0; i<vo.size(); i++) {
 %>
		                <tr class="low">
		                    <td><%= i+1%></td>
		                    <td><%= vo.get(i).getArtistname() %></td>
		                    <td><a href="<%= vo.get(i).getLink() %>" target="_blank" class="at"><%= vo.get(i).getSongname() %></a></td>
		                    <td><%=	vo.get(i).getHits() %></td>
		                    <td>
		                    	<button type="button" onclick="javafood_team/javafood?javafood=5&id=<%=i%>'">재생</button>
		                    </td>
		                    <form>
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=i+1%>"> </td>
		                	</form>
		                </tr> <% }
		                } %>
    				<%if(request.getParameter("id")!=null){%><iframe width="560" height="315" src="https://www.youtube.com/embed/<%=db.link1(db.list().get(Integer.parseInt(request.getParameter("id"))))%>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen><%} %>
            </table>
        </div>
    </div>
    <script>
			
    </script>
    --%>
</body>
</html>
<%--}}--%>