<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<body>
	
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
 <script>
         (function (){  
            document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
            document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
         }());
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
            margin : 20px 20px 0px 20px;
            justify-content: space-between;
        }

        .left_num{
            width: 100px;
            height: 40px;
            text-align: center;
        }
        .left_song{
            margin-left: 70px;
            width: 300px;
            text-align: left; 
        }
        .left_artist{
            width: 150px;
            height: 40px;
            text-align: left;
            text-overflow : ellipsis;
            white-space : nowrap;
            overflow : hidden;
           
        }
        .left_album{
            width: 100px;
            height: 40px;
            text-align: left;
            text-overflow : ellipsis;
            white-space : nowrap;
            overflow : hidden;
            padding-left: 40px;
           
        }
        .heart{
            width: 35px;
            padding-right: 35px;
            padding-left: 40px;
        }

        /* 곡리스트 */
        .musiclist{
           /*  margin-top: 20px; */
/*             display : inline-block; */
        }
        .cont2{
            display: flex;
            height: 85px;
            border-bottom: 1px solid rgb(98, 98, 98);
            margin : 0px 20px 0px 20px;
            justify-content: space-between;
            align-items : center;
        }
        .cont2:hover{
            cursor: pointer;
        }
        
        .left_item{
            width: 100px;
            height: 40px;
            text-align: center;
        }
        
        .left_img{
            width: 60px;
            height: 60px;
            text-align: center;
            line-height: 40px;
        }
        
        .left_name{
         	width: 300px;
            text-align: left;
        }
        .right_item{
            width: 100px;
            height: 40px;
            text-align: center;
         	/* margin-left: 140px */;
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
	
		/* .right_top_item_1{
            width: 45px;
            height: 40px;
            text-align: center;
            margin-left: 0;
            margin-bottom:20px;
            text-overflow : ellipsis;
        } */
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
        .left_song_bot{
            margin-left: 10px;
            width: 300px;
            text-align: left; 
            line-height: 40px;
            text-overflow : ellipsis;
            white-space : nowrap;
            overflow : hidden;
        }
         .right_item_bot{
            width: 100px;
            height: 40px;
            text-align: center;
            line-height: 40px;
        }
        .left_item_bot{
            width: 100px;
            height: 40px;
            text-align: center;
            line-height: 40px;
        }
        .left_artist_bot{
            width: 150px;
            height: 40px;
            text-align: left;
            text-overflow : ellipsis;
            white-space : nowrap;
            overflow : hidden;
            line-height: 40px;
           
        }
        .left_album_bot{
            width: 100px;
            height: 40px;
            text-align: left;
            text-overflow : ellipsis;
            white-space : nowrap;
            overflow : hidden;
            padding-left: 40px;
            line-height: 40px;
           
        }
</style>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
    <!-- <header id ="menu">
        <span style="font-size: 34px; font-weight: 600;">Music</span>
    </header> -->
    <div id="home">
        <h1><a href='http://localhost:8080/javafood_team/javafood?javafood=7'>최신음악</a></h1>
        
        
        <div class="no_chart">        
                <input type="checkbox" id="cb1" name="selectall" onclick="selectAll(this)" value="selectall">
                   <!-- <label for="cd1"></label> -->
            <div class="left_num">NO</div>
            <div class="left_song">곡이름</div>
            <div class="left_artist">아티스트</div>
            <div class="left_album">앨범</div>
            <div class="right_item">재생시간</div>
            <div><img class="heart" src="https://han.gl/CJMPm"></div>
            <form method="post" action="/javafood_team/javafood?javafood=3">
            <div> <input type="hidden" class="btn"><a href="${ popular_music.link}"target='_blank'><img class="img" src="https://c11.kr/1asd1"></a></div><!-- 노래재생 유튜브 -->
            </form>
            <form method="post" action="/javafood_team/javafood?javafood=3">
            <div> <input type="hidden" class="put"><img class="img" src="https://c11.kr/1asd6"></div><!-- 담기 버튼 -->
            </form>
        </div>
		
		<c:forEach var="popular_music" items="${music}" varStatus="status">
        <div class= "musiclist">
             <div class="cont2">
             	<input type="checkbox" id="cb1" name="chk" onclick="checkSelectAll()">
                <div class="left_item_bot">${ status.count} </div>  <!-- 곡 순서 -->
                <div><img class="left_img" src="${ popular_music.imglink}" ></div>  <!-- 앨범 이미지 -->
                <div class="left_song_bot"><a href="${ popular_music.link}"target='_blank'>${ popular_music.songname}</a></div> <!-- 곡 제목 -->
                <div class="left_artist_bot" title="${ popular_music.artistname}">${ popular_music.artistname}</div> <!-- 가수명 -->
                <div class="left_album_bot" title="${ popular_music.album}"><a href = "/javafood_team/javafood?javafood=AlbumList&num=${popular_music.songnumber}">${ popular_music.album}</a></div> <!-- 앨범 --> 
                <div class="right_item_bot">${ popular_music.playtime}</div> <!-- 재생시간 -->
                <form method="post" action="/javafood_team/javafood?javafood=7">
                <div class="right_item_bot" id="like">${ popular_music.likes}<input type="submit" value="" class="sub"><input type="hidden" name="good1" value="${popular_music.songnumber}"><!-- 좋아요 -->
                <input type="hidden" name="number" value="${ popular_music.songnumber}"> <!-- 곡 번호 -->
                </div>
                </form>
                <form method="post" action="/javafood_team/javafood?javafood=3">
                <div> <input type="hidden" class="btn"><a href="${ popular_music.link}"target='_blank'><img class="img" src="https://c11.kr/1asd1"></a></div><!-- 노래재생 유튜브 -->
                </form>
                <form method="post" action="/javafood_team/javafood?javafood=3">
                <div> <input type="hidden" class="put" name="songName" value="${ popular_music.songname }"><img class="img" src="https://c11.kr/1asd6"></div><!-- 담기 버튼 -->
             	</form>
             </div>
		</c:forEach>
            
        </div>
    </div>
</body>

</html>