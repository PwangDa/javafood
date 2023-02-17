<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "album.info.AlbumDAO"
    import = "album.info.AlbumVO"
    import = "javafood_DTO.AlbumDTO"
    import = "SecondProject.JavaFood_DAO"
    import = "java.util.List"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Album Test</title>
<%-- 	    
JavaFood_DAO dao = new JavaFood_DAO();
String num = request.getParameter("a.ALBUM_NUM");
System.out.println("num : "+num);
List<AlbumDTO> list = dao.listAlbum(num);  --%>
<script>

    window.onload = function(){

        let checkbox = document.querySelectorAll(".but");
        let cont2 = document.getElementsByClassName("cont2");

        for(let x=0; x<checkbox.length; x++){
            checkbox[x].addEventListener('click', function(event){
                //부모의 부모가져오기
                // console.log("커렌트타켓"+event.currentTarget.parentNode.parentNode);
                let checked = checkbox[x].checked;
    
                for(let i=0; i<cont2.length; i++){
                    if(checked == true){
                        console.log(checked);
                        event.currentTarget.parentNode.parentNode.style.backgroundColor = 'rgba(86, 86, 86, 0.423)';           
                    }else if(checked == false){
                        console.log(checked);
                        event.currentTarget.parentNode.parentNode.style.backgroundColor = 'transparent';
                    }
            }
            });
        }
        
	}

</script>
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

       
        #home{
            position: relative;
            top : 53px;
            width: 75%;
            padding: 25px;
            margin: 0 auto;
        }

        .cont1{
            display: flex;
            margin-bottom: 29px;
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

        .cont2{
            display: flex;
            height: 50px;
            border-bottom: 1px solid rgb(98, 98, 98);
            margin : 0px 20px;
            padding-top: 13px;
        }
        .cont2:hover {
            cursor: pointer;
        }

        .left_item{
            width: 100px;
            height: 40px;
            padding: 7px;
            text-align: center;
        }
        .left_name{
            width: 400px;
            text-align: left;
        }
        .right_item{
            width: 100px;
            height: 40px;
            padding: 7px;
            text-align: center;
            margin-left: auto;
        }
        /*해당 div에 커서올리면 체크박스 나오게*/
        <%-- for(int i=0; i<list.size(); i++) {--%>
        <c:forEach var="album" items="${album_title}" varStatus="loop"> 
        	.cont2_${loop.count}:hover span{
        		display : none;
        	}
  
        	.cont2_${loop.count}:hover .but{
        		display : block;
        	}
        <%--}--%>
        </c:forEach>
        
        /*체크박스*/
        <%--/*.but{
            display : none;
            width: 20px;
            height: 20px;
            text-align: center;
            margin-left: 40px;
        }  */--%>
        
       /*체크박스가 체크되면 유지되게. */  
       /* > 는 자식요소 / ~는 모두다 /+형제에서 다음형제?*/
        .but:checked + span{
        	display : none;
        }
        .but:checked {
        	display : block;
        }
        
        
        
		/*체크박스 디자인*/
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
                
                text-align: center;
            	margin-left: 40px;
            	display : none;
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

            input[type="checkbox"]:checked {
                background-color: #adadad;
                border-color: rgb(255, 255, 255);
                color: white;
            }        
        
</style>
</head>
<body>
   <jsp:include page="/menu.jsp"></jsp:include>
    <%--	for (int i =0; i < 1; i++) {
	    	AlbumDTO vo = list.get(i);
	    	
	    	String cover = vo.getAlbum_cover();
			String alname = vo.getAlbum_name();
			String into =  vo.getAlbum_into();
			String artist = vo.getArtistname();
	    
    --%>
    <div id = "home">
        <div class="cont1">
            <div class="cont1_1">
                <img class="img1" src="${album_list[0].album_cover }">
            </div>
            <div class="cont1_1">
                <h1>${album_list[0].album_name }</h1>
                <p>${album_list[0].artistname }</p>
                <p>아직내용 못가져옴</p>
                <details>
                    <summary style="color: rgb(150, 150, 150);">출처</summary>
                    <p>Wikipedia(https://ko.wikipedia.org/wiki)</p>
                </details>
                <br>
                <button class="btn" type="button" style="font-size: 16px;">+ 보관함에 추가</button>
            </div>
        </div>
        <%-- } --%>
        <%-- for (int i =0; i < list.size(); i++) {
        	AlbumDTO vo = list.get(i);
        	
			String music_num = vo.getMusic_num();
			String music_name = vo.getMusic_name();
			String music_link = vo.getMusic_link();
			String music_time = vo.getMusic_time();
        --%>
        <c:forEach var="album" items="${album_title}" varStatus="loop">
        	<div class= "musiclist ">
            	<div class="cont2 cont2_${loop.count}">
                	<div class="left_item" style="color: rgb(187, 187, 187);">${loop.count}</div>
                	<div class="left_item left_name"><a href="naver.com"><strong>${album}</strong></a></div>
                	<div class="right_item">
                	<input type="checkbox" class="but btn${loop.count}">
                	<span class="chek1" style="color: rgb(187, 187, 187);">3:15</span>
                	</div>
            	</div>		
        	</div>
        </c:forEach>
        <%-- } --%>
    </div>
</body>
</html>