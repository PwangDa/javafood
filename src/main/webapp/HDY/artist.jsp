<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "comment.CommentDAO"
    import = "comment.CommentVO"
    import = "comment.CommentServlet"
    import = "album.info.AlbumDAO"
    import = "album.info.AlbumVO"
    import = "java.sql.Date"
    import = "java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist.jsp Test전용</title>
<% 		CommentDAO dao = new CommentDAO();

		String command = request.getParameter("command"); 
		
		if("addcomment".equals(command)) {
			String id_1 = request.getParameter("id");
			String cont_1 = request.getParameter("cont");
			
			CommentVO vo = new CommentVO();
			vo.setComment_id(id_1);
			vo.setComment_cont(cont_1);
			
			dao.addcomment(vo);
		}else if("delcommnet".equals(command)) {
			
			String id_2 = request.getParameter("id");
			System.out.println("delete 확인"+id_2);
			dao.delcomment(id_2);
		}
		
		List<CommentVO> list = dao.listComment();%>
 <script>
 		/*댓글 입력창 if문*/
        function fn_sendComment(){
        	
        	var frmCommand = document.frmComment;
        	var id = frmCommand.id.value;
        	var cont = frmCommand.cont.value;
        	
        	if(id.length == 0 || id == ""){
        		alert("아이디를 입력해주세요")
        	}else if(cont.length == 0 || cont == ""){
        		alert("내용을 입력해주세요")
        	}else{
            frmComment.method = "post";
            frmComment.action = "artist.jsp";
            frmComment.submit();
        	}
        }
        
        var prevScrollpos = window.pageYOffset;
        window.onscroll = headerbarToggle
        window.onload = headerbarToggle
        function headerbarToggle(){
            console.log(1234);
        /*메뉴상단 스크롤 함수*/
            var headerbar = document.getElementById("menu");
            var currentScrollPos = window.pageYOffset;
            if(prevScrollpos < currentScrollPos){
                headerbar.style.opacity = 1;
            }else{
                headerbar.style.opacity = 0.6;
            }
            
            /*앨범 < > 함수*/
            let prev = document.querySelector(".prev");
            let next = document.querySelector(".next");
            let slides = document.querySelector(".clides");
            let slds = document.querySelector("#slds");
            let slidelmg = document.querySelectorAll(".clides li");
            let current = 0;
            let slideCount = slidelmg.length;

    	       next.addEventListener('click', function() {
    	           console.log(slideCount); /*5*/
    	           if(current !== slideCount){
    	           		console.log('안녕 친구들');
    	        	    current = slideCount;
    	        	    console.log(current);
    	           		slds.classList.add("marLeft");
    	           }
    	       });
    	        
    	       prev.addEventListener('click', function() {
    	    	   if(current !== 0){
    	           	console.log('hello');
    	           	console.log(slideCount);
    	           	slds.classList.remove("marLeft");
    	           	current = 0;
    	    	   }
    	       });
    	       
        }

  </script>
  <style>
  
  		/*공통으로 적용 될거*/
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
        	border-radius: 12px;
        }
        
        a{
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
        
        #cont{
            background-image:
            linear-gradient(
                to bottom,
                rgba(0, 0, 0, 0) 10%,
                rgba(0, 0, 0, 0.25) 25%,
                rgba(0, 0, 0, 0.5) 50%,
                rgba(0, 0, 0, 0.75) 75%,
                rgb(0, 0, 0) 100%
            ),
            url("https://i.pinimg.com/1200x/08/81/34/088134b9c3c6d6a1fa2c037bae1d5b49.jpg") ;
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            height: 550px;     
            position: relative;
        }
        
        .text1{
            color : white;
            padding: 0px 10px;
            position : absolute;
            bottom : 0;
        }
        
        /* 노래목록 style */
        #cont1{
            display : flex;
            justify-content: center;
            height: 80px;
        }
        .box1{
            width: 170px;
            height: 60px;
            margin: 0 15px;
            text-align: left;     

        }
        
        hr{
            width: 62%;
            border: 0;
            border-top: 1px solid rgb(98, 98, 98);
        }
        .img1{
            width: 60px;
        }
		
		/* 댓글 style*/
        .comment{
            display: flex;
            justify-content: center;
        }
        .text2{
            padding-top: 20px;
        }
        
		/*textarea input 스타일*/
        textarea{
            width: 500px;
            height: 110px;
            padding: 10px;
            margin: 11px;
            box-sizing: border-box;
            border-radius: 15px;
            color: white;
            border: none;
            resize: none;
            background-color: rgb(70, 70, 70);
        }

        .input1{
            background-color: rgb(70, 70, 70);
            color: white;
            border-radius: 15px;
            border: none;
            height: 19px;
        }
        
        .image1{
            width: 90px;
            display: block;
            border-radius: 70%;
            margin : 5px 0px 5px 40px;
            
        }
        .btn{
            color:white;
            background-color:rgb(70, 70, 70);
            padding: 15px 30px;
            height: 110px;
            margin: 10px;
            border-radius: 15px;
            border: none;
        }

        .btn:active{
            transform: scale(1.1);
        }
        .btn:hover{
            background-color:rgba(173, 173, 173, 0.545);
        }

        /* 답글용  아이디text*/
        .input2{
            background-color: transparent;
            color: white;
            /* border-radius: 15px; */
            border: none;
            border-bottom: 2px solid rgb(70, 70, 70);
            height: 19px;
            width: 90px;
            margin: 10px 3px;
        }
         /* 답글용  내용text*/
        .input3{
            background-color: transparent;
            color: white;
            /* border-radius: 15px; */
            border: none;
            border-bottom: 2px solid rgb(70, 70, 70);
            height: 19px;
            width: 250px;
            margin: 10px 3px;
        }
        /* 답글용  이미지*/
        .image3{
            margin: 10px 3px;
        	width: 35px;
        	height: 35px;
        	border-radius: 70%;
        }

        /* 답글용  버튼*/
        .btn1{
            color:white;
            background-color:rgb(70, 70, 70);
            /* padding: 15px 30px; */
            width: 50px;
            height: 30px;
            margin: 10px;
            border-radius: 15px;
            border: none;
        }

        .btn1:active{
            transform: scale(1.1);
        }
        .btn1:hover{
            background-color:rgba(173, 173, 173, 0.545);
        }

        .comment_1{
            
            height: 40px;
            /* vertical-align: top; */
        }

        .comment_1_1{
            display: inline-block;
          
            height: 20px;
            vertical-align: top;
        }
        .comment_1_2{
            height: 24px;
            vertical-align: top;

        }
        
        .comment_1_3{
           
            width: 530px;
        }


        .command{
            text-align: center;
        }
        
        .cont2{
            /* border: 1px solid rgb(70, 70, 70); */
            width: 500px;
            margin: 11px;
            padding: 10px;
            box-sizing: border-box;
            border-radius: 15px;
            text-align: left;
        }

        .id2{
            /* border: 1px solid rgb(70, 70, 70); */
            color :rgb(113, 113, 113);
            border-radius: 15px;
            width: 130px;
            font-size: 15px;
        }

        .image2{
            width: 75px;
            border-radius: 70%;          
        }
        
        /*댓글 입력한 날짜출력 스타일*/
        .date1{
           
            border-radius: 15px;
            margin: 11px;
            padding: 1px;
            text-align: right;
            color :rgb(113, 113, 113);
            font-size: 13px;
        }
        
        #detail{
        	text-align: left;
        	font-size: 14px;
            cursor: pointer;
        }
        
        /* 앨범  < > 용 스타일*/
        #cont3{
            margin-top : 20px;
            text-align: center;
        }
        #cont3_1{
            /*border: 1px solid white;*/
            width: 900px;
            height: 250px;
            position: relative;
            margin: 15px auto;
            overflow: hidden;
        }
        
        /*슬라이드 애니메이션*/
        #slds{
        	transition: margin 0.8s;
        }
        
        li{
            list-style-type: none;
        }

        .clides li:not(:last-child){
            float: left;
            margin-right: 25px;
        }

        .clides{
            position: absolute;
            left: 0;
            top: 0;
            width: 2500px; /* 슬라이드할 사진과 마진 총 넓이 */
         }

         .clides li{
            float: left;
            margin-right: 25px;
            }
            
        /* < > 화살표 */    
        .point{
            border: 1px solid rgb(98, 98, 98);
            background-color: transparent;
            border-radius: 70%;
            width : 30px;
            height: 31px;
            margin : 10px;
            padding: 0px 3px;
            padding-bottom: 3px;
            font-size: 20px;
            display: inline-block;
            font-weight: 200;
        }

        .point:hover{
            background-color: rgba(128, 128, 128, 0.652);
            cursor: pointer;
        }

        .image{
            width: 190px;
        }
        
        .marLeft{
        	margin-left: -885px;
        }
    </style>
