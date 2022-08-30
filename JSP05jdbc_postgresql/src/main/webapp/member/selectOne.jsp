<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/select_One.css">

</head>
<body>
   <h1>Board_Member</h1>
   <jsp:include page="../top_menu.jsp"></jsp:include>
   <h3>회원정보</h3>
   <br><br>
   <table>
      <tbody>
         <tr>
            <td><label for="num">NUM:</label></td>
            <td colspan="2">${param.num}</td>
         </tr>
         <tr>
            <td><label for="id">ID:</label></td>
            <td colspan="2">${vo2.id}</td>
         </tr>
         <tr>
            <td><label for="pw">PW:</label></td>
            <td colspan="2">${vo2.pw}</td>
         </tr>
         <tr>
            <td><label for="name">NAME:</label></td>
            <td colspan="2">${vo2.name}</td>
         </tr>
         <tr>
            <td><label for="tel">TEL:</label></td>
            <td colspan="2">${vo2.tel}</td>
         </tr>
         <tr>
			<td><a href="m_update.do?num=${param.num}">회원수정</a></td>
			<td><a href="m_delete.do?num=${param.num}">회원삭제</a></td>
         </tr>
      </tbody>
   </table>
</body>
</html>