<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.NaFella.Model.Bean.Product"%>



<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <title> Welcome to Home NaFella </title>

  <%@ include file="PresentationLayer/Jsp/head.html" %>
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
    .center-box{
      position:absolute;
      top:0;
      right:0;
      bottom:0;
      left:0;
      z-index:99;
      margin:auto;
      height:200px;
      width:200px;
      border:1px solid #000;
      text-align:center;
      line-height:200px;
    }
  </style>
</head>
<body>


	<%@ include file="PresentationLayer/Jsp/header.jsp" %>

	  <div id="sketch_holder"></div>
	  <div class="container">
	    <div class="center-box">
	      <h1>Welcome to the NaFella Shop</h1>
			
		  <a href='catalog' class='ng-button'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shop Now&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></center>
			
	    </div>
	  </div>

	<%@ include file="PresentationLayer/Jsp/footer.jsp" %>


</body>
</html>
