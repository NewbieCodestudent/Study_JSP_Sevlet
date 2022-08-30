<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>회원목록</title>
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/selectAll.css">
</head>
<body>
	<h1>Board_Member</h1>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h3>회원관리</h3>
	<form action="m_Mater_searchList.do" method="get">
		<table>
			<tr>
				<td>
					<select name="searchKey" id="searchKey">
	            	<option value="name">name</option>
	            	<option value="tel">tel</option>
	            	</select>
				</td>
				<td>
				<input type="text" name="searchWord" id="searchWord" value="ki">
	        	<input type="submit" value="검색">
	        	</td>
			</tr>
		</table>
    </form>
	<table>
        <thead> <!-- table의 제목 -->
            <tr>
                <th>num</th>   <!-- 표의 제목을 작성-->
                <th>id</th>
                <th>pw</th>
                <th>name</th>
                <th>tel</th>
            </tr>
        </thead>
        <tbody> <!-- table의 바디 -->
        	<!-- JSTL 문법 -->
        	<!-- items : 대상, var : 변수 -->
			<c:forEach var="vo" items="${vos}">
            <tr> 
                <td><a href="m_selectOne.do?num=${vo.num}">${vo.num}</a></td> 
                <td>${vo.id}</td>
                <td>${vo.pw}</td>
                <td>${vo.name}</td>
                <td>${vo.tel}</td>
            </tr>
			</c:forEach>
        </tbody>
        <tfoot> <!-- table의 꼬리말 -->
            <tr>
                <td colspan="5", style="color: white;">1 2 3 4 5</td>
            </tr>
        </tfoot>
    </table>
</body>
</html>