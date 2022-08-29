<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 아이디 메인 방법 #1 -->
<div id="login">
	<% if(session.getAttribute("user_id") != null) {%>
	 	<a>${user_id}</a> <a href="logout.do">로그아웃</a>
	<% } else { %>
	 	<a href="login.do">로그인</a> <a href="join.do">회원가입</a>
	<% } %>
</div>

${user_id}

<!-- 아이디 메인 방법 #2 -->
<c:choose>
	<c:when test="${user_id == null}">
		<a href="login.do">로그인</a>
		<a href="join.do">회원가입</a>
	</c:when>
	<c:otherwise>
		<a href="logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>

<div id="nav">
	<ul>
		<li><a href="index.do">home</a></li>
		<li><a href="m_insert.do">회원입력</a></li>
		<li><a href="m_selectAll.do">회원목록</a></li>
	</ul>
</div>