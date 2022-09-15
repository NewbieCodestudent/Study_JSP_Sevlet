<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	.siblings * {
		display: block;
		border: 2px solid lightgrey;
		color: lightgrey;
		padding: 5px;
		margin: 15px;
	}
</style>
<script>
	$(document).ready(function() {
		// 대상의 같은 레벨 중 위,아래에 있는 것을 찾음
		/* $("h2").siblings().css({
			"color" : "red",
			"border" : "2px solid red"
		}); */
		
		// 대상의 같은 레벨 중 위,아래에 있는 것들 중 하나를 찾음
		/* $("h2").siblings("p").css({"color": "red", "border": "2px solid red"}); */
		
		// 대상의 같은 레벨 중 아래에 있는 요소를 찾음
		/* $("h2").next().css({"color": "red", "border": "2px solid red"}); */
		
		// 대상의 같은 레벨 중 아래에 있는 모든 요소르 찾음
		/* $("h2").nextAll().css({"color": "red", "border": "2px solid red"}); */
		
		// 대상부터 어디 전까지 요소를 찾는다.
		/* $("h2").nextUntil("h6").css({"color": "red", "border": "2px solid red"}); */
		
		/* $("h2").prevAll().css({"color": "red", "border": "2px solid red"}); */
		$("h2").prevUntil("p").css({"color": "red", "border": "2px solid red"});
	});
</script>
</head>
<body class="siblings">

	<div>div (parent)
	  <p>p</p>
	  <span>span</span>
	  <h2>h2</h2>
	  <h3>h3</h3>
	  <h4>h4</h4>
	  <h5>h5</h5>
	  <h6>h6</h6>
	  <p>p</p>
	</div>

</body>
</html>
