<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원삭제</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/delete.css">
</head>
<body>
	<h3>회원삭제</h3>
	<jsp:include page="../top_menu.jsp"></jsp:include>
   <br><br>
   <table>
      <tbody>
         <tr>
            <td colspan="2"><label for="num">NUM:</label></td>
            <td>${param.num}</td>
         </tr>
         <tr>
            <td colspan="2">정말삭제하시겠습니까?</td>
            <td><a href="m_deleteOK.do?num=${param.num}">삭제</a></td>
         </tr>
      </tbody>
   </table>
</body>
</html>