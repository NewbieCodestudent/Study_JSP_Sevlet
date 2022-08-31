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
<link rel="stylesheet" href="css/select_all.css">

</head>
<body>
	<h3>회원목록</h3>
	
	<jsp:include page="../top_menu.jsp"></jsp:include>
	
	<form action="m_searchList.do" method="get">
    <table>
    	<tr>
    		<td><select name="searchKey" id="searchKey">
		            <option value="name">name</option>
		            <option value="tel">tel</option>
		        </select>
        	</td>
    		<td>
    			<input type="text" name="searchWord" id="searchWord" value="ki">
        	</td>
    		<td>
    			<input type="submit">
    		</td>
    	</tr>
    </table>
    </form>
	
	<table>
        <thead>
            <tr>
                <th>NUM</th>
                <th>ID</th>
                <th>PW</th>
                <th>NAME</th>
                <th>TEL</th>
                <th>PROFILE</th>
            </tr>
        </thead>
        <tbody>
			
        	<c:forEach var="vo" items="${vos}">
        	<tr>
                <td><a href="m_selectOne.do?num=${vo.num}">${vo.num}</a></td>
                <td>${vo.id}</td>
                <td>${vo.pw}</td>
                <td>${vo.name}</td>
                <td>${vo.tel}</td>
                <td><img width="100" alt="${vo.profile}" src="upload/${vo.profile}"></td>
            </tr>
        	</c:forEach>
        	
            
        </tbody>
        <tfoot>
            <tr>
                <td colspan="6">1 2 3 4 5</td>
            </tr>
        </tfoot>
    </table>

</body>
</html>