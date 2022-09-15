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
		
		$("#title").mouseenter(function() {
			console.log("mouseenter...");
			$(this).css("color", "powderblue");
		});
		$("#title").mouseleave(function() {
			console.log("mouseleave...")
			$(this).css("color", "black");
		});
		$("#searchWord").keypress(function() {
			console.log("keypress...");
		});
		$("#searchWord2").keyup(function() {
			console.log("keypress...");
		});
		
		$("#frm").submit(function() {
			console.log("submit...");
			console.log("searchWord:" + $("searchWord").val());
			console.log("searchWord2:" + $("searchWord2").val());
			if($("#searchWord").val().trim().legth==0) return false
			if($("#searchWord2").val().trim().legth==0) return false
			return true;
		});
		
		$("input").focus(function(){
			$(this).css("background-color", "yellow");
		});
		$("input").blur(function(){
			$(this).css("background-color", "white");
		});
		
		$("#hobby1").change(function(){
			console.log("change....")
			console.log($(this).is(":checked"));
		});
		
		$("#serachKey").change(function(){
			console.log("select change....")
			console.log($(this).val());
		});
		
		$(".p_txt").each(function(i){
			$(this).hover(function(){
				console.log("over....");
			},function(){
				console.log("out....");
			});
		});
	});
</script>
</head>
<body>
	<h3 id=title>jq01</h3>
	<from action="index.jsp" id="frm">
		<input type="text" id="searchWord" value="jq">
		<input type="text" id="searchWord2" value="jq">
		<input type="checkbox" id="hobby1" value="hobby1">hobby1
		<input type="submit">
		<select id="searchKey">
			<option value="name">name</option>
			<option value="tel">tel</option>
		</select>
	</from>
	
	<h3>jq02</h3>
	<h3>jq03</h3>
	
	<div>
		<span class="p_txt">Hello jquery1</span> <button class="btn">botton01</button> <br>
		<span class="p_txt">Hello jquery2</span> <button class="btn">botton02</button> <br>
		<span class="p_txt">Hello jquery3</span> <button class="btn">botton03</button> <br>
	</div>

</body>
</html>