package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logOut")
public class Logout extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.getSession().invalidate();// it is used to destroyed or kill session which has been created
		resp.getWriter().print("<h1>LogOut Success</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);
	}

}
