<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.NaFella.Model.Bean.Cart, com.NaFella.Model.Bean.Customer, 
    com.NaFella.Model.Bean.Address, com.NaFella.Model.Bean.Product, java.util.*"%>
    
<% Collection<?> addresses = (Collection<?>) request.getAttribute("addresses"); %>
<!DOCTYPE html>
<html>
<head>
	<title>Checkout</title>
	<%@ include file="head.html" %>
	<script>
	  var pathname = window.location.pathname;
	  if(pathname=="/NaFella/Checkout.jsp")
	  {
			  window.location.href = "checkout";
	  }							
	</script>
</head>
<body>
	
	<%@ include file="header.jsp" %>
	<div class=" col-xs-12 text-center">
		<h1>Your checkout</h1>
	</div>
	
	<%
	if (cart != null && cart.getProducts().size() != 0) 
	{ %>
	<div class="container">
		    <div class="row">
		        <div class="col-xs-12">
		            <table class="table table-hover">
		                <thead>
		                    <tr>
		                        <th>Product</th>
		                        <th>Price</th>
		                        <th> </th>
		                    </tr>
		                </thead>
		                <tbody>
		                	<%  double totalPrice = 0;
							ArrayList<Product> cartArray = cart.getProducts();
							ArrayList<String> images = cart.getImages();
							for(int i = 0; i < cartArray.size(); i++) {
						%>
		                    <tr>
		                        <td class="col-xs-6">
		                        <div class="media">
		                            <img class="media-object" src="images/<%=cartArray.get(i).getName()%>.jpg" style="width: 72px; height: 72px;">
		                            <div class="media-body">
		                                <h4 class="media-heading"><%=cartArray.get(i).getName() %></h4>
		                            </div>
		                        </div></td>
		                        <% if(cartArray.get(i).getDiscount() == 0) { %>
		                        <td class="col-xs-5"><strong>&euro;<%=cartArray.get(i).getPrice()%></strong></td>
		                        <% totalPrice += cartArray.get(i).getPrice(); 
		                        	} else { %>
		                        	<td class="col-xs-6 text-right"><strong>&euro;<font color = "red"> <del><%=cartArray.get(i).getPrice()%></del></font> <%=cartArray.get(i).getPrice()-cartArray.get(i).getDiscount()%></strong></td>
		                        <% totalPrice += Math.floor((cartArray.get(i).getPrice()-cartArray.get(i).getDiscount()) * 100.0) / 100.0;
		                        	} %>

		                    </tr>
		                    <% } %>
		                    <tr>
		                        <td class="col-xs-6"><h3>Total</h3></td>
		                        <td class="col-xs-1"></td>
		                        <td class="col-xs-5 text-right"><h3><strong>&euro;<%=totalPrice %></strong></h3></td>
		                    </tr>
		                    <tr>
		                        <td class = "col-xs-6">
		                        	
										<%
											if (addresses != null && addresses.size() != 0) { %>
												<select class="form-control" id="addresses"name="address_id"> 
												<%	Iterator<?> add_it = addresses.iterator();
													while (add_it.hasNext()) {
															Address adr = (Address) add_it.next(); %>
																			
										<option value ="<%=adr.getId()%>">
											<%=adr.getStreet()%>, &nbsp;
											<%=adr.getPostalCode()%> &nbsp;
											<%=adr.getCity()%> &nbsp; 
											(<%=adr.getProvince()%>) &nbsp;
											<%=adr.getCountry()%>
										</option>
								
									<% } %>
										</select>
										
									<%	} else {
												%>					
													<p>No addresses available</p>				
												<%
													}
												%>
		                        <td class = "col-xs-1"></td>
		                        <td class="col-xs-5 text-right">
		                        <button class="btn btn-success" onclick="confirmCheckout()" type="button">Confirm Checkout</button></td>
		                    </tr>
		                </tbody>
		            </table>
		        </div>
		    </div>
	
		  <script>
		  	function confirmCheckout() {
		  		var b = confirm("Vuoi confermare l'operazione?");
		  		if(b) {
		  			var e = document.getElementById("addresses");
		  			var strUser = e.options[e.selectedIndex].value;
		  			location.href = "confirm?total="+<%=request.getAttribute("total")%>+"&address_id="+strUser;
		  		}
		  	}
		  </script>
	</div>
<% } else { %>
	
	<div class="container">
		<div class="col-xs-12 text-center">
			<h2> No products in you cart! </h2>
		</div>
	</div>

<% } %>
  
  
  <%@ include file="footer.jsp" %>
</body>
</html>