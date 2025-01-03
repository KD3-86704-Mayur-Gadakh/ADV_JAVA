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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString

public class Products extends BaseEntity {

	@Column(length = 20)
	private String title;
	@Column(name = "description", length = 50)
	private String description;
	@Column(name = "price")
	private double price;
	

	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<Orders> orders=new ArrayList<>();
	
	
	
}
