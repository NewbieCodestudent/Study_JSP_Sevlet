<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글번호검색</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<h1>Board_Member</h1>
    <jsp:include page="../top_menu.jsp"></jsp:include>
	<h3>글번호검색</h3>
	<table>
      <tbody>
		 <tr>
            <td><label for="num">글번호</label></td>
            <td colspan="2">${param.num}</td>
         </tr>
         <tr>
            <td>제목</td>
            <td colspan="2">${vo2.title}</td>
         </tr>
         <tr>
            <td>내용</td>
            <td colspan="2">${vo2.content}</td>
         </tr>
         <tr>
            <td>작성자</td>
            <td colspan="2">${vo2.writer}</td>
         </tr>
         <tr>
            <td>작성일</td>
            <td colspan="2">${vo2.wdate}</td>
         </tr>
         <tr>
			<td></td>
            <td colspan="2">
				<a href="b_update.do?num=${param.num}">수정</a>
				<a href="b_delete.do?num=${param.num}">삭제</a>
			</td>
         </tr>
      </tbody>
   </table>
</body>
</html>