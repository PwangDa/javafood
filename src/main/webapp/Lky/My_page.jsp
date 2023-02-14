<%@page import="java.util.List"%>
<%@page import="My_Page.dbon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html>
<html>
<head>
	<c:if test="${link!=null }">	<script>location.href='${link }'</script>	</c:if> 
	<c:if test="${login==null }">
		<script>
			alert('로그인을 하셔야합니다.')
            location.href='javafood?javafood=4';
		</script>
	</c:if>
<meta charset="UTF-8">
<title>My Page</title>
 <style>      
         body{background-color :black; cursor: url("https://zrr.kr/Wlm3"), auto;}
 		 div{text-align: center;     width: 100%; height: 100%; display: inline-block;    }
        .head{width: 100%; position: sticky;top:0px; height: 100px; background-color: black; color: white;}
        .body{height: 100%; text-align: center;margin: 30px;}
        .left{width: 88%;float: left; font-size: 60px;}
        .right{line-height: 80px; width: 11%;float: right; background-image:url(${session_user.myimg}); background-repeat: no-repeat; background-size: cover;background-position: center; }
        .tbody{ position: sticky;top: 100px; height: 40px; background: white;}
        input{vertical-align: middle;}
        .butt{font-size: 0px; background: url(https://zrr.kr/Ovva)no-repeat; border: none;width: 32px;height: 32px;cursor: pointer;}
        .text{ height: 30px;width: 350px; margin: 0;}
        table{margin: auto; border: 1px solid black; border-collapse: collapse;}
        th,td{border-top: 1px solid black;}
        th{background-color: cornflowerblue;}
        .low{background-color: darkkhaki;}
        tr.low:hover {background-color: rgb(148, 100, 237); border: 1px solid black;}
        .at{color: white; text-decoration: none;}
		input[type="checkbox"]{display: none;}
   </style>
   <script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<div style="width: 100%;height: 100%;">
        <div class="head">
            <div class="left"><a href="javafood?javafood=5" class="at"><strong><c:out value="My pages"/></strong></a></div>
            <div class="right"><strong0> <c:out value="${session_user.nic }"/></strong></div>
        </div>
        <div class="tbody">
       	<form method="get" action="javafood">
           <input type="hidden" name="javafood" value="5">
            <td>
                <select name="option" style="height: 30px;">
                    <option  value="sing"><c:out value="노래검색"/></option>
                    <option  value="man"><c:out value="가수검색"/></option>
                </select>
            </td>
            <td><input type="text" class="text" name="text"></td>
            <td><input type="submit" class="butt"></td>
        </form>
        <div style="color: white;"><a href="javafood?javafood=5&usre=${session_user.id }" class="at"><c:out value="${session_user.id } 의 재생기록 확인"/></a> </div>
        </div>
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
			
			
			
			<table>
				<h1 style="text-align: center; color: white;">회원정보 수정</h1>
				
		        <form method="post" action="javafood?javafood=4">
		            <div class="head">
		              <table>
		        <tr class="low"  style="text-align: left;">
		            <th style="text-align: right;"><c:out value=" 아이디 : "/></th>
		            <td colspan="2"><c:out value="${login }"/> </td>
		            <td></td>
		        </tr>
		        <tr class="low" style="text-align: left;">
		            <th style="text-align: right;"><c:out value="비밀번호 1 :  "/></th>
		            <td><input type="password" id="pw1" name="PW1"placeholder="비밀번호를 입력하시오"></td>
		            <td rowspan="2"><input type="button" id="pwbutt" value="일치 확인"></td>
		            <td><input type="checkbox" id="ch2" class="ch"></td>
		        </tr>
		        <tr class="low" style="text-align: left;">
		            <th style="text-align: right;"><c:out value="비밀번호 2 :  "/></th>
		            <td><input type="password" id="pw2" placeholder="다시입력하시오"></td>
		            <td></td>
		        </tr>
		        <tr class="low" style="text-align: left;">
		            <th style="text-align: right;"><c:out value="닉네임 : "/></th>
		            <td><input type="text" id="nic" name="nic" placeholder="닉네임"></td>
		            <td><input type="button" id="nicbutt" value="중복확인"></td>
		            <td><input type="checkbox" id="ch3" class="ch"></td>
		        </tr>
		        <tr class="low" style="text-align: left;">
		            <th style="text-align: right;"><c:out value="이메일 : "/></th>
		            <td><input type="text" id="email" name="mail" placeholder="mail@naver.com"></td>
		            <td><input type="button" id="mailbutt" value="인증하기"></td>
		            <td><input type="checkbox" id="ch4" class="ch"></td>
		        </tr>
		        <tr class="low" style="text-align: left;">
		            <th style="text-align: right;"><c:out value="인증번호 : "/></th>
		            <td><input type="text" placeholder="메일 인증번호"></td>
		            <td><input type="button" id="mailchbutt" value="인증확인"></td>
		            <td><input type="checkbox" id="ch5" class="ch"></td>
		        </tr>
		        <tr class="low" style="text-align: left;">
		            <th id="pn" class="tr" style="text-align: right;"><c:out value="주민등록 번호 : "/></th>
		            <td>
		                <input type="text" class="pn" name="pn1" id="pn1" placeholder="911222">
		                <input type="password" class="pn" name="pn2" id="pn2" placeholder="1234567">
		            </td>
		            <td style="text-align: right;"><input type="button" id="pnbutt" value="중복확인"></td>
		            <td><input type="checkbox" id="ch6" class="ch"></td>
		        </tr>
		        <tr class="low" style="text-align: left;">
		            <th class="tr" style="text-align: right;"><c:out value=" 휴대폰 번호 : "/></th>
		            <td>
		                <input type="text" class="phone" name="phone1" id="phone1" placeholder="010">
		                <input type="text" class="phone" name="phone2" id="phone2" placeholder="1234">
		                <input type="text" class="phone" name="phone3" id="phone3" placeholder="4567">
		            </td>
		            <td style="text-align: right;"><input type="button" id="phonebutt" value="연락처 확인"></td>
		            <td><input type="checkbox" id="ch7" class="ch"></td>
		        </tr>
		        <tr class="low">
		            <th><input type="hidden" name="remove" value="id"></th>
		            <th><a href="javafood?javafood=m" class="at"><c:out value=" 취 소 "/></a></th>
		            <th><input class="sub" type="submit" value="수정하기" id="end"disabled></th>
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
		                        j==5?$('#end').attr('disabled',false):$('#end').attr('disabled',true);
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
			</table>
				
                <%--
                if(request.getParameter("p")!=null){
                				List<login_DTO> vvo = db.uresong(a.get(0).getId());
                		                	for(int i=0; i<vvo.size(); i++) {
                %>
		                <tr class="low">
		                    <td><%=i+1%></td>
		                    <td><%=vvo.get(i).getArtistname()%></td>
		                    <td><a href="<%=vvo.get(i).getLink()%>" target="_blank" class="at"><%=vvo.get(i).getSongname()%></a></td>
		                    <td><%=vvo.get(i).getHits()%></td>
		                    <td>
		                    	<button type="button" onclick="javafood?javafood=5&id=<%=i%>'">재생</button>
		                    </td>
		                    <form>
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=vvo.get(i).getSongnumber()%>"> </td>
		                	</form>
		                </tr> <%
 } 
                 }else{
                 	if(request.getParameter("option")!=null){
 				List<login_DTO> vo1 = db.Search(request.getParameter("option"),request.getParameter("text"));
 		                	for(int i=0; i<vo1.size(); i++) {
 %>
		                <tr class="low">
		                    <td><%=i+1%></td>
		                    <td><%=vo1.get(i).getArtistname()%></td>
		                    <td><a href="<%=vo1.get(i).getLink()%>" target="_blank" class="at"><%=vo1.get(i).getSongname()%></a></td>
		                    <td><%=vo1.get(i).getHits()%></td>
		                    <td>
		                    	<button type="button" onclick="javafood?javafood=5&id=<%=i%>'">재생</button>
		                    </td>
		                    <form>
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=vo1.get(i).getSongnumber()%>"> </td>
		                	</form>
		                </tr> <%
 } 
                 	}else if(request.getParameter("option")==null){
                 		List<login_DTO> vo = db.list();
 		                for(int i=0; i<vo.size(); i++) {
 %>
		                <tr class="low">
		                    <td><%= i+1%></td>
		                    <td><%= vo.get(i).getArtistname() %></td>
		                    <td><a href="<%= vo.get(i).getLink() %>" target="_blank" class="at"><%= vo.get(i).getSongname() %></a></td>
		                    <td><%=	vo.get(i).getHits() %></td>
		                    <td>
		                    	<button type="button" onclick="javafood_team/javafood?javafood=5&id=<%=i%>'">재생</button>
		                    </td>
		                    <form>
		                    <td><input type="submit" value="좋아요"><input type="hidden" name="good" value="<%=i+1%>"> </td>
		                	</form>
		                </tr> <% }
		                } %>
    				<%if(request.getParameter("id")!=null){%><iframe width="560" height="315" src="https://www.youtube.com/embed/<%=db.link1(db.list().get(Integer.parseInt(request.getParameter("id"))))%>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen><%} %>
            </table>
        </div>
    </div>
    <script>
			
    </script>
    --%>
</body>
</html>
<%--}}--%>