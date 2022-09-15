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
		$.get("json_dept_id.do",function(responseText){
			let dept_ids = JSON.parse(responseText);
			console.log(".get : ",dept_ids);
			dept_ids.forEach(function(dept_id){
				$("#department_id").append(
					'<option value="'+dept_id+'">'+dept_id+'</option>');
			});
		});
		$.get("json_major_id.do",function(responseText){
			let major_ids = JSON.parse(responseText);
			console.log(".get : ",major_ids);
			major_ids.forEach(function(major_id){
				$("#major_id").append(
					'<option value="'+major_id+'">'+major_id+'</option>');
			});
		});
	});
</script>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>학생추가</h3>
	<form action="insert_studentOK.do" method="post">
		<label for="student_name">student_name : </label>
		<input type="text" placeholder="student_name" id="student_name" name="student_name" value="GilDong">
		<br>
		 
		<label for="department_id">학과번호:</label>
		<select id="department_id" name="department_id"></select>
		<br>
				 
		<label for="major_id">전공번호:</label>
		<select id="major_id" name="major_id"></select>
		<br>
		
		<label for="student_credit">이수학점:</label>
		<input type="text" placeholder="student_credit"id="student_credit" name="student_credit" value="120"><br> 
		<input type="submit" value="학생추가">
	</form>
</body>
</html>