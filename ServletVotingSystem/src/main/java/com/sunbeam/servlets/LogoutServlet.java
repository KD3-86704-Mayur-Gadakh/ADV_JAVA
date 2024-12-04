package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie c1 = new Cookie("uname", "");
				c1.setMaxAge(-1);
				resp.addCookie(c1);
			Cookie c2 = new Cookie("role", "");
				c2.setMaxAge(-1);
				resp.addCookie(c2);
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		pw.println("<html>");
		pw.println("<thead>");
		pw.println("<title>LogOut</title>");
		pw.println("</thead>");
		pw.println("<body>");
		pw.println("<h2>Thank You For Voting</h2>");
		pw.println("</body>");
		
		pw.println("<p><a href='index.html'>Login Again</a></p>");
		pw.println("</html>");
	}

}
