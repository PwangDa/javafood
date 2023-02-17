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
 <script></script>
 <script link src ="javafoodScript/artistScript.js"></script>
 <style>
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
            url("${album_list[1].artist_img}") ; 
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            height: 550px;     
            position: relative;
        }
   </style>
   <link rel="stylesheet" href="javafoodCSS/artistCSS.css">
</head>
<body  onscroll="headerbarToggle()">
	<jsp:include page="menu.jsp"></jsp:include>
    <div id = "home">
        <div id = "cont" class = "contain">     
            <div class = "text1"> 
            <%--forEach 안하고 하나의 값만 가져오고 싶을때 --%>
                <h1>${album_list[0].artistname }</h1>
                <p style="width: 690px;">${album_list[1].artist_info }</p>
                <div> <a target="_blank" href="https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0">출처:namuwiki</a></div>
            </div>
        </div>
        <div id ="cont1_1">
            <h2 style="text-align: center; margin: 13px;">음악</h2>
            <jsp:useBean id="daoTest" class="album.info.AlbumDAO"></jsp:useBean>

           <c:forEach var="album" items="${album_list}" varStatus="loop">
	            <div id = "cont1">
	                <div class = "box1">
	                    <img class="img1" src="${album.album_cover }">
	                </div>
	                <div class = "box1 text2"><a href="${loop.count}"><strong>${album.music_name}</strong></a></div>
	                <div class = "box1 text2" style = "color:rgb(192, 192, 192);">${album_list[0].artistname }</div>
	                <div class = "box1 text2"><a style = "color:rgb(192, 192, 192);" href="/javafood_team/Album.jsp?a.ALBUM_NUM=${loop.count}">${album.album_name }</a></div>
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

                <c:forEach var ="album" items="${album_list}" varStatus="loop">
                    <li>
                        <a href="/javafood_team/Album.jsp?a.ALBUM_NUM=${loop.count}"><img  class="image" src="${album.album_cover }"></a>
                        <br>
                        <a style = "font-size:14px;" href="/javafood_team/Album.jsp?a.ALBUM_NUM=${album.album_name}"><span class="al_name"><strong>${album.album_name }</strong></span></a>
                    </li>
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
						                        <input class="btn1" type="submit" value="답글"> 
						                    	<input type ="hidden" name="command_articleNO" value="${comment.articleNO }">
			                			</div>
		                            </form>
                				</details>
	                        </div>
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
            </div>                 
        </div>
    </div>


</body>
</html>