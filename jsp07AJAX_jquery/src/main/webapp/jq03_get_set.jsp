<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> 링크로 연결하는 방법 -->
<script>
	$(function(){
		console.log("ready...");
		
		//text
		console.log($("#title").text());
		$("#title").text("HTML");
		
		//value
		console.log($("#searchWord").val());
		$("#searchWord").val("HTML");
		
		//html
		console.log($("#content").html());
		$("#content").html("<h1>BIG</h1>");
		
		let tr = "<tr><td>aaa</td><td>bbb</td><td>ccc</td></tr>";
		tr += "<tr><td>111</td><td>222</td><td>333</td></tr>";
		$("#vos").html(tr);
		
		//attribute
		console.log($("h2").attr("class"));
		$("h1").attr("class", "myName");
		console.log($("h1").attr("class"));
		
	  	$("button").click(function(){
	    	$("#w3s").attr("href", "https://www.w3schools.com/jquery/");
	    	$("#w3s").text("W3Schools.com/jquery/");
	  	});
		
	});
</script>
<style>
	.myName {
		font-size : 30pt;
		color : powderblue
	}
</style>
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
	<div id="content">
		<h2>Hello</h2>
		<p>javascript</p>
	</div>
	
	<table id="vos">
	
	</table>
	
	<h2 class="myName">yangssem1</h2>
	<h1>yangssem2</h1>
	
	<p><a href="https://www.w3schools.com" id="w3s">W3Schools.com</a></p>

	<button>Change href Value</button>

	<p>Mouse over the link (or click on it) to see that the value of the href attribute has changed.</p>
</body>
</html>