<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btn_01").click(function(){
		    // $("#div1").load("jq13_temp.txt");
		    // $("#div1").load("jq13_temp.do");
		    // $("#div1").load("jq13_temp.do #p1")
		    
		    $("#div1").load("jq13_temp.do", function(x,y,z){
		    	console.log("load...", x);
		    	console.log("load...", y);
		    	console.log("load...", z);
		    });
		});
	});
</script>
</head>
<body>
	
	<button><a href="jq13_load.jsp">reset</a></button>
	<button id="btn_01">Get External Content</button>
	
	<div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>

	
</body>
</html>