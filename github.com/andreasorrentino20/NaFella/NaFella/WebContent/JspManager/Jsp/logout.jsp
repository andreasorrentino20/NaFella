<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
<%@ include file="../fragments/ico.html" %>
</head>
<body>

<% session.removeAttribute("admin"); 
   session.removeAttribute("Time");
%>

<script>
        	        top.location.href = "login.jsp";
</script>

</body>
</html>