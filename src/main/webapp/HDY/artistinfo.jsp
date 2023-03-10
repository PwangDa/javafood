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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Artist.jsp Test전용</title>
<%-- 		CommentDAO dao = new CommentDAO();

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
		
		List<CommentVO> list = dao.listComment();--%>
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
            frmComment.action = "/javafood_team/javafood?javafood=1&command=addcommnet.do";
            frmComment.submit();
        	}
        } 
 		
        function fn_sendComment_2(){
        	
        	var frmCommand = document.frmComment_2;
        	var id = frmCommand.id_2.value;
        	var cont = frmCommand.cont_2.value;
        	
        	if(id.length == 0 || id == ""){
        		alert("아이디를 입력해주세요")
        	}else if(cont.length == 0 || cont == ""){
        		alert("내용을 입력해주세요")
        	}else{
            frmComment.method = "post";
            frmComment.action = "/javafood_team/javafood?javafood=1&command=addReply.do";
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
            url("${listAlbum[0].artist_img}") ;
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
            height: 90px;
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
            margin-right: 4px;
            height: 20px;
            vertical-align: top;
        }
        .comment_1_2{
            height: 24px;
            vertical-align: top;
            margin: 12px 10px 0px 10px;
        }
        
        .comment_1_3{
           text-align: left;
            width: 520px;
            margin: 3px;
            padding: 2px;
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

        .reply{
            /* border: 1px solid white; */
            display: inline-block;
            width: 530px;
            text-align: left;
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
	<jsp:include page="/menu.jsp"></jsp:include>
    <div id = "home">
        <div id = "cont" class = "contain">     
            <div class = "text1"> 
            <%--forEach 안하고 하나의 값만 가져오고 싶을때 --%>
                <h1>${listAlbum[0].artistname }</h1>
                <p style="width: 690px;">${listAlbum[0].artist_info }</p>
                <div> <a target="_blank" href="https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0">출처:namuwiki</a></div>
            </div>
        </div>
        <div id ="cont1_1">
            <h2 style="text-align: center; margin: 13px;">음악</h2>
            <jsp:useBean id="daoTest" class="album.info.AlbumDAO"></jsp:useBean>
            <%-- service에 
            AlbumDAO albumDAO = new AlbumDAO(); 생성 [생성자선언해도 되나?]   
            
            public List<AlbumVO> Albumlist(){
            	List<AlbumVO> Albumlist = albumDAO.listAlbum(); 
            	return Albumlist;선언하고 
            }
                  
            controller.java 에서 
            listAlbum = Service.Albumlist();
			request.setAttribute("listAlbum", listAlbum);
			nextPage = "/artistinfo.jsp";
			dispatch.forward();
		    하면 jsp로 송출
				 
            jsp 이 페이지에서
            AlbumVO vo = Albumlist.get(j); 
            가 vo에 .get(j)로 for문으로 (0), (1) 하나씩 뽑아 넣어서 넣었다면
            
            향상된 for문으로 
             album에 하나씩 넣어서 
            <c:forEach var:"album" items="${listAlbum}">로 앨범목록출력
            	 <div id = "cont1">
                	<div class = "box1">
                    <img class="img1" src="${album.cover}">
                  </div>
                  <div class = "box1 text2"><a href="${album.link}">
                  
            --%>
            <%-- 
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
            	--%>
           <c:forEach var="album" items="${listAlbum}">
	            <div id = "cont1">
	                <div class = "box1">
	                    <img class="img1" src="${album.album_cover }">
	                </div>
	                <div class = "box1 text2"><a href="${album.music_link}"><strong>${album.music_name }</strong></a></div>
	                <div class = "box1 text2" style = "color:rgb(192, 192, 192);">${album.artistname }</div>
	                <div class = "box1 text2"><a style = "color:rgb(192, 192, 192);" href="/javafood_team/Album.jsp?a.ALBUM_NUM=${album.album_num}">${album.album_name }</a></div>
	            </div>
	            <hr>
            </c:forEach>
            <%--} --%>
        </div>
        <div id = "cont3">
                <p class="point prev">&lang;</p>
            <h2 style="text-align: center; margin: 0px; display: inline;">앨범</h2>
                <p class="point next">&rang;</p>
            <div id="cont3_1">
                <ul id = "slds" class="clides">
                <%-- for(int h=0; h<Albumlist.size(); h++){ 
                	AlbumVO vo = Albumlist.get(h);
                	
                	String alNum = vo.getAlbum_num();
        	    	String cover = vo.getAlbum_cover();
        			String alname = vo.getAlbum_name();

                --%>
                <c:forEach var ="album" items="${listAlbum}">
                    <li>
                        <a href="/javafood_team/Album.jsp?a.ALBUM_NUM=${album.album_num}"><img  class="image" src="${album.album_cover }"></a>
                        <br>
                        <a style = "font-size:14px;" href="/javafood_team/Album.jsp?a.ALBUM_NUM=${album.album_name}"><span><strong>${album.album_name }</strong></span></a>
                    </li>
                    <%--} --%>
                </c:forEach>
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
                <%-- for(int i= 0; i<list.size(); i++) {
	    	    	  CommentVO vo = list.get(i);
	    	    	  
	    	    	  String id = vo.getComment_id();
	    	    	  String cont = vo.getComment_cont();
	    	    	  Date date = vo.getComment_Date(); --%>
	    	<div>
	    	  	<c:forEach var ="comment" items="${commentList}">
	            	<c:if test="${comment.level == 1 }">
	                	<div class="comment" >
                            <div class="text2 cont2_1">
	                            <img class="image2" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
	                            <div class="id2">${comment.comment_id }</div>
	                        </div>
	                        <div class="text2">
	                            <div class="cont2">${comment.comment_cont }</div>
	                            <div class="date1">${comment.comment_Date }</div>
	                            <details id="detail">
		                   		 	<summary style="color: rgb(150, 150, 150);">답글달기</summary>
		                   		 	<form name="frmComment_2" method="post" action="/javafood_team/javafood?javafood=1&command=addReply.do">
			                    		<div class="comment" >
						                        <img class="image3" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
						                        <input class="input2" type="text" name="id_2" placeholder=" ID">
						                        <input class="input3" type="text" name="cont_2" placeholder="답글 추가...">
						                        <%-- <button class="btn1" type="button" onclick="fn_sendComment_2()"> 답글 </button>--%>
						                        <input class="btn1" type="submit" value="답글"> 
						                    	<input type ="hidden" name="command_articleNO" value="${comment.articleNO }">
			                			</div>
		                            </form>
                				</details>
	                        </div>
	                        <!-- 삭제하기 기능도 
	                        	<a href="/javafood_team/delcommnet.do?id=${list.id}">
	                        -->
	                        <div class="text2">
	                            <a href="/javafood_team/javafood?javafood=1&command=delcommnet.do&articleNO=${comment.articleNO }"><button class='btn' type='button'> 삭제 </button></a>
	                        </div>
	                	</div>
                        
	             	</c:if>
                    	<%--대댓글 등록했을 때 form --%>
	             		<form name="frmComment_2" method="post" action="/javafood_team/javafood?javafood=1&command=delcommnet.do">
			            	<c:if test="${comment.level >= 2}">
			            		<div class="reply">
				        			<div class="comment_1">
                                            <span class="comment_1_1">└</span>
						                    <img class="image3" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png">
						                    <p class="comment_1_1">${comment.comment_id }</p>
						                    <p class="comment_1_1" style="color: rgb(113, 113, 113);">${comment.comment_Date }</p>
						                    <a href="/javafood_team/javafood?javafood=1&command=delcommnet.do&articleNO=${comment.articleNO }"><button class="btn1 comment_1_2" type="button"> 삭제</button></a>
				        			</div>
				        			<div class="comment_1_3">
				                        <span class="comment_1_4" style="margin-right :70px;"></span>
				                        ${comment.comment_cont }
				                    </div>
				                </div>
			            	</c:if>
			            </form>
                    </c:forEach>  
                <%-- } --%>
            </div>                 
        </div>
    </div>


</body>
</html>