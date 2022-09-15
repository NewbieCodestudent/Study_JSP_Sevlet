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

<script>
	$(function(){
		console.log("ready....");
	});
</script>
</head>
<body>
	<h1>전공추가</h1>
	<form action="m_insertOK.do" method="post">
		<label for="major_id">major_id:</label>
		<input type="text" placeholder="major_id" id="major_id"
			name="major_id" value="SOFT_DEV">
		<br> 
		<label for="major_title">major_title:</label>
		<input type="text" placeholder="major_title" id="major_title"
			name="major_title" value="소프트웨어 공학">
		<br> 
		
		<label for="min_score">min_score:</label>
		<select id="min_score" name="min_score">
			<option value="0">0</option>
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
			<option value="40">40</option>
			<option value="50">50</option>
		</select><br>
		<label for="max_score">max_score:</label>
		<select id="max_score" name="max_score">
			<option value="60">60</option>
			<option value="70">70</option>
			<option value="80">80</option>
			<option value="90">90</option>
			<option value="100">100</option>
		</select><br>
		<input type="submit" value="전공추가">
	</form>

</body>
</html>