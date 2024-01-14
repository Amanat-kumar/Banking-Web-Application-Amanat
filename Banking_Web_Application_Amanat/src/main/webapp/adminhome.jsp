<%@page import="dto.BankAccounts"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<h1>Welcome to Admin home page</h1>
	<%
	List<BankAccounts> bankAccountList=(List<BankAccounts>)request.getSession().getAttribute("bankAccountList");
	%>
	<table border="1">
		<tr>
			<th>Account_number</th>
			<th>Account_type</th>
			<th>Customer_name</th>
			<th>Customer_id</th>
			<th>Account_status</th>
			<th>Change_status</th>
		</tr>
		<%
		for(BankAccounts bankAccount : bankAccountList)  {
		%>
		<tr>
			<th><%=bankAccount.getAccountNo() %></th>
			<th><%=bankAccount.getAccountType() %></th>
			<th><%=bankAccount.getCustomer().getcName() %></th>
			<th><%=bankAccount.getCustomer().getcId() %></th>
			<th><%=bankAccount.isAccountStatus() %></th>
			<th><a href="changeStatus?accountNo=<%= bankAccount.getAccountNo() %>"><button>Change status</button></a></th>
		</tr>
		<%} %>
	</table>
	
	<br>
	<br>
	<a href="logOut"><button>LogOut</button></a>
</body>
</html>