<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="demo" uri="http://ujjwal.com" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<demo:products password="derby" database="jdbc:derby:C:\\Users\\ujjwa\\testDB" query="SELECT * FROM products" username="admin"></demo:products>
</body>
</html>