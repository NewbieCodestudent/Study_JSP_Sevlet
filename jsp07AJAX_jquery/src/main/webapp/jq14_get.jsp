<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btn_01").click(function(){
		    $.get("jq13_temp.do?num=11", function(responsTxt, status, obj){
		    	console.log("get...", responsTxt);
		    	console.log("get...", status);
		    	console.log("get...", obj);
		    	
		    	$("#div1").html(responsTxt);
		    });
		});
	});
</script>
</head>
<body>
	
	<button><a href="jq14_get.jsp">reset</a></button>
	<button id="btn_01">Get External Content</button>
	
	<div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>

	
</body>
</html>