<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>학생추가</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
	$(function(){
		console.log("ready....");
		
		$.get("json_major_id.do",function(responseText){
// 			console.log(".get : ",responseText);
			let ids = JSON.parse(responseText);//10~270
			console.log(".get : ",ids);
			ids.forEach(function(id){
				$("#major_id").append(
					'<option value="'+id+'">'+id+'</option>');
			});
			
		});
		
		$.get("json_dept_id.do",function(responseText){
// 			console.log(".get : ",responseText);
			let ids = JSON.parse(responseText);//10~270
			console.log(".get : ",ids);
			ids.forEach(function(id){
				$("#dept_id").append(
					'<option value="'+id+'">'+id+'</option>');
			});
			
		});
	});
</script>
</head>
<body>
	<h1>학생추가</h1>
	<form action="s_img_insertOK.do" method="post" enctype="multipart/form-data">
		<label for="st_name">st_name:</label>
		<input type="text" placeholder="st_name" id="st_name"
			name="st_name" value="홍길동">
		<br> 
		<label for="score">score:</label>
		<input type="number" placeholder="score" id="score"
			name="score" value="90">
		<br> 
		
		<label for="major_id">major_id:</label>
		<select id="major_id" name="major_id">
		</select><br>
		<label for="dept_id">dept_id:</label>
		<select id="dept_id" name="dept_id">
		</select><br>
		<label for="img_file">score:</label>
		<input type="file" id="img_file"
			name="img_file">
		<br> 
		<input type="submit" value="학생추가">
	</form>

</body>
</html>