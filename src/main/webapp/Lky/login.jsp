<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javafood 로그인</title>
<style>
	body{background-size: contain; color: white; background-position: center; text-align: center; background-image: url(https://velog.velcdn.com/images/gigymi2005/post/c941bf05-995a-4b90-a4b5-63ecd6b5374f/pankaj-patel-u2Ru4QBXA5Q-unsplash.jpg);}
    div{display: inline-block; border: 1px solid red; width: 100%; height: 100px;}
    .sub{margin-top: 10px;width: 100px; height: 30px;}
</style>
</head>
<body>
	<h1>javafood 로그인</h1>
    <form method="post" action="http://localhost:8080/javafood_team/main">
        <div class="head">
             아 이 디 &nbsp;: <input type="text" name="ID"><br>
            비밀번호 : <input type="text" name="PW"><br>
            <input class="sub" type="submit" value="로그인">
            <input class="sub" type="reset" value="다시작성">
        </div>
    </form>
    <div class="body"></div>
</body>
</html>