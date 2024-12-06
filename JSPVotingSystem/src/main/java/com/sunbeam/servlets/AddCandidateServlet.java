package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/candidateRegister")
public class AddCandidateServlet extends HttpServlet {
	
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
		
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		
		try (CandidateDao canDao=new CandidateDaoImpl()){
			
			Candidate c=new Candidate(1,name,party,0);
			
			int count=canDao.save(c);
			
			if(count==1) {
				
				pw.println("<html>");
				pw.println("<thead>");
				pw.println("<title>Candidate Register</title>");
				pw.println("<body>");
				pw.println("<h2>Candidate Register Successfully</h2>");
				pw.println("</body>");
				pw.println("</thead>");
				pw.println("</html>");
				resp.sendRedirect("result");
			}else {
				pw.println("<html>");
				pw.println("<thead>");
				pw.println("<title>Candidate Register</title>");
				pw.println("<body>");
				pw.println("<h2>Candidate Not Register</h2>");
				pw.println("</body>");
				pw.println("</thead>");
				pw.println("</html>");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}

}
