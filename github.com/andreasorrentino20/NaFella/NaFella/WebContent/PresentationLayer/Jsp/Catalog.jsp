<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.NaFella.Model.Bean.Product"%>

<% Collection<?> products = (Collection<?>) request.getAttribute("products"); 

	String action = request.getParameter("action");
	String sex = request.getParameter("tipoPiatto");
	String stamp_sex = "";
	
	if(sex!=null)
	{
		if(sex.equalsIgnoreCase("Bianca"))
		{
			stamp_sex = "BIANCA";
		}
		else
			if(sex.equalsIgnoreCase("Rossa"))
			{
				stamp_sex = "ROSSA";
			}
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>
	<% 
		if(action!=null && sex!= null) 
		{%>
			Products <%=action%> <%=stamp_sex%>
	  <%}
		else
		{%>
			Catalog
	  <%} %>

</title>

<%@ include file="head.html" %>

	
	<script>
	  var pathname = window.location.pathname;
	  
	  if(pathname=="/NaFella/Catalog.jsp")
	  {	
			  window.location.href = "catalog";
	  }	
	</script>
	
</head>
<body>
	
	<%@ include file="scroll.html" %>
	
	<%@ include file="header.jsp" %>
		
	 
	
	<% 
		
		String product_name = "";
		
		String stamp = null;
		
		if(action!=null)
		{
			stamp = action + " Products";
		}
		else
			stamp = "All Products";
		
		int pages = 1;
		if(request.getParameter("page")!=null)
		{
			pages = Integer.parseInt(request.getParameter("page"));
		}
		int show = 0;
		int show_limit = 0;
		int count = 1;
		
		if(pages != 0)
		{
			show_limit = 15 +  (15 * (pages - 1));
			show = show_limit - 14;
		}
		
	 if (products != null && products.size() != 0) {
			Iterator<?> it = products.iterator();
			
		%>
		<div class="container"> 
			<h1> <%=stamp %> </h1>    
		  <div class="row">
		<% 
			while (it.hasNext()) {
				Product pr = (Product) it.next();
				
				if(count >= show && count <= show_limit)
				{
					int k = 0;
					if(pr.getDescription().length() > 37)
						k = 37;
					else
						k = pr.getDescription().length();
					
					String name_image = "";
					int i=0;
					String comparison = pr.getImg().substring(i, i+1);
					
					while(!comparison.equalsIgnoreCase("*"))
					{	
						name_image = name_image + pr.getImg().substring(i, i+1);						
						
						i++;
						comparison = pr.getImg().substring(i, i+1);
					}
					
					if(!product_name.equalsIgnoreCase(pr.getName()))
					{ 
						product_name = pr.getName();
					%>		
					    <div class="col-sm-4">
					    <% if(pr.getDescription().equalsIgnoreCase("Bianca"))
					   	   { %>
						      	<div class="panel panel-primary">
					    <% } %>
					    <% if(pr.getDescription().equalsIgnoreCase("Rossa"))
					   	   { %>
					    	 	<div class="panel panel-danger">
						<% } %>
						<% if(pr.getDescription().equalsIgnoreCase("Contorni"))
					       { %>
						     	<div class="panel panel-success">
						<% } %>
						   <div class="panel-heading"><%=pr.getName()%></div>
						   <div class="panel-body"><a href="product?id=<%=pr.getId()%>"><img src="images/<%=name_image%>" class="img-responsive" style="width:100%" alt="Image" title="Clicca per visualizzare"></a></div>
						       
						      	<div class="panel-footer"> Buy € <%if(pr.getDiscount()>0) { %> <font color = "red"> <del><%=pr.getPrice()%></del></font> € <%=Math.floor((pr.getPrice()-pr.getDiscount()) * 100.0) / 100.0%> <% } else { %> <%=pr.getPrice()%> <%}%> <br><%=pr.getDescription().substring(0, k)%>...<a href="product?id=<%=pr.getId()%>">Read More</a></div>
						      </div>
						    </div> 
				 <%}
			}
				count++;
		}
		%>
		  </div>
		</div><br>
		<%int pagination = products.size() / 15;
		
		if(products.size()%15!=0)
		{
			pagination = pagination+1;
		}%>	
		<center>
            <ul class="pagination">
            <% 
            if(pages==1)
              {%>
            		<li class="disabled"><a href="#">«</a></li>
            <%}
              else
              {	%>
            	<li><a href="catalog?page=<%=pages-1%>">«</a></li>
            <%}
            
            for(int i = 1;i<=pagination;i++)
            	  {		
            	  	if(i==pages)
            	  	{%>
		              <li class="active"><a href="catalog?page=<%=i%>"> <%=i%> <span class="sr-only">(current)</span></a></li>
		            <%}
            	  	else
            	  	{%>
		              <li><a href="catalog?page=<%=i%>"><%=i%></a></li>
              	<%	}
            	  } 
              if(pages == pagination)
              {
              %><li class="disabled"> <a href="#">»</a></li>
              <%}
              else
              {%>
            	  <li><a href="catalog?page=<%=pages+1%>">»</a></li>
            	  
              <%}%>
            </ul>
		</center>
	 <%
	} 
	else 
	{
	%> <div class="container"> 
			<h2> <strong> Sorry! </strong> No products available </h2>
		</div>
	<%
	}
	%>	
		
	<%@ include file="footer.jsp" %>
	
	
</body>
</html>