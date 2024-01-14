package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccounts;
import dto.BankTransactions;

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String wAmt=req.getParameter("wAmt");
		double wAmtcp=Double.parseDouble(wAmt);
		long accountNo=(Long)req.getSession().getAttribute("accountNoS");
		
		BankDao bankDao=new BankDao();
		BankAccounts bankAcount=bankDao.find(accountNo);
		if(bankAcount.getAmount()<wAmtcp)
		{
			resp.getWriter().print("<h1>Insufficient balance, your avialble balance is : "+bankAcount.getAmount()+"</h1>");
			req.getRequestDispatcher("customerHome.html").include(req, resp);
		}
		else {
			if(wAmtcp>bankAcount.getAccountLimit())
			{
				resp.getWriter().print("<h1>you are exceeding limit your account  limit is : "+bankAcount.getAccountLimit()+"</h1>");
				req.getRequestDispatcher("customerAccountHome.html").include(req, resp);
			}
			else
			{
				bankAcount.setAmount(bankAcount.getAmount()-wAmtcp);
				BankTransactions bankTransaction=new BankTransactions();

				bankTransaction.setDeposite(0);
				bankTransaction.setWithdraw(wAmtcp);
				bankTransaction.setAvailableBalance(bankAcount.getAmount());
				bankTransaction.setTransactionDateTime(LocalDateTime.now());
				List<BankTransactions> transactionList=bankAcount.getTransactionList();
				transactionList.add(bankTransaction);// previous transaction history+current transsaction history
				bankAcount.setTransactionList(transactionList);
				bankDao.updateAccountDetails(bankAcount);

				resp.getWriter().print("<h1>"+wAmtcp+" Amount withdrawed succesfully</h1>");
				req.getRequestDispatcher("customerAccountHome.html").include(req, resp);
			}
		}
	}
}
