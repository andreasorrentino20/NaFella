<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login Manager</title>
	
	<%@ include file="../fragments/ico.html" %>
	
	<script src="js/login_form_validation.js"></script> 
	
	<script src="../../js/login_form_validation.js"></script>
	
	<link type="text/css" rel="stylesheet" href="../../css/stile.css">
	
    <!-- Bootstrap Core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>

<body>

	<%@ include file="../fragments/date_time.jsp"%>
	
	<%  
	 int login = 0;
	 Customer sessione = (Customer) request.getSession().getAttribute("admin");
	 
	 if(sessione!=null)		
		 if(sessione.getEmail().length()==0)
		    session.removeAttribute("admin"); 
    %>
	
	<div class="container">
	<br><br><br>
	<%
	
	 String error_index = (String) session.getAttribute("ErrorIndex");
	
	 if(error_index!=null)
	 {%>
		 <div class="alert alert-danger">
		      <strong>Sorry!</strong> <%=error_index%>
		 </div>
	 <%}
	 session.removeAttribute("ErrorIndex");
	 
	 if(sessione!=null)
	   {		
		 if(sessione.getEmail().length()==0)
		 { %> 
			
			<div class="alert alert-danger">
		      <strong>Sorry!</strong> Invalid login. Wrong email or password.
			</div>
			
		  <%
		}
		 else
			{    session.setMaxInactiveInterval(900);
				 login = 1;
				 session.setAttribute("Time",time_user_logged);
			  %>  
			  <div class="alert alert-success">
		        <strong>Welcome!</strong> <%=sessione.getFirstName()%> <%=sessione.getLastName()%>, login made.
		      </div>		
			  <font color="red"> <h3> Loading... </h3> </font>	
			  <script>
					// Redirect dopo 3 secondi
					setTimeout(function() {
					  window.location.href = "index.jsp";
					}, 3000);
			  </script> 
				
				 <%@ include file="../animation.html" %>	
			  		
			
		<% }	
	   } 
	 if(login==0){%>
	 

        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form name='forms_login' action="login_admin" onSubmit="return login_Validation()" method="post">
                        <input type="hidden" name="action" value="login_admin">
                            <fieldset>
                                <div class="form-group">
                                	<span id="error1"> </span>
                                    <input class="form-control" placeholder="E-mail" name="email" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                	<span id="error2"> </span>
                                    <input class="form-control" placeholder="Password" name="psw" type="password" value="">
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" value="Send" class="btn btn-lg btn-success btn-block">Login</button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
<% } %>
    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
