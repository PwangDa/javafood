<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<iframe id="프레임네임"  src=""  width="530"> </iframe>


<form name="폼네임">
	<input type="text" id="id" name="id" value="user1"/>
	<input type="hidden" id="password" name="password" value="myNameis"/>
	<input type="submit" value="제출">
</form>


<script>
    document.폼네임.target = "프레임네임";
    document.폼네임.submit();

</script>
</body>
</html>