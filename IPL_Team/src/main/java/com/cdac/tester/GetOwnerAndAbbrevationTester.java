package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class GetOwnerAndAbbrevationTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
//	
			
			System.out.println("Enter the age : ");
			int age=sc.nextInt();
			System.out.println("Enter the Batting average :");
			double avg=sc.nextDouble();
			TeamDao teamDao=new TeamDaoImpl();
//			System.out.println(teamDao.getAllTeamSpecific(age,avg));
			
			teamDao.getOwnerAndAbbrevation(age,avg);
			
			
					
					
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		
		}

	}

}
