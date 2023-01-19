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
    <% 
	    AlbumDAO dao = new AlbumDAO();
	    List<AlbumVO> list = dao.listAlbum(); 
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
                <div class="left_item"><%= music_num%></div>
                <div class="left_item left_name"><%= music_name %></div>
                <div class="right_item"><%= music_time %></div>
            </div>		
        </div>
        <% } %>
    </div>
</body>
</html>