package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

@WebServlet("/deletecand")
public class DeleteCandidateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req,resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		processRequest(req,resp);
		
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String candId=req.getParameter("id");
		int id=Integer.parseInt(candId);
		
		try (CandidateDao canDao=new CandidateDaoImpl()){
			
			int count=canDao.deleteById(id);
			
			if(count==1) {
				String message="Candidate Deleted"+count;
				req.setAttribute("message", message);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
RequestDispatcher reqDis=req.getRequestDispatcher("result");
reqDis.forward(req, resp);
		
		
	}

}
