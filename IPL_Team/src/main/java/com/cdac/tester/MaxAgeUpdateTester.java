package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;

public class MaxAgeUpdateTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			
			
			System.out.println("Enter the team name : ");
			String name=sc.next();
			System.out.println("Enter the age :");
			int age=sc.nextInt();
			TeamDao teamDao=new TeamDaoImpl();
			
			System.out.println(teamDao.updateMaxAge(name, age)) ;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
