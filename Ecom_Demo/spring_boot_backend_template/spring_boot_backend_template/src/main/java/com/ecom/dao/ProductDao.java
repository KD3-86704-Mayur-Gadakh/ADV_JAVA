package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entities.Products;

public interface ProductDao extends JpaRepository<Products, Long> {

}
