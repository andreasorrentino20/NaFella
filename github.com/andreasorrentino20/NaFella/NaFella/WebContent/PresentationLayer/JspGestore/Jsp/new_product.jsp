<%@ page contentType="text/html; charset=UTF-8" import="java.io.*,java.util.*,com.NaFella.Model.Bean.Customer"%>


<%
 	
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

    <title>Insert New Product NaFella Manager</title>
	
	<%@ include file="../fragments/ico.html" %>
	
        <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<script src="../js/form-validation.js"></script>
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
            <br><br>
            	<% if(request.getAttribute("message_success")!=null)
				   {%>
				   	  <div class="alert alert-success">
				        <strong>Success!</strong> <%=request.getAttribute("message_success")%>
				      </div>
				 <%}
				   else
					   if(request.getAttribute("message_danger")!=null)
					   {%>
					   	  <div class="alert alert-danger">
					        <strong>Danger!</strong> <%=request.getAttribute("message_danger")%>
					      </div>
					 <%}%>
                <div class="col-lg-12">
                    <h1 class="page-header">Insert New Product</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Form Elements
                        </div>
                        <div class="panel-body">
                            <div class="row">
                           
                            <form name='all_forms' action="uploadfile" onSubmit="return formValidation()" method="post" enctype="multipart/form-data">
                                <div class="col-lg-6">
                                    
                                    <input type="hidden" name="action" value="insert_product">
                                        <div class="form-group">
                                            <label>Product Name</label> <span id="error1"></span>
                                            <input type="text" maxlength="64" class="form-control" placeholder="Enter Product Name" name="product_name">
                                        </div>
                                        <div class="form-group">
                                            <label>Size</label> <span id="error2"></span>
                                            <input type="text" maxlength="16" class="form-control" placeholder="Enter Size" name="size">
                                        </div>
                                        <div class="form-group">
                                            <label>Select Image</label> <span id="error4"></span>
                                            <input type="file" multiple accept="image/*" name="file" >
                                        </div>
                                        <div class="form-group">
                                            <label>Tipo Piatto</label> <span id="error5"></span>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="sex" id="optionsRadios1" value="Bianca" checked> CARNE BIANCA
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="sex" id="optionsRadios2" value="Rossa"> CARNE ROSSA
                                                </label>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="sex" id="optionsRadios3" value="PiattiPronti"> PIATTI PRONTI
                                                </label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label>Product Type</label> <span id="error6"></span>
                                            <select name = "product_type" class="form-control">
                                                <option value="PrimaScelta">Prima Scelta</option>
                                                <option value="Salumi">Salumi</option>
                                                <option value="Affettati">Affettati</option>
                                                <option value="PrimiPiatti">Primi Piatti</option>
                                                <option value="SecondiPiatti">Secondi Piatti</option>
                                                <option value="Contorni">Contorni</option>
                                            </select>
                                        </div>                                  
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                                <div class="col-lg-6">  
                                	<div class="form-group">
                                         <label>Description</label> <span id="error8"></span>
                                         <textarea maxlength="256" class="form-control" rows="3" placeholder="Enter Description" name="description"></textarea>
                                    </div>                            
                                    <label>Price</label>  <span id="error9"></span>
                                    <div class="form-group input-group">
                                         <span class="input-group-addon"><i class="fa fa-eur"></i></span>
                                         <input type="text" maxlength="8" class="form-control" placeholder="Enter Price" name="price">
                                    </div>
                                    <label>Discount (Optional - If you want to leave it blank enter 0)</label> <span id="error10"></span>
                                    <div class="form-group input-group"> 
                                        <span class="input-group-addon"><i class="fa fa-eur"></i></span>
                                        <input type="text" maxlength="8" class="form-control" placeholder="Enter Discount" name="discount">
                                    </div>
                                    <div class="form-group">
                                        <label>Availability</label> <span id="error11"></span>
                                        <input type="text" maxlength="10" class="form-control" placeholder="Enter Availability" name="availability">
                                    </div>
                                    
                                    <button type="submit" class="btn btn-success">Insert New Product</button>
                                    <button type="reset" class="btn btn-danger">Reset All</button>                                
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