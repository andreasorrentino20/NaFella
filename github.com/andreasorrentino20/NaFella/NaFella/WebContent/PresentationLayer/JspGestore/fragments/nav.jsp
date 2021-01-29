
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,com.NaFella.Model.Bean.Customer"%>


<%
 	
	 Customer sessione_header = (Customer) request.getSession().getAttribute("admin");

	String time = (String) session.getAttribute("Time");
	
	
	 String nome = null;
	 if(sessione_header!=null)
		 if(sessione_header.getEmail()!=null)
		 {  
		       nome = sessione_header.getFirstName() + " "+sessione_header.getLastName();  	
	     }	
%>
	
	<%@ include file="date_time.jsp"%>
	
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">NaFella Manager</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">

                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li><a href="index.jsp"><i class="fa fa-user fa-fw"></i> Ciao, <%=nome%></a> </li>
                        <li> <i class="fa fa-time fa-fw"></i> <span class="glyphicon glyphicon-time"></span> Logged:   <% if(time!=null){%> <%=time%>	<%}%></li>
                        <li class="divider"></li>
                        <li><a href="logout.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
			
            <!--  <div class="collapse navbar-collapse sidebar" role="navigation">  -->
            <div class="navbar-default sidebar" role="navigation">   
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="index.jsp"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="total_orders?action=total_orders"><i class="fa fa-shopping-cart fa-fw"></i> Total Orders</a>
                        </li>
                        <li>
                            <a href="customers_registered"><i class="fa fa-users fa-fw"></i> Customers Registered</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Products <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="products.jsp">All Products</a>
                                </li>
                                <li>
                                    <a href="new_product.jsp">Insert New Product</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>