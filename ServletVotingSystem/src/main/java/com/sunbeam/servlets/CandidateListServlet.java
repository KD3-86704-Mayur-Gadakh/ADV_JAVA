package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/candidateList")
public class CandidateListServlet extends HttpServlet
{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	List<Candidate> list=new ArrayList<Candidate>();
	
	try(CandidateDao canDao=new CandidateDaoImpl())
	{
		list=canDao.findAll();
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new ServletException();
		
	}
	
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	
	pw.println("<html>");
	pw.println("<head>");
	pw.println("<title>Candidates list</title>");
	pw.println("</head>");
	pw.println("<body>");
	
	
	Cookie[] arr=req.getCookies();
	String userName="",role="";
if(arr!=null) {
	for(Cookie c:arr) {
		if(c.getName().equals("uname")) {
			userName=c.getValue();
		}
		if(c.getName().equals("role")) {
			role=c.getValue();
		}
	}
}
pw.printf("Hello, %s (%s)<hr/>\n", userName, role);
	
	pw.println("<h2>Cadidates For Election</h2>");
	
	pw.println("<form method='post' action='vote'>");
	for(Candidate c:list) {
		pw.printf("<input type='radio' name='candidate' value='%d'/>%s <br/> \n",
				c.getId(),c.getName()
				);
	}
	pw.println("<br/> <input type='submit' value='Vote'>");
	pw.println("</form>");
	pw.println("</body>");
	pw.println("</html>");
	}
	
	

}
