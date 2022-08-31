<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/select_one.css">

</head>
<body>
	<h3>회원정보</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<table>
		<tbody>
			<tr>
				<td><label for="num">NUM</label></td>
				<td colspan="2">${param.num}</td>
			</tr>
			<tr>
				<td><label for="profile">PROFILE</label></td>
				<td><img width="100" alt="${vo2.profile}" src="upload/${vo2.profile}"></td>
			</tr>
			<tr>
				<td><label>ID</label></td>
				<td colspan="2">${vo2.id}</td>
			</tr>
			<tr>
				<td><label>PW</label></td>
				<td colspan="2">${vo2.pw}</td>
			</tr>
			<tr>
				<td><label>NAME</label></td>
				<td colspan="2">${vo2.name}</td>
			</tr>
			<tr>
				<td><label>TEL:</label></td>
				<td colspan="2">${vo2.tel}</td>
			</tr>
			<tr>
				<td colspan="3">
					<a href="m_update.do?num=${param.num}">회원수정</a>
					<a href="m_delete.do?num=${param.num}">회원삭제</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>