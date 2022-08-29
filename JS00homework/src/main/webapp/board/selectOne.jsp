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
	<h3>게시글</h3>
	<table>
      <tbody>
         <tr>
            <td><label for="num">NUM</label></td>
            <td colspan="2">${param.num}</td>
         </tr>
         <tr>
            <td><label for="tilte">TITLE</label></td>
            <td colspan="2">${vo.title}</td>
         </tr>
         <tr>
            <td><label for="content">CONTENT</label></td>
            <td colspan="2">${vo.content}</td>
         </tr>
         <tr>
            <td><label for="writer">WRITER</label></td>
            <td colspan="2">${vo.writer}</td>
         </tr>
         <tr>
			<td></td>
            <td colspan="2">
				<a href="update.do?num=${param.num}">게시글수정</a>
				<a href="delete.do?num=${param.num}">게시글삭제</a>
			</td>
         </tr>
      </tbody>
   </table>
</body>
</html>