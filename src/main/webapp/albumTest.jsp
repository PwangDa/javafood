<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
     body{
            background-color: black;
            margin: 0;
        }

        div{
            border: 1px solid white;
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
            transition: opacity 0.4s;
        }
        #home{
            position: relative;
            top : 53px;
            padding: 30px;
        }

        img{
            width: 350px;
        }
</style>
</head>
<body>
    <div>
        <header id ="menu">
            <span style="font-size: 34px; font-weight: 600;">Music</span>
        </header>
    </div>
    <div id = "home">
        <div class="cont1">
            <div>
                <img class="img1" src="https://w.namu.la/s/db95e8529db90e3ad7c75b6d7ea8506b7a4a6f0d547810cc6ab1aa8c7f063f848a56c4f93636c7fa53e81f5fe00a3374df82f3d4b38372669e466cad41c3ea9f6d8599a7e1cc92e480151edd39e8d11f9fe8f557a20aca3229ccf1ece31b874b">
            </div>
            <div>
                <h1>IU 5th Album 'LILAC'</h1>
                <p>앨범 소개 하는 내용</p>
            </div>
        </div>
        <div class="cont1 musiclist">
            <div>수록곡1</div>
            <div>수록곡2</div>
            <div>수록곡3</div>
        </div>
    </div>
</body>
</html>