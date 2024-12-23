package com.ecom.service;

import java.time.LocalDate;
import java.util.List;

import com.ecom.dto.ApiRespDto;
import com.ecom.entities.Orders;

public interface OrderService {
	
	ApiRespDto placeOrder(Long productId,Long customerId,int quantity);
	List<Orders> getAllPlacedOrders(Long cutomerId);
	
	List<Orders> getOrderDetails(LocalDate startDate,LocalDate endDate);

}
