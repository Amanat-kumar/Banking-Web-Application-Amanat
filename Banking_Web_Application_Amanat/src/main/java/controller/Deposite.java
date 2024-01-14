package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccounts;
import dto.BankTransactions;

@WebServlet("/deposite")
public class Deposite extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String dAmt=req.getParameter("dAmt");
		double dAmtcp=Double.parseDouble(dAmt);
		long acountNoT=(long)req.getSession().getAttribute("accountNoS");
		System.out.println(acountNoT);
		
		BankDao bankDao=new BankDao();
		BankAccounts bankAcount=bankDao.find(acountNoT);
		bankAcount.setAmount(bankAcount.getAmount()+dAmtcp);
		bankDao.updateAccountDetails(bankAcount);
		
		BankTransactions bankTransaction=new BankTransactions();

		bankTransaction.setDeposite(dAmtcp);
		bankTransaction.setWithdraw(0);
		bankTransaction.setAvailableBalance(bankAcount.getAmount());
		bankTransaction.setTransactionDateTime(LocalDateTime.now());
		
		List<BankTransactions> transactionList=bankAcount.getTransactionList();
		transactionList.add(bankTransaction);
		bankAcount.setTransactionList(transactionList);
		bankDao.updateAccountDetails(bankAcount);

		
		resp.getWriter().print("<h1>"+dAmtcp+" Amount Despoited succesfully</h1>");
		req.getRequestDispatcher("customerAccountHome.html").include(req, resp);
		
	}

}
