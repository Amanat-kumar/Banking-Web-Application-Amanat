<%@page import="dto.BankTransactions"%>
<%@page import="dto.BankAccounts"%>
<%@page import="java.util.List"%>
<%@page import="dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction</title>
</head>
<body>
<h1>welcome to Transaction Page</h1>

<%
long accountNo=(long) request.getSession().getAttribute("accountNoS"); 
BankDao bankDao=new BankDao();
BankAccounts bankAccount=bankDao.find(accountNo);
List<BankTransactions> transactionList=bankAccount.getTransactionList();
%>

<table border="1">
	<tr>
	<td>Transaction ID</td>
	<td>Deposit</td>
	<td>Withdraw</td>
	<td>Available Balance</td>
	<td>Transaction Date</td>
	</tr>
<%
for(BankTransactions bankTransaction : transactionList) {
%>

<tr>
	<td><%= bankTransaction.getTransactionId() %> </td>
	<td><%= bankTransaction.getDeposite() %> </td>
	<td><%= bankTransaction.getWithdraw() %> </td>
	<td><%= bankTransaction.getAvailableBalance() %> </td>
	<td><%= bankTransaction.getTransactionDateTime()%></td>
	<%} %>
	</tr>
</table>

	<br>
	<a href="customerAccountHome.html"><button>Back</button></a>
	<br>
	<br>
	<a href="logOut"><button>LogOut</button></a>
</body>
</html>