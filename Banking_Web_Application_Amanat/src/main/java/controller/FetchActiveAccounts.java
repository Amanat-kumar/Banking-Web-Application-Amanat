package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BankAccounts;
import dto.Customers;

@WebServlet("/fetchActiveAccount")
public class FetchActiveAccounts extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customers customer=(Customers) req.getSession().getAttribute("customer");
		List<BankAccounts> cAccountList=customer.getBankAccountList();
		
		ArrayList<BankAccounts> activeAccountList=new  ArrayList<>();
		
		for (BankAccounts bank_Account : cAccountList) {
			if (bank_Account.isAccountStatus()) {
				//System.out.println("status is active");
				activeAccountList.add(bank_Account);
			} 
			
		}
		req.getSession().setAttribute("activeAccountList", activeAccountList);
		req.getRequestDispatcher("accounts.jsp").include(req, resp);
	}
}
