<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>Board</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>게시글 수정</h3>
	<form action="updateOK.do" method="get">
		<table>
			<tbody>
				<tr>
					<td><label for="num">NUM</label></td>
					<td>${param.num}<input type="hidden" placeholder="NUM" id="num" name="num" value="${param.num}"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="title">TITLE</label></td>
					<td><input type="text" placeholder="TITLE" id="title" name="title" value="${vo2.title}"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="content">CONTENT</label></td>
					<td><input type="text" placeholder="CONTENT" id="content" name="content" value="${vo2.content}"></td>
					<td></td>
				</tr>
				<tr>
					<td><label for="writer">WRITER</label></td>
					<td><input type="text" placeholder="WRITER" id="writer" name="writer" value="${vo2.writer}"></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td colspan="3"><input type="submit" value="수정완료"></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>