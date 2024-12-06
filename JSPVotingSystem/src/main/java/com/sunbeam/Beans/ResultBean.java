package com.sunbeam.Beans;

import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class ResultBean {
	
	private List<Candidate> candList;
	
	public ResultBean() {
	}
	
	
	
	
	
	
	
	
public List<Candidate> getCandList() {
		return candList;
	}








	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}








public void fetchCandidate() {
	try (CandidateDao canDao=new CandidateDaoImpl()){
		
		this.candList=canDao.findAll();
		
		System.out.println(candList);
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new RuntimeException(e);
	}
		
	}
}
