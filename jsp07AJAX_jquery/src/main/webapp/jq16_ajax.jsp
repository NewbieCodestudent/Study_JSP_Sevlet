<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#btn_01").click(function(){
		    $.ajax({
		    	url : "jq16_temp.do",
		    	type : "post",
		    	date:{num:$("#num").val()},
		    	dataType:"json",
		    	success:function(responsTxt, status, obj){
			    	console.log("success...", responsTxt);
			    	console.log("success...", status);
			    	console.log("success...", obj);
			    	
			    	$("#div1").html(responsTxt.name + ":" + responsTxt.age);
		    	},
		    	error:function(xhr, status, error){
			    	console.log("error...", xhr);
			    	console.log("error...", status);
			    	console.log("error...", error);
		    	}
		    });
		});
	});
</script>
</head>
<body>
	
	<button><a href="jq16_ajax.jsp">reset</a></button>
	<button id="btn_01">Get External Content</button>
	
	<div id="div1"><h2>Let jQuery AJAX Change This Text</h2></div>
	<input type="nember" id="num" value="11">

	
</body>
</html>