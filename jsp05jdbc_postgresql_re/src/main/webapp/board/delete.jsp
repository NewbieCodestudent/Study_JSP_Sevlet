<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글삭제</title>
<link rel="stylesheet" href="css/menu.css">

</head>
<body>
	<h3>글삭제</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>

	<table>
		<tbody>
			<tr>
				<td><label for="num">NUM:</label></td>
				<td colspan="2">${param.num}</td>
			</tr>
			<tr>
				<td colspan="2">정말 삭제하시겠습니까?</td>
				<td><a href="b_deleteOK.do?num=${param.num}">삭제완료</a></td>
			</tr>
		</tbody>
	</table>
</body>
</html>