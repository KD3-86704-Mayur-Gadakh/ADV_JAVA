package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidate {
	
	private int candId;
	private int count;
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	public void deleteCandidate() {
		
		
		try (CandidateDao canDao=new  CandidateDaoImpl()){
			
			this.count=canDao.deleteById(this.candId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	

}
