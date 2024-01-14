package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dto.BankAccounts;

@WebServlet("/changeStatus")
public class ChangeStatus  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNo=req.getParameter("accountNo");
		long accountNocp=Long.parseLong(accountNo);
		
		BankDao bankDao=new BankDao();
		BankAccounts bankAccount=bankDao.fetchAccountDetails(accountNocp);
		
		if(bankAccount.isAccountStatus())
		{
			bankAccount.setAccountStatus(false);
		}
		else {
			bankAccount.setAccountStatus(true);
		}
		
		bankDao.updateAccountDetails(bankAccount);
		resp.getWriter().print("<h1>Status got updated</h1>");
		
		//here i am going to take the updated information from bank account table
		List<BankAccounts> bankAccountList=bankDao.fetchAll();
		//session tracking
		req.getSession().setAttribute("bankAccountList", bankAccountList);
		req.getRequestDispatcher("adminhome.jsp").include(req, resp);
		
	}
}
