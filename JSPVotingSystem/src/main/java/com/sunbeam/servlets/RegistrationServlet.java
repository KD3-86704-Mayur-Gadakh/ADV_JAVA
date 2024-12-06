package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/userRegister")
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		processRequest(req,resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();

		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String email=req.getParameter("email");
		String DOB=req.getParameter("DOB");
		Date date=Date.valueOf(DOB);
	
		String passwd=req.getParameter("passwd");
		
//		
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(email);
//		System.out.println(DOB);
//		System.out.println(passwd);
		
		User user = new User(1,firstName,lastName,email,passwd,date,0,"voter");
		
		System.out.println(user);
		try (UserDao userDao=new UserDaoImpl()){
			
			int count =userDao.save(user);
			
			System.out.println(count);
			if(count==1) {

//				System.out.println("registration success ");
				
				
					pw.println("<html>");
	pw.println("<head>");
	pw.println("<title>Success</title>");
	pw.println("<body>");
	pw.println("<h2>User Register Successfully</h2>");
	pw.println("</body>");
	pw.println("</head>");
	pw.println("</html>");
			}else {
				
//				System.out.println("error in register");
				
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<title>error</title>");
				pw.println("<body>");
				pw.println("<h2>Error in register User</h2>");
				pw.println("</body>");
				pw.println("</head>");
				pw.println("</html>");
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		throw new ServletException(e);
		}
	}
}
