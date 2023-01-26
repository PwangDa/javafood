<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="My_Page.dbon" import="My_Page.vod"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<%
		String song = request.getParameter("genre");
	%>
	
	<%
		dbon db = new dbon();
	%>
	<%
		if(request.getParameter("number")!=null){
		db.like(request.getParameter("number"));
		}
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
<meta charset="UTF-8">
<title>Insert title here</title>
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
<style>
        body{
        
            background-color: black;
            margin: 0;
        }

        div{
            /* border: 1px solid white; */
            color : white;
            /* vertical-align: middle; */
        }
        header{
            background-color: black;
            color: white;
            width: 100%;
            position:fixed;
            height: 53px;
            border-bottom:1px solid rgb(70, 70, 70);
            z-index: 1;
            /* transition: opacity 0.4s; */
        }

        #home{
            position: relative;
            top : 53px;
            width: 87%;
            padding: 25px;
            margin: 0 auto;
        }

        a{
            text-decoration: none;
            color: white;
        }
        .tab{
            display: flex;
            justify-content: space-between;
            text-align: center;
            height: 50px;
        }
        .tab1{
            background-color: rgb(42, 42, 42);
            
            border-radius: 15px;
            width: 174px;
        }
        .tab1:hover{
            cursor: pointer;
            background-color:rgba(173, 173, 173, 0.545);
        }
        .tab1:active{
            transform: scale(1.1);
        }
        .tab1_1{
            border-left: 6px solid rgb(194, 233, 255);
        }
        .tab1_2{
            border-left: 6px solid rgb(79, 82, 255);
        }
        .tab1_3{
            border-left: 6px solid rgb(235, 81, 255);
        }
        .tab1_4{
            border-left: 6px solid rgb(89, 224, 81);
        }
        .tab1_5{
            border-left: 6px solid rgb(255, 122, 60);
        }
        .tab1_6{
            border-left: 6px solid rgb(239, 255, 62);
        }

        /*담기*/

        <%--.push{
            margin-top: 40px;
            height: 60px;
        }--%>

        input[type="checkbox"]{
            -webkit-appearance: none;
            position: relative;
            width: 20px;
            height: 20px;
            cursor: pointer;
            outline: none !important;
            border: 1px solid #eeeeee;
            border-radius: 2px;
            background: #000000;
        }

        input[type="checkbox"]::before {
            content: "\2713";
            position: absolute;
            top: 50%;
            left: 50%;
            overflow: hidden;
            transform: scale(0) translate(-50%, -50%);
            line-height: 1;
        }
        input[type="checkbox"]:checked {
            background-color: #adadad;
            border-color: rgb(255, 255, 255);
            color: white;
        }
