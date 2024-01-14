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

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aName=req.getParameter("aName");
		String aEmail=req.getParameter("aEmail");
		
		BankDao bankDao=new BankDao();
		
		if(aEmail.equals("admin@gmail.com") && aName.equals("admin"))
		{
			resp.getWriter().print("<h1>Admin Login Success</h1>");
			List<BankAccounts> bankAccountList=bankDao.fetchAll();			
			//session tracking
			req.getSession().setAttribute("bankAccountList", bankAccountList);
			req.getRequestDispatcher("adminhome.jsp").include(req, resp);
		}
		else {
			resp.getWriter().print("<h1>Invalid Login Credential</h1>");
		}
	}
}
