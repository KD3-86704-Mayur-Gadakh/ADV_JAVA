package com.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entities.Orders;

public interface OrdersDao  extends JpaRepository<Orders, Long>{

}
