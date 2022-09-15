<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>학생정보</h3>
	<table>
		<thead>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학과번호</td>
			<td>전공번호</td>
			<td>이수학점</td>
			<td>삭제</td>
		</thead>
		<c:forEach var="vo" items="${vos}">
		<tbody>
			<td>${vo.student_id}</td>
			<td>${vo.student_name}</td>
			<td>${vo.department_id}</td>
			<td>${vo.major_id}</td>
			<td>${vo.student_credit}</td>
			<td><a href="student_delete.do?student_id=${vo.student_id}&student_name=${vo.student_name}&department_id=${vo.department_id}&major_id=${vo.major_id}&student_credit=${vo.student_credit}">삭제</a></td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>