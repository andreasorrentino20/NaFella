<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.NaFella.Model.Bean.Product"%>
    
<%
	Product pr = (Product)request.getAttribute("product");

		String image1="",image2="",image3="",image4="";
		String out_of_stock = "";
		int k = 0;
		
		if(pr!=null)
		{
			for(int i=0;i<pr.getImg().length();i++)
			{						
				String comparison = pr.getImg().substring(i, i+1);
				
				if((comparison.equalsIgnoreCase("*")))
				{	
					k++;
				}
				else
				{
					if(k==0)
						image1 = image1 + pr.getImg().substring(i, i+1);
					
					if(k==1)
						image2 = image2 + pr.getImg().substring(i, i+1);
					
					if(k==2)
						image3 = image3 + pr.getImg().substring(i, i+1);
					
					if(k==3)
						image4 = image4 + pr.getImg().substring(i, i+1);
					
				}
			}
		}
	%>
<!DOCTYPE html>
<html>
<head>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link type="text/css" rel="stylesheet" href="css/sticky_footer.css">
	<link type="text/css" rel="stylesheet" href="css/stile.css">
	
	<link rel="shortcut icon" type="image/x-icon" href="images/logo.ico"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/productstyle.css" >

    <script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.5.11/addons/p5.dom.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/p5.js/0.5.11/p5.min.js"></script>
    <script src="js/sketch.js"></script>

	<title>Product</title>
	     	
	<link rel="stylesheet" href="css/etalage.css">
	
	<script src="js/jquery.etalage.min.js"></script>
	<script>
			jQuery(document).ready(function($){
			
			$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
							
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
					 //alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});
				// This is for the dropdown list example:
				$('.dropdownlist').change(function(){
					etalage_show( $(this).find('option:selected').attr('class') );
				});
			});
	</script>
</head>

<body>

<%@ include file="header.jsp" %>

<%if(pr!=null) { 
	if(pr.getId()!=-1) { %>
	<script>
		var i = 0;
		 function addToCart() {
	    		var canvas = document.getElementById("defaultCanvas0");
	    		var dataURL = canvas.toDataURL("image/png");
	    		var ajax;
	    		
	    	    if (window.XMLHttpRequest) {
	    	        ajax = new XMLHttpRequest();
	    	    } else if (window.ActiveXObject) {
	    	        ajax = new ActiveXObject("Microsoft.XMLHTTP");
	    	    }
			ajax.open('POST', "addToCart", true);
		    	ajax.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	    	    ajax.onreadystatechange = function() {
	    	        if(this.readystate == 4 || this.status == 200) {
	    	        	if(i==0)
	    	        	{
	    	        			alert("Product added to cart!");		
	    	        	}
	    	     
	    	        	if(i==2)
	    	        		document.getElementById("cart").innerHTML = "Cart (" + this.responseText + " items)";
	    	        	i++;
	        			
		    	    } else {
		    	    	if(i==0)
		    	    	{
		    	    		alert("Something has gone wrong, retry");
		    	    		i=1;
		    	    	}
	    	        }
	    	   }
	    	   if(i==0)
	    	   	ajax.send("action=add&id="+<%=pr.getId()%>+"&image="+dataURL);
	    	   else
	    	   {
	    		   alert("Product ALREADY added to cart! After this message the page will be reloaded, in order to add this product to another image.");
	    		   window.location.reload()
	    	   }
    		}
	</script>

    <div class="container-fluid">
        <div class="content-wrapper">
    		<div class="item-container">
    			<div class="row">
	    			<div class="col-md-9 single_left">
	    				<div class="single_image">
						     <ul id="etalage">
								<%if(!image1.equalsIgnoreCase("")) 
	    						{%>
									<li>
										<a href="#">
											<img class="etalage_thumb_image" src="images/<%=image1 %>" alt="<%=pr.getName()%>"/>
											<img class="etalage_source_image" src="images/<%=image1 %>" alt="<%=pr.getName()%>" />
										</a>
									</li>
								<%} %>
								<%if(!image2.equalsIgnoreCase("")) 
	    						{%>
									<li>
										<img class="etalage_thumb_image" src="images/<%=image2 %>" alt="<%=pr.getName()%>"/>
										<img class="etalage_source_image" src="images/<%=image2 %>" alt="<%=pr.getName()%>" />
									</li>
								<%} %>
								<%if(!image3.equalsIgnoreCase("")) 
	    						{%>
									<li>										
										<img class="etalage_thumb_image" src="images/<%=image3 %>" alt="<%=pr.getName()%>"/>
										<img class="etalage_source_image" src="images/<%=image3 %>" alt="<%=pr.getName()%>" />										
									</li>
								<%} %>
								<%if(!image4.equalsIgnoreCase("")) 
	    						{%>
									<li>
										<img class="etalage_thumb_image" src="images/<%=image4 %>" alt="<%=pr.getName()%>"/>
										<img class="etalage_source_image" src="images/<%=image4 %>" alt="<%=pr.getName()%>" />
									</li>
								<%}
								else
								{%>
									<li>
										<img class="etalage_thumb_image" src="images/bianco.jpg" />
									</li>
								<%}%>
							</ul>
						</div>
    				</div>
    			</div>
    			<div class="col-md-7">
    					<div class="product-title"><%=pr.getName() %></div>
    					<div class="product-desc">Size: <%=pr.getSize()%></div>
    					<hr>
    					
    					<%if(pr.getDiscount()<=0) 
    					{ %>
    						<div class="product-price">&euro;<%= pr.getPrice() %></div>	
    				<% }
    					else
    					{%>
    						<div class="product-price"> &euro; <font color = "red"> <del><%=pr.getPrice()%></del></font> <span class="glyphicon glyphicon-arrow-right"></span> &euro;<%=Math.floor((pr.getPrice()-pr.getDiscount()) * 100.0) / 100.0%> </div>
    						<div class="product-price">&euro;<%= pr.getDiscount() %> discount</div>	
    					<%}%>
    					
    						<%if(pr.getAvailability() > 0) { %>
    						<div class="product-stock">
    							<%if(pr.getAvailability() <= 10)
    							  { %>
    								<p>In Stock <font color="red"> <strong> Only <%=pr.getAvailability()%> left</strong></font> </p> 
    							<%}
    							 else
    							 {%>
    							 	<p>In Stock</p>
    						   <%} %>
    						</div>
    						<% } else {  
    							out_of_stock = "disabled";%>
    						<div class="product-out-stock">
    							<p>Out of Stock!</p>
    						</div>
    						<% } %>
    					<hr>
		              <div class="btn-ground text-center">
		              <button type="button" <%=out_of_stock %> class="btn btn-primary" onclick="addToCart()"><span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</button>
		             
		              </div>
    			</div>
		    	<div class="container-fluid">
		    		<div class="col-md-12 product-info">
		    				<ul id="myTab" class="nav nav-tabs nav_tabs">
		
	    						<li class="active"><a href="#service-one" data-toggle="tab">DESCRIPTION</a></li>
		
	    					</ul>
		   				<div id="myTabContent" class="tab-content">
		   						<div class="tab-pane fade in active" id="service-one">
		
		   							<section class="container product-info">
		   								<p><%=pr.getDescription() %></p>
		   							</section>
		   						</div>
		   				</div>
		   				<hr>
		   			</div>
		   		</div>
		   	</div>
   		</div>
    </div>
		
		     
    <% } 
	} else { %>
<h2>You haven't selected any product!</h2>
<% } %>	
</div>



<%@ include file="footer.jsp" %>

</body>

</html>