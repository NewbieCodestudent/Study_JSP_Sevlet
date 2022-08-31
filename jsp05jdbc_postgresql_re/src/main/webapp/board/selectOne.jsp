<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
<link rel="stylesheet" href="css/menu.css">

</head>
<body>
	<h3>글상세</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<table>
		<tbody>
			<tr>
				<td><label for="num">NUM:</label></td>
				<td colspan="2">${param.num}</td>
			</tr>
			<tr>
				<td><label>제목:</label></td>
				<td colspan="2">${vo2.title}</td>
			</tr>
			<tr>
				<td><label>내용:</label></td>
				<td colspan="2">${vo2.content}</td>
			</tr>
			<tr>
				<td><label>작성자:</label></td>
				<td colspan="2">${vo2.writer}</td>
			</tr>
			<tr>
				<td><label>작성일자:</label></td>
				<td colspan="2">${vo2.wdate}</td>
			</tr>
			<tr>
				<td colspan="3">
					<a href="b_update.do?num=${param.num}">회원수정</a>
					<a href="b_delete.do?num=${param.num}">회원삭제</a>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>