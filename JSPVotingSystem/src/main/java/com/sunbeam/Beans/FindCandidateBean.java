package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class FindCandidateBean {

	
	private int candId;
	private Candidate cand;
	
	public FindCandidateBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public Candidate getCand() {
		return cand;
	}
	public void setCand(Candidate cand) {
		this.cand = cand;
	}
	

	
	
	public void findCandidate() {
		
		try (CandidateDao canDao=new CandidateDaoImpl()){
			
			
			this.cand=canDao.findById(this.candId);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}
