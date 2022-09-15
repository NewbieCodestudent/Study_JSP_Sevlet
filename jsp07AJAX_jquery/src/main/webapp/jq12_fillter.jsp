<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		//첫번째 div를 찾는다.
		// $("div").first().css("background-color", "pink");
		// $("div:eq(0)").css("background-color", "pink");
		// $("div").eq(0).css("background-color", "pink");
		$("div:first").css("background-color", "pink");
		
		$("div").last().css("background-color", "powderblue");
		// $("div:eq(-1)").css("background-color", "powderblue");
		// $("div").eq(-1).css("background-color", "powderblue");
		
		// 대상에 대해서만 적용
	  	// $("p").filter(".intro").css("background-color", "yellow");
	  	// $("p.intro").css("background-color", "yellow");

	  	// 대상외 모든것에 대해서 적용
	  	// $("p").not(".intro").css("background-color", "yellow");
	  	$("p").not(".intro").not("div *").css("background-color", "yellow");
	});
</script>
</head>
<body>
	
	<h1>Welcome to My Homepage</h1>
	
	<p>This is a paragraph.</p>
	
	<div style="border: 1px solid black;">
	  <p>A paragraph in a div.</p>
	  <p>Another paragraph in a div.</p>
	</div>
	<br>
	
	<div style="border: 1px solid black;">
	  <p>A paragraph in another div.</p>
	  <p>Another paragraph in another div.</p>
	</div>
	<br>
	
	<div style="border: 1px solid black;">
	  <p>A paragraph in another div.</p>
	  <p>Another paragraph in another div.</p>
	</div>
	
	<p>My name is Donald.</p>
	<p class="intro">I live in Duckburg.</p>
	<p class="intro">I love Duckburg.</p>
	<p>My best friend is Mickey.</p>
	
</body>
</html>
