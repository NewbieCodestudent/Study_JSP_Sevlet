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
      
      $("button").click(function() {
         /* $("#div1").css("background","blue");
         $("#div1").css("color","white");
         $("#div1").css("font-size","200%"); */
         $("#div1").css({"background":"blue", "font-size":"200%", "color":"white", "width":"600px"});
      });
      
   });
</script>
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