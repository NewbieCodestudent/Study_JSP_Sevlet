<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전공목록</title>
</head>
<body>
	<h1>전공목록</h1>
	<table border="1">
		<tr>	
			<th>major_id</th>
			<th>major_title</th>
			<th>min_score</th>
			<th>max_score</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.major_id}</td>
				<td>${vo.major_title}</td>
				<td>${vo.min_score}</td>
				<td>${vo.max_score}</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>