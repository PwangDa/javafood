<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <style>

        @import url(//fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
        

       h1 {
            font-size: 50px;
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
            margin-left: 50px;
            margin-right: 50px;
            border-style: solid;
            border: 1px solid white;
            border-radius: 30px 30px;
            opacity: 0.5; 
        }

        td:hover {
            opacity: 1.0;
        }

        img {
            height: 300px;
            width: 300px;
        
        }


            #log {
                background-color: blue;
                color: white;
                text-align:center;
                width: 200px;
                height: 50px;
                float: left;
                line-height: 50px;
                font-size: 40px;
                padding: 40px
            }

             #my {
                background-color: #12eaa2;
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
                background-color: violet;
                color: white;
                text-align: center;
                float: right;
                width: 500px;
                height: 250px;
                text-align: center;
                line-height: 230px;
                font-size: 50px;
            }

             #list {
                background-color: hwb(40 17% 6%);
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
                background-color: hwb(40 17% 6%);
                color: #fbfffa;
                text-align: center;
                float:right;
                width:200px;
                height:100px;
                text-align: center;
                line-height: 100px;
                font-size: 20px;
                }

             #al {
                
                background-color: hwb(40 17% 6%);
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
                left: 50px;
                top: 400px;
                width: 400px;
                height: 400px;             
             }

             .lin {
                color: white;
             }

             

       

    </style>

        <meta charset="UTF-8">

            <title>자바 미식회</title>

    </head>

            <body bgcolor="#EFF8FB">
                <table>

                    <tr>
                        <h1>javafood music</h1>
                    </tr>

            <tr>
                <td id="log"><a class="lin" href="http://localhost:8080/javafood_team/Lky/login.jsp"
                    style="text-decoration:none">로그인</a>
                </td>
                
                <td id="my"><a class="lin" href="http://localhost:8080/javafood_team/Lky/My_page.jsp"
                    style="text-decoration:none">마이페이지</a></td>

                <td id="cha"><a class="lin" href="http://localhost:8080/javafood_team/Song.jsp"
                    style="text-decoration:none">인기차트</a></td>
            </tr>

                <tr>
                 <td id="list"><a class="lin" href="http://localhost:8080/javafood_team/PlayList"
                    style="text-decoration:none"
                   >재생목록</a>
                </td>

                 </tr>

                 <tr>
                    <td id="ac"><a class="lin" href="http://localhost:8080/javafood_team/Genre/Genre.jsp"
                        style="text-decoration:none">장르별목록</a>
                    </td>
                  </tr>

                    <tr>
                        <td id="al"><a class="lin" href="http://localhost:8080/javafood_team/artistcomment"
                            style="text-decoration:none">앨범</a></td>
                        </tr>

                        <img id="dog" src="giphy (1).gif">

                      
                    
    
</body>
</html>