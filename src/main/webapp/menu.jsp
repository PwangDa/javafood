<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javafood menu</title>

<link rel="stylesheet" href="javafoodCSS/menuCSS.css?css=css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

</head>
<body>
	
    <header id ="menu" style="display: inline-block;" >
        <span style="font-size: 34px; font-weight: 600; cursor: pointer;">
        <a href="javafood?javafood=m" class="a1"><img src="https://c11.kr/1asbb" class="logo-img">Music</a>
        </span>
        <div class="menu-box">
            <a href="javafood?javafood=m" class="a1"><span class="main main_1" >홈</span></a>
            <a href="javafood?javafood=6" class="a1"><span class="main main_2" >장르별</span></a>
            <a href="javafood?javafood=3" class="a1"><span class="main main_3" >보관함</span></a>
           	<select id="opt" style="height: 30px;">
                <option value="song"><c:out value="노래검색"/></option>
	            <option value="man"><c:out value="가수검색"/></option>
            </select>
            <div class = "main-box main_4">
                <input id="pot" class="search-txt" type="text" placeholder="검색">
                <button class="search-btn" type="button" id="cli">검색</button>
            </div>
        </div>
        <span id="spa" class="abc">
	        <c:if test="${lo[0].myimg!=null}">
		        <a href="javafood?javafood=5"><img class="menu-img" src=" ${lo[0].myimg }"></a>
	        </c:if>
	        <c:if test="${lo[0].myimg==null}">
				<a href="javafood?javafood=5"><img class="menu-img" src="http://blog.tofte-it.dk/wp-content/uploads/2018/12/profile-picture.png"></a>
	        </c:if>
    	</span>
        
    </header>
<!--     <div id="ek" style="width: 94%;margin-top:55px; height:100PX; TEXT-ALIGN: CENTER; DISPLAY: INLINE-BLOCK;"></div> -->
    <div id="di" STYLE="margin-top:55px; padding-right:5%; WIDTH: 99%;HEIGHT:100PX; BORDER: 1PX SOlid red; text-align: right; display: inline-block;">123</div>
	<script>
		
// 		$("#ek").hide();
		$("#di").hide();
		
		$('#spa').on('mouseover',function(){
			$('#di').slideDown();
// 			$('#ek').slideDown();

		})
		$('#spa').on('mouseleave',function(){
			$('#di').hide();
// 			$('#ek').hide();
		})
	</script>
	

</body>
<script link src ="javafoodScript/menuScript.js"></script>
</html>