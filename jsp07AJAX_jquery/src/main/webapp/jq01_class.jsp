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
	$(function(){
		console.log("ready...");
		let h3s = $("h3");
		console.log(h3s);
		console.log(h3s[0]);
		
		let colors = ['gray', 'powderblue', 'pink', 'orange', 'tomato', 'yellow']
		
		h3s.each(function(index){
			$(this).click(function(){
				console.log($(this).text());
				console.log($(this).text(colors[index]));
				console.log($(this).css("background", colors[index]));
			});
		});
		
		let ps = $(".p_txt");
		let btns = $(".btn");
		
		btns.each(function(index){
			$(this).click(function(){
				/* $(ps[index]).css("background", colors[index]);
				$($(".p_txt")[index]).css("background", colors[index]); */
				$(".p_txt:eq("+index+")").css("background", colors[index]);
			});
		});
		
		/* let p0 = $(".p_txt:eq(0)"); */
		let p0 = $(".p_txt:first");
		p0.click(function(){
			$(this).css("font-size", "30px");
		});
		
		
		let as = $(".a_choice");
		as.each(function(index){
			$(this).click(function(){
				console.log(index);
				$($("ul li")[index]).css("font-size", "30px");
				return false;
			});
		});
		
		$("#hide").each(function(index){
			$(this).click(function(){
				console.log($("#hide").name);
				$("ol").hide();
				return false;
			});
		});
		
		$("#hide2").each(function(index){
			$(this).click(function(){
				console.log(index);
				$("ol").show();
				return false;
			});
		});
		
		$(":button").ready(function(){
			$("button").click(function(){
				$(":button").hide();
			});
		});
		
	});

</script>
</head>
<body>
	<h3>jq01</h3>
	<h3>jq02</h3>
	<h3>jq03</h3>
	<h3>jq04</h3>
	<h3>jq05</h3>
	<h3>jq06</h3>
	
	<div>
		<span class="p_txt">Hello jquery1</span> <button class="btn">botton01</button> <br>
		<span class="p_txt">Hello jquery2</span> <button class="btn">botton02</button> <br>
		<span class="p_txt">Hello jquery3</span> <button class="btn">botton03</button> <br>
		<span class="p_txt">Hello jquery4</span> <button class="btn">botton04</button> <br>
		<span class="p_txt">Hello jquery5</span> <button class="btn">botton05</button> <br>
		<span class="p_txt">Hello jquery6</span> <button class="btn">botton06</button> <br>
		<input type="button" value="input_button">
	</div>
	
	<div>
		<h1>과일가게</h1>
		<a href="index.jsp" id="hide">숨어</a>
		<a href="index.jsp" id="hide2">보여</a>
		<a href="index.jsp" class="a_choice">사과 선택</a>
		<a href="index.jsp" class="a_choice">배 선택</a>
		<a href="index.jsp" class="a_choice">바나나 선택</a>
		
		<ol>
			<li>사과</li>	
			<li>배</li>
			<li>바나나</li>	
		</ol>
		
		<ul>
			<li>사과</li>	
			<li>배</li>	
			<li>바나나</li>	
		</ul>
	</div>

</body>
</html>