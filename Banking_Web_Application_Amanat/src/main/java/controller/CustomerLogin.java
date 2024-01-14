package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customers;

@WebServlet("/cutomerLogin")
public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cId = req.getParameter("cId");

		int cIdcp = Integer.parseInt(cId);
		String cPwd = req.getParameter("cPwd");

		CustomerDao customerDao = new CustomerDao();
		Customers customer = customerDao.login(cIdcp);//inside customer ref.variable whole customer information is there
		if (customer == null) {
			resp.getWriter().print("<h1>Invalid customer Id</h1>");
			req.getRequestDispatcher("Home.html").include(req, resp);
		} 
		else {
			if (customer.getcPwd().equals(cPwd)) {
				resp.getWriter().print("<h1>Login Successfull</h1>");
				//session tracking
				req.getSession().setAttribute("customer", customer);//it is used to store or set the information of customer or user which can be used in future also(set attribute is the method in which will take parameter as key and value format)
				req.getRequestDispatcher("customerHome.html").include(req, resp);
			} 
			else {
				resp.getWriter().print("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("Home.html").include(req, resp);
			}
		}

	}
}
