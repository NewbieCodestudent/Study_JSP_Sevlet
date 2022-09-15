<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서정보</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp08_jdbc_oracle/>Home</a></h1>
	<h3>부서정보</h3>
	<table>
		<thead>
			<td>부서번호</td>
			<td>부서이름</td>
			<td>관리자번호</td>
			<td>지역번호</td>
		</thead>
		<c:forEach var="vo" items="${vos}">
		<tbody>
			<td>${vo.department_id}</td>
			<td>${vo.department_name}</td>
			<td>${vo.manager_id}</td>
			<td>${vo.location_id}</td>
			<td><a href="d_delete.do?department_id=${vo.department_id}">삭제</a></td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>