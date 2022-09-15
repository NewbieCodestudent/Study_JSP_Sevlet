<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생삭제</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp09_mission/>Home</a></h1>
	<h3>학생삭제</h3>
	<table>
		<thead>
			<td>학생번호</td>
			<td>학생이름</td>
			<td>학과번호</td>
			<td>전공번호</td>
			<td>이수학점</td>
		</thead>
		<tbody>
			<tr>
				<td><label for="student_id">${param.student_id}</label></td>
				<td><label for="student_name">${param.student_name}</label></td>
				<td><label for="department_id">${param.department_id}</label></td>
				<td><label for="major_id">${param.major_id}</label></td>
				<td><label for="student_credit">${param.student_credit}</label></td>
			</tr>
			<tr>
				<td colspan="4">정말 삭제하시겠습니까?</td>
				<td><a href="student_deleteOK.do?student_id=${param.student_id}">삭제완료</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>