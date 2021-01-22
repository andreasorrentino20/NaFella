<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer"%>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Login</title>
	
	<%@ include file="head.html" %>
	
</head>

<body>
	
	<%  
	
	 Customer sessione = (Customer) request.getSession().getAttribute("customer");
	 
	 if(sessione!=null)		
		 if(sessione.getEmail().length()==0)
		    session.removeAttribute("customer"); 
    %>
	
	<div class="container">
	
	<%@ include file="header.jsp" %>
	
	<%
	
	if(request.getAttribute("message_danger")!=null)
	{
		%> 
		
		<div class="alert alert-danger">
	      <strong>Sorry!</strong> <%=request.getAttribute("message_danger") %>
		</div>
		
	  <%
	}
	
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
			
			  %>  
			  <div class="alert alert-success">
		        <strong>Welcome!</strong> <%=sessione.getFirstName()%> <%=sessione.getLastName()%>, login made.
		      </div>
			  		
			  <font color="red"> <h3> Redirect in your reserved area between <span id="secondi">  </span> seconds. </h3> </font>	
			  <script>
					// Redirect dopo 3 secondi
					setTimeout(function() {
					  window.location.href = "personalArea";
					}, 3000);
				</script> 
				
				<script language="JavaScript" type="text/JavaScript" src="js/countdown.js"></script>	
			  		
			
		<% }	
	   } %>
	   
	   
		  <h2>Login Customer</h2>
		  <form name='forms_login' action="login"  onSubmit="return login_Validation()" method="post">
		   <input type="hidden" name="action" value="login"> 
		    <div class="form-group">
		      <label for="email">Email:</label> <span id="error1"> </span>
		      <input type="text" class="form-control" maxlength="64" id="email" placeholder="Enter email" name="email">
		    </div>
		    <div class="form-group">
		      <label for="pwd">Password:</label> <span id="error2"> </span>
		      <input type="password" class="form-control" maxlength="25" id="pwd" placeholder="Enter password" name="psw">
		    </div>
		    <button type="submit" value="Send" class="btn btn-success">Login</button>
		  </form>
		</div>

	<%@ include file="footer.jsp" %>
</body>
</html>