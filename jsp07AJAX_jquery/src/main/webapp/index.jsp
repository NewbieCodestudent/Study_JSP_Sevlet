<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> 링크로 연결하는 방법 -->
<script>
	console.log("jquery...",${3*4});
	
	let sum = ${3*4};
	console.log("sum : " + sum);
	
	/* 자바스크립트의 출력문 : window.onload = function(){} */
	/* jquery의 출력문 :  $(function(){}) */
	$(function(){
		console.log("ready...");
		/* console.log($("*")); */
		console.log($("body"));
		
		let bool = true;
		let interval_id; 
		
		$("#btn_on").click(function(){
			console.log("click...btn_on");
			interval_id = setInterval(function(){
				console.log("setInterval()...", bool);
				
				let bg_color = "powderblue";
				if(bool) {
					bg_color = "green";
				} else {
					bg_color = "powderblue"; 
				}
				$("body").css("background",bg_color);

				
				bool = !bool;
			},1000);
		});
		$("#btn_off").click(function(){
			console.log("click...btn_off");
			clearInterval(interval_id);
			$("body").css("background","white");
		});
		
	});
</script>
</head>
<body>
	<h3>jquery</h3>
	${3*4}
	<button id="btn_on">배경색 on</button>
	<button id="btn_off">배경색 off</button>
</body>
</html>