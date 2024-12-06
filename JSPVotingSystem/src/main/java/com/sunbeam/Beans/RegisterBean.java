package com.sunbeam.Beans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegisterBean {
	
	String firstName;
	String lastName;
	String email;
	String passwd;
	String dob;
	int count;
	
	
	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	
	public void registerUser()
	{
		Date date=Date.valueOf(dob);
	
		

		
		User user = new User(1,firstName,lastName,email,passwd,date,0,"voter");
		
		System.out.println(user);
		try (UserDao userDao=new UserDaoImpl()){
			
			int count =userDao.save(user);
			
			System.out.println(count);
			if(count==1) {
				this.count=count;
			
			}

		
	}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		throw new RuntimeException(e);
		}
}


	
}
