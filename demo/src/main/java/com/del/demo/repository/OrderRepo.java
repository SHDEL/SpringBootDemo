package com.del.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.demo.entity.Order;

public interface OrderRepo extends JpaRepository<Order,Integer>{
    
}
