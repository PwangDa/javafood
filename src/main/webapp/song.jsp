<%-- <%@page import="java.util.*"%> --%>
<%-- <%@page import="java.sql.Date"%> --%>
<%-- <%@ page import="java.sql.ResultSet"%> --%>
<%-- <%@ page import="java.sql.Statement"%> --%>
<%-- <%@ page import="java.sql.Connection"%> --%>
<%-- <%@ page import="javafood_DTO.login_DTO"%> --%>
<%-- <%@ page import="java.sql.DriverManager"%> --%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="My_Page.*" import="javafood_DTO.*"
	import="SecondProject.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
	<%
	JavaFood_DAO dao;
	dao = new JavaFood_DAO();
	%>

	<%
	List<javafood_DTO.song_DTO> list = dao.listSong();
	%>

	<meta charset="UTF-8">
	<title>JavaFood Music</title>

	<script type="text/javascript">
	
		 function refresh() {

			setTimeout('location.reload()', 300000);
			window.scrollTo({ left: 0, top: 0, behavior: "smooth"});
		}

		function nowtime() {
			let now = new Date();

			let hour = now.getHours();
			let minute = now.getMinutes();
			let second = now.getSeconds();

			if (hour < 10) {
				hour = "0" + hour;
			}
			if (minute < 10) {
				minute = "0" + minute;
			}
			if (second < 10) {
				second = "0" + second;
			}

			document.getElementById("timebox").value = hour + ":" + minute
					+ ":" + second;
		}

		window.onload = function() {
			//HTML이 다 load가 완료 됐을 때 실행됨
			nowtime();
			setInterval(function() {
			
				nowtime();
			}, 1000); //1초 단위

			refresh();
			
			 let checkbox = document.querySelectorAll(".but");
		     let cont2 = document.getElementsByClassName("table3");

		        for(let x=0; x<checkbox.length; x++){
		            checkbox[x].addEventListener('click', function(event){
		                //부모의 부모가져오기
		                // console.log("커렌트타켓"+event.currentTarget.parentNode.parentNode);
		                let checked = checkbox[x].checked;
		    
		                for(let i=0; i<cont2.length; i++){
		                    if(checked == true){
		                        console.log(checked);
		                        event.currentTarget.parentNode.style.backgroundColor = 'rgba(86, 86, 86, 0.423)';           
		                    }else if(checked == false){
		                        console.log(checked);
		                        event.currentTarget.parentNode.style.backgroundColor = 'transparent';
		                    }
		            }
		            });
		        }
		}
	</script>
	
	 <script>
         (function (){  
            document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
            document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
         }());
   </script>
	
<style>
header {
	top: 0;
}

body {
	margin: 0 auto;
	background-color: black;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	
}

.table {
	border: 1px solid black;
	
}
.table2 {
	color: white;
	border: 2px solid white;
	font-size: 20px;
}

.table3 {
	color: white;
	border: 2px solid white;
	font-size: 15px;
}

 td {
	text-align: center;
	background-color: black;
	color: white;
	border: 1px solid white;
}

.time {
	width : 100%;
	margin : 60px;
	text-align : right;
}

.list {
	margin : -51px;
	width : 100%;
}
.play {
 	border-radius: 2px;
	width : 30px;
}
.save {
	border-radius: 2px;
	width : 30px;
}
        <%--/*해당 div에 커서올리면 체크박스 나오게*/
        <% for(int i=0; i<list.size(); i++) {%>
        .cont2_<%= i+1%>:hover span{
        	display : none;
        }
  
        .cont2_<%= i+1%>:hover .but{
        	display : block;
        }
        <%}%>
        
        /*체크박스*/
        /*.but{
            display : none;
            width: 20px;
            height: 20px;
            text-align: center;
            margin-left: 40px;
        }  */
        
       </*체크박스가 체크되면 유지되게. */  
       /* > 는 자식요소 / ~는 모두다 /+형제에서 다음형제?*/
        .but:checked + span{
        	display : none;
        }
        .but:checked {
        	display : block;
        }--%>
        
        
        
		/*체크박스 디자인*/
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
                
                text-align: center;
            	margin-left: 0px;
            	
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
</style>
</head>
	<jsp:include page="/menu.jsp"></jsp:include>
<body>
<div class="time">
	<input type="text" size="10" id="timebox"> 현재시각 기준
</div>
	<div class="list">
		<table class="table">
			<tr class="table2">
				<td style="width:50px;">체크</td>
				<td style="width:50px;">번호</td>
				<td style="width:50px;">순위</td>
				<td style="width:120px;">인기점수</td>
				<td>앨범</td>
				<td style="width:350px;">제목</td>
				<td style="width:400px;">가수</td>
				<td style="width:60px;">장르</td>
				<td style="width:90px;">조회수</td>
				<td style="width:80px;">좋아요</td>
				<td style="width:120px;">재생 시간</td>
				<td style="width:120px;">재생</td>
				<td style="width:120px;">담기</td>
			</tr>
			<c:forEach var="dao" items="${ list_login}" >
				<tr class="table3 table3_${dao.songnumber }">
					<td> <input type="checkbox" class="but btn${dao.songnumber }"></td>
					<td>${dao.songnumber }</td>
					<td>${dao.ranking }</td>
					<td>${dao.famous }</td>
					<td><img src="${dao.imglink }" style="width:80px;"></td>
					<td>${dao.songname }</td>
					<td>${dao.artistname }</td>
					<td>${dao.bygenre }</td>
					<td>${dao.hits }</td>
					<td>${dao.likes }</td>
					<td>${dao.playtime }</td>
					<td><a href="${dao.link }"target='_blank'><img class="play" src="https://c11.kr/1asd1"></a></td>
					<td><img class="save" src="https://c11.kr/1asd6"></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>