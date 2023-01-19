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
		javafood.method = "post";
		document.javafood.action = "/javafood_team/song";
		document.javafood.submit();
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
        .search {
        
        }
        .search2{
        
        }
        .search3{
        
        }
    </style>

<body>
    
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
                    <tr>
                        <th>순위</th>
                        <th>좋아요 수</th>
                        <th>제목</th>
                        <th>아티스트</th>
                    </tr>
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
        	<input  type="button" name="page" value="My page"><br>
        </div>
        	
      <form method="post" action="javafood_team/song">
        <div class="search">
            <td>
                <select name="option" style="height: 30px;">
                    <option  value="song">노래검색</option>
                    <option  value="artist">가수검색</option>
                </select>
            </td>
            <td><input type="text" class="search2" name="text"></td>
            <td><input type="submit" class="search3"></td>
        </div>
        </form>
		
 	

</body>

</html>