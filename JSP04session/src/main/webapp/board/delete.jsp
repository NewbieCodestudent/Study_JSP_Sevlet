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
	<h1>게시판</h1>
    <jsp:include page="../top_menu.jsp"></jsp:include>
	<h3>글삭제</h3>
	<table>
      <tbody>
         <tr>
            <td colspan="2"><label for="num">NUM:</label></td>
            <td>${param.num}</td>
         </tr>
         <tr>
            <td colspan="2">정말삭제하시겠습니까?</td>
            <td><a href="b_deleteOK.do?num=${param.num}">삭제</a></td>
         </tr>
      </tbody>
   </table>
</body>
</html>