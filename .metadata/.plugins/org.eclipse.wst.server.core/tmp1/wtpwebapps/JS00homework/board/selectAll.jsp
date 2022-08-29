<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h1>Board</h1>
	<jsp:include page="../menu.jsp"></jsp:include>
	<h3>게시글 목록</h3>
	<form action="searchList.do" method="get">
		<table>
			<tr>
				<td>
					<select name="searchKey" tel="searchKey">
	            	<option value="content">종류</option>
	            	<option value="writer">작성자</option>
	            	</select>
				</td>
				<td>
				<input type="text" name="searchWord" id="searchWord" value="lee">
	        	<input type="submit" value="검색">
	        	</td>
			</tr>
		</table>
    </form>
	<table>
	        <thead>
	            <tr>
	                <th>NUM</th>
	                <th>TITLE</th>
	                <th>CONTENT</th>
	                <th>WRITER</th>
	            </tr>
	        </thead>
	        <tbody>
	        	<c:forEach var="vo" items="${vos}">
	            <tr> 
	                <td><a href="selectOne.do?num=${vo.num}">${vo.num}</a></td> 
	                <td>${vo.title}</td>
	                <td>${vo.content}</td>
	                <td>${vo.writer}</td>
	            </tr>
	            </c:forEach>
	        </tbody>
	        <tfoot> <!-- table의 꼬리말 -->
	            <tr>
	                <td colspan="5">1 2 3 4 5</td>
	            </tr>
	        </tfoot>
	</table>
	<form action="insert.do" method="get">
		<input type="submit" value="새글작성">
	</form>
</body>
</html>