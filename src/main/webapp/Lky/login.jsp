<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="javafood_DTO.*"
    import="SecondProject.*"
    %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
	<script link src ="javafoodScript/loginScript.js"></script>
	<link rel="stylesheet" href="javafoodCSS/loginCSS.css?css=css">
<c:if test="${good!=null }">
	<c:if test="${good==1 }"><script>alert("회원가입 성공")</script></c:if>
	<c:if test="${good==0 }"><script>alert("회원가입 실패")</script></c:if>
</c:if>

<c:if test="${re!=null }"><script>alert('회원정보 수정이 완료되었습니다. 다시 로그인 해주세요.')</script></c:if>

<c:if test="${membership!=null }">

	<title>javafood 회원가입</title>
	</head>
	<body>
		<div><h1><c:out value="javafood 회원가입"/></h1></div>
	        <form id="form" method="post" action="http://localhost:8080/javafood_team/aj" 
		   		   enctype="multipart/form-data" 
		  		   accept-charset="utf-8">
		  		<div>
					<div style="width: 200px; height: 250px">
						<div>
							<input type="file" name="file1">
							<p><strong> 프로필 사진 (서버가 없어서 다른컴퓨터에서 이미지 출력 불가)</strong></p>
							<img src="http://localhost:8080/javafood_team/aj1?fileName=new_javafood.JPG" style="width: 150px;height: 150px;">
						</div>
						<div>
							<input type="button" onclick="but()" value="업로드">
						</div>
					</div>
				</div>
			</form>
	        
	        <form method="post" action="javafood?javafood=4">
	            <div class="head">
	              <table>
	        <tr class="tr">
	            <th><c:out value=" 아이디 : "/></th>
	            <td><input type="text" name="Id1" id="Id1" placeholder="아이디를 입력하시오"></td>
	            <td><input type="button" id="idbutt" value="중복 확인"></td>
	            <td><input type="checkbox" id="ch1" class="ch"></td>
	        </tr>
	        <tr>
	            <th><c:out value="비밀번호 1 :  "/></th>
	            <td><input type="password" id="pw1" name="PW1"placeholder="비밀번호를 입력하시오"></td>
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
	                <input type="text" class="pn" name="pn1" id="pn1" placeholder="911222">
	                <input type="password" class="pn" name="pn2" id="pn2" placeholder="1234567">
	            </td>
	            <td><input type="button" id="pnbutt" value="중복확인"></td>
	            <td><input type="checkbox" id="ch6" class="ch"></td>
	        </tr>
	        <tr>
	            <th class="tr"><c:out value=" 휴대폰 번호 : "/></th>
	            <td>
	                <input type="text" class="phone" name="phone1" id="phone1" placeholder="010">
	                <input type="text" class="phone" name="phone2" id="phone2" placeholder="1234">
	                <input type="text" class="phone" name="phone3" id="phone3" placeholder="4567">
	            </td>
	            <td><input type="button" id="phonebutt" value="연락처 확인"></td>
	            <td><input type="checkbox" id="ch7" class="ch"></td>
	        </tr>
	        <tr>
	            <th><a href="javafood?javafood=4" class="at"><c:out value=" 취 소 "/></a></th>
	            <th><input class="sub" type="submit" value="회원가입" id="end"disabled></th>
	            <th><input class="sub" type="reset" id="re" value="다시작성"></th>
	        </tr>
	    </table>
	            </div>
	        </form>
	</body>
	</html>
 </c:if>
 
 <c:if test="${log==2 }">
	<title>javafood</title>
	</head>
	<body>
		<h1><c:out value="javafood 로그인성공"/></h1>
		<h1>${login[0].nic } <c:out value="님 환영합니다."/></h1>
		<strong id="time"></strong><c:out value="초후에 매인 화면으로 이동됩니다. 마음의 준비를 해주세요."/>
		<script>loging();</script>
	</body>
	</html>
 </c:if>
<c:if test="${log==0 }"><script>alert('아이디가 틀렸습니다.');location.href='javafood?javafood=4';</script></c:if>
<c:if test="${log==1 }"><script>alert('페스워드가 틀렸습니다.');location.href='javafood?javafood=4';</script></c:if>

<c:if test="${membership==null&&log==null }">
	<title>javafood 로그인</title>
	</head>
		<body>
			<h1><c:out value="javafood 로그인"/></h1>
		    <form method="post" action="javafood?javafood=4">
		        <div class="head1">
		            <c:out value="아 이 디 : "/>&nbsp;<input class = "tt" type="text" name="ID" placeholder="USER NAME"><br><br>
		            <c:out value=" 비밀번호 : "/><input class = "tt" type="password" name="PW" placeholder="PASSWORD"><br><br>
		            <a href="javafood?javafood=4&membership=O" class="at"><c:out value="회원가입"/></a>
		            <input class="sub" type="submit" value="로그인">
		            <input class="sub" type="reset" value="다시작성">
		        </div>
		    </form>
		    <div class="body"></div>
		</body>
	</html>
	<br>
	<hr>
</c:if>
