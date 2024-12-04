package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.DrbgParameters.Reseed;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Style;

import org.apache.catalina.connector.Response;


@WebServlet("/ProfileServlet")
public class ProfileServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw=resp.getWriter();
		
		resp.setContentType("text/html");
		
		pw.println("<html>");
		pw.println("<title>Student Profile </title>");
		
		pw.println("<body style=background-color:pink;>");				
		pw.println("<h3>First Name :Mayur </h3>");
		pw.println("<h3>First Last Name :Gadakh </h3>");
		pw.println("<h3>First Qualification :BE-IT </h3>");
		pw.println("<h3>Univasity  :Savitribai Phule Pune Univarsity </h3>");
		pw.println("<h3>First Birth-Date :13/4/2000 </h3>");
		
		pw.println("</body>");
		pw.println("");
		
		pw.println("</html>");
	}
	
}
