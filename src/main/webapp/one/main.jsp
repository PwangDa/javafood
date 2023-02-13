<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>

            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">
            <meta charset="utf-8">
    <style>

        @import url(//fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
        

       h1 {
            font-size: 60px;
            text-align: center;
            margin:10px;
            width: 400px;
            margin-left:auto;
            margin-right:auto;
            font-family: 'Jeju Myeongjo', serif;
            color: hsl(198, 79%, 58%);

       }

        td {    
            margin-top: 30px;
            margin-left: 30px;
            margin-right: 50px;
            border-radius: 40px 40px;
            font-family: 'IBM Plex Sans KR', sans-serif;
        }

        img {
            height: 300px;
            width: 300px;
        }


            #log {
                background-color: #6464d2;
                color: white;
                text-align:center;
                width: 200px;
                height: 50px;
                float: left;
                line-height: 50px;
                font-size: 40px;
                padding: 40px;
                font-family: 'IBM Plex Sans KR', sans-serif;
            }

             #my {
                background-color: hsl(160, 73%, 74%);
                color:white;
                text-align: center;
                width: 200px;
                height: 150px;
                float: left;
                font-size: 30px;
                text-align: center;
                line-height: 150px;  
                }

            #cha {
                background-color: #f29cf2;
                color: white;
                text-align: center;
                float: right;
                width: 400px;
                height: 300px;
                text-align: center;
                line-height: 230px;
                font-size: 50px;
            }

             #list {
                background-color: rgb(240, 201, 124);
                color:#fcfcfc;
                margin-top: 1px;
                text-align: center;
                float:right;
                width:100px;
                height:100px;
                text-align: center;
                line-height: 100px;
                font-size: 20px;
                }

             #ac {
                background-color: rgb(240, 201, 124);
                color: #fbfffa;
                text-align: center;
                float:right;
                width:100px;
                height:100px;
                text-align: center;
                line-height: 100px;
                font-size: 20px;
                }

             #al {
                
                background-color: rgb(240, 201, 124);
                color:rgb(255, 255, 255);
                text-align: center;
                float:right;
                width:100px;
                height:100px;
                text-align: center;
                line-height: 100px;
                font-size: 20px;
             }

             #dog {
                position: absolute;
                right: 500px;
                top: 450px;
                width: 250px;
                height: 250px;             
             }

             .lin {
                color: white;
             }

             

       

    </style>

        <meta charset="UTF-8">

            <title>javafood music</title>

    </head>

            <body bgcolor="black">
                <table>

                    <tr>
                        <h1>javafood music</h1>
                    </tr>

            <tr>
                <td id="log"><a class="lin" href="http://localhost:8080/javafood_team?javafood=4"
                    style="text-decoration:none">로그인</a>
                </td>
                
                <td id="my"><a class="lin" href="http://localhost:8080/javafood_team?javafood=5"
                    style="text-decoration:none">마이페이지</a></td>

                <td id="cha"><a class="lin" href="http://localhost:8080/javafood_team?javafood=2"
                    style="text-decoration:none">인기차트</a></td>
            </tr>

                <tr>
                 <td id="list"><a class="lin" href="http://localhost:8080/javafood_team?javafood=3"
                    style="text-decoration:none"
                   >재생목록</a>
                </td>

                 </tr>

                 <tr>
                    <td id="ac"><a class="lin" href="http://localhost:8080/javafood_team?javafood=6"
                        style="text-decoration:none">장르별목록</a>
                    </td>
                  </tr>

                    <tr>
                        <td id="al"><a class="lin" href="http://localhost:8080/javafood_team?javafood=1"
                            style="text-decoration:none">앨범</a></td>
                        </tr>

                        <img id="dog" src="giphy (1).gif">

                      
                    
    
</body>
</html>