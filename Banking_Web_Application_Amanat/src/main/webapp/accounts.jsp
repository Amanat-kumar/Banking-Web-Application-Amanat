<%@page import="dto.BankAccounts"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Active Accounts</title>
</head>
<body>
<h1>Welcome To Your Bank Accounts Page</h1>
<%
List<BankAccounts> activeAccountList=(List<BankAccounts>)request.getSession().getAttribute("activeAccountList");
if(activeAccountList.isEmpty())
{
%>
	<h1>You don't have any Active Account</h1>
<%
}
else{
%>
	<h1>Select Bank Account</h1>

	
	<%for(BankAccounts activeAccount : activeAccountList){%>
	
		<a href="setActiveAccount?accountNoT=<%= activeAccount.getAccountNo() %>"><button><%= activeAccount.getAccountNo() %></button></a>
	<%} %>
<%}%>

	<br>
	<br>
	<a href="customerHome.html"><button>Back</button></a>
	<br>
    <br>
	<a href="logOut"><button>LogOut</button></a>
</body>
</html>