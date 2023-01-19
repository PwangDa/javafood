<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="My_Page.dbon" import="My_Page.vod"
	import="Chart.SongServlet"%>
<!DOCTYPE html>
<html>
<head>
<%
vod vo = new vod();
dbon db = new dbon();
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function fn_send(){
		document.update.method = "post";
		document.update.action = "javafood_team/song";
		document.update.submit();
	}
</script>
</head>
<body>
	<form name="update" action="javafood_team/song">
						<table>
					<tr>
                        <th>노래제목</th>
                        <th>아티스트 이름</th>
                    </tr>
                    <%
				if (request.getParameter("user") != null) {
					List<vod> user = db.Search(request.getParameter("user"), request.getParameter("text"));
					for (int i = 0; i < user.size(); i++) {
				%>
				<tr class="low">
					<td><%=i + 1%></td>
					<td><%=user.get(i).getSongname()%></td>
					<td><%=user.get(i).getArtistname() %></td>
					</td><%=user.get(i).getLikes()%></td>
					<td><a
						href="http://localhost:8080/javafood_team/Song.jsp?songname=<%=i%>"
						>순위</a></td>
					<td><input type="submit" value="순위확인"></td>
				</tr>
				<%
				}
				} else if (request.getParameter("user") == null) {
				List<vod> user = db.list();
				for (int i = 0; i < user.size(); i++) {
				%>
				<tr class="low">
					<td><%=i + 1%></td>
					<td><%=user.get(i).getSongname()%></td>
					<td><%=user.get(i).getArtistname() %></td>
					</td><%=user.get(i).getLikes()%></td>
					<td><a
						href="http://localhost:8080/javafood_team/Song.jsp?songname=<%=i%>"
						class="fir" style="color: red;">순위</a></td>
					<form method="post" action="Song.jsp">
						<td><input type="submit" value="순위확인"><input
							type="hidden" name="rank" value="<%=i + 1%>"></td>
					</form>
				</tr><% }
				} %>
				 </table>
			<input type="button" value="업데이트" onclick="fn_send()">
			<input type="hidden" name="히든" value="updateSong">
	</form>
</body>
</html>