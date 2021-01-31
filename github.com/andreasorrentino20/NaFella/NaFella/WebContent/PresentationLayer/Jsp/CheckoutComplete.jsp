<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  
  <%@ include file="head.html" %>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.5.11/addons/p5.dom.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.5.11/p5.min.js"></script>
  <script src="js/welcome.js"></script>
  <style>
    #sketch_holder canvas {
      margin: 0;
      position: absolute !important;
      left: 0px !important;
	  top: 0px !important;
      width: 100% !important;
      height:100% !important;
    }
  </style>

  <title>Checkout Completed</title>
</head>

<body>
  <div id="sketch_holder"></div>
  <%@ include file="header.jsp" %>

  	 <div class ="col-xs-12 text-center">
      <h1>Your order is almost completed!</h1>
     </div>
     <div class="col-xs-12 text-center">
	      <p>We now have to confirm you order, but don't worry! It's just a question of minutes.</p>
      </div>
      <div class="col-xs-12 text-center">
      		<a href="PersonalArea.jsp">Go back to your personal area</a>
      </div>
  <%@ include file="footer.jsp" %>
</body>
</html>
