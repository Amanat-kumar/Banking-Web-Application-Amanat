package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setActiveAccount")
public class SetActiveAccount extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accountNoT=req.getParameter("accountNoT");
		long accountNocp=Long.parseLong(accountNoT);
		req.getSession().setAttribute("accountNoS", accountNocp);
		req.getRequestDispatcher("customerAccountHome.html").include(req, resp);
	}
}
