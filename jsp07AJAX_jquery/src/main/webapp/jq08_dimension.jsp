<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js"></script>
<!-- <script src="https://code.jquery.com/jquery-3.6.1.min.js"></script> -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->

<script>
   $(function() {
      console.log("ready....");
      
      $("#div1").css("background","pink");
      
      console.log($("#div1").width(),$("#div1").height());
      console.log($("#div1").innerWidth(),$("#div1").innerHeight());
      console.log($("#div1").outerWidth(),$("#div1").outerHeight());
      console.log($("#div1").outerWidth(true),$("#div1").outerHeight(true));
      console.log($(document).width(),$(document).height());
      console.log($(window).width(),$(window).height());
      
      $("button").click(function() {
    	  $("#div1").width(500);
    	  $("#div1").height(300);
      });
      
   });
</script>
<style>
#div1 {
  height: 100px;
  width: 300px;
  padding: 10px;
  margin: 3px;
  border: 1px solid blue;
  background-color: lightblue;
}
</style>
</head>
<body>
   <div id="div1" style="width: 300px; border: 1px solid black;">

      This is some text in the div.
      <p>This is a paragraph in the div.</p>
      <p>This is another paragraph in the div.</p>

   </div>
   <br>

   <button>Css Method div element</button>
   
</body>
</html>