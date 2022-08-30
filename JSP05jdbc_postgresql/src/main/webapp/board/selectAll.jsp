<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록</title>
<link rel="stylesheet" href="css/menu.css">
<script>
	console.log("sessionStorage:", sessionStorage.user_id);
	console.log("localStorage:", localStorage.user_name);
</script>
</head>
<body>
	<h1>Board_Member</h1>
    <jsp:include page="../top_menu.jsp"></jsp:include>
	<h3>글목록</h3>
	${player_name}
	<form action="searchList.do" method="get">
		<table>
			<tr>
				<td>
					<select name="searchKey" id="searchKey">
	            	<option value="title">제목</option>
	            	<option value="writer">작성자</option>
	            	</select>
				</td>
				<td>
				<input type="text" name="searchWord" id="searchWord" value="title">
	        	<input type="submit" value="검색">
	        	</td>
			</tr>
		</table>
    </form>
	<table>
        <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
        </thead>
        <tbody>
			<c:forEach var="vo" items="${vos}">
            <tr> 
                <td><a href="selectOne.do?num=${vo.num}">${vo.num}</a></td> 
                <td>${vo.title}</td>
                <td>${vo.writer}</td>
                <td>${vo.wdate}</td>
            </tr>
			</c:forEach>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="5", style="color: black;">1 2 3 4 5</td>
            </tr>
        </tfoot>
        <c:set var="x" value="20"></c:set>
        <c:out value=""></c:out>
    </table>
</body>
</html>