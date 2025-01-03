package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.UserDao;
import com.ecom.dto.ApiRespDto;
import com.ecom.dto.UserRequestDto;
import com.ecom.entities.User;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public ApiRespDto signUp(UserRequestDto Userdto) {
		// TODO Auto-generated method stub
		
		User user=modelMapper.map(Userdto, User.class);
		
	User userRef=userDao.save(user);
		System.out.println(userRef);
		
		
		return new ApiRespDto("User Created Suuccessfully");
	}

}
