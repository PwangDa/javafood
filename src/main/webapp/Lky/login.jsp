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
    <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
    <script>
			(function (){  
				document.onmousemove=function (e){ var ob=document.getElementById("foo").style; ob.left=e.pageX+15+"px"; ob.top=e.pageY+15+"px";}
				document.write("<img src='https://tistory1.daumcdn.net/tistory/4694508/skin/images/hai1.gif' id='foo' style='position:absolute; transition:all 0.3s ease-in; z-index: 1;'>");
			}());
	</script>
<meta charset="UTF-8">

<c:if test="${good!=null }">
	<c:if test="${good==1 }">
		<script>alert("회원가입 성공")</script>
	</c:if>
	<c:if test="${good==0 }">
		<script>alert("회원가입 실패")</script>
	</c:if>
</c:if>

<c:if test="${re!=null }">
	<script>
		alert('다시 로그인 해주세요.')
	</script>
</c:if>

<c:if test="${membership!=null }">
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
		<h1><c:out value="javafood 회원가입"/></h1>
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
		 <script>
			function but(){
				var url = $("#form").attr("action");
				var form = $('#form')[0];
				var formData = new FormData(form);
				$.ajax({
					url: url,
					type: 'POST',
					data: formData,
					contentType: false,
					processData: false,
					cache: false,
					success: function () {
						alert("이미지 저장 성공")
						location.href='javafood?javafood=4&membership=O';
					},
					error: function () {
						alert("이미지 저장 실패")
					}
				})
			}
			</script> 
	        
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	                $("#pnbutt").on("click",function(){
	                    let pn = 'pn='+$('#pn1').val() +"-"+ $('#pn2').val();
	                    aj(pn,fn,'#ch6');
	                })
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	                $("#phonebutt").on("click",function(){
	                    let phone = 'phone='+$('#phone1').val() + "-" + $('#phone2').val()+ "-" + $('#phone3').val();
	                    aj(phone,fn,'#ch7');
	                })
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        </script>
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
		<script>
			let time=3;
	    	$("#time").append(time);
	        setInterval (function(){
	        	console.log(time);
	            time--;
	            $("#time").text(time);
	            if (time==0){
	            	location.href='javafood?javafood=m';
	            	}
	         	},1000)
		</script>
	</body>
	</html>
 </c:if>
<c:if test="${log==0 }">
	 <script>alert('아이디가 틀렸습니다.');location.href='javafood?javafood=4';</script>
</c:if>
<c:if test="${log==1 }">
	 <script>alert('페스워드가 틀렸습니다.');location.href='javafood?javafood=4';</script>
</c:if>
<c:if test="${membership==null&&log==null }">
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
	
		<h1><c:out value="javafood 로그인"/></h1>
	    <form method="post" action="javafood?javafood=4">
	        <div class="head">
	             <c:out value="아 이 디 : "/>&nbsp;<input type="text" name="ID"><br><br>
	            <c:out value=" 비밀번호 : "/><input type="text" name="PW"><br><br>
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
