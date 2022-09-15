<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과정보</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>학과정보</h3>
	<table>
		<thead>
			<td>학과번호</td>
			<td>학과이름</td>
			<td>과대번호</td>
		</thead>
		<c:forEach var="vo" items="${vos}">
		<tbody>
			<td>${vo.department_id}</td>
			<td>${vo.department_name}</td>
			<td>${vo.department_number}</td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>