package com.ecom.dto;

import java.time.LocalDate;

import com.ecom.entities.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UserRespDto  {

	
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private LocalDate dob;
	private double regAmount;
	private UserRole role;
}