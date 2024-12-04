package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req,resp);
	}
	
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw = resp.getWriter();
	
	String email=req.getParameter("email");
	String password=req.getParameter("passwd");
	
	try(UserDao userDao= new UserDaoImpl()) {
		User dbUser= userDao.findByEmail(email);
		
		if(dbUser !=null && dbUser.getPassword().equals(password)) {
		
			Cookie c1 = new Cookie("uname", dbUser.getFirstName());
							c1.setMaxAge(3600);
							resp.addCookie(c1);
							Cookie c2 = new Cookie("role", dbUser.getRole());
							c2.setMaxAge(3600);
							resp.addCookie(c2);
			
			if(dbUser.getRole().equals("admin")){
			//to do the redirection	
				resp.sendRedirect("result");
//				System.out.println("Admin login successfully");
			}else {
				//tp do the redurection
				resp.sendRedirect("candidateList");
//				System.out.println("User Login Successfully");
			}
		}else{
			resp.setContentType("text/html");
							
							pw.println("<html>");
							pw.println("<head>");
							pw.println("<title>Login</title>");
							pw.println("</head>");
							pw.println("<body>");
							pw.println("<h2>Login Failed</h2>");
							pw.println("<p>Sorry, Invalid email or password.</p>");
							pw.println("<p><a href='index.html'>Login Again</a></p>");
							pw.println("</body>");
							pw.println("</html>");
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new ServletException();
	}
	
	
	
	}
	
	
	
}
