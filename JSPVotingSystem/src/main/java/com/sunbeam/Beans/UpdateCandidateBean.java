package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class UpdateCandidateBean {
	
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
	
	
	
	public UpdateCandidateBean(){}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public void updateCandidate() {
		
		try(CandidateDao canDao=new CandidateDaoImpl()) {
			Candidate c=new Candidate(id,name,party,votes);
			 this.count=canDao.update(c);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		throw new RuntimeException(e);
		}
	}
	
	

}