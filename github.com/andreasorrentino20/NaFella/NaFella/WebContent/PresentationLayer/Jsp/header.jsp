
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer, com.NaFella.Model.Bean.Cart"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.NaFella.Model.Bean.Cart, com.NaFella.Model.Bean.Customer, com.NaFella.Model.Bean.Product"%>

<%
 
	 Customer sessione_header = (Customer) request.getSession().getAttribute("customer");

	 Cart cart = (Cart) request.getSession().getAttribute("cart");
     
	 String nome = null;
	 if(sessione_header!=null)
		 if(sessione_header.getEmail()!=null)
		 {  
		       nome = sessione_header.getFirstName() + " "+sessione_header.getLastName();  	
	     }	
%>

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">NaFella</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">CARNE BIANCA <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="catalog?action=PrimaScelta&tipoPiatto=Bianca">Prima Scelta</a></li>
            <li><a href="catalog?action=Salumi&tipoPiatto=Bianca"">Salumi</a></li>
            <li><a href="catalog?action=Affettati&tipoPiatto=Bianca"">Affettati</a></li>
          </ul>
        </li>
        <li class="dropdown">
           <a class="dropdown-toggle" data-toggle="dropdown" href="#">CARNE ROSSA <span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="catalog?action=PrimaScelta&tipoPiatto=Rossa">Prima Scelta</a></li>
            <li><a href="catalog?action=Salumi&tipoPiatto=Rossa">Salumi</a></li>
            <li><a href="catalog?action=Affettati&tipoPiatto=Rossa">Affettati</a></li>
          </ul>
        </li>
        <li class="dropdown">
           <a class="dropdown-toggle" data-toggle="dropdown" href="#">PIATTI PRONTI <span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="catalog?action=PrimiPiatti&tipoPiatto=PiattiPronti">Primi Piatti</a></li>
            <li><a href="catalog?action=SecondiPiatti&tipoPiatto=PiattiPronti">Secondi Piatti</a></li>
            <li><a href="catalog?action=Contorni&tipoPiatto=PiattiPronti">Contorni</a></li>
           </ul>   
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <% if(sessione_header!=null)
	       {
		     if(sessione_header.getEmail()!=null)
		     { %>
		        <li><a href="personalArea"><span class="glyphicon glyphicon-user"></span> Personal Area (<%=nome%>)</a></li>
		        <li><a href="Jsp/Logout.jsp"> <span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
		  <% } 
		   }
		   else 
		   { %>
			    <li><a href="Signup.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
			    <!--   <li><a href="Login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> -->
			  <li class="dropdown">
                     <a class="dropdown-toggle" data-toggle="dropdown">Sign in <b class="caret"></b></a>
                     <ul class="dropdown-menu" style="padding: 15px;min-width: 250px;">
                        <li>
                           <div class="row">
                              <div class="col-md-12">
                                 <form name='forms_login_up' action="login" onSubmit="return login_up_Validation()" method="post">
		   							<input type="hidden" name="action" value="login">
		    							<div class="form-group">
										<label for="email">Email:</label> <span id="error_up_1"> </span>
									    <input type="text" class="form-control" maxlength="64" id="email" placeholder="Enter email" name="email">
									</div>
									<div class="form-group">
									  	<label for="pwd">Password:</label> <span id="error_up_2"> </span>
									    <input type="password" class="form-control" maxlength="25" id="pwd" placeholder="Enter password" name="psw">
									</div>
									<button type="submit" value="Send" class="btn btn-success">Login</button>
								</form>
                              </div>
                           </div>
                        </li>
                     </ul>
                  </li>
        <% } %>
        
        <%
          int n = 0; 
          String message = null;
          
          if (cart != null && cart.getProducts().size() != 0) { 
			n = cart.getProducts().size();
			
		    if(n>1)
		    	message = n + " items";
		    else 
		    	message = n + " item";
			%>
			
			<li><a id="cart" href="cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart (<%=message%>)</a></li> 
		<%
		  } else { %> 
		  <li><a  id="cart" href="cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart (no item)</a></li>
		  <% } %>        
      </ul>
    </div>
  </div>
</nav>

<br><br><br><br><br>