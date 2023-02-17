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

<form id="form" class="form-horizontal" enctype="multipart/form-data" 
		action="http://localhost:8080/javafood_team/aj"  
		accept-charset="utf-8">
	<input type="text" class="form-control needs-validation" name="writerEmail">
	<input type="file" name="attachFile">
	<input type="submit" id="btn_submit">
</form>


<script>
      $("#btn_submit").on("click", function (event) {

        var url = $("#form").attr("action");
        var form = $('#form');
        var formData = new FormData(form);
        
        $.ajax({
          url: url,
          type: 'POST',
          data: formData,
          success: function (data) {
          	alert(data)

          },
          error: function (data) {
            alert(data);
          },
          cache: false,
          contentType: false,
          processData: false
        });
</script>





<%--
		파일1 : <input type="file" name="file1" multiple /><br>
		매개변수1 : <input type="text" name="param1"><br>
		<input type="hidden"  value="img" name="img">
		<input type="button"  value="업로드" id="but">


	<script>
		$('#but').on("click",function(){
			var data = new FormData();
			var input= $('input[name="file1"]');
			var files = inputFile[0].files;
			
			data.append('key1','value1');
			data.append('key2','value2');
			
			for(var i=0; i<files.length; i++){
				data.append('uploadFiles',files[i]);
			}
			$.ajax({
				contentType : false,
				processData: false,
				data : formData,
				url : 'http://localhost:8080/javafood_team/aj?img=img',
				type : 'POST',
				success : function(result){
					if(result.result ==='success'){
						alert('success to upload')
					}else{
						alert('fail to upload')
					}
				}
			})
		})
 	</script> 
 	 --%>
</body>
</html>