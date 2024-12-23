package com.ecom.entities;

import java.time.LocalDate;
import java.util.jar.Attributes.Name;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Orders extends BaseEntity {

	@ManyToOne
	@JoinColumn(name="customer_id",nullable = false)
	private  User userCustomer; 
	
	@ManyToOne
	@JoinColumn(name="product_id",nullable = false)
	private Products product;
	
	private Integer quantity;
	
	@Column(name="total_amount")
	private Double totalAmount;
	
	@Column(name="order_date")
	private LocalDate orderDate; 
	
	
	public void calculateTotalAmount() {
		this.totalAmount=this.product.getPrice()*this.quantity;
	}
	
}
