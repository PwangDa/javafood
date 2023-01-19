<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="My_Page.dbon" import="My_Page.vod"
	import="Chart.SongServlet"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<%
		dbon db = new dbon();
		vod vo = new vod();
	%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>인기차트</title>
    <style>
        #body1{
            width:50%;
            position:relative;
            margin:auto;
            background-color: black;
            color:white;
        }
        #top {
            text-align: center;
        }
       .table{
            border: 1px solid white;
            text-align: center;
       }


    </style>
</head>
<body id="body1">
    <h1 id="top">인기차트</h1>
    <div class="table">
           <tr>
                <th>노래 제목</th>
                <th>아티스트 명</th>
           </tr>
           <%
           	if(vo.getLikes().equals(1)){%>
           	<html>
           		<body>
           			<table>
           				<tr>노래 제목</tr>
           				<tr>아티스트 명</tr>
           			</table>
           		</body>
           	</html>
          <% }%>
           
    </div>
</body>
</html>