<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>전공추가</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>전공추가</h3>
	<form action="insert_majorOK.do" method="post">
		<label for="major_name">전공이름:</label>
		<input type="text"placeholder="major_name" id="major_name" name="major_name" value="major">
		<br>
		 
		<label for="min_credit">최소학점:</label>
		<input type="text" placeholder="min_credit" id="min_credit" name="min_credit" value="120">
		<br>
		
		<label for="max_credit">최소학점:</label>
		<input type="text" placeholder="max_credit" id="max_credit" name="max_credit" value="200">
		<br> 
		
		<input type="submit" value="전공추가">
	</form>
</body>
</html>