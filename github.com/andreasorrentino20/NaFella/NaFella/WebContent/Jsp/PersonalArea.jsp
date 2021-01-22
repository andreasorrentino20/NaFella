<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			
<%
	Collection<?> addresses = (Collection<?>) request.getAttribute("addresses");
	Address address = (Address) request.getAttribute("address");
	
	Collection<?> orders = (Collection<?>) request.getAttribute("orders");
	Order order = (Order) request.getAttribute("order");
	
	Collection<?> products = (Collection<?>) request.getAttribute("products");
	Product product = (Product) request.getAttribute("order");
	
	String error_delete = (String) session.getAttribute("ErrorDelete");

%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer,com.NaFella.Model.Bean.Address,com.NaFella.Model.Bean.Order"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Personal Area</title>
	
	<%@ include file="head.html" %>

	<script>
	  var pathname = window.location.pathname;
	  if(pathname=="/NaFella/Jsp/PersonalArea.jsp")
	  {
			  window.location.href = "personalArea"
	  }							
	</script>
	
</head>

<body>
	
	<%@ include file="header.jsp"%>
	
	<div class="container">
	
	<%
	 Customer sessione = (Customer) request.getSession().getAttribute("customer");
	 if(sessione!=null)
	   {
		 if(sessione.getEmail()!=null)
		 { 
		 
		    if(error_delete!=null)
	 		{%>	
				<div class="alert alert-danger">
			      <strong>Sorry!</strong> <%=error_delete%>
				</div>
	   		<%
	   		}
	   		session.removeAttribute("ErrorDelete");
	   		%> 
		 	 
		     <font color="green"> <h3> Welcome, <%=sessione.getFirstName()%> <%=sessione.getLastName()%>, into your Personal Area. </h3> </font>
			
			<div class="container">
			  <h2>My Personal Area</h2>
			 <div class="panel-group" id="accordion">
			  <div class="panel panel-default">
				     <div class="panel-heading">
				       <h4 class="panel-title">
				         <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">My personal Information</a>
				       </h4>
				     </div>
				     <div id="collapse1" class="panel-collapse collapse">
				       <div class="panel-body">
					       <div class="form-group">
							  <label>Email:</label>
							  <input type="text" value="<%=sessione.getEmail()%>" class="form-control" disabled> 
							</div>
							<div class="form-group">
							  <label>First Name</label>
							 <input type="text" value="<%=sessione.getFirstName()%>" class="form-control" disabled> 
							</div>
							<div class="form-group">
							  <label>Last Name:</label>
							 <input type="text" value="<%=sessione.getLastName()%>" class="form-control" disabled> 
							</div>	
							<div class="form-group">
							  <label>Phone Number:</label>
							  <input  type="text"  value="<%=sessione.getPhoneNumber()%>" class="form-control" disabled> 
							</div>      
			       		</div>
			     	</div>
			    </div>
			    <div class="panel panel-default">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">View Address</a>
			        </h4>
			      </div>
			      <div id="collapse2" class="panel-collapse collapse in">
			        <div class="panel-body">
			        
				        <%
							if (addresses != null && addresses.size() != 0) {
								Iterator<?> it = addresses.iterator();
								while (it.hasNext()) {
									Address adr = (Address) it.next();
						%>
						
						
						<%=adr.getStreet()%>, &nbsp;
						<%=adr.getPostalCode()%> &nbsp;
						<%=adr.getCity()%> &nbsp; 
						(<%=adr.getProvince()%>) &nbsp;
						<%=adr.getCountry()%>
						<a href="personalArea?action=edit&id=<%=adr.getId()%>"> <span class="glyphicon glyphicon-edit"></span> </a>
						<a href="personalArea?action=delete_address&id=<%=adr.getId()%>"> <span class="glyphicon glyphicon-trash"></span> </a> <br>		
				
						<%
								}
							} else {
						%>
							
							No addresses available
						
						<%
							}
		
						if (address != null) {
							%>
							<h2>Edit</h2>
							<form name='ad_form' action="personalArea" onSubmit="return ad_form_Validation()" method="post" class="form-inline">
								<input type="hidden" name="action" value="modify"> 
								  
								<input name="id" type="hidden" value="<%=address.getId()%>"> 
								
								<div class="form-group">
								  <label>Street:</label> <span id="error1_1"> </span>
								  <input name="street" type="text" maxlength="128" value="<%=address.getStreet()%>" class="form-control"> 
								</div>
								<div class="form-group">
								  <label>City:</label> <span id="error1_2"> </span>
								 <input name="city" type="text" maxlength="64" value="<%=address.getCity()%>" class="form-control">
								</div>
								<div class="form-group">
								  <label>Postal Code:</label> <span id="error1_3"> </span>
								 <input name="postalCode" type="text" maxlength="16" value="<%=address.getPostalCode()%>" class="form-control">
								</div>
								<div class="form-group">
								  <label>Province:</label> <span id="error1_4"> </span>
								  <input name="province" type="text"  maxlength="16" value="<%=address.getProvince()%>" class="form-control">
								</div>	
								<div class="form-group">
								  <label>Country:</label> <span id="error1_5"> </span>
								  <input name="country" type="text"  maxlength="32" value="<%=address.getCountry()%>" class="form-control">
								</div>
										
								<button type="submit" class="btn btn-danger" >Modify</button>
							</form>
							<%
								}
							%>        
			        </div>
			      </div>
			    </div>
			    <div class="panel panel-default">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Insert Address</a>
			        </h4>
			      </div>
			      <div id="collapse3" class="panel-collapse collapse in">
			        <div class="panel-body">
			        
						<form name='address_form' action="personalArea" onSubmit="return address_form_Validation()" method="post">
							<input type="hidden" name="action" value="insert_address"> 
							
							<div class="form-group">
							  <label for="street">Street:</label> <span id="error1"> </span>
							  <input name="street" type="text" maxlength="128" placeholder="enter street" class="form-control"> 
							</div>
							<div class="form-group">
							  <label for="city">City:</label> <span id="error2"> </span>
							  <input name="city" type="text" maxlength="64" placeholder="enter city" class="form-control">
							</div>
							<div class="form-group">
							  <label for="postalCode">Postal Code:</label> <span id="error3"> </span>
							  <input name="postalCode" type="text" maxlength="16" placeholder="enter Postal Code" class="form-control">
							</div>
							<div class="form-group">
							  <label for="province">Province:</label> <span id="error4"> </span>
							  <input name="province" type="text" maxlength="16" placeholder="enter province" class="form-control">
							</div>	
							<div class="form-group"> 
							  <label for="country">Country:</label> <span id="error5"> </span>
							  <input name="country" type="text"  maxlength="32" placeholder="enter country" class="form-control">
							</div>
									
							<button type="submit" class="btn btn-success" >Insert</button>
						</form>
			        
			        </div>
			      </div>
			     </div>
			    <div class="panel panel-default">
			     <div class="panel-heading">
			       <h4 class="panel-title">
			         <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">My order</a>
			       </h4>
			     </div>
			     <div id="collapse4" class="panel-collapse collapse">
			       <div class="panel-body">
			       		
			       		<%
			       		int id_order = 0,i = 0;
			       		
			       		if (orders != null && orders.size() != 0 && products != null && products.size() != 0) {
							Iterator<?> it_ord = orders.iterator();
							Iterator<?> it_prod = products.iterator();
							%>
					 <div class="col-lg-15">
		                  <div class="panel panel-default">
		                      <div class="panel-heading">
		                           Orders Effectuated
		                      </div>
		                      <!-- /.panel-heading -->
		                      <div class="panel-body">
		                          <div class="table-responsive">
		                              <table class="table">
		                               <thead>   
							<%
							while (it_ord.hasNext()&& it_prod.hasNext()) {
								Order ord = (Order) it_ord.next();
								Product prd = (Product) it_prod.next();
								
								if(i==0)
								{
								%>									
		                                   	<tr>
												<th>Order Status (Tracking Code)</th>
												<th>#</th>
		                                        <th>Was made on</th>
		                                        <th>Payment</th>
		                                        <th>Total price</th>
		                                        <th><%if(ord.getTracking()==null)
													{
								 	 				%>						
														Delete
													<%
													}%>
												</th>
												<th>You bought</th>
			                                	<th>Size</th>
			                                	<th>Tipo Piatto</th>
			                                	<th>Type</th>
			                                	<th>Real Price Product </th>
			                             	</tr>
		                               
								
								<%i=1;
								}%>
								</thead>
								<tbody>
								
								<%if(ord.getId()!=id_order)
								{
									id_order=ord.getId();
									%>									
									
									<%
									if(ord.getTracking()==null)
									{
								  		%>
								  		<tr class="danger">
		                                     <td>Order to be ACCEPTED.</td>       
		                                     <td><%=ord.getId()%></td>
		                                     <td><%=ord.getDate()%></td>
		                                     <td><%=ord.getPaymentState()%></td>
		                                     <td><%=ord.getPrice()%></td>
		                                     <td><a href="personalArea?action=delete_order&id=<%=ord.getId()%>"> <span class="glyphicon glyphicon-trash"></span> </a> </td>
		                                </tr>								  		
										<%
									}
									else 
									{%>
										<tr class="success">
		                                      <td>ORDER ACCEPTED (<%=ord.getTracking()%>)</td>       
		                                     <td><%=ord.getId()%></td>
		                                     <td><%=ord.getDate()%></td>
		                                     <td><%=ord.getPaymentState()%></td>
		                                     <td><%=ord.getPrice()%></td>
		                                     <td></td>
		                               </tr>				 
									<%}%>                 	                            								    
								<%} 
								 
								if(ord.getTracking()==null)
									{
								  		%>
								  										  		
					 					<tr class="danger">
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
										<%
									}
									else 
									{%>
		                               <tr class="success">
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
									<%}%>                           					 		                
						<%
								}%>
							</tbody>	
							
                            </table>
	                        </div>
	                        <!-- /.table-responsive -->
	                    </div>
	                    <!-- /.panel-body -->
	                </div>
	                <!-- /.panel -->
	            </div>
	            <!-- /.col-lg-6 -->	
							<%} 
			       			  else 
			       			  {
								%>
									No orders available.
									<a href="catalog" class="btn btn-default"> Go to Catalog </a>
								<%
							  } %>						
				      	
		                                            
			       </div>
			     </div>
			    </div>
			  </div> 
			</div>
	  <% }	
	   }
	 else
	  {
		 %> 
		 	<font color="red"> <h3> Access to the restricted area is denied. If you are logged in log in or register. <br>
		 							Redirect between <span id="secondi">  </span> seconds. </h3> </font>
		 	<script>
			// Redirect dopo 3 secondi
			setTimeout(function() {
			  window.location.href = "index.jsp";
			}, 3000);
			</script>
			
			<script type="text/JavaScript" src="js/countdown.js"></script>
	<%
	  }
	 %>
	 
	 </div>
	 <%@ include file="footer.jsp" %>
</body>
</html>