<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer"%>

<%
	Customer register = (Customer) request.getAttribute("customer");
%>

<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Sign up</title>
	
	<%@ include file="PresentationLayer/Jsp/head.html" %>
	
</head>

<body>
	
	<%@ include file="PresentationLayer/Jsp/header.jsp" %>
	
	<div class="container">
	
	<% if(session.getAttribute("register_fault")!=null)
	   {
	%>
		<div class="alert alert-danger">
		    <strong>Sorry!</strong> <%=session.getAttribute("register_fault")%> , you are already registered. 
		</div>
	
	<%  
	   }  
	   else 
		   if(session.getAttribute("register_completed")!=null)
		   {
		%>
			<div class="alert alert-success">
		      <strong>Congratulations!</strong> <%=session.getAttribute("register_completed")%> , you are registered.
		    </div>
		
		<% }  
	
	 Customer sessione = (Customer) request.getSession().getAttribute("customer");
	 
	if(sessione!=null)
	   {		
		
		 if(sessione.getEmail()!=null)
		 {
			  %>  
			  
			  <div class="alert alert-success">
		        <strong>Hello!</strong> <%=sessione.getFirstName()%> <%=sessione.getLastName()%>, login already made.
		      </div>
			
		<% }
	   }
	 else
	  {
		 session.removeAttribute("register_completed");
		 session.removeAttribute("register_fault");
		 %> 
    
        
		  <h2>Register New Customer</h2>
		  <form name='signup_forms' action="signup" onSubmit="return signup_formValidation()" method="post"> 
		  	<input type="hidden" name="action" value="insert">
		  
		    <div class="form-group">
		      <label for="email">Email:</label> <span id="error1"> </span>
		      <input type="text" maxlength="64" class="form-control" id="email" placeholder="Enter email" name="email">
		    </div>
		    <div class="form-group"> 
		      <label for="first_name">First Name:</label> <span id="error2"> </span>
			  <input name="first_name" type="text" maxlength="64" class="form-control" id="firs_name" placeholder="enter first name">
		    </div>
		    <div class="form-group">
		      <label for="last_name">Last Name:</label> <span id="error3"> </span>
			  <input name="last_name" type="text" maxlength="64"  class="form-control" id="last_name" placeholder="enter last name"><br>
		    </div>
		    <div class="form-group">
		      <label for="phone_number">Phone number: </label> <span id="error4"> </span>
			  <input name="phone_number" type="text" maxlength="10" class="form-control" placeholder="enter Phone number"><br>
		    </div>
		    <div class="form-group">
		      <label for="pwd">Password:</label> <span id="error5"> </span>
		      <input type="password" maxlength="25" class="form-control" id="pwd" placeholder="Enter password" name="psw">
		    </div>
		    <button type="submit" value="Send" class="btn btn-success">Submit </button> 
		    <button type="reset" value="Reset" class="btn btn-danger"> Reset </button> 
		  </form>
		</div>
		   
	<% }
	%>
	
	<%@ include file="PresentationLayer/Jsp/footer.jsp" %>
</body>
</html>

