package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiRespDto;
import com.ecom.dto.ProductDto;
import com.ecom.dto.ProductRespDto;
import com.ecom.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto,@RequestParam Long userId) {

		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productDto,userId));

		} catch (RuntimeException e) {
			// TODO: handle exception

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespDto(e.getMessage()));

		}

	}

	@DeleteMapping
	public ResponseEntity<?> deleteProduct(@RequestParam() Long productId, @RequestParam() Long userId) {

		try {

			return ResponseEntity.ok(productService.deleteProduct(productId, userId));

		} catch (RuntimeException e) {
			// TODO: handle exception

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespDto(e.getMessage()));
		}

	}

	@GetMapping()
	public ResponseEntity<?> getAllProducts() {

		List<ProductRespDto> products = productService.getAllProducts();

		if(products.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
		return 	ResponseEntity.ok(products);
		}
		

	}

}
