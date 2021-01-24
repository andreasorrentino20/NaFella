<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer"%>


<%
	 Collection<?> customers = (Collection<?>) request.getAttribute("customers");
	 Customer customers_registered = (Customer) request.getSession().getAttribute("customer");

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
	
    <title>Customers Registered - NaFella Manager</title>
	
	<script>
	  var pathname = window.location.pathname;
	  if(pathname=="/NaFella/JspManager/Jsp/customers_registered.jsp")
	  {
			  window.location.href = "customers_registered"
	  }							
	</script>
	
	<%@ include file="../fragments/ico.html" %>
	
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
                    <h1 class="page-header">Customers Registered</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <% if (customers != null && customers.size() != 0) { %>
            <div class="row">
                <div class="col-lg-7">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Customers Registered (<%=customers.size()%>)
                        
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th>id &nbsp;<a href="customers_registered?sort=id"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>email &nbsp;<a href="customers_registered?sort=email"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Fist Name &nbsp;<a href="customers_registered?sort=first_name"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Last Name &nbsp;<a href="customers_registered?sort=last_name"><span class="fa fa-sort fa-fwt"></span></a></th>
                                            <th>Phone Number &nbsp;<a href="customers_registered?sort=phone_number"><span class="fa fa-sort fa-fwt"></span></a></th>               							
                                        	<th>Delete</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <% 
										Iterator<?> it = customers.iterator();
											while (it.hasNext()) {
												Customer bean = (Customer) it.next();
									%>
	                                        <tr>                                        
	                                            <td><%=bean.getId()%></td>
	                                            <td><%=bean.getEmail()%></td>
	                                            <td><%=bean.getFirstName()%></td>
	                                            <td><%=bean.getLastName()%></td>
	                                            <td><%=bean.getPhoneNumber()%></td>
	                                            <td><a href="customers_registered?action=delete&id=<%=bean.getId()%>"> <span class="glyphicon glyphicon-trash"></span></a></td>
	                                        </tr>
                                   <%		} %>     
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
            <% } 
            	else { %>
            			No customers registred
            	<% }%>           
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