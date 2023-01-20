<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="My_Page.dbon" import="My_Page.vod"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장르별</title>
	
	<%
	String song = request.getParameter("genre");
	%>
	
	<%
	dbon db = new dbon();
	%>
	<%
	List<vod> vo = null;
	%>
	
	<%
	if (song == null) {
		vo = db.list();
	} else {
		vo = db.getGenre(song);
	}
	%>
	<style>

	#top {
		width: auto;
		margin: 100px 0px 0px 120px;
	}
	
	.title {
		margin: 30px 0px 0px 0px;
		width: 1200px;
		height: 30px;
	}
	
	li {
		float: left;
		list-style: none;
		text-align: center;
		margin: 0px 30px 20px 100px;
	}
	
	img {
		width: 20px;
		height: 20px;
	}
	
	.nametable {
		margin: 10px 30px 20px 120px;
		width: 960px;
		text-align: left;
		border-collapse: collapse;
	}
	
	.td_no {
		text-align: center;
	}
	
	.td_img {
		text-align: center;
	}
	
	p {
		text-align: center;
	}
	
	th {
		border-bottom: 1px solid gray;
	}
	
	a {
		text-decoration-line: none;
		color: black;
	}
	
	.btline {
		text-decoration: underline;
	}
	</style>
	</head>
	<body>
		<h1 id="top"><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp'>장르별</a></h1>
		<%
		if ("발라드".equals(song)) {
		%>
		<div class="title">
			<ul>
				<li class='la_ballad btline'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=발라드'><strong>발라드</strong></a></li>
				<li class='la_dance'><a	href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=댄스'><strong>댄스</strong></a></li>
				<li class='la_pop'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=pop'><strong>POP</strong></a></li>
				<li class='la_rnb'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=R%26B'><strong>R&B</strong></a></li>
				<li class='la_indy'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=인디'><strong>인디</strong></a></li>
				<li class='la_trot'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=트로트'><strong>트로트</strong></a></li>
			</ul>
		</div>
		<%
		} else if ("댄스".equals(song)) {
		%>
		<div class="title">
			<ul>
				<li class='la_ballad'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=발라드'><strong>발라드</strong></a></li>
				<li class='la_dance btline'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=댄스'><strong>댄스</strong></a></li>
				<li class='la_pop'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=pop'><strong>POP</strong></a></li>
				<li class='la_rnb'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=R%26B'><strong>R&B</strong></a></li>
				<li class='la_indy'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=인디'><strong>인디</strong></a></li>
				<li class='la_trot'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=트로트'><strong>트로트</strong></a></li>
			</ul>
		</div>
		<%
		} else if ("pop".equals(song)) {
		%>
		<div class="title">
			<ul>
				<li class='la_ballad'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=발라드'><strong>발라드</strong></a></li>
				<li class='la_dance'><a href='http://127.0.0.1:8080/javafood_team/Genre?.jspgenre=댄스'><strong>댄스</strong></a></li>
				<li class='la_pop btline'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=pop'><strong>POP</strong></a></li>
				<li class='la_rnb'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=R%26B'><strong>R&B</strong></a></li>
				<li class='la_indy'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=인디'><strong>인디</strong></a></li>
				<li class='la_trot'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=트로트'><strong>트로트</strong></a></li>
			</ul>
		</div>
		<%
		} else if ("R&B".equals(song)) {
		%>
		<div class="title">
			<ul>
				<li class='la_ballad'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=발라드'><strong>발라드</strong></a></li>
				<li class='la_dance'><a	href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=댄스'><strong>댄스</strong></a></li>
				<li class='la_pop'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=pop'><strong>POP</strong></a></li>
				<li class='la_rnb btline'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=R%26B'><strong>R&B</strong></a></li>
				<li class='la_indy'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=인디'><strong>인디</strong></a></li>
			<li class='la_trot'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=트로트'><strong>트로트</strong></a></li>
			</ul>
		</div>
		<%
		} else if ("인디".equals(song)) {
		%>
		<div class="title">
			<ul>
				<li class='la_ballad'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=발라드'><strong>발라드</strong></a></li>
				<li class='la_dance'><a	href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=댄스'><strong>댄스</strong></a></li>
				<li class='la_pop'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=pop'><strong>POP</strong></a></li>
				<li class='la_rnb'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=R%26B'><strong>R&B</strong></a></li>
				<li class='la_indy btline'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=인디'><strong>인디</strong></a></li>
				<li class='la_trot'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=트로트'><strong>트로트</strong></a></li>
			</ul>
		</div>
		<%
		} else if ("트로트".equals(song)) {
		%>
		<div class="title">
			<ul>
				<li class='la_ballad'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=발라드'><strong>발라드</strong></a></li>
				<li class='la_dance'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=댄스'><strong>댄스</strong></a></li>
				<li class='la_pop'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=pop'><strong>POP</strong></a></li>
				<li class='la_rnb'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=R%26B'><strong>R&B</strong></a></li>
				<li class='la_indy'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=인디'><strong>인디</strong></a></li>
				<li class='la_trot btline'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=트로트'><strong>트로트</strong></a></li>
			</ul>
		</div>
		<%
		} else {
		%>
		<div class="title">
			<ul>
				<li class='la_ballad'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=발라드'><strong>발라드</strong></a></li>
				<li class='la_dance'><a	href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=댄스'><strong>댄스</strong></a></li>
				<li class='la_pop'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=pop'><strong>POP</strong></a></li>
				<li class='la_rnb'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=R%26B'><strong>R&B</strong></a></li>
				<li class='la_indy'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=인디'><strong>인디</strong></a></li>
				<li class='la_trot'><a href='http://127.0.0.1:8080/javafood_team/Genre.jsp?genre=트로트'><strong>트로트</strong></a></li>
			</ul>
		</div>
		<%
		}
		%>
		<br>
		<br>
		<input type="checkbox" id="chack_all" name="selectall" onclick="selectAll(this)" value="selectall" style="margin: 0px 10px 0px 130px">
		<button class="allplay" type="button"><img src="data:image/png;base64,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">듣기</button>
		<br>
		<table class="nametable">
			<tr>
				<th></th>
				<th style="width: 30px; height: 30px;">NO</th>
				<th style="width: 600px">곡 이름</th>
				<th style="width: 200px">가수명</th>
				<th class="td_img" style="width: 60px">좋아요</th>
				<th class="td_img" tyle="width: 40px">듣기</th>
				<th class="td_img" style="width: 40px">담기</th>
			</tr>
			<%
			for (int i = 0; i < vo.size(); i++) {
			%>
	
			<tr>
				<td><input type="checkbox" id="chk" name="chk" onclick="checkSelectAll()"></td>
				<td class="td_no" style="width: 30px"><strong><%= (i+1) %></strong></td>
				<td style="width: 600px"><a href="<%= vo.get(i).getLink() %>"><strong><%= vo.get(i).getSongname() %></strong></a></td>
				<td style="width: 200px"><strong><%= vo.get(i).getArtistname()%></strong></td>
				<td style="width: 60px"><p>	<%= vo.get(i).getLikes() %>	<%--"<img  src=\"https://w7.pngwing.com/pngs/471/756/png-transparent-heart-red-free-heart-graphic-love-text-photography.png\">--%></p></td>
		<%--	<td class =\"td_img\" style=\"width: 60px\"><button type=\"button\" >"+vo.get(i).getLikes()+/*"<img  src=\"https://w7.pngwing.com/pngs/471/756/png-transparent-heart-red-free-heart-graphic-love-text-photography.png\">*/"</button></td>--%>
				<td class="td_img" style="width: 60px"><a href="<%= vo.get(i).getLink() %>"><button type="button"><img src="data:image/png;base64,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"></button></a></td>
				<td class="td_img" style="width: 60px"><button type="button"><img src="https://cdn-icons-png.flaticon.com/512/7598/7598663.png"></button></td>
			</tr>
			<%
			}
			%>
		</table>
		<script>
		
		function checkSelectAll(){
			
			  const checkboxes = document.querySelectorAll('input[name="chk"]');
			  const checked = document.querySelectorAll('input[name="chk"]:checked');
			  const selectAll = document.querySelector('input[name="selectall"]');
			  
			  if(checkboxes.length === checked.length)  {
			    selectAll.checked = true;
			  }else {
			    selectAll.checked = false;
			  }

			}
		function selectAll(selectAll)  {
			console.log(selectAll.checked);
			  const checkboxes = document.getElementsByName("chk");
			  
			  checkboxes.forEach((checkbox) => {
			    checkbox.checked = selectAll.checked;
			  })
		}
		
		</script>
	</body>
	</html>
	
	
	</body>
	</html>