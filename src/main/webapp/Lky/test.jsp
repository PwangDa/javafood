<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" value="abc" name="ajax1">
	<input type="button" value="test" name="ajax">
<script>
	$.ajax({
		type : "get",
		url:"http://localhost:8080/javafood_team/Lky/test.jsp?id=1",
				datatype : "text",
				error : function () {
					
				}
	})
</script>
</body>
<audio controls><source src="https://www.youtube.com/embed/11cta61wi0g.mp4"></audio>
</html>