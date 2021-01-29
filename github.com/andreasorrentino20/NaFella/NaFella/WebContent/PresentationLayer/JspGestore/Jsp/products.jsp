<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer,com.NaFella.Model.Bean.Product"%>


<%
 	
	 Customer sessione = (Customer) request.getSession().getAttribute("admin");

	 Collection<?> products = (Collection<?>) request.getAttribute("product_admin");
	 Product product = (Product) request.getAttribute("product");
	 
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

    <title>All Products - NaFella Manager</title>
	
	<%@ include file="../fragments/ico.html" %>

	<script>
	  var pathname = window.location.pathname;
	  if(pathname=="/NaFella/JspManager/Jsp/products.jsp")
	  {
			 window.location.href = "products_admin"
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
	
	<script src="../js/modify_validation.js"></script>
	<style>
		#error1, #error2, #error3, #error4, #error5, #error6, #error7, #error8, #error9, #error10, #error11 {
			color: red;
			font-size: medium;
		}
	</style>
	
</head>

<body>

    <div id="wrapper">

		<%@ include file="../fragments/nav.jsp" %>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">All Products</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <%
				if (products != null && products.size() != 0) {
					Iterator<?> it = products.iterator();
					%>
		
            <div class="row">
                <div class="col-lg-10">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Products (<%=products.size()%>)
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>id &nbsp;<a href="products_admin?sort=id"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Product Name &nbsp;<a href="products_admin?sort=product_name"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Size &nbsp;<a href="products_admin?sort=size"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Tipo Piatto &nbsp;<a href="products_admin?sort=tipoPiatto"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Product Type &nbsp;<a href="products_admin?sort=product_type"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Price &nbsp;<a href="products_admin?sort=price"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Discount &nbsp;<a href="products_admin?sort=discount"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Availability &nbsp;<a href="products_admin?sort=availability"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Edit</th>
                                            <th>Detele</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <% while (it.hasNext()) {
													Product pr = (Product) it.next();
										%>
										
                                        <tr>
                                            <td><%=pr.getId()%> </td>
                                            <td><%=pr.getName()%></td>
                                            <td><%=pr.getSize()%></td>
                                            </td>
                                            <td><%=pr.getType()%></td>
                                            <td><%=pr.getPrice()%></td>
                                            <td><%=pr.getDiscount()%></td>
                                            <td><%=pr.getAvailability()%></td>
                                            <td><a href="products_admin?action=edit&id=<%=pr.getId()%>"><span class="glyphicon glyphicon-pencil"></span></a></td>
                                			<td><a href="products_admin?action=delete&id=<%=pr.getId()%>" class="trash"><span class="glyphicon glyphicon-trash"></span></a></td>
                                        </tr>
                                        <%
												}
										%>
                                    </tbody>
                                </table>
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>                
            </div>
            <!-- /.row -->   
           <%} 
			 else {
			  	  %>
							
					No products available
						
				 <%
				  }
				  
            
			if (product != null) 
			{%>
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Edit Product
                        </div>
                        <div class="panel-body">
                            <div class="row">
                            
                               <form name='modify_product_forms' action="products_admin" onSubmit="return modify_formValidation()" method="post">
                                <div class="col-lg-6">
                                 
                                 	<input type="hidden" name="action" value="modify"> 
						  
									<input name="id" type="hidden" value="<%=product.getId()%>"> 
						
									<div class="form-group">
									  <h3>
						  				<label>You are editing the product with id: <%=product.getId()%></label> 
			 						  </h3>	
									</div>
									<div class="form-group">
                                            <label>Product Name</label> <span id="error1"></span>
                                            <input type="text" maxlength="64" class="form-control" value="<%=product.getName()%>" name="product_name">
                                    </div>
                                    <div class="form-group"> 
                                            <label>Size</label> <span id="error2"></span>
                                            <input type="text" maxlength="16" class="form-control" value="<%=product.getSize()%>" name="size">
                                    </div>
                                    <div class="form-group">
                                            <label>Image Url</label> <span id="error4"></span>
                                            <input type="text" maxlength="4096" class="form-control" value="<%=product.getImg()%>" name="image">
                                    </div>
                                    
   									<div class="form-group">
                                            
                                     </div>
								</div>
								<!-- /.col-lg-6 (nested) -->
							 	<div class="col-lg-6">
									<div class="form-group">
                                            <label>Product Type</label> <span id="error6"></span>
                                            <select name = "product_type" class="form-control">
                                                <option value="Prima Scelta" <%if(product.getType().equalsIgnoreCase("Prima Scelta")) {%> selected<%}%>>Prima Scelta</option>
                                                <option value="Salumi" <%if(product.getType().equalsIgnoreCase("Salumi")) {%> selected<%}%> >Salumi</option>
                                                <option value="Affettati" <%if(product.getType().equalsIgnoreCase("Affettati")) {%> selected<%}%>>Affettati</option>
                                                <option value="PrimiPiatti" <%if(product.getType().equalsIgnoreCase("PrimiPiatti")) {%> selected<%}%>>PrimiPiatti</option>
                                                <option value="SecondiPiatti" <%if(product.getType().equalsIgnoreCase("SecondiPiatti")) {%> selected<%}%>>SecondiPiatti</option>
                                                <option value="Contorni" <%if(product.getType().equalsIgnoreCase("Contorni")) {%> selected<%}%>>Contorni</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Description</label> <span id="error8"></span>
                                            <textarea maxlength="256" class="form-control" rows="3" name="description"><%=product.getDescription()%></textarea>
                                        </div>  
                                        <label>Price</label> <span id="error9"></span>
                                    	<div class="form-group input-group">
                                        	<span class="input-group-addon"><i class="fa fa-eur"></i></span>
                                        	<input type="text" maxlength="8" class="form-control" value="<%=product.getPrice()%>" name="price">
                                    	</div>
                                    	<label>Discount</label> <span id="error10"></span>
                                    	<div class="form-group input-group">
                                        	<span class="input-group-addon"><i class="fa fa-eur"></i></span>
                                        	<input type="text" maxlength="8" class="form-control" value="<%=product.getDiscount()%>" name="discount">
                                    	</div>
                                    	<div class="form-group">
                                        	<label>Availability</label> <span id="error11"></span>
                                        	<input type="text" maxlength="11" class="form-control" value="<%=product.getAvailability()%>" name="availability">
                                    	</div>
                                    
                                    	<button type="submit" class="btn btn-success">Modify</button>
								</div>
                                <!-- /.col-lg-6 (nested) -->
                              </form>
                            </div>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row --> 
            <%} %>         
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
	session.setAttribute("ErrorIndex", "You must be logged in to access the manager area."); %>
	<script>
		window.location.href = "login.jsp";
	</script>
	
<%
}
%>