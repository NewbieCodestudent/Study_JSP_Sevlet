<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대학정보_join</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>대학정보_join</h3>
	<table>
		<thead>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학과번호</td>
			<td>학과이름</td>
			<td>과대번호</td>
			<td>전공번호</td>
			<td>전공이름</td>
			<td>최소학점</td>
			<td>최대학점</td>
			<td>이수학점</td>
		</thead>
		<c:forEach var="vo" items="${vos}">
		<tbody>
			<td>${vo.student_id}</td>
			<td>${vo.student_name}</td>
			<td>${vo.department_id}</td>
			<td>${vo.department_name}</td>
			<td>${vo.department_number}</td>
			<td>${vo.major_id}</td>
			<td>${vo.major_name}</td>
			<td>${vo.min_credit}</td>
			<td>${vo.max_credit}</td>
			<td>${vo.student_credit}</td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>