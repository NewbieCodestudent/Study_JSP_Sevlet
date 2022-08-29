<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/menu.css">
<script>
	sessionStorage.user_id = "tester";
	console.log("sessionStorage:", sessionStorage.user_id);
	localStorage.user_name = "lee";
	console.log("localStorage:", localStorage.user_name);
</script>
</head>
<body>
	<h1>게시판</h1>
    <jsp:include page="top_menu.jsp"></jsp:include>
    
    ${pageContext.request.scheme} <!-- 형식 : http -->
    ${pageContext.request.serverName} <!-- 서버이름 : localhost -->
    ${pageContext.request.serverPort} <!-- 포트 : 8090 -->
    <br>
    ${pageContext.request.contextPath} <!-- 경로 : JSP04session -->
    <br>
    <%= request.getContextPath() %> <!-- 경로 : JSP04session -->
    <br>
    <%= application.getAttribute("player_name") %>
</body>
</html>