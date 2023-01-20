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

        
        /* input[type="checkbox"]{
            display: none;
        } */
        
        /* input[id="cb1"] + label{
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 2px solid #ffffff;
            margin: -2px 10px 0 0;
            vertical-align: middle;
            cursor: pointer;
        }
        input[id="cb1"]:checked + label{
            background-color: #a7a7a7;
        } */
        /* input[id="cb1"] {
            display: none;
        } */

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
        
            /* input[type="checkbox"]:hover {
                border-color: rgba(170, 170, 170, 0.5);
            } */
        
            input[type="checkbox"]:checked {
                background-color: #adadad;
                border-color: rgb(255, 255, 255);
                color: white;
            }
        
            /* input[type="checkbox"]:checked::before {
                border-radius: 2px;
                transform: scale(1) translate(-50%, -50%)
            } */

        .no_chart{
            margin-top: 40px;
            display: flex;
            height: 30px;
        }

        .left_num{
            width: 60px;
            height: 40px;
            text-align: center;
        }
        .left_song{
            margin-left: 30px;
            width: 400px;
            text-align: left; 
        }
        .left_artist{
            width: 100px;
            height: 40px;
            text-align: left;
           
        }
        .heart{
            width: 35px;
        }

        /* 곡리스트 */
        .musiclist{
            margin-top: 30px;
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


        <div class="no_chart">        
                <input type="checkbox" id="cb1">
                   <label for="cd1"></label><strong>담기</strong>
            <div class="left_num">NO</div>
            <div class="left_song">곡이름</div>
            <div class="left_artist">아티스트</div>
            <div><img class="heart" src="https://www.pngkit.com/png/detail/86-865424_plain-black-heart-frame-white-heart-icon-no.png"></div>
        </div>

        <div class= "musiclist">
             <div class="cont2">
                <input type="checkbox" id="cb1">
                <div class="left_item">1</div>
                <div class="left_item left_name">라일락</div>
                <div class="left_artist">아티스트명</div>
                <div class="right_item">좋아요숫자</div>
                <div class="right_item">3:35</div>
             </div>
            <div class="cont2">
                <input type="checkbox" id="cb1">
                <div class="left_item">2</div>
                <div class="left_item left_name">Flu</div>
                <div class="right_item">3:09</div>
             </div>
            <div class="cont2">
                <input type="checkbox" id="cb1">
                <div class="left_item">3</div>
                <div class="left_item left_name">Coin</div>
                <div class="right_item">3:14</div>
            </div>
            <div class="cont2">
                <input type="checkbox" id="cb1">
                <div class="left_item">4</div>
                <div class="left_item left_name">봄 안녕 봄</div>
                <div class="right_item">5:25</div>
             </div>
        </div>
    </div>
</body>
</html>