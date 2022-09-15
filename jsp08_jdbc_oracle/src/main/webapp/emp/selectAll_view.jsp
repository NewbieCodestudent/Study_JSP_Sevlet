<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원정보_join</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp08_jdbc_oracle/>Home</a></h1>
	<h3>사원정보</h3>
	<table>
		<thead>
			<td>emp_id</td>
			<td>emp_name</td>
			<td>salary</td>
			<td>dept_name</td>
			<td>job_title</td>
		</thead>
		<c:forEach var="vo" items="${vos}">
		<tbody>
			<td>${vo.emp_id}</td>
			<td>${vo.emp_name}</td>
			<td>${vo.salary}</td>
			<td>${vo.dept_name}</td>
			<td>${vo.job_title}</td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>