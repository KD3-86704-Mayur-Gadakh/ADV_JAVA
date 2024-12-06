package com.sunbeam.Beans;



import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {

	String email;
	String passwd;
	User user;
	
	public LoginBean() {
		// TODO Auto-generated constructor stub
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
	
	public User getUser() {
		return user;
	}







	public void setUser(User user) {
		this.user = user;
	}



	
	public void execute() {		
		try (UserDao userdao=new UserDaoImpl()){

			User dbUser= userdao.findByEmail(email);
			
			if(dbUser !=null && dbUser.getPassword().equals(passwd)) {
				this.user = dbUser;
			}				
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}








}
