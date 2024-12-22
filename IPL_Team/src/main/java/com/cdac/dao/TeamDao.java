package com.cdac.dao;

import java.util.List;

import com.cdac.entities.Team;

public interface TeamDao {

	
	String signupTeam(Team team);
//	Team getTeamDetails( Long teamId);



	List<Team> getAllTeam();
	List<Team>  getAllTeamSpecific(int age,double battingAvg);
	List<Team> getOwnerAndAbbrevation(int age ,double battingAvg);
	String updateMaxAge(String name,int age);

	

}
