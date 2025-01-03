package com.ecom.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.criteria.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class User extends BaseEntity {

	
	@Column(name = "first_name", length = 20) 
	private String firstName;
	@Column(name = "last_name", length = 20) 
	private String lastName;
	@Column(length = 25, unique = true) 
	private String email;
	@Column(length = 20, nullable = true) 
	private String password;
	private LocalDate dob;
	@Column(name = "reg_amount")
	private double regAmount;
	@Enumerated(EnumType.STRING) 
	@Column(length = 30) 
	private UserRole role;
	
	
	@OneToMany(mappedBy = "userCustomer",cascade = CascadeType.ALL)
	private List<Orders>orders=new ArrayList<>();
	
	
	
	
	
	
}
