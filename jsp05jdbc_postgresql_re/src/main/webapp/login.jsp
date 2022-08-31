<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<h3>Login</h3>
	<jsp:include page="top_menu.jsp"></jsp:include>

	<form action="loginOK.do" method="post">
		<table>
			<tr>
				<td><label for="id">ID:</label></td>
				<td><input type="text" placeholder="ID" id="id" name="id"
					value="admin"></td>
			</tr>
			<tr>
				<td><label for="pw">PW:</label></td>
				<td><input type="password" placeholder="PW" id="pw" name="pw"
					value="hi1234"></td>
			</tr>
			<tr>
					<td></td>
					<td><input type="submit" value="로그인"></td>
				</tr>
		</table>
	</form>

</body>
</html>