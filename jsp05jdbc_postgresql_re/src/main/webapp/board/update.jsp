<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
<link rel="stylesheet" href="css/menu.css">

</head>
<body>
	<h3>글수정</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form action="b_updateOK.do" method="post">
		<table>
			<tbody>
				<tr>
					<td><label for="num">글번호:</label></td>
					<td>${param.num}<input type="hidden" id="num" name="num"
						value="${param.num}"></td>
				</tr>
				<tr>
					<td><label for="title">제목:</label></td>
					<td><input type="text" placeholder="제목" id="title" name="title"
						value="${vo2.title}"></td>
				</tr>
				<tr>
					<td><label for="content">내용:</label></td>
					<td>
						<textarea  id="content" name="content" 
						   rows="5" cols="30">${vo2.content}</textarea>
					</td>
				</tr>
				<tr>
					<td><label for="writer">작성자:</label></td>
					<td><input type="text" placeholder="작성자" id="writer"
						name="writer" value="${vo2.writer}"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="수정완료"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>