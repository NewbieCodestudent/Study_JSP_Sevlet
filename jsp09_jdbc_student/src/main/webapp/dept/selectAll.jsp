<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과목록</title>
</head>
<body>
	<h1>학과목록</h1>
	<table border="1">
		<tr>	
			<th>dept_id</th>
			<th>dept_name</th>
			<th>mgr_id</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
			<tr>
				<td>${vo.dept_id}</td>
				<td>${vo.dept_name}</td>
				<td>${vo.mgr_id}</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>