package com.cdac.tester;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;
import com.cdac.entities.Team;
import com.cdac.utils.HibernateUtils;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	try (SessionFactory sf=getSessionFactory()) {
		System.out.println("Hibernate is running");
		
		Scanner sc=new Scanner(System.in);
		
		TeamDao tm=new TeamDaoImpl();
		
		System.out.println("Enter the Team Name ");
		String name=sc.nextLine();
		System.out.println("Enter the Abbravation ");
		String abb=sc.nextLine();
		System.out.println("Enter the Owner ");
		String owner=sc.nextLine();
		System.out.println("Enter the Max Age");
		int age=sc.nextInt();
		System.out.println("Enter the batting average");
		double average=sc.nextDouble();
		System.out.println("Enter the wicket taken ");
		int wicket=sc.nextInt();
		
		Team team=new Team(name, abb, owner, age, average, wicket);
		
		System.out.println( tm.signupTeam(team));
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		throw new RuntimeException(e);
	}
		

	}

}
