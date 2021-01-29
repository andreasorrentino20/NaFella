<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.NaFella.Model.Bean.Cart, com.NaFella.Model.Bean.Customer, com.NaFella.Model.Bean.Product"%>
<!DOCTYPE html>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>

<%@ include file="head.html" %>

</head>
<body>

<%@ include file="header.jsp"%>
<%if (cart != null && cart.getProducts().size() != 0) { %> 
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
						System.out.println(images.get(i));
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
                        	<td class="col-xs-5"><strong>&euro;<font color = "red"> <del><%=cartArray.get(i).getPrice()%></del></font> <%=cartArray.get(i).getPrice()-cartArray.get(i).getDiscount()%></strong></td>
                        <% totalPrice += cartArray.get(i).getPrice()-cartArray.get(i).getDiscount(); 
                        	} %>
                        <td class="col-xs-1 text-right">
                        <a href="cart?action=remove&id=<%=cartArray.get(i).getId()%>&removeFromCart=<%=i%>"><button type="button" class="btn btn-danger">
                            <span class="glyphicon glyphicon-remove"></span> Remove
                        </button></a></td>
                    </tr>
                    <% } %>
                    <tr>
                        <td class="col-xs-6"><h3>Total</h3></td>
                        <td class="col-xs-1"></td>
                        <td class="col-xs-5 text-right"><h3><strong>&euro;<%=totalPrice %></strong></h3></td>
                    </tr>
                    <tr>
                        <td class = "col-xs-6">
                        <a href="catalog">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                        </button></a></td>
                        <td class = "col-xs-1"></td>
                        <td class="col-xs-5 text-right">
                        <a href="checkout"><button type="button" class="btn btn-success">
                            Checkout <span class="glyphicon glyphicon-play"></span>
                        </button></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
 <% } else { %>
	
	 <div class="container"> 
			<h2> No products in you cart! </h2>
	</div>
<% } %>
 
  
 <%@ include file="footer.jsp" %>
</body>
</html>