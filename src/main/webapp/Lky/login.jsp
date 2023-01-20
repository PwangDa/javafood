<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="My_Page.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	if(request.getParameter("mail")!=null){
		vod vo1 = new vod();
		vo1.setId(request.getParameter("ID"));
		vo1.setPw(request.getParameter("PW1"));
		vo1.setNic(request.getParameter("nic"));
		vo1.setPn(request.getParameter("pn1")+"-"+request.getParameter("pn2"));
		vo1.setPhone(request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3"));
		vo1.setEmail(request.getParameter("mail"));
// 		vo1.setHome(home);
	}
	
	dbon db = new dbon(); 
	List<vod> vo = db.listID();
%>
<%if("O".equals(request.getParameter("new"))) {%>
<title>javafood 회원가입</title>
<style>
	body{background-size: contain; color: white; background-position: center; text-align: center; background-image: url(https://velog.velcdn.com/images/gigymi2005/post/c941bf05-995a-4b90-a4b5-63ecd6b5374f/pankaj-patel-u2Ru4QBXA5Q-unsplash.jpg);}
    div{display: inline-block; width: 100%; height: 100%; background-color: black;}
    .sub{margin-top: 10px;width: 100px; height: 30px;}
    .at{color: white; text-decoration: none;}
    .head{text-align: left;}
</style>
</head>
<body>
        <h1>javafood 회원가입</h1>
        <form method="post" action="login.jsp">
            <div class="head">
                 아 이 디 &nbsp;: <input type="text" name="ID">
                                        <input type="button" id="butt1" value="중복 확인"><br>
                <hr>
                비밀번호1 : <input type="password" id="pw1" name="PW1"><br>
                비밀번호2 : <input type="password" id="pw2"><br>
                                <input type="button" id="butt2" value="일치 확인"><br>
                <hr>
                닉 네 임 &nbsp;: <input type="text" id="pw1" name="nic"><br>
                                        <input type="button" id="butt3" value="중복확인"><br>
                <hr>
                이 메 일  &nbsp;: <input type="text" id="pw1" name="mail">
                                        <input type="button" id="butt3" value="이메일 인증하기"><br>
                                        인증번호 : <input type="text" >
                                        <input type="button" id="butt12" value="확인">
                                        <br>
                <hr>
                주민등록 번호 : <input type="text" class="pn" name="pn1">
                                    <input type="password" class="pn" name="pn2"><br>
                                    <input type="button" id="butt4" value="주민등록 번호 확인"><br>
                <hr>
                휴대폰번호 : <input type="text" class="phone" name="phone1">
                                <input type="text" class="phone" name="phone2">
                                <input type="text" class="phone" name="phone3"><br>
                                <input type="button" id="butt5" value="연락처 확인"><br>
                <hr>
                <a href="login.jsp" class="at">취소</a>
                <input class="sub" type="submit" value="회원가입">
                <input class="sub" type="reset" value="다시작성">
            </div>
        </form>
        <div class="body"></div>
        <script>
                document.querySelector("#butt2").addEventListener("click",function(){
                    if(document.querySelector("#pw1").value != document.querySelector("#pw2").value){
                       alert("잘못입력 하셨습니다.");
                    }else alert("비밀번호가 일치합니다.");
                })
        </script>
</body>
</html>
<% }else {%>
<title>javafood 로그인</title>
<style>
	body{background-size: contain; color: white; background-position: center; text-align: center; background-image: url(https://velog.velcdn.com/images/gigymi2005/post/c941bf05-995a-4b90-a4b5-63ecd6b5374f/pankaj-patel-u2Ru4QBXA5Q-unsplash.jpg);}
    div{display: inline-block; border: 1px solid red; width: 100%; height: 100px;}
    .sub{margin-top: 10px;width: 100px; height: 30px;}
    .at{color: white; text-decoration: none;}
</style>
</head>
<body>
	<h1>javafood 로그인</h1>
    <form method="post" action="login.jsp">
        <div class="head">
             아 이 디 &nbsp;: <input type="text" name="ID"><br>
            비밀번호 : <input type="text" name="PW"><br>
            <a href="login.jsp?new=O" class="at">회원가입</a>
            <input class="sub" type="submit" value="로그인">
            <input class="sub" type="reset" value="다시작성">
        </div>
    </form>
    <div class="body"></div>
<%--     <%for(int i=0; ) %> --%>
</body>
</html>
<%}%>