</head>
<body  onscroll="headerbarToggle()">
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
    <div id = "home">
        <div id = "cont" class = "contain">
            <div class = "text1">
                <h1>아이유(IU)</h1>
                <p>아이유는 대한민국의 가수이자 배우이다. 배우로 활동할 때는 본명을 사용한다. 
                <br>'아이유'라는 예명은 'I'와 'You'를 합친 합성어로 '너와 내가 음악으로 하나가 된다.'라는 의미이다.</p>
                <div> <a target="_blank" href="https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0">출처:namuwiki</a></div>
            </div>
        </div>
        <div id ="cont1_1">
            <h2 style="text-align: center; margin: 13px;">음악</h2>
            <% 	    
            AlbumDAO albumDAO = new AlbumDAO();
        	String num = request.getParameter("a.ALBUM_NUM");
        	System.out.println("num : "+num);
    	    List<AlbumVO> Albumlist = albumDAO.listAlbum(); 
            for(int j=0; j<Albumlist.size(); j++) {
            	AlbumVO vo = Albumlist.get(j);
    	    	
            	String alNum = vo.getAlbum_num();
    	    	String cover = vo.getAlbum_cover();
    			String alname = vo.getAlbum_name();
    			String artist = vo.getArtist();
            	
    			String music_name = vo.getMusic_name();
    			String music_link = vo.getMusic_link();
            	%>
            
            <div id = "cont1">
                <div class = "box1">
                    <img class="img1" src="<%= cover%>">
                </div>
                <div class = "box1 text2"><a href="<%= music_link %>"><strong><%= music_name %></strong></a></div>
                <div class = "box1 text2" style = "color:rgb(192, 192, 192);"><%= artist %></div>
                <div class = "box1 text2"><a style = "color:rgb(192, 192, 192);" href="/javafood_team/Album.jsp?a.ALBUM_NUM=<%= alNum %>"><%= alname %></a></div>
            </div>
            <hr>
            <%} %>
        </div>
        <div id = "cont3">
                <p class="point prev">&lang;</p>
            <h2 style="text-align: center; margin: 0px; display: inline;">앨범</h2>
                <p class="point next">&rang;</p>
            <div id="cont3_1">
                <ul id = "slds" class="clides">
                <% for(int h=0; h<Albumlist.size(); h++){ 
                	AlbumVO vo = Albumlist.get(h);
                	
                	String alNum = vo.getAlbum_num();
        	    	String cover = vo.getAlbum_cover();
        			String alname = vo.getAlbum_name();

                %>
                    <li>
                        <a href="/javafood_team/Album.jsp?a.ALBUM_NUM=<%= alNum %>"><img  class="image" src="<%= cover%>"></a>
                        <br>
                        <a style = "font-size:14px;" href="/javafood_team/Album.jsp?a.ALBUM_NUM=<%= alNum %>"><span><strong><%= alname %></strong></span></a>
                    </li>
                    <%} %>
                </ul>
            </div>
        </div>
        <div>
        	<br>
            <h2 style="text-align: center; margin: 0px;">댓글</h2>
            <form name="frmComment">
                <div class="comment">
                    <div class="text2">
                        <img class="image1" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
                        <input class="input1" type="text" name="id" placeholder=" ID를 입력해주세요">
                    </div>
                    <div class="text2">
                        <textarea name="cont" placeholder="*게시물의 저작권 등 분쟁, 개인정보 노출로 인한 책임은 작성자 또는 게시자에게 있음을 유의해 주세요."></textarea>
                    </div>
                    <div class="text2">
                        <button class="btn" type="button" onclick="fn_sendComment()"> 등록 </button>
                    </div>
                    <input type ="hidden" name="command" value="addcomment">
                </div>
            </form>
            </div>
            <div class="command">
            <hr>
                <% for(int i= 0; i<list.size(); i++) {
	    	    	  CommentVO vo = list.get(i);
	    	    	  
	    	    	  String id = vo.getComment_id();
	    	    	  String cont = vo.getComment_cont();
	    	    	  Date date = vo.getComment_Date(); %>
                <div class="comment">
                        <div class="text2 cont2_1">
                            <img class="image2" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
                            <div class="id2"><%= id %></div>
                        </div>
                        <div class="text2">
                            <div class="cont2"><%= cont %></div>
                            <div class="date1"><%= date %></div>
                        <details id="detail">
                   		 	<summary style="color: rgb(150, 150, 150);">답글달기</summary>
                    		<div class="comment">
			                        <img class="image3" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
			                        <input class="input2" type="text" name="id" placeholder=" ID">
			                        <input class="input3" type="text" name="cont" placeholder="답글 추가...">
			                        <button class="btn1" type="button" onclick="fn_sendComment()"> 답글 </button>
			                    	<input type ="hidden" name="command" value="addcomment">
                			</div>
                			<div class="comment_1">
			                        <img class="image3" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
			                        <p class="comment_1_1">아이디</p>
			                        <p class="comment_1_1" style="color: rgb(113, 113, 113);">등록날짜</p>
			                        <button class="btn1 comment_1_2" type="button" onclick="fn_sendComment()"> 삭제</button>
			  
                			</div>
                			<div class="comment_1_3">
                                <span class="comment_1_4" style="margin-right :40px;"></span>
                                아이유는 대한민국의 가수이자 배우이다. 배우 활동 할 땐 본명을 쓴다.</div>
                		</details>
                        </div>
                        <div class="text2">
                            <a href="/javafood_team/artist.jsp?command=delcommnet&id=<%= id%>"><button class='btn' type='button'> 삭제 </button></a>
                        </div>
                       
                </div> <% } %>
                
                
            </div>
        </div>


</body>
</html>