<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전공정보</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>전공정보</h3>
	<table>
		<thead>
			<td>전공번호</td>
			<td>전공이름</td>
			<td>최소학점</td>
			<td>최대학점</td>
		</thead>
		<c:forEach var="vo" items="${vos}">
		<tbody>
			<td>${vo.major_id}</td>
			<td>${vo.major_name}</td>
			<td>${vo.min_credit}</td>
			<td>${vo.max_credit}</td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>