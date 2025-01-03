package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiRespDto;
import com.ecom.dto.ProductDto;
import com.ecom.dto.UserRequestDto;
import com.ecom.service.ProductService;
import com.ecom.service.UserService;



@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> userSignUp(@RequestBody UserRequestDto userDto) {

		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.signUp(userDto));

		} catch (RuntimeException e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiRespDto(e.getMessage()));
		}

		
	}
	
	
	
	
}
