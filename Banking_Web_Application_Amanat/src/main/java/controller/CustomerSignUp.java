package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDao;
import dto.Customers;

@WebServlet("/customerSignUp")
public class CustomerSignUp extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cName = req.getParameter("cName");
		String cPhone = req.getParameter("cPhone");
		long cPhonecp = Long.parseLong(cPhone);
		String cDob = req.getParameter("cDob");
		String cGender = req.getParameter("cGender");
		String cEmail = req.getParameter("cEmail");
		String cPwd = req.getParameter("cPwd");

		Date cdobcp = Date.valueOf(cDob);
		Period period = Period.between(cdobcp.toLocalDate(), LocalDate.now());
		int age = period.getYears();
		Customers customers = new Customers();
		CustomerDao customerDao = new CustomerDao();
		if (age > 18) {
			if (customerDao.check1(cEmail).isEmpty() && customerDao.check2(cPhonecp).isEmpty()) {
				// customer.setCid(); It will be auto generated
				customers.setcName(cName);
				customers.setcPhone(cPhonecp);
				customers.setcGender(cGender);
				customers.setcEmail(cEmail);
				customers.setcDob(cdobcp);
				customers.setcPwd(cPwd);
				customerDao.save(customers);
				
				Customers customer2=customerDao.check1(cEmail).get(0);

				if(customer2.getcGender().equals("female")) {
					resp.getWriter().print("<h1> Hello Madam</h1>");
				}
				else {
					resp.getWriter().print("<h1> Hello sir</h1>");
				}
				resp.getWriter().print("<h1> Account has been created successfully. <br>Your Customer Id : "+customer2.getcId()+"</h1>");
				req.getRequestDispatcher("customerLogin.html").include(req, resp);
			} 
			else {
				resp.getWriter().print("<h1> Account already exists.</h1>");
			}
		} 
		else {
			resp.getWriter().print("<h1> You are not eligible to create an account.</h1>");
		}
	}
}
