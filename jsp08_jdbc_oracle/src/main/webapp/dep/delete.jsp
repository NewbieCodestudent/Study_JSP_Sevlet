<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서삭제</title>
</head>
<body>
	<h1><a href=http://localhost:8090/jsp08_jdbc_oracle/>Home</a></h1>
	<h3>부서삭제</h3>
	<table>
		<tbody>
			<tr>
				<td><label for="department_id">부서코드:</label></td>
				<td>${param.department_id}</td>
			</tr>
			<tr>
				<td colspan="2">정말 삭제하시겠습니까?</td>
				<td><a href="d_deleteOK.do?department_id=${param.department_id}">예</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>