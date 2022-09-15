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
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>학과추가</h3>
	<form action="insert_departmentOK.do" method="post">
		<label for="department_name">학과이름:</label>
		<input type="text" placeholder="department_name" id="department_name" name="department_name" value="department_name">
		<br>
		
		<label for="department_number">과대번호:</label>
		<input type="text"placeholder="department_number" id="department_number" name="department_number" value="department_number">
		<br> 

		<input type="submit" value="학과추가">
	</form>
</body>
</html>