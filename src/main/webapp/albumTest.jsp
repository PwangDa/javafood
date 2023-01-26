<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "album.info.AlbumDAO"
    import = "album.info.AlbumVO"
    import = "java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Album Test</title>
<style>
    /*공통사항*/
     body{
            background-color: black;
            margin: 0;
        }

        div{
            /* border: 1px solid white; */
            color : white;
            /* vertical-align: middle; */
        }

        img{
            width: 300px;
        	border-radius: 12px;
        }

        p{
            color: rgb(150, 150, 150);
        }
        
        a{
            text-decoration: none;
            color: white;
        }

        /*메뉴상단*/
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

         /*홈, 인기차트, 보관함, 검색창 있는 div박스*/
        #menu{
            margin: 0;
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
        #home{
            position: relative;
            top : 53px;
            width: 75%;
            padding: 25px;
            margin: 0 auto;
        }

        .cont1{
            display: flex;
        }
        .cont1_1{
            /* display: inline-block; */
            padding: 20px;
            
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
        .cont2:hover {
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
        
        /*.cont2:hover + .right_item{
        	display : none;
        }*/
        
        .chek1:hover{
        	display: none;
        }
        
        .chek1:hover + .but{
        	display : block;
        }
        .but:checked {
        	display : block;
        }
        
        .but:checked + .chek1{
        	display : none;
        }
        .but{
        	display : none;
        	width: 20px;
            height: 20px;
            text-align: center;
            margin-left: 40px;
        }  
        
</style>
</head>
<body>
    <div>
        <header id ="menu" >
            <span style="font-size: 34px; font-weight: 600; cursor: pointer;">JV Music</span>
            <div class="menu-box">
                <span class="main main_1" >홈</span>
                <span class="main main_2" >인기차트</span>
                <span class="main main_3" >보관함</span>
                <div class = "main-box main_4">
                    <input class="search-txt" type="text" placeholder="검색">
                    <button class="search-btn" type="submit">검색</button>
                </div>
            </div>
            <img class="menu-img" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
        </header>
    </div>
    <% 
	    AlbumDAO dao = new AlbumDAO();
    	String num = request.getParameter("a.ALBUM_NUM");
    	System.out.println("num : "+num);
	    List<AlbumVO> list = dao.listAlbum(num); 
	    for (int i =0; i < 1; i++) {
	    	AlbumVO vo = list.get(i);
	    	
	    	String cover = vo.getAlbum_cover();
			String alname = vo.getAlbum_name();
			String into =  vo.getAlbum_into();
			String artist = vo.getArtist();
	    
    %>
    <div id = "home">
        <div class="cont1">
            <div class="cont1_1">
                <img class="img1" src="<%= cover %>">
            </div>
            <div class="cont1_1">
                <h1><%= alname %></h1>
                <p><%= artist %></p>
                <p><%= into %></p>
                <details>
                    <summary style="color: rgb(150, 150, 150);">출처</summary>
                    <p>Wikipedia(https://ko.wikipedia.org/wiki)</p>
                </details>
                <br>
                <button class="btn" type="button" style="font-size: 16px;">+ 보관함에 추가</button>
            </div>
        </div>
        <% } %>
        <% for (int i =0; i < list.size(); i++) {
        	AlbumVO vo = list.get(i);
        	
			String music_num = vo.getMusic_num();
			String music_name = vo.getMusic_name();
			String music_link = vo.getMusic_link();
			String music_time = vo.getMusic_time();
        %>
        <div class= "musiclist">
            <div class="cont2">
                <div class="left_item" style="color: rgb(187, 187, 187);"><%= music_num%></div>
                <div class="left_item left_name"><a href="<%= music_link %>"><strong><%= music_name %></strong></a></div>
                <div class="right_item">
                <span class="chek1" style="color: rgb(187, 187, 187);"><%= music_time %></span>
                <input type="checkbox" class="but">
                </div>
            </div>		
        </div>
        <% } %>
    </div>
</body>
</html>