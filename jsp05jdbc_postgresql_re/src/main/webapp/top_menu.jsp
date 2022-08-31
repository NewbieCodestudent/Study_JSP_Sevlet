<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div id="nav">
	<ul>
		<li><a href="home.do">홈</a></li>
		<li><a href="b_insert.do">글쓰기</a></li>
		<li><a href="b_selectAll.do">글목록</a></li>
		<li><a href="m_selectAll.do">회원목록</a></li>
	</ul>
</div>
<br><br>
<hr>
	${user_id}
	<c:choose>
		<c:when test="${user_id == null}">
			<a href="login.do">로그인</a>
			<a href="m_insert.do">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href="logout.do">로그아웃</a>
		</c:otherwise>
	</c:choose>