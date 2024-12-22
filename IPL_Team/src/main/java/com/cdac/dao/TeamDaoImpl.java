package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static  com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import com.cdac.entities.Team;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String signupTeam(Team team) {
		// TODO Auto-generated method stub
		
		
		String message="Team Register Faild";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction transaction= session.beginTransaction();
		
		try {
			
			Serializable teamId= session.save(team);
		transaction.commit();
		message="Team Added With id "+teamId;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		
		
		return message;
	}

	@Override
	public List<Team> getAllTeam() {
		// TODO Auto-generated method stub
		
		String jpql="select t from Team t";
		
		List<Team> team=null;
		
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction trx= session.beginTransaction();
		try {
			
			team=session.createQuery(jpql,Team.class).getResultList();
			trx.commit();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			if(trx!=null)
				trx.rollback();
			
			throw e;
		}
		
		
		
		
		return team;
		
		
	}
	
	
	public List<Team> getAllTeamSpecific(int age, double battingAvg){
		String jpql="select t from Team t where t.maxPlayerAge<:age and t.battingAvg>:avg ";
	
		List<Team>team=null;
		
		Session session=getSessionFactory().getCurrentSession();
		Transaction trx=session.beginTransaction();
		
		
		try {
			
		team=session.createQuery(jpql,Team.class).setParameter("age",age).setParameter("avg",battingAvg).getResultList();
		trx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if(trx!=null)
				trx.rollback();
			throw e;
		}
		
		return team;
		
	}
	
	
	public List<Team> getOwnerAndAbbrevation(int age,double battingAvg){
	
		String jpql="select new com.cdac.entities.Team(abbreviation,owner) from Team t where t.maxPlayerAge<:age and t.battingAvg>:avg";
		
		List<Team> team=null;
		
		Session session= getSessionFactory().getCurrentSession();
		Transaction trax= session.beginTransaction();
		
		try {
			
			
			team=session.createQuery(jpql,Team.class).setParameter("age", age).setParameter("avg",battingAvg).getResultList();
			trax.commit();
		} catch (Exception e) {
			// TODO: handle exception
			
			if(trax!=null) 
				trax.rollback();
			
			throw e;
			
		}
		 System.out.println(team);
		
		return team;
		

	}
	
	
	public String updateMaxAge(String name ,int age) {
		
		Team team=null;
		String mesg = "Max Age Updattion Faild  ...!";
		String jpql = "select t from Team t where t.name=:nm";
		
				Session session = getSessionFactory().getCurrentSession();
				Transaction tx = session.beginTransaction();
				
				try {
					team=session.createQuery(jpql, Team.class)
							.setParameter("nm",name)
							.getSingleResult();
					team.setMaxPlayerAge(age);
					tx.commit();
					mesg="Age Update Successfully";
					
				} catch (Exception e) {
					if (tx != null)
						tx.rollback();
					throw e;
				
				}
		
		
		return mesg;
		
		
	}
	

	

	

}
