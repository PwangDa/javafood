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
  
  /*공통으로 적용 될거*/
body{
    /* box-sizing: border-box; */
    /* background-color: black; */
    margin: 0px;
}

div{
    /* border: 1px solid white; */
    color : white;
    /* vertical-align: middle; */
}

img{
    border-radius: 12px;
}

.a1{
    text-decoration: none;
    color: white;
}

/*메뉴 상단바*/
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

/*홈, 인기차트, 보관함, 검색창 있는 div박스*/
#menu{
    margin: 0;
    background-color: black;
}

.menu-box{
    display: inline-block;
    position:absolute;
    left: 50%;
    top: 10px;
}
.main{
    color: rgb(159, 159, 159);
    font-size: 20px; 
    font-weight: 600;
    margin: 0px 13px;
}

.main_1:hover{
    color: white;
    cursor: pointer;
}
.main_2:hover{
    color: white;
    cursor: pointer;
}
.main_3:hover{
    color: white;
    cursor: pointer;
}
.main_4:hover{
    color: white;
}

.main-box{
    display: inline-block;
    height: 32px;
    width:260px;
    border: 1px solid rgb(98, 98, 98);
    background-color: transparent;
}
.main-box:hover{
    border: 1px solid rgb(176, 176, 176);
}
.logo-img{
	width:50px;
	height:50px;
}
/*검색 입력창*/
.search-txt::placeholder{
    font-size: 18px;
    font-weight: 600;
}
.search-txt::placeholder:hover{
    color:rgb(172, 172, 172);
}

.search-txt{
    width: 190px;
    padding: 10px;
    border: 0px;
    outline:none;
    background-color: transparent;
    color: white;
    
}
/*검색 버튼*/
.search-btn{
    border : 0px;
    width: 44px;
    height: 100%;
    float:right;
    outline:none;
    background-color: rgb(45, 45, 45);
    color: rgb(159, 159, 159);
    cursor: pointer;
    font-weight: 600;
}

.search-btn:hover{
    color: rgb(206, 206, 206);
    background-color: rgb(91, 91, 91);
}

/*프로필사진*/
.menu-img{
    width: 38px;
    float: right;
    border-radius: 70%;
    margin: 6px 14px;
}
</style>
</head>
<body onscroll="headerbarToggle()">
    <header id ="menu" >
        <span style="font-size: 34px; font-weight: 600; cursor: pointer;">
        <img src="https://c11.kr/1asbb" class="logo-img"> Music
        </span>
        <div class="menu-box">
            <a href="javafood?javafood=m" class="a1"><span class="main main_1" >홈</span></a>
            <a href="javafood?javafood=6" class="a1"><span class="main main_2" >장르별</span>
            <a href="javafood?javafood=3" class="a1"><span class="main main_3" >보관함</span>
            <div class = "main-box main_4">
                <input class="search-txt" type="text" placeholder="검색">
                <button class="search-btn" type="submit">검색</button>
            </div>
        </div>
        <img class="menu-img" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
    </header>
</body>
</html>