<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer,com.NaFella.Model.Bean.Address"%>

<%@ page contentType="text/html; charset=UTF-8" import="com.NaFella.Model.Bean.Product,com.NaFella.Model.Bean.Order"%>

<%
 	
	Collection<?> addresses = (Collection<?>) request.getAttribute("addresses_admin");
	Address address = (Address) request.getAttribute("address");
	
	Collection<?> orders = (Collection<?>) request.getAttribute("orders_admin");
	Order order = (Order) request.getAttribute("order");
	
	Collection<?> products = (Collection<?>) request.getAttribute("products_admin");
	Product product = (Product) request.getAttribute("product");
	
	Customer sessione = (Customer) request.getSession().getAttribute("admin");
     
	if(sessione!=null)
	{		
		 if(sessione.getEmail().length()>0)
	 	{
		       
	     	
%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Total Orders - NaFella Manager</title>
	
	<%@ include file="../fragments/ico.html" %>
	
	<script>
	  var pathname = window.location.pathname;
	  if(pathname=="/NaFella/JspManager/Jsp/total_orders.jsp")
	  {
			 window.location.href = "total_orders"
	  }							
	</script>
	
	<link href="../vendor/bootstrap/css/admin.css" rel="stylesheet">
	
    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
</head>

<body>

    <div id="wrapper">

		<%@ include file="../fragments/nav.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Total Orders</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <%
			       		int id_order = 0;
			       		
			       		if (orders != null && orders.size() != 0 && products != null && products.size() != 0 && addresses != null && addresses.size() != 0) {
							Iterator<?> it_ord = orders.iterator();
							Iterator<?> it_prod = products.iterator();
							Iterator<?> it_adr = addresses.iterator();
							%>
            <div class="row">
                <div class="col-lg-15">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Orders (Sold items <%=orders.size()%>)
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>Purchase Date</th>
                                            <th>Tracking Code</th>
                                            <th>Payment State</th>
                                            <th>Total Price</th>
                  							<th>Id Customer</th> 
                  						    <th>Street</th>
                  						    <th>Postal Code</th>
                  						    <th>City</th>
                  						    <th>Province</th>
                  						    <th>Country</th>
                  						    <th>Name Product</th>
			                                <th>Size</th>
			                                <th>Tipo Piatto</th>
			                                <th>Type</th>
			                                <th>Real Price Product </th>                 							
                                        </tr>
                                    </thead>
                                    <%
										while (it_ord.hasNext()&& it_prod.hasNext()) {
											Order ord = (Order) it_ord.next();
											Product prd = (Product) it_prod.next();
											Address adr = (Address) it_adr.next();
											
											
											%>	
		                                    <tbody>
		                                    <%if(ord.getId()!=id_order)
										  	{
												id_order=ord.getId();
												%>						
												
											  		<tr>      
					                                     <td><%=ord.getId()%></td>
					                                     <td><%=ord.getDate()%></td>
					                                     <%
															if(ord.getTracking()==null)
															{
														  		%>
					                                     		<td id="accept">Order to be accepted</td>
					                                       <%} 
					                                       else
					                                       {%>
					                                       	   <td id="accepted"><%=ord.getTracking()%></td>
					                                    <% }%>
					                                     <td><%=ord.getPaymentState()%></td>
					                                     <td><%=ord.getPrice()%></td>
					                                     <td><%=ord.getCustomerId()%></td>
					                                     <td><%=adr.getStreet()%></td>
					                                	 <td><%=adr.getPostalCode()%></td>
					                                	 <td><%=adr.getCity()%></td>
					                                	 <td><%=adr.getProvince()%></td>
					                                	 <td><%=adr.getCountry()%></td>
					                                </tr>								  					 
											<%}%>                 	                            								    							
								  										  		
					 					<tr>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td></td>
		                                	<td><%=prd.getName()%></td>
		                                 	<td><%=prd.getSize()%></td>
		                                  	<td><%=prd.getSex()%></td>
		                                  	<td><%=prd.getType()%></td>
		                                  	<td><%=prd.getReal_price()%></td>
		                                </tr>
										                   					 		                
								<%	} %>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div> 
                 <!-- /.col-lg-8 -->     
            </div>
            <!-- /.row -->
			<%} 
			  else
			  {%>
					<h3> No Orders available </h3>
			<%}%>
                        
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../vendor/raphael/raphael.min.js"></script>
    <script src="../vendor/morrisjs/morris.min.js"></script>
    <script src="../data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
<%}
}
else
{	
	session.setAttribute("ErrorIndex", "You must be logged in to access the administrator area."); %>
	<script>
		window.location.href = "login.jsp";
	</script>
	
<%
}
%>