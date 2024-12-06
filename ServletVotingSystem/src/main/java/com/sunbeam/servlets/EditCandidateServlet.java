package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ServletContext color = this.getServletContext();
		String bgColor = color.getInitParameter("bg.color");
		
		String candId=req.getParameter("id");
		int id=Integer.parseInt(candId);
		resp.setContentType("text/html");
		
		PrintWriter pw=resp.getWriter();
		
		
		pw.println("<html>");
		pw.println("<thead>");	
		pw.println("<title>Edit Candidate</title>");
		pw.println("</thead>");
		pw.println("<body bgcolor='bgColor'>");
		
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		pw.printf("<h1>%s</h1>", appTitle);
		
		
	
		try (CandidateDao canDao=new CandidateDaoImpl()){
			Candidate c=canDao.findById(id);
			
			if(c != null) {
								pw.println("<form method='post' action='editcand'>");
								pw.printf(" <input type='hidden' name='id' value='%d' readonly><br/>\n", c.getId());
								pw.printf("Name: <input type='text' name='name' value='%s'><br/>\n", c.getName());
								pw.printf("Party: <input type='text' name='party' value='%s'><br/>\n", c.getParty());
								pw.printf("Votes: <input type='text' name='votes' value='%d' readonly><br/><br/>\n", c.getVotes());
								pw.println("<input type='submit' value='Update Candidate'>");
								pw.println("</form>");
							}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			throw new ServletException();
		}
		
		
		
		pw.println("</body>");	
		pw.println("</html>");
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		String canId=req.getParameter("id");
		int id=Integer.parseInt(canId);
		String name =req.getParameter("name");
		String party=req.getParameter("party");
		
		String voteStr=req.getParameter("votes");
		int votes=Integer.parseInt(voteStr);
		
		Candidate c=new Candidate(id,name,party,votes);
		
		try (CandidateDao canDao=new CandidateDaoImpl()){
		
			int count =canDao.update(c);
if(count ==1) {
	String message="Candidate Update"+count;
	req.setAttribute("message", message);
	
}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		RequestDispatcher reqDis= req.getRequestDispatcher("result");
		reqDis.forward(req, resp);
		
		
	}
}
