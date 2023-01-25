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
            frmComment.action = "artistcomment";
            frmComment.submit();
        	}
        }
        
        var prevScrollpos = window.pageYOffset;
        window.onscroll = headerbarToggle
        window.onload = headerbarToggle
        function headerbarToggle(){
            console.log(1234);
            var headerbar = document.getElementById("menu");
            var currentScrollPos = window.pageYOffset;
            if(prevScrollpos < currentScrollPos){
                headerbar.style.opacity = 1;
            }else{
                headerbar.style.opacity = 0.5;
            }

        var prev = document.querySelector(".prev");
        var next = document.querySelector(".next");
        var slides = document.querySelector(".clides");
        var slidelmg = document.querySelectorAll(".clides li");
        var current = 0;
        var slideCount = slidelmg.length;
        const slideWidth = 900; //한개의 슬라이드 넓이
        const slideMargin = 25; //슬라이드간의 margin 값

        slides.style.width = (slideWidth + slideMargin) * slideCount + 'px';

        function moveSlide(num){
            slides.style.left = -num * 400 + "px";
            current = num;
        }

        }
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
            transition: opacity 0.4s;
        }

        a{
            text-decoration: none;
            color: white;
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

        .comment{
            display: flex;
            justify-content: center;
        }
        .text2{
            padding-top: 20px;
        }

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
        .date1{
            /* border: 1px solid rgb(70, 70, 70); */
            border-radius: 15px;
            margin: 11px;
            padding: 1px;
            text-align: right;
            color :rgb(113, 113, 113);
            font-size: 13px;
        }

        #cont3{
            border: 1px solid white;
            /* width: 500px; */
            /* display: flex; */
            text-align: center;
        }
        #cont3_1{
            border: 1px solid white;
            width: 900px;
            height: 250px;
            position: relative;
            margin: 15px auto;
            overflow: hidden;
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
            transition: left 0.5s ease-out; 
            /*ease-out: 처음에는 느렸다가 점점 빨라짐*/
         }

         .clides li{
            float: left;
            margin-right: 25px;
            }
        .point{
            border: 1px solid white;
            background-color: transparent;
            border-radius: 70%;
            padding: 2px 3px;
            /* text-align: center; */
            /* width: 200px; */
            /* height: 100px; */
            font-size: 30px;
        }

        .point:hover{
            background-color: rgba(128, 128, 128, 0.652);
        }

        .prev{
            left: 10px;
        }

        .image{
            width: 190px;
        }
    </style>
</head>
<body  onscroll="headerbarToggle()">
    <header id ="menu">
        <span style="font-size: 34px; font-weight: 600;">Music</span>
    </header>
    <%-- String num = request.getParameter("a.ALBUM_NUM"); --%>
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
    			String into =  vo.getAlbum_into();
    			String artist = vo.getArtist();
            	
    			String music_num = vo.getMusic_num();
    			String music_name = vo.getMusic_name();
    			String music_link = vo.getMusic_link();
    			String music_time = vo.getMusic_time();
            	%>
            
            <div id = "cont1">
                <div class = "box1">
                    <img class="img1" src="<%= cover%>">
                </div>
                <div class = "box1 text2"><a href="<%= music_link %>"><%= music_name %></a></div>
                <div class = "box1 text2"><%= artist %></div>
                <div class = "box1 text2"><a href="/javafood_team/Album.jsp?a.ALBUM_NUM=<%= alNum %>"><%= alname %></a></div>
            </div>
            <hr>
            <%} %>
        </div>
        <div id = "cont3">
            <h3 style="text-align: center; margin: 0px; display: inline;">앨범</h3>
                <span class="point prev">&lang;</span>
                <span class="point next">&rang;</span>
            <div id="cont3_1">
                <ul class="clides">
                    <li>
                        <img  class="image" src="https://w.namu.la/s/dd10984aec9e0100e8472908ccf9f3d5be391ae2f0e7f962706df43e750fc092d386e38f2f238ca014202108ecc9ee63d7237a18804a56b32c0c0b4f48d65229cf9c0fee9a61326cc53c12f939c2aaeecfcfb8fcf71831154a974db7ca2416fbfa31eec0ca0b899915b8b7e2e2d90a6d">
                        <br>
                        <span>앨범명</span>
                    </li>
                    <li>
                        <img  class="image" src="https://w.namu.la/s/dd10984aec9e0100e8472908ccf9f3d5be391ae2f0e7f962706df43e750fc092d386e38f2f238ca014202108ecc9ee63d7237a18804a56b32c0c0b4f48d65229cf9c0fee9a61326cc53c12f939c2aaeecfcfb8fcf71831154a974db7ca2416fbfa31eec0ca0b899915b8b7e2e2d90a6d">
                        <br>
                        <span>앨범명</span>
                    </li>
                    <li>
                        <img  class="image" src="https://w.namu.la/s/dd10984aec9e0100e8472908ccf9f3d5be391ae2f0e7f962706df43e750fc092d386e38f2f238ca014202108ecc9ee63d7237a18804a56b32c0c0b4f48d65229cf9c0fee9a61326cc53c12f939c2aaeecfcfb8fcf71831154a974db7ca2416fbfa31eec0ca0b899915b8b7e2e2d90a6d">
                        <br>
                        <span>앨범명</span>
                    </li>
                    <li>
                        <img  class="image" src="https://w.namu.la/s/dd10984aec9e0100e8472908ccf9f3d5be391ae2f0e7f962706df43e750fc092d386e38f2f238ca014202108ecc9ee63d7237a18804a56b32c0c0b4f48d65229cf9c0fee9a61326cc53c12f939c2aaeecfcfb8fcf71831154a974db7ca2416fbfa31eec0ca0b899915b8b7e2e2d90a6d">
                        <br>
                        <span>앨범명</span>
                    </li>
                    <li>
                        <img  class="image" src="https://w.namu.la/s/dd10984aec9e0100e8472908ccf9f3d5be391ae2f0e7f962706df43e750fc092d386e38f2f238ca014202108ecc9ee63d7237a18804a56b32c0c0b4f48d65229cf9c0fee9a61326cc53c12f939c2aaeecfcfb8fcf71831154a974db7ca2416fbfa31eec0ca0b899915b8b7e2e2d90a6d">
                        <br>
                        <span>앨범명</span>
                    </li>
                </ul>
            </div>
        </div>
        <div>
            <h3 style="text-align: center; margin: 0px;">댓글</h3>
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
                        </div>
                        <div class="text2">
                            <a href="/javafood_team/artistcomment?command=delcommnet&id=<%= id%>"><button class='btn' type='button'> 삭제 </button></a>
                        </div>
                </div> <% } %>
                
                
            </div>
        </div>


</body>
</html>