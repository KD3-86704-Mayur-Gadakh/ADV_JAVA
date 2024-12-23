package com.ecom.service;

import java.util.List;

import com.ecom.dto.ApiRespDto;
import com.ecom.dto.ProductDto;
import com.ecom.dto.ProductRespDto;
import com.ecom.entities.Products;

import io.swagger.v3.oas.annotations.responses.ApiResponse;

public interface ProductService {
	
	ApiRespDto deleteProduct(Long productId,Long userId);
	ApiRespDto addProduct(ProductDto dto,Long userId);
	List<ProductRespDto> getAllProducts();

}
