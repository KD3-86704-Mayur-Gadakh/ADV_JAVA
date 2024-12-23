package com.ecom.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class ProductRespDto extends BaseEntityDto{

	private String title;
	private String description;
	private double price;

	
}
