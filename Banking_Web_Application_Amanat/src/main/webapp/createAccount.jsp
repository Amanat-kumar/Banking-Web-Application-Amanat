<%@page import="dto.Customers"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Bank Account</title>
</head>
<body>
	<h1>Welcome to Account Creation Page</h1>
	<%
	Customers customer =(Customers) request.getSession().getAttribute("customer");
	%>
	<h1>Hello dear <%= customer.getcName() %> </h1>
	<form action="createBankAccount">
		<h2>Please Select Account type</h2><br>
		<input type="radio" name="accountType" value="savings" required>Savings <br><br>
		<input type="radio" name="accountType" value="current" required>Current <br><br>
		<button>Submit</button>
		<button>Reset</button>
	</form>
	<a href="customerHome.html"><button>Back</button></a>
	<br>
	<br>
	<a href="logOut"><button>LogOut</button></a>
</body>
</html>