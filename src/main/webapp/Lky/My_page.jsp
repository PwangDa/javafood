<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
    <head>
    	<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
   		<script link src ="javafoodScript/mypageScript.js"></script>
   		<c:if test="${out!=null }"><script>urseout('${out}');</script></c:if>
        <c:if test="${login==null }"><script>notlogin();</script></c:if>
        <c:if test="${out!=null }"><script>urseout();</script></c:if>
        <c:if test="${link!=null }"><script> location.href ='${link }'</script></c:if>
        <meta charset="UTF-8">
        <title>My Page</title>
    </head>
    <body>
 	<jsp:include page="/menu.jsp" />   
    <link rel="stylesheet" href="javafoodCSS/mypageCSS2.css?css=css">
    <div class="div ddr">
	    <div class="mume div"><h3><a class="at" href="javafood?javafood=5&remove=1"><c:out value="회원정보 수정"/></a></h3></div>
	    <div class="mume div"><h3><a class="at" href="#" onclick="replay('${session_user.id}')"><c:out value="재생기록"/></a></h3></div>
	    <div class="mume div"><h3><a class="at" href="#" onclick="outt('${session_user.id}')"><c:out value="로그아웃"/></a></h3></div>
	    <div class="mume div"><h3><a class="at" href="#" onclick="out('${session_user.id}')"><c:out value="회원탈퇴"/></a></h3></div>
    </div>
    
    
	<c:if test="${usre!=null }">
    <link rel="stylesheet" href="javafoodCSS/mypageCSS3.css?css=css">
		<table border="1">
		<tr>
			<th>이미지</th>
			<th>노래</th>
			<th>가수</th>
			<th>앨범</th>
			<th>시간</th>
			<th>하트</th>
			<th>보관</th>
		</tr>
		<c:forEach items="${usre }" var="i">
			<tr class="ddr">
				<td><a class="at" href="${i.link }"><img src="${i.imglink }"></a></td>
				<td><a class="at" href="${i.link }"><c:out value="${i.songname }"/></a></td>
				<td><a class="at" href="javafood?javafood=ArtistList&num=${i.songnumber }"><c:out value="${i.artistname }"/></a></td>
				<td><a class="at" href="javafood?javafood=AlbumList&num=${i.songnumber }"><c:out value="${i.album_name}"/></a></td>
				<td><c:out value="${i.playtime }"/></td>
				<td><c:out value="${i.likes }"/></td>
				<td><c:out value="${i.likes }"/></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>    
    
    
    <c:if test="${remove==1}" >
        <h1 class="ddr"><c:out value="회원정보 수정"/></h1>
        <form
        	id="form"
            method="post"
            action="http://localhost:8080/javafood_team/aj"
            enctype="multipart/form-data"
            accept-charset="utf-8">
            <div class="ddr div">
                <div class="div" style="width: 200px; height: 250px">
                    <div class="div">
                        <input type="file" name="file1">
                        <p><strong>프로필 사진</strong></p>
                        <img src="http://localhost:8080/javafood_team/aj1?fileName=new_javafood.JPG"
                            style="width: 150px;height: 150px;">
                    </div>
                    <div class="div"><input type="button" onclick="but()" value="업로드"></div>
                </div>
            </div>
        </form>
        <form method="post" action="javafood?javafood=4">
            <div class="head div">
                <table>
                    <tr class="tr">
                        <th><c:out value="이미지url : "/></th>
                        <th><c:out value="서버없어서 이미지url만 적용됩니다."/></th>
                        <td><input type="text" id="img" name="img" placeholder="${lo[0].myimg }"></td>
                        <td><input type="hidden" value="1" name="remove"></td>
                    </tr>
                    <tr class="tr">
                        <th><c:out value=" 아이디 : "/></th>
                        <td><c:out value="${session_user.id }"/>
                        </td>
                    </tr>
                    <tr>
                        <th><c:out value="비밀번호 1 :  "/></th>
                        <td><input type="password" id="pw1" name="PW1" placeholder="비밀번호를 입력하시오"></td>
                        <td rowspan="2"><input type="button" id="pwbutt" value="일치 확인"></td>
                        <td><input type="checkbox" id="ch2" class="ch"></td>
                    </tr>
                    <tr>
                        <th><c:out value="비밀번호 2 :  "/></th>
                        <td><input type="password" id="pw2" placeholder="다시입력하시오"></td>
                        <td></td>
                    </tr>
                    <tr class="tr">
                        <th><c:out value="닉네임 : "/></th>
                        <td><input type="text" id="nic" name="nic" placeholder="닉네임"></td>
                        <td><input type="button" id="nicbutt" value="중복확인"></td>
                        <td><input type="checkbox" id="ch3" class="ch"></td>
                    </tr>
                    <tr>
                        <th><c:out value="이메일 : "/></th>
                        <td><input type="text" id="email" name="mail" placeholder="mail@naver.com"></td>
                        <td><input type="button" id="mailbutt" value="인증하기"></td>
                        <td><input type="checkbox" id="ch4" class="ch"></td>
                    </tr>
                    <tr id="mail">
                        <th><c:out value="인증번호 : "/></th>
                        <td><input type="text" placeholder="메일 인증번호"></td>
                        <td><input type="button" id="mailchbutt" value="인증확인"></td>
                        <td><input type="checkbox" id="ch5" class="ch"></td>
                    </tr>
                    <tr>
                        <th id="pn" class="tr"><c:out value="주민등록 번호 : "/></th>
                        <td>
                            <c:out value="${session_user.pn }"/>
                        </td>
                    </tr>
                    <tr>
                        <th class="tr"><c:out value=" 휴대폰 번호 : "/></th>
                        <td>
                            <input type="text" class="phone" name="phone1" id="phone1" placeholder="010">
                            <input type="text" class="phone" name="phone2" id="phone2" placeholder="1234">
                            <input type="text" class="phone" name="phone3" id="phone3" placeholder="4567">
                        </td>
                        <td><input type="button" id="phonebutt" value="본인 확인"></td>
                        <td><input type="checkbox" id="ch7" class="ch"></td>
                    </tr>
                    <tr>
                        <th>
                            <a href="javafood?javafood=5" class="at"><c:out value=" 취 소 "/></a>
                        </th>
                        <th><input class="sub" type="submit" value="수정하기" id="end" disabled="disabled"></th>
                        <th><input class="sub" type="reset" id="re" value="다시작성"></th>
                    </tr>
                </table>
            </div>
        </form>
    </c:if>
