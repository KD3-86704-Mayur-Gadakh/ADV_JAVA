package com.sunbeam.Beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {
	private int candId;
	private boolean success;
	private int userId;
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public void vote() {
		this.success=false;
		
		try (CandidateDao canDao=new CandidateDaoImpl()){
			
			int count =canDao.incrVote(this.userId);
			if(count==1) {
			
				try (UserDao userDao=new UserDaoImpl()) {
					
					User user=userDao.findById(this.userId);
					
					if(user !=null) {
						user.setStatus(1);
						
						count =userDao.update(user);
						
						if(count==1) {
							this.success=true;
						}
					}
					
					
				} catch (Exception e) {
					// TODO: handle exception
				}
			
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
