<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>부서추가</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function(){
		$.get("json_mana_id.do",function(responseText){let mana_ids = JSON.parse(responseText);
		console.log(".get : ",mana_ids);
		mana_ids.forEach(function(mana_id){
			$("#manager_id").append('<option value="'+mana_id+'">'+mana_id+'</option>');
			});
		});
		
		$.get("json_loc_id.do",function(responseText){let loc_ids = JSON.parse(responseText);
		console.log(".get : ",loc_ids);
		loc_ids.forEach(function(loc_id){
			$("#location_id").append('<option value="'+loc_id+'">'+loc_id+'</option>');
			});
		});
	});
</script>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp08_jdbc_oracle/>Home</a></h1>
	<h3>부서추가</h3>
	<form action="d_insertOK.do" method="post">
		<label for="department_name">department_name:</label>
		<input type="text" placeholder="department_name" id="department_name"name="department_name" value="부서이름"><br>
		<label for="manager_id">manager_id:</label>
		<select id="manager_id" name="manager_id"></select><br>
		<label for="location_id">location_id:</label>
		<select id="location_id" name="location_id"></select><br>
		<input type="submit" value="부서추가">
	</form>
</body>
</html>