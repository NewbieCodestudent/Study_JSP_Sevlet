<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp08_jdbc_oracle/>Home</a></h1>
	<h3>사원정보</h3>
	<table>
		<thead>
			<td>직원번호</td>
			<td>성</td>
			<td>이름</td>
			<td>봉급</td>
			<td>직책</td>
			<td>부서번호</td>
		</thead>
		<c:forEach var="vo" items="${vos}">
		<tbody>
			<td>${vo.employee_id}</td>
			<td>${vo.last_name}</td>
			<td>${vo.first_name}</td>
			<td>${vo.salary}</td>
			<td>${vo.job_id}</td>
			<td>${vo.department_id}</td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>