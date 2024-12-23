package com.ecom.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class ProductDto extends BaseEntityDto {
	
	private String title;
	private String description;
	private double price;

}
