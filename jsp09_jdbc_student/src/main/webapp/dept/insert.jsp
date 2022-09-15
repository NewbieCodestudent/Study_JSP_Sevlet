<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학과추가</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	$(function(){
		console.log("ready....");
		
		$.get("json_st_id.do",function(responseText){
// 			console.log(".get : ",responseText);
			let ids = JSON.parse(responseText);//10~270
			console.log(".get : ",ids);
			ids.forEach(function(id){
				$("#mgr_id").append(
					'<option value="'+id+'">'+id+'</option>');
			});
			
		});
		
		
		
		
		
	});
</script>
</head>
<body>
	<h1>학과추가</h1>
	<form action="d_insertOK.do" method="post">
		<label for="dept_name">dept_name:</label>
		<input type="text" placeholder="dept_name" id="dept_name"
			name="dept_name" value="컴공과">
		<br> 
		
		<label for="mgr_id">mgr_id:</label>
		<select id="mgr_id" name="mgr_id">
		</select><br>
		<input type="submit" value="학과추가">
	</form>

</body>
</html>