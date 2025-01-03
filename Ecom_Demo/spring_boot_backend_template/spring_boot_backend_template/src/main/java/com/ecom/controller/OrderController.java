package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ApiRespDto;
import com.ecom.entities.Orders;
import com.ecom.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	@PostMapping
	public ResponseEntity<?> placeOrder(@RequestParam Long cutomerId, @RequestParam Long productId,@RequestParam Integer quantity){
		
		try {
			
			return ResponseEntity.ok( orderService.placeOrder(productId, cutomerId,quantity ));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiRespDto(e.getMessage()));
		}
		
		
		
	}
}
