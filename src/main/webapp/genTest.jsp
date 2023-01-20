<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

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

        .push{
            margin-top: 40px;
            height: 60px;
        }

        input[type="checkbox"]{
            display: none;
        }

        input[type="checkbox"] + label{
            cursor: pointer;
            width: 50px;
            height: 50px;
            background-color: black;
            border: 2px solid white; 
            border-radius: 3px;
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

        /* 곡리스트 */
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
    <header id ="menu">
        <span style="font-size: 34px; font-weight: 600;">Music</span>
    </header>
    <div id="home">
        <h1>장르</h1>
        <div class="tab">
            <div class="tab1 tab1_1">발라드</div>
            <div class="tab1 tab1_2">댄스</div>
            <div class="tab1 tab1_3">POP</div>
            <div class="tab1 tab1_4">R&B</div>
            <div class="tab1 tab1_5">인디</div>
            <div class="tab1 tab1_6">트로트</div>
        </div>
        
        <div class="push">
             <input type="checkbox" id="cb1">
                <label for="cd1" class="chk_box"></label>
                담기
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
        </div>
    </div>
</body>
</html>