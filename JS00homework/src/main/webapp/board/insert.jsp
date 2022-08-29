<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<h1>Board</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>게시글 작성</h3>
	<form action="insertOK.do" method="get">
		<table>
			<tbody>
				<tr>
					<td><label for="num">번호</label></td>
					<td><input type="text" placeholder="NUM" id="num" name="num" value="1"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="title">제목</label></td>
					<td><input type="text" placeholder="TITLE" id="title" name="title" value="homework"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="content">종류</label></td>
					<td><input type="text" placeholder="CONTENT" id="content" name="content" value="JSP_homework"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="writer">작성자</label></td>
					<td><input type="text" placeholder="WRITER" id="writer" name="writer" value="lee"></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td><input type="submit" value="작성"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>