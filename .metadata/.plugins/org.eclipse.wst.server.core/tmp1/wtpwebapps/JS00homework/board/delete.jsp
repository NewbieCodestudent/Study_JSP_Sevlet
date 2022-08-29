<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
	<h1>Board</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>게시글 작성</h3>
	<table>
      <tbody>
         <tr>
            <td colspan="2"><label for="num">NUM:</label></td>
            <td>${param.num}</td>
         </tr>
         <tr>
            <td colspan="2">정말삭제하시겠습니까?</td>
            <td><a href="deleteOK.do?num=${param.num}">삭제</a></td>
         </tr>
      </tbody>
   </table>
</body>
</html>