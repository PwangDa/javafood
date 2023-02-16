<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>


	<form id="form" method="post" action="http://localhost:8080/javafood_team/aj" 
		   enctype="multipart/form-data" 
		   accept-charset="utf-8">
		파일1 : <input type="file" name="file1"><br>
		매개변수1 : <input type="text" name="param1"><br>
		<input type="button" onclick="but()" value="업로드">
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
						alert("성공")
					},
					error: function () {
						alert("실패")
					}
				})
			}
		</script> 
</body>
</html>