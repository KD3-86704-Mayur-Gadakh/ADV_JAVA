package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/result")
public class ResultServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req,resp);
	}
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	ServletContext color = this.getServletContext();
	String bgColor = color.getInitParameter("bg.color");
	
	List<Candidate> list=new ArrayList<Candidate>();
	
	
	try (CandidateDao canDao=new CandidateDaoImpl()){
		
	list=canDao.findAll();
		
	} catch (Exception e) {
		// TODO: handle exception
	e.printStackTrace();
	throw new ServletException(e);
	}
	
	resp.setContentType("text/html");
	
	PrintWriter pw=resp.getWriter();
	
	pw.println("<html>");
	pw.println("<head>");
	pw.println("<title>Result</title>");
	pw.println("<body bgcolor='bgColor'> ");
	
	ServletContext app = this.getServletContext();
	String appTitle = app.getInitParameter("app.title");
	pw.printf("<h1>%s</h1>", appTitle);
	
	
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
	

ServletContext ctx = this.getServletContext();
		String ann = (String) ctx.getAttribute("announcement");
		if(ann != null)
			pw.println("<p style='color:red'>New  Announcement: " + ann + "</p>");


	
	pw.println("<h2>Voting Results</h2>");
	pw.println("<table border=1>");
	pw.println("<thead>");
	pw.println("<tr>");
	pw.println("<th>Id</th>");
	pw.println("<th>Name</th>");
	pw.println("<th>Party</th>");
	pw.println("<th>Votes</th>");
	pw.println("<th>Action</th>");
	pw.println("</tr>");
	pw.println("</thead>");
	pw.println("<tbody>");
	for(Candidate c:list) {
		pw.println("<tr>");
		pw.printf("<td>%d</td>\n",c.getId());
		pw.printf("<td>%s</td>\n",c.getName());
		pw.printf("<td>%s</td>\n",c.getParty());
		pw.printf("<td>%d</td>\n",c.getVotes());
		pw.printf("<td>\n");
		pw.printf("<a href='editcand?id=%d'><img src='images/edit.jpg' alt=' go to Edit' width='30' height='30' ></a>\n",c.getId());
		pw.printf("<a href='deletecand?id=%d'><img src='images/delete.jpg' alt=' go to Delete' width='30' height='30' ></a>\n",c.getId());
		pw.printf("</td>\n");
		pw.println("</tr>");
	}
	pw.println("</tbody>");

	pw.println("</table>");
	String message=(String) req.getAttribute("message");
	
	if(message!=null) {
		pw.println("<h3>"+message+"</h3>");
	}
	
	
//	pw.println("<a href='logout' >Sign Out</a>");
	pw.println("<p><a href='announcment.html'>Announcement</a> | <a href='logout'>Sign Out</a></p>");
	pw.println("<p>");
	pw.println("<a href='newCandidate.html'>new Cnadidate</a>");
	pw.println("</p>");
	pw.println("</body>");
	pw.println("</head>");
	pw.println("</html>");
	}
	

}