</body>
</html>
<%--
      
      <div class="body">
          <h2><c:out value="최근재생목록"/></h2>
          <table border="1">
              <tr>
                  <th><c:out value="순위"/></th>
                  <th><c:out value="이미지"/></th>
                  <th><c:out value="아티스트 이름"/></th>
                  <th><c:out value="노래 제목"/></th>
                  <th><c:out value="조회수"/></th>
                  <th><c:out value="유튜브 검색"/></th>
                  <th><c:out value="좋아요"/></th>
              </tr>
		<c:if test="${song!=null }">
			<c:forEach items="${song }" var="i">
				<tr class="low">
					<td><c:out value="${i.songnumber}"/></td>
					<td> <img src="${i.imglink}"></td>
					<td><c:out value="${i.artistname}"/></td>
					<td><c:out value="${i.songname}"/></td>
					<td><c:out value="${i.hits}"/></td>
					<td><a class="athe" href="javafood?javafood=5&user=${i.songnumber }&link=${i.link }" target="_blank"><c:out value="검색"/></a></td>
					<td><a class="atge" href="javafood?javafood=5&likes=${i.songnumber }"><c:out value="${i.likes}"/></a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${usre!=null }">
			<c:forEach items="${usre }" var="i">
				<tr class="low">
					<td><c:out value="${i.songnumber}"/></td>
					<td> <img src="${i.imglink}"></td>
					<td><c:out value="${i.artistname}"/></td>
					<td><c:out value="${i.songname}"/></td>
					<td><c:out value="${i.hits}"/></td>
					<td><a class="athe" href="javafood?javafood=5&user=${i.songnumber }&link=${i.link }" target="_blank"><c:out value="검색"/></a></td>
					<td><a class="atge" href="javafood?javafood=5&likes=${i.songnumber }"><c:out value="${i.likes}"/></a></td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${song==null&&usre==null }">
			<c:forEach items="${list }" var="i">
				<tr class="low">
					<td><c:out value="${i.songnumber}"/></td>
					<td> <img src="${i.imglink}"></td>
					<td><c:out value="${i.artistname}"/></td>
					<td><c:out value="${i.songname}"/></td>
					<td><c:out value="${i.hits}"/></td>
					<td><a class="athe" href="javafood?javafood=5&user=${i.songnumber }&link=${i.link }" target="_blank"><c:out value="검색"/></a></td>
					<td><a class="atge" href="javafood?javafood=5&likes=${i.songnumber }"><c:out value="${i.likes}"/></a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</div>

--%>

<%-- 	<c:if test="${a!=null }"> --%>