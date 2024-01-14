package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;
import dao.CustomerDao;
import dto.BankAccounts;
import dto.Customers;

@WebServlet("/createBankAccount")
public class CreateBankAccount extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountType=req.getParameter("accountType");
		Customers customer=(Customers) req.getSession().getAttribute("customer"); 
		List<BankAccounts> cAccountsList=customer.getBankAccountList();
		
		boolean flag=true;
		
		for (BankAccounts bankAccount : cAccountsList) {
			
			if(bankAccount.getAccountType().equals(accountType))
			{
				flag=false;
				break;
			}
		}
		
		if (flag==true) {
			BankAccounts bankAccount=new  BankAccounts();
	
			bankAccount.setAccountType(accountType);
			
			if(bankAccount.getAccountType().equals("savings"))
			{
				bankAccount.setAccountLimit(10000);
			}
			else {
				bankAccount.setAccountLimit(15000);
			}
			
			bankAccount.setCustomer(customer);
			
			BankDao bankDao=new  BankDao();
			bankDao.saveAccount(bankAccount);
			
			List<BankAccounts> cAccountList2=cAccountsList;
			cAccountList2.add(bankAccount);
			
			CustomerDao customerDao=new  CustomerDao();
			customerDao.update(customer);
			resp.getWriter().print("<h1>Congratulations your account has been created successfully . <br>Please wait for Manager approval</h1>");
			req.getRequestDispatcher("customerHome.html").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>Account already exists</h1>");
			req.getRequestDispatcher("customerHome.html").include(req, resp);
		}
	}
}
