package com.ecom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ecom.cutome_exception.ResourceNotFoundException;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiRespDto;
import com.ecom.dto.ProductDto;
import com.ecom.dto.ProductRespDto;
import com.ecom.entities.Products;
import com.ecom.entities.User;
import com.ecom.entities.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserDao userDao;

	@Override
	public ApiRespDto addProduct(ProductDto dto,Long userId) {
		// TODO Auto-generated method stub

		Products product = modelMapper.map(dto, Products.class);

		User us=userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("User Not Found"));
		
		if(us.getRole()==UserRole.ADMIN) {
			Products addedProcut = productDao.save(product);

			return new ApiRespDto("Product Added With id " + addedProcut.getId());
		}else {
			return new ApiRespDto("You Are Not Admin");
		}
		
		
	}

	@Override
	public ApiRespDto deleteProduct(Long productId,Long userId) {
		// TODO Auto-generated method stub

		
		User user=userDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("Not User"));
		
		if(  user.getRole()==UserRole.ADMIN) {
			if (productDao.existsById(productId)  ) {
				productDao.deleteById(productId);
				return new ApiRespDto("Product Deleted Successfully");
			} else {
				throw new ResourceNotFoundException("Invalid Product Id");
			}
		
		}
		return new ApiRespDto("You Are not Admin");

	}

	@Override
	public List<ProductRespDto> getAllProducts() {
		// TODO Auto-generated method stub
		
		
	
		return productDao.findAll() 
		.stream() 
		.map(product -> modelMapper.map(product, ProductRespDto.class)) 
		.collect(Collectors.toList());
	}

}
