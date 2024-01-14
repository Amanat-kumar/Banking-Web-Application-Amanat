<%@page import="dto.Customers"%>
<%@page import="dao.BankDao"%>
<%@page import="dto.BankAccounts"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Balance</title>
</head>
<body>
<h1>welcome to Balance Page</h1>
	<%
		long accountNo=(long) request.getSession().getAttribute("accountNoS"); 
		BankDao bankDao = new BankDao();
		BankAccounts bankAccount=bankDao.find(accountNo);
		Customers customer=bankAccount.getCustomer();
	%>
	<h1>Hello Your Available Balance is : <%=bankAccount.getAmount() %></h1>
	<br>
	<a href="customerAccountHome.html"><button>Back</button></a>
	<br>
	<br>
	<a href="logOut"><button>LogOut</button></a>
</body>
</html>