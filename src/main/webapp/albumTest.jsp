<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Album Test</title>
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
            /* border-bottom:1px solid rgb(70, 70, 70); */
            z-index: 1;
            transition: opacity 0.4s;
        }
        #home{
            position: relative;
            top : 53px;
            width: 75%;
            padding: 25px;
            margin: 0 auto;
        }

        img{
            width: 300px;
        }

        .cont1{
            display: flex;
        }
        .cont1_1{
            /* display: inline-block; */
            padding: 20px;
            
        }

        p{
            color: rgb(150, 150, 150);
        }

        .btn{
            background-color: black;
            color: white;
            border: 1px solid white;
            padding: 2px;
            width: 150px;
            height: 40px;
        }
        .btn:active{
            transform: scale(1.1);
        }
        .btn:hover{
            background-color:rgb(52, 52, 52);
            cursor: pointer;
        }

        .musiclist{
            margin-top: 40px;
        }
        .cont2{
            display: flex;
            height: 40px;
            border-bottom: 1px solid rgb(98, 98, 98);
            margin : 20px;
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
            margin-left: auto;
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
            <div class="cont1_1">
                <img class="img1" src="https://w.namu.la/s/db95e8529db90e3ad7c75b6d7ea8506b7a4a6f0d547810cc6ab1aa8c7f063f848a56c4f93636c7fa53e81f5fe00a3374df82f3d4b38372669e466cad41c3ea9f6d8599a7e1cc92e480151edd39e8d11f9fe8f557a20aca3229ccf1ece31b874b">
            </div>
            <div class="cont1_1">
                <h1>IU 5th Album 'LILAC'</h1>
                <p>아이유(IU)</p>
                <p>LILAC은 대한민국의 가수 아이유의 다섯 번째 정규 음반으로, 2021년 3월 25일에 발매되었다. 발매년도 기준 한국식 나이로 29살인 아이유가 20대를 마무리하면서 지금까지 자신을 지켜봐 준 모든 사람들에게 감사 인사를 전하는 앨범이다.</p>
                <details>
                    <summary style="color: rgb(150, 150, 150);">출처</summary>
                    <p>Wikipedia(https://ko.wikipedia.org/wiki)</p>
                </details>
                <br>
                <button class="btn" type="button" style="font-size: 16px;">+ 보관함에 추가</button>
            </div>
        </div>
        <div class= "musiclist">
            <div class="cont2">
                <div class="left_item">1</div>
                <div class="left_item left_name">라일락</div>
                <div class="right_item">3:35</div>
            </div>
            <div class="cont2">
                <div class="left_item">2</div>
                <div class="left_item left_name">Flu</div>
                <div class="right_item">3:09</div>
            </div>
            <div class="cont2">
                <div class="left_item">3</div>
                <div class="left_item left_name">Coin</div>
                <div class="right_item">3:14</div>
            </div>
            <div class="cont2">
                <div class="left_item">4</div>
                <div class="left_item left_name">봄 안녕 봄</div>
                <div class="right_item">5:25</div>
            </div>
            <div class="cont2">
                <div class="left_item">5</div>
                <div class="left_item left_name">Celebrity</div>
                <div class="right_item">3:16</div>
            </div>
            <div class="cont2">
                <div class="left_item">6</div>
                <div class="left_item left_name">돌림노래(feat. DEAN)</div>
                <div class="right_item">3:10</div>
            </div>
            <div class="cont2">
                <div class="left_item">7</div>
                <div class="left_item left_name">빈 컵 (Empty Cup)</div>
                <div class="right_item">2:20</div>
            </div>
        </div>
    </div>
</body>
</html>