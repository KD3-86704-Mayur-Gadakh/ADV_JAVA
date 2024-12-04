package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

	
	ArrayList<Marks> result;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		

		
		result = new ArrayList<>();
		result.add(new Marks("java", 90));
		result.add(new Marks(".net", 60));
		result.add(new Marks("core java", 87));
		result.add(new Marks("MySql", 70));
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		
		pw.println("<table border=1 >");
		pw.println("<tr>");
		pw.println("<td> Subject</td>");
		pw.println("<td> Marks</td>");
		pw.println("</tr>");
		
	for(Marks m:result) {
		
		pw.println("<tr>");
		pw.printf("<td> %s</td>",m.getSubject());	
		pw.printf("<td> %s</td>",m.getMarks());
		pw.println("</tr>");
		
	}

	pw.println("</table>");	
		
		
		
		
	}
	
}
