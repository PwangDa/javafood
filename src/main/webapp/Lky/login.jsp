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
	body{background-size: contain; color: white; background-color: black; text-align: center;;}
    div{display: inline-block; width: 100%; height: 100%;}
    .sub{margin-top: 10px;width: 100px; height: 30px;}
    .at{color: white; text-decoration: none;}
    .head{text-align: left;}
    .pn{width: 43%;}
    .phone{width: 26%;}
    td{width: 100px;}
    table{background-size: contain; background-color: black;   text-align: right; margin: auto; border: 1px solid black; border-collapse: collapse;}
    
</style>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
        <h1>javafood 회원가입</h1>
        <form method="post" action="login.jsp">
            <div class="head">
              <table>
        <tr>
            <th>아이디 : </th>
            <td><input type="text" name="ID" id="Id" placeholder="아이디를 입력하시오"></td>
            <td><input type="button" id="butt1" value="중복 확인"></td>
        </tr>
        <tr>
            <th>비밀번호 1 :  </th>
            <td><input type="password" id="pw1" name="PW1"placeholder="비밀번호를 입력하시오"></td>
            <td rowspan="2"><input type="button" id="butt2" value="일치 확인"></td>
        </tr>
        <tr>
            <th>비밀번호 2 : </th>
            <td><input type="password" id="pw2" placeholder="다시입력하시오"></td>
            <td></td>
        </tr>
        <tr>
            <th>닉네임 : </th>
            <td><input type="text" id="nic" name="nic" placeholder="닉네임"></td>
            <td><input type="button" id="butt3" value="중복확인"></td>
        </tr>
        <tr>
            <th>이메일 : </th>
            <td><input type="text" id="email" name="mail" placeholder="mail@naver.com"></td>
            <td><input type="button" id="butt4" value="인증하기"></td>
        </tr>
        <tr id="mail">
            <th>인증번호 : </th>
            <td><input type="text" placeholder="메일에 온 인증번호를 입력하시오."></td>
            <td><input type="button" id="butt12" value="인증확인"></td>
        </tr>
        <tr>
            <th id="pn">주민등록 번호 : </th>
            <td>
                <input type="text" class="pn" name="pn1" id="pn1" placeholder="911222">
                <input type="password" class="pn" name="pn2" id="pn2" placeholder="1234567">
            </td>
            <td><input type="button" id="butt5" value="중복확인"></td>
        </tr>
        <tr>
            <th>휴대폰 번호 : </th>
            <td>
                <input type="text" class="phone" name="phone1" id="phone1" placeholder="010">
                <input type="text" class="phone" name="phone2" id="phone2" placeholder="1234">
                <input type="text" class="phone" name="phone3" id="phone3" placeholder="4567">
            </td>
            <td><input type="button" id="butt6" value="연락처 확인"></td>
        </tr>
        <tr>
            <th><a href="login.jsp" class="at">취소</a></th>
            <th><input class="sub" type="submit" value="회원가입"></th>
            <th><input class="sub" type="reset" value="다시작성"></th>
        </tr>
    </table>
            </div>
        </form>
        <div class="body"></div>
        <script>
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#butt1").on("click",function(){
                    let id = $('#Id').val();
                    let ii;
                    let q = 0;
                    <%
                    	for(vod v:vo){%>
                    		ii='<%=v.getId()%>'
                    		ii==id?q++:q;
                    	<%}%>
                    q!=0?alert('사용중인 아이디 입니다.'):alert('생성 가능');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#butt2").on("click",function(){
                    $("#pw1").val() != $("#pw2").val() ? alert("잘못입력 하셨습니다.") : alert("비밀번호가 일치합니다.");
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#butt3").on("click",function(){
                    let nic = $('#nic').val();
                    let ii;
                    let q = 0;
                    <%
                    	for(vod v: vo){%>
                    		ii='<%=v.getNic()%>'
                    		ii==nic?q++:q;
                    	<%}%>
                    q!=0?alert('사용중인 닉네임 입니다.'):alert('사용 가능');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#butt4").on("click",function(){
                    let email = $('#email').val();
                    let ii;
                    let q = 0;
                    <%
                    	for(vod v: vo){%>
                    		ii='<%=v.getEmail()%>'
                    		ii==email?q++:q;
                    	<%}%>
                    q!=0?alert('사용중인 주소 입니다.'):alert('인증번호를 발송했습니다.');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#butt5").on("click",function(){
                    let pn = $('#pn1').val() +"-"+ $('#pn2').val();
                    let ii;
                    let q = 0;
                    <%
                   			for(vod v: vo){%> 
                    		ii='<%=v.getPn()%>'
                    		ii==pn?q++:q;
		                    console.log(pn);
                    		console.log(<%=v.getPn()%>)
                    	<%}%>
                    q!=0?alert('이미 계정이 있습니다.'):alert('확인됬습니다.');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#butt6").on("click",function(){
                    let phone = $('#phone1').val() + "-" + $('#phone2').val()+ "-" + $('#phone3').val();
                    let ii;
                    let q = 0;
                    <%
                   			for(vod v: vo){%> 
                    		ii='<%=v.getPn()%>'
                    		ii==pn?q++:q;
		                    console.log(phone);
                    		console.log(<%=v.getPhone()%>)
                    	<%}%>
                    q!=0?alert('이미 계정이 있습니다.'):alert('확인됬습니다.');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        </script>
</body>
</html>
<% }else if(request.getParameter("ID") != null){%>
<title>javafood</title>
</head>
<body>
	<% for(vod v:vo){
		if(request.getParameter("ID").equals(v.getId())){
			System.out.println("아이디 일치");
			if(request.getParameter("PW").equals(v.getPw())){
				System.out.println("페스워드 일치"); %>
				<h1>javafood 로그인성공</h1>
				<h1><%=v.getNic() %> 님 환영합니다.</h1>
</body>
</html>
			<%} 
		} 
	}%>
<%}else {%>
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
</body>
</html>
<%}%>