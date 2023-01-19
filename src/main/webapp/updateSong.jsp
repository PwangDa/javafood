<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function fn_send(){
		document.update.method = "post";
		document.update.action = "javafood_team/song";
		document.update.submit();
	}
</script>
</head>
<body>
	<form name="update" action="javafood_team/song">
						<table>
					<tr>
                        <th>노래제목</th>
                        <th>아티스트 이름</th>
                    </tr>
				 </table>
			<input type="button" value="업데이트" onclick="fn_send()">
			<input type="hidden" name="히든" value="updateSong">
	</form>
</body>
</html>