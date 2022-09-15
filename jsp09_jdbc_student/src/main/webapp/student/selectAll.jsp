<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생목록</title>
</head>
<body>
	<h1>학생목록</h1>
	<table border="1">
		<tr>	
			<th>st_id</th>
			<th>st_name</th>
			<th>score</th>
			<th>major_title</th>
			<th>dept_name</th>
			<th>프사</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.st_id}</td>
				<td>${vo.st_name}</td>
				<td>${vo.score}</td>
				<td>${vo.major_title}</td>
				<td>${vo.dept_name}</td>
				<td><img width="50px" alt="${vo.st_name}" src="uploadimg/${vo.img_name}"> </td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>