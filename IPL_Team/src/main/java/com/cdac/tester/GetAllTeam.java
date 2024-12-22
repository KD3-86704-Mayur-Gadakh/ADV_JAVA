package com.cdac.tester;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoImpl;




public class GetAllTeam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create user dao instance
//			UserDao userDao=new UserDaoimpl();
			TeamDao teamDao=new TeamDaoImpl();
			
			System.out.println(teamDao.getAllTeam());
			
			TeamDao userDao = new TeamDaoImpl();
			userDao.getAllTeam().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
