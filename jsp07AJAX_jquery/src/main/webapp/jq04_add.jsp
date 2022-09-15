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
	$(document).ready(function(){
		$("#btn1").click(function(){
			$("p").append(" <b>Appended text</b>.");
		});

		$("#btn2").click(function(){
			$("ol").append("<li>Appended item</li>");
		});
	  
		$("#btn3").click(function(){
			$("p").prepend(" <b>Prepend text</b>.");
		});

		$("#btn4").click(function(){
			$("ol").prepend("<li>Prepend item</li>");
		});
		
		$("#btn5").click(function(){
			$("img").before("<b>Before</b>");
		});

		$("#btn6").click(function(){
			$("img").after("<i>After</i>");
		});
		
		$("#btn7").click(function(){
		    $("#div1").remove();
		});
		
		$("#btn8").click(function(){
		    $("#div1").empty();
		});
		
		$("#btn9").click(function(){
		    $("#th").remove();
		});
		
		$("#btn10").click(function(){
		    $("#tb").empty();
		});
		
		for(var i = 0; i<10; i++) {
			$("#tb").append("<tr><td>aaa"+i+"</td><td>bbb"+i+"</td></tr>");
		}
		
	});
	
	function appendText() {
		var txt1 = "<p>Text.</p>";        // Create text with HTML
		var txt2 = $("<p></p>").text("Text.");  // Create text with jQuery
		var txt3 = document.createElement("p");
		txt3.innerHTML = "Text.";         // Create text with DOM
		$("body").append(txt1, txt2, txt3);   // Append new elements
	}
	
</script>
</head>
<body>
	
	<button><a href="jq04_add.jsp">초기화</a></button>
	<button id="btn1">Append text</button>
	<button id="btn2">Append list items</button>
	<button id="btn3">Prepend text</button>
	<button id="btn4">Prepend list items</button>
	
	<p>This is a paragraph.</p>
	<p>This is another paragraph.</p>

	<ol>
  		<li>List item 1</li>
  		<li>List item 2</li>
  		<li>List item 3</li>
	</ol>
	
	<div>
		<p>This is a paragraph.</p>
		<button onclick="appendText()">Append text</button>
	</div>
	
	<button id="btn5">Insert before</button>
	<button id="btn6">Insert after</button>
	<div>
		<img src="image/팬더.jpg" alt="jQuery" width="100" height="140">
	</div>
	
	<div id="div1" style="height:100px;width:300px;border:1px solid black;background-color:yellow;">
		This is some text in the div.
		<p>This is a paragraph in the div.</p>
		<p>This is another paragraph in the div.</p>
	</div>
	
	<button id="btn7">Remove div element</button>
	<button id="btn8">Empty div element</button>
	
	<table id="table">
		<thead id="th">
			<tr><td>name</td><td>age</td></tr>
		</thead>
		<tbody id="tb">
			<tr><td>aaa</td><td>bbb</td></tr>
		</tbody>
		<tfoot id="tf">
			<tr><td>1 2 3</td></tr>
		</tfoot>
	</table>
	<button id="btn9">Remove element</button>
	<button id="btn10">Empty element</button>
</body>
</html>