/* 
        input#cd1 + label:before{
            width: 30px;
            height: 30px;
            background-color: black;
            border: 2px solid white;
            border-radius: 3px;
        } */
        /* input[id="cd1"] + label:after{
            width: 20px;
            background-color: rgb(103, 103, 103);
            border: 2px solid white;
            border-radius: 3px;
        } */
        
        /*.no_chart{
            margin-top: 40px;
            display: flex;
            height: 30px;
            padding-left: 20px;
        }*/
        .no_chart{
            display: flex;
            height: 40px;
            border-bottom: 1px solid rgb(98, 98, 98);
            margin : 20px;
            justify-content: space-between;
        }

        .left_num{
            width: 100px;
            height: 40px;
            text-align: center;
        }
        .left_song{
            margin-left: 0px;
            width: 395px;
            text-align: left; 
        }
        .left_artist{
            width: 100px;
            height: 40px;
            text-align: left;
            text-overflow : ellipsis;
            white-space : nowrap;
            overflow : hidden;
           
        }
        .heart{
            width: 35px;
            padding-right: 35px;
            padding-left: 40px;
        }

        /* 곡리스트 */
        .musiclist{
            margin-top: 20px;
        }
        .cont2{
            display: flex;
            height: 40px;
            border-bottom: 1px solid rgb(98, 98, 98);
            margin : 20px;
            justify-content: space-between;
        }
        .cont2:hover{
            cursor: pointer;
        }
        
        .left_item{
            width: 100px;
            height: 40px;
            text-align: center;
        }
        
        .left_name{
         	width: 400px;
            text-align: left;
        }
        .right_item{
            width: 100px;
            height: 40px;
            text-align: center;
         	margin-left: 140px;
             /*margin-left: 95px;*/
        }
        /*.right_top_item{
            width: 100px;
            height: 40px;
            text-align: center;
            margin-left: auto;
        }*/
        .btline {
			text-decoration: underline;
			text-decoration-color: white;
		}
	
		.right_top_item_1{
            width: 45px;
            height: 40px;
            text-align: center;
            margin-left: 0;
            margin-bottom:20px;
            text-overflow : ellipsis;
        }
        #like{
        	margin-left: 10px;
        }
        .btn{
        	width: 40px;
        	border:none;
        	padding: 0px;
        	margin-left: 5px;
        	border-radius: 30%;
        }
        
        .img{
        	width: 30px;
        	margin-left: 0px;
        	border-radius: 30%;
        	
        }
        .sub{
        	background-image: url('https://han.gl/CJMPm');
   			background-position:  0px 0px;
    		background-repeat: no-repeat;
 			cursor:pointer;
 			outline: 0;
 			width: 20px;
 			height: 20px;
 			background-size: contain;
        }
</style>
</head>
<body>
    <header id ="menu">
        <span style="font-size: 34px; font-weight: 600;">Music</span>
    </header>
    <div id="home">
        <h1><a href='http://127.0.0.1:8080/javafood_team/Genre/NewGenre.jsp'>장르</a></h1>
        
       
        <%
		if ("발라드".equals(song)) {
		%>
        <div class="tab">
            <div class="tab1 tab1_1 btline"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=발라드'>발라드</a></div>
            <div class="tab1 tab1_2"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=댄스'>댄스</a></div>
            <div class="tab1 tab1_3"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=pop'>POP</a></div>
            <div class="tab1 tab1_4"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=R%26B'>R&B</a></div>
            <div class="tab1 tab1_5"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=인디'>인디</a></div>
            <div class="tab1 tab1_6"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=트로트'>트로트</a></div>
        </div>
        <%
		} else if ("댄스".equals(song)) {
		%>
		<div class="tab">
            <div class="tab1 tab1_1"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=발라드'>발라드</a></div>
            <div class="tab1 tab1_2 btline"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=댄스'>댄스</a></div>
            <div class="tab1 tab1_3"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=pop'>POP</a></div>
            <div class="tab1 tab1_4"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=R%26B'>R&B</a></div>
            <div class="tab1 tab1_5"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=인디'>인디</a></div>
            <div class="tab1 tab1_6"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=트로트'>트로트</a></div>
        </div>
        <%
		} else if ("pop".equals(song)) {
		%>
		<div class="tab">
            <div class="tab1 tab1_1"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=발라드'>발라드</a></div>
            <div class="tab1 tab1_2"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=댄스'>댄스</a></div>
            <div class="tab1 tab1_3 btline"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=pop'>POP</a></div>
            <div class="tab1 tab1_4"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=R%26B'>R&B</a></div>
            <div class="tab1 tab1_5"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=인디'>인디</a></div>
            <div class="tab1 tab1_6"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=트로트'>트로트</a></div>
        </div>
        <%
		} else if ("R&B".equals(song)) {
		%>
		<div class="tab">
            <div class="tab1 tab1_1"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=발라드'>발라드</a></div>
            <div class="tab1 tab1_2"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=댄스'>댄스</a></div>
            <div class="tab1 tab1_3"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=pop'>POP</a></div>
            <div class="tab1 tab1_4 btline"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=R%26B'>R&B</a></div>
            <div class="tab1 tab1_5"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=인디'>인디</a></div>
            <div class="tab1 tab1_6"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=트로트'>트로트</a></div>
        </div>
        <%
		} else if ("인디".equals(song)) {
		%>
		<div class="tab">
            <div class="tab1 tab1_1"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=발라드'>발라드</a></div>
            <div class="tab1 tab1_2"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=댄스'>댄스</a></div>
            <div class="tab1 tab1_3"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=pop'>POP</a></div>
            <div class="tab1 tab1_4"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=R%26B'>R&B</a></div>
            <div class="tab1 tab1_5 btline"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=인디'>인디</a></div>
            <div class="tab1 tab1_6"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=트로트'>트로트</a></div>
        </div>
        <%
		} else if ("트로트".equals(song)) {
		%>
		<div class="tab">
            <div class="tab1 tab1_1"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=발라드'>발라드</a></div>
            <div class="tab1 tab1_2"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=댄스'>댄스</a></div>
            <div class="tab1 tab1_3"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=pop'>POP</a></div>
            <div class="tab1 tab1_4"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=R%26B'>R&B</a></div>
            <div class="tab1 tab1_5"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=인디'>인디</a></div>
            <div class="tab1 tab1_6 btline"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=트로트'>트로트</a></div>
        </div>
        <%
		} else{
		%>
		<div class="tab">
            <div class="tab1 tab1_1"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=발라드'>발라드</a></div>
            <div class="tab1 tab1_2"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=댄스'>댄스</a></div>
            <div class="tab1 tab1_3"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=pop'>POP</a></div>
            <div class="tab1 tab1_4"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=R%26B'>R&B</a></div>
            <div class="tab1 tab1_5"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=인디'>인디</a></div>
            <div class="tab1 tab1_6"><a href='http://localhost:8080/javafood_team/Genre/NewGenre.jsp?genre=트로트'>트로트</a></div>
        </div>
        <%
		} 
		%>
        <div class="no_chart">        
                <input type="checkbox" id="cb1" name="selectall" onclick="selectAll(this)" value="selectall">
                   <label for="cd1"></label>
            <div class="left_num">NO</div>
            <div class="left_song">곡이름</div>
            <div class="left_artist">아티스트</div>
            <div class="right_item">재생시간</div>
            <div><img class="heart" src="https://han.gl/CJMPm"></div>
            <div class="right_top_item_1">듣기</div>
            <div class="right_top_item_1">담기</div>
        </div>

		
		<%
			for (int i = 0; i < vo.size(); i++) {
			%>
        <div class= "musiclist">
             <div class="cont2">
             	<input type="checkbox" id="cb1" name="chk" onclick="checkSelectAll()">
                <div class="left_item"><%=(i+1) %></div>
                <div class="left_item left_name"><a href="<%= vo.get(i).getLink() %>"target='_blank'><%=vo.get(i).getSongname() %></a></div>
                <div class="left_artist" title="<%=vo.get(i).getArtistname()%>"><%= vo.get(i).getArtistname()%></div>
                <div class="right_item"><%= vo.get(i).getPlayTime() %></div>
                <form method="post" action="/javafood_team/Genre/NewGenre.jsp">
                <div class="right_item" id="like"><%= vo.get(i).getLikes() %><input type="submit" value="" class="sub"><input type="hidden" name="good" value="<%= i+1%>">
                <input type="hidden" name="number" value="<%= vo.get(i).getSongnumber()%>">
                </div>
                </form>
                <div> <button type="button" class="btn"><a href="<%= vo.get(i).getLink() %>"target='_blank'><img class="img" src="https://url.kr/e4lkai"></a></button></div>
                <div> <button type="button" class="btn"><img class="img" src="https://han.gl/vTHCa"></button></div>
             </div>
            
        </div>
        <%
			}
			%>
    </div>
</body>
</html>