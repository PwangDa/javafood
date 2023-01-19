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
						<th>차트</th>
				 		<tr>
				 		<td>노래번호</td>
				 		<td>
				 		<input type='text' name='songnumber'>
				 		</td>
				 		</tr>
						<tr>
				 		<td>아티스트명</td>
				 		<td>
				 		<input type='text' name='artistname'>
				 		</td>
				 		</tr>
				 		<tr>
						<td>노래제목</td>
				 		<td>
				 		<input type='text' name='songname'>
				 		</td>
				 		</tr>
				 		<tr>
				 		<tr>
				 		<td>장르</td>
				 		<td>
				  		<input type='text' name='bygenre'>
				 		</td>
				 		</tr>	
				 		<tr>
				 		<tr>
				 		<td>조회수</td>
				 		<td>
				  		<input type='text' name='hits'>
				 		</td>
				 		</tr>
				 		<tr>
				 		<tr>
				 		<td>좋아요</td>
				 		<td>
				  		<input type='text' name='likes'>
				 		</td>
						</tr>
				 		<tr>
				 		<tr>
				 		<td>링크</td>
				 		<td>
				  		<input type='text' name='link'>
				 		</td>
				 		</tr>
				 		<tr>
				 		<tr>
				 		<td>순위</td>
				 		<td>
				  		<input type='text' name='ranking'>
				 		</td>
				 		</tr>
				 		<tr>
				 </table>
			<input type="button" value="업데이트" onclick="fn_send()">
			<input type="hidden" name="히든" value="updateSong">
	</form>
</body>
</html>