<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="My_Page.*"%>
<!DOCTYPE html>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<meta charset="UTF-8">
<%
	dbon db = new dbon(); 
	if(request.getParameter("Id1")!=null){
		vod vo1 = new vod();
		vo1.setId(request.getParameter("Id1"));
		vo1.setPw(request.getParameter("PW1"));
		vo1.setNic(request.getParameter("nic"));
		vo1.setPn(request.getParameter("pn1")+"-"+request.getParameter("pn2"));
		vo1.setPhone(request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3"));
		vo1.setEmail(request.getParameter("mail"));
		db.addId(vo1);
		%><script>alert("회원가입 성공")</script>  <%
	}
	
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
   .tr{height: 80px; }
   input[type="checkbox"]{display: none;}
</style>
</head>
<body>
        <h1>javafood 회원가입</h1>
        <form method="post" action="login.jsp">
            <div class="head">
              <table>
        <tr class="tr">
            <th>아이디 : </th>
            <td><input type="text" name="Id1" id="Id1" placeholder="아이디를 입력하시오"></td>
            <td><input type="button" id="idbutt" value="중복 확인"></td>
            <td><input type="checkbox" id="ch1" class="ch"></td>
        </tr>
        <tr>
            <th>비밀번호 1 :  </th>
            <td><input type="password" id="pw1" name="PW1"placeholder="비밀번호를 입력하시오"></td>
            <td rowspan="2"><input type="button" id="pwbutt" value="일치 확인"></td>
            <td><input type="checkbox" id="ch2" class="ch"></td>
        </tr>
        <tr>
            <th>비밀번호 2 : </th>
            <td><input type="password" id="pw2" placeholder="다시입력하시오"></td>
            <td></td>
        </tr>
        <tr class="tr">
            <th>닉네임 : </th>
            <td><input type="text" id="nic" name="nic" placeholder="닉네임"></td>
            <td><input type="button" id="nicbutt" value="중복확인"></td>
            <td><input type="checkbox" id="ch3" class="ch"></td>
        </tr>
        <tr>
            <th>이메일 : </th>
            <td><input type="text" id="email" name="mail" placeholder="mail@naver.com"></td>
            <td><input type="button" id="mailbutt" value="인증하기"></td>
            <td><input type="checkbox" id="ch4" class="ch"></td>
        </tr>
        <tr id="mail">
            <th>인증번호 : </th>
            <td><input type="text" placeholder="메일 인증번호"></td>
            <td><input type="button" id="mailchbutt" value="인증확인"></td>
            <td><input type="checkbox" id="ch5" class="ch"></td>
        </tr>
        <tr>
            <th id="pn" class="tr">주민등록 번호 : </th>
            <td>
                <input type="text" class="pn" name="pn1" id="pn1" placeholder="911222">
                <input type="password" class="pn" name="pn2" id="pn2" placeholder="1234567">
            </td>
            <td><input type="button" id="pnbutt" value="중복확인"></td>
            <td><input type="checkbox" id="ch6" class="ch"></td>
        </tr>
        <tr>
            <th class="tr">휴대폰 번호 : </th>
            <td>
                <input type="text" class="phone" name="phone1" id="phone1" placeholder="010">
                <input type="text" class="phone" name="phone2" id="phone2" placeholder="1234">
                <input type="text" class="phone" name="phone3" id="phone3" placeholder="4567">
            </td>
            <td><input type="button" id="phonebutt" value="연락처 확인"></td>
            <td><input type="checkbox" id="ch7" class="ch"></td>
        </tr>
        <tr>
            <th><a href="login.jsp" class="at">취소</a></th>
            <th><input class="sub" type="submit" value="회원가입" id="end"disabled></th>
            <th><input class="sub" type="reset" id="re" value="다시작성"></th>
        </tr>
    </table>
            </div>
        </form>
        <div class="body"></div>
        <script>
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				$('#re').on('click',function(){
                    $('#end').attr('disabled',true);
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    let c= false;
                    function aj(key, callback, chak){
                        let xml = new XMLHttpRequest();
                        xml.open('get','http://localhost:8080/javafood_team/aj?'+key);
                        xml.send();
                        xml.onload=function(){
                        	let z = 0;
                        	c=xml.responseText;
                        	if(c!=1){
                                z=1;
                        		alert('사용가능.');
                        	}else{
                                z=0;
                        		alert('사용중입니다.');
                        	}
                           callback(z,chak);
                        }
                    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    function fn(call,chak){
                        call!=1?$(chak).prop('checked',false):$(chak).prop('checked',true);
                        let j=0;
                        for(let i =0; i<$('.ch').length; i++){
                            if($('.ch')[i].checked==true)j++;
                        }
                        j==6?$('#end').attr('disabled',false):$('#end').attr('disabled',true);
                    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				$('#idbutt').on('click',function(){
					aj("id="+$('#Id1').val(), fn, '#ch1');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#pwbutt").on("click",function(){
                    if($("#pw1").val() == $("#pw2").val()){
                        alert("비밀번호가 일치합니다.");
                        fn(1,'#ch2');
                    }else {
                        alert("잘못입력 하셨습니다.");
                        fn(0,'#ch2');
                    }
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#nicbutt").on("click",function(){
                    aj("nic="+$('#nic').val(), fn, '#ch3');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#mailbutt").on("click",function(){
                    aj('email='+$('#email').val(), fn, '#ch4')
                })
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#pnbutt").on("click",function(){
                    let pn = 'pn='+$('#pn1').val() +"-"+ $('#pn2').val();
                    aj(pn,fn,'#ch6');
                })
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                $("#phonebutt").on("click",function(){
                    let phone = 'phone='+$('#phone1').val() + "-" + $('#phone2').val()+ "-" + $('#phone3').val();
                    aj(phone,fn,'#ch7');
                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        </script>
</body>
</html>
<% }else if(request.getParameter("ID") != null){%>
<title>javafood</title>
</head>
<body>
	<% int a =0;
		for(vod v:vo){
		if(request.getParameter("ID").equals(v.getId())){
			System.out.println("아이디 일치");
			a++;
			if(request.getParameter("PW").equals(v.getPw())){
				System.out.println("페스워드 일치");a++; %>
				<h1>javafood 로그인성공</h1>
				<h1><%=v.getNic() %> 님 환영합니다.</h1>
				<strong id="time"></strong>초후에 이동됩니다. 마음의 준비를 해주세요.
				<%request.getSession().setAttribute("login", request.getParameter("ID")); %>
				<script>
				let time=5;
                $("#time").append(time);
                    setInterval (function(){
                        console.log(time);
                        time--;
                        $("#time").text(time);
                    	if (time==0){
                            location.href='http://localhost:8080/javafood_team/one/main.jsp';
                        }
                    },1000)
				</script>
</body>
</html>
			<%}
		}
	}
	if(a==0){%> <script>alert('아이디가 틀렸습니다.');location.href='http://localhost:8080/javafood_team/Lky/login.jsp';</script> <%}
	else if(a==1){%> <script>alert('페스워드가 틀렸습니다.');location.href='http://localhost:8080/javafood_team/Lky/login.jsp';</script> <%}
	%>
<%}else {%>
<title>javafood 로그인</title>
<style>
	body{background-size: contain; color: white; background-position: center; text-align: center;background-color: black;}
    div{display: inline-block;  width: 100%; height: 100px;}
    .sub{margin-top: 10px;width: 100px; height: 30px;}
    .at{color: white; text-decoration: none;}
    .head{margin-top: 50px;}
</style>
</head>
<body>
	<h1>javafood 로그인</h1>
    <form method="post" action="login.jsp">
        <div class="head">
             아 이 디 &nbsp;: <input type="text" name="ID"><br><br>
            비밀번호 : <input type="text" name="PW"><br><br>
            <a href="login.jsp?new=O" class="at">회원가입</a>
            <input class="sub" type="submit" value="로그인">
            <input class="sub" type="reset" value="다시작성">
        </div>
    </form>
    <div class="body"></div>
</body>
</html>
<%}%>