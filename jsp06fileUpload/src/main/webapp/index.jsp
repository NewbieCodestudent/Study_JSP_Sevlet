<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index.jsp</title>
</head>
<body>
	<h3>fileUplaod</h3>
	<form action="fileUpload.do" method="post" enctype="multipart/from-date">
		<input type="text" name="name" value="kim">
		<input type="text" name="age" value="33">
		<input type="file" name="upFile">
		<input type="submit">
	</form>
	<img width="100" alt="imgName" src="upload/담비.jpg">
</body>
</html>