<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script>
    function fn_send(){
		frmMember.method = "post";
		document.frmMember.action = "javafood_team/song";
		document.frmMember.submit();
	}
    </script>
    <style>
        body{
            margin:auto;
            background-color: black;
        }

        #button {
            position:relative;
            top:50%;
            left:50%;
            transform: translate(-50%, 50%);
        }

        .page {
           position:relative;
           top: 50%;
            left: 50%;
            transform: translate(-50%, 00%);
        }

        .title {
            text-align: center;
            color: white;
        }

        .search {
            text-align: center;

        }

        .search2 {
            width: 180px;

        }

        .table {
            border: 1px solid white;
            margin: 0 auto;
            color:white;
        }

        .text {
            display: inline;
            text-align: center;


        }
        .front{
        	position:absolute;
        	top:50%;
            left:50%;
            transform: translate(0%, 30%);
        }
        .back{
        	position:absolute;
        	top:0%;
            left:0%;
            transform: translate(100%, 100%);
        }
        .enter{
        	color:white;
        	text-align: center;
        }
    </style>

<body>
    <form action="search">
        <div>
            <h1 class="title">자바미식회 선정 인기차트</h1>
        </div>
        <div class="search">
            <input class="search2" type="text" name="search" placeholder="노래검색(제목/아티스트/번호)">
        </div>
        <br>

        <div class="text">
            <table border="1" class="table">
                <caption>인기차트</caption>
                <thead>
                    <tr>
                        <th>순위</th>
                        <th>변동</th>
                        <th>제목</th>
                        <th>아티스트</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1등</td>
                        <td>1↓</td>
                        <td>여행</td>
                        <td>볼빨간사춘기</td>
                    </tr>
                    <tr>
                        <td>2등</td>
                        <td>10↑</td>
                        <td>안녕</td>
                        <td>폴킴</td>
                    </tr>
                    <tr>
                        <td>3등</td>
                        <td>20↑</td>
                        <td>여행을 떠나요</td>
                        <td>이승기</td>
                    </tr>
                    <tr>
                        <td>4등</td>
                        <td>50↑</td>
                        <td>좋은날</td>
                        <td>아이유</td>
                    </tr>
                    <tr>
                        <td>5등</td>
                        <td>80↑</td>
                        <td>에잇</td>
                        <td>아이유</td>
                    </tr>
                    <tr>
                        <td>6등</td>
                        <td>20↓</td>
                        <td>막걸리 한잔</td>
                        <td>영탁</td>
                    </tr>
                    <tr>
                        <td>7등</td>
                        <td>2↑</td>
                        <td>사건의 지평선</td>
                        <td>윤하</td>
                    </tr>
                    <tr>
                        <td>8등</td>
                        <td>1↑</td>
                        <td>해요(2022)</td>
                        <td>#안녕</td>
                    </tr>
                    <tr>
                        <td>9등</td>
                        <td>15↑</td>
                        <td>Into the Unknown</td>
                        <td>Aurora</td>
                    </tr>
                </tbody>
        </table>
        </div>
        
        <br>
        <div class="back">
        	<input  type="button" name="back" value="prev">
        </div>
        <div class="front">
        	<input  type="button" name="front" value="next">
        </div>
        <div class="page">
        	<input  type="buton" name="page" value="My page"><br>
        </div>
        	
        
    <div class="enter">  
		<form method="post" action="http://localhost:8080/javafood_team/song">
        	노래번호 : <input type="text" name="songnumber" size="10px" name="노래번호"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
        	아티스트명 : <input type="text" name="artistname" size="10px" name="아티스트명"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
        	노래제목 : <input type="text" name="songname" size="10px" name="노래제목"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
        	링크 : <input type="text" name="link" size="10px" name="링크"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
        	장르 : <input type="text" name="bygenre" size="10px" name="장르"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
        	조회수 : <input type="text" name="hits" size="10px" name="조회수"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
        	좋아요 : <input type="text" name="likes" size="10px" name="좋아요"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
        	순위 : <input type="text" name="ranking" size="10px" name="순위"><input type="submit" name="search" value="검색" action="http://localhost:8080/javafood_team/song" onclick="fn_sendmember()"><br>
		</form>
	</div>
    </form>



</body>

</html>