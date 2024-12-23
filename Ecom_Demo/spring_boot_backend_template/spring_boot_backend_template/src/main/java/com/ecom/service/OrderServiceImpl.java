package com.ecom.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.cutome_exception.ResourceNotFoundException;
import com.ecom.dao.OrdersDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiRespDto;
import com.ecom.entities.Orders;
import com.ecom.entities.Products;
import com.ecom.entities.User;
import com.ecom.entities.UserRole;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserDao userDao; 
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrdersDao orderDao;
	
	
	@Override
	public ApiRespDto placeOrder(Long productId, Long customerId, int quantity) {
		// TODO Auto-generated method stub
		
		User customer=userDao.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer Not Found"));
		
		if(customer.getRole()==UserRole.CUSTOMER) {
			if(quantity>0) {
				
			
			
			Products product=productDao.findById(productId).orElseThrow(()->new ResourceNotFoundException("Product Not Found For This Id"));
			
			Orders orders=new Orders();
			
			orders.setUserCustomer(customer);
			orders.setProduct(product);
			orders.setQuantity(quantity);
			orders.setOrderDate(LocalDate.now());
			orders.calculateTotalAmount();
			
			orderDao.save(orders);
			
			return new ApiRespDto("Order Successful with Total Amount "+orders.getTotalAmount());
			}else {
				return new ApiRespDto("Increase Your Quantity");
			}
			
			
		}else {
		
			return new ApiRespDto("You are not customer");
		}
		
		
	}


	@Override
	public List<Orders> getAllPlacedOrders(Long cutomerId) {
		// TODO Auto-generated method stub
		
		
	return	(List<Orders>) orderDao.findById(cutomerId).orElseThrow(()->new ResourceNotFoundException("Orders Not found"));
		
		
		
		
	}
	
	

}
