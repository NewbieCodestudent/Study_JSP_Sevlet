<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="css/menu.css">

</head>
<body>
	<h3>글쓰기</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form action="b_insertOK.do" method="post">
		<table>
			<tbody>
				<tr>
					<td><label for="title">제목:</label></td>
					<td><input type="text" placeholder="제목" id="title" name="title"
						value="jsp servlet"></td>
				</tr>
				<tr>
					<td><label for="content">내용:</label></td>
					<td>
						<textarea  id="content" name="content" 
						   rows="5" cols="30">Hello java jsp servlet HTML5 javascript css</textarea>
					</td>
				</tr>
				<tr>
					<td><label for="writer">작성자:</label></td>
					<td><input type="text" placeholder="작성자" id="writer"
						name="writer" value="${user_id}"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="작성완료"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>