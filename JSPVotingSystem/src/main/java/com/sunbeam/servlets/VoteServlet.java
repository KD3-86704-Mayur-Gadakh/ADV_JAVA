package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;


@WebServlet("/vote")
public class VoteServlet extends HttpServlet {

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
	
	
	String candidateId=req.getParameter("candidate");
	int id=Integer.parseInt(candidateId);
	
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	
pw.println("<html>");
pw.println("<head>");
pw.println("<title>Result</title>");
pw.println("</head>");
pw.println("<body bgcolor='bgColor'>");

ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		pw.printf("<h1>%s</h1>", appTitle);

Cookie[] arr=req.getCookies();
String userName="",role="";
if(arr!=null) {
for(Cookie c:arr) {
	if(c.getName().equals(userName)) {
		userName=c.getValue();
	}
	if(c.getName().equals(role)) {
		role=c.getValue();
	}
}
}
pw.printf("Hello, %s (%s)<hr/>\n", userName, role);

pw.println("<h2>Voting Status</h2>");

//try (CandidateDao canDao=new CandidateDaoImpl()){
//	
//	int count=canDao.incrVote(id);
//	
//	if(count==1) {
//		pw.println("<h3>You Successfully give your Vote</h3>");
//	}else{
//	pw.println("<h3>Yout Voting Is Faild</h3>");
//	}
	
//	HttpSession session=req.getSession();
	
	HttpSession session=req.getSession(false);
	
	if(session==null) {
		resp.sendError(440);
		return;
	}
	
	
	User user=(User) session.getAttribute("curUser");
	
	if(user.getStatus()==0) {
		
		try (CandidateDao candDao= new CandidateDaoImpl()){
			int count =candDao.incrVote(id);
			if(count==1) {
				
				pw.println("<h3>You have Successfully givenm your Vote</h3>");
				
				user.setStatus(1);
				try (UserDao userDao=new UserDaoImpl()){
					
					count=userDao.update(user);
					
					if(count==1) 
						pw.println("<h3>You Already Voted</h3>");
					
					
				} 
				
				
			}
			else {
				pw.println("<h3>Your Voting Faild</h3>");
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}else {
		pw.println("<h3>You Already Voted</h3>");
	}
	
	
//} catch (Exception e) {
//	// TODO: handle exception
//e.printStackTrace();
//throw new ServletException(e);
//
//}

pw.println("<a href='logout'> SignOut</a>");
pw.println("</body>");

pw.println("</html>");	
	
	}
}