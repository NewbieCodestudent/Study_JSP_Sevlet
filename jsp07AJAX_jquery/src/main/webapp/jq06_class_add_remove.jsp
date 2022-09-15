<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(function() {
		console.log("ready...")
		
		$("button:eq(0)").on("click", function() {
			$("h2").attr("class", "forestgreen");
			/* $("h1").addClass("forestgreen"); */
			$("h1, h2, p").addClass("forestgreen");
			$("div").addClass("important");
		});
		
		$("button:eq(1)").on("click", function() {
			$("h1, h2, p").removeClass("forestgreen");
			$("div").removeClass("important");
		});
		
		$("button:eq(2)").on("click", function() {
			$("h1, h2, p").toggleClass("forestgreen");
			$("div").toggleClass("important");
		});
	});
</script>
<style>
.important {
  font-weight: bold;
  font-size: xx-large;
  color :  orange
}

.forestgreen {
  color:forestgreen;
}
</style>
</head>
<body>
	<button>Add classes to elements</button>
	<button>Remove classes to elements</button>
	<button>Toggle classes to elements</button>

	<h1>Heading 1</h1>
	<h2>Heading 2</h2>
	
	<p>This is a paragraph.</p>
	<p>This is another paragraph.</p>
	
	<div>This is some important text!</div><br>
	
</body>
</html>