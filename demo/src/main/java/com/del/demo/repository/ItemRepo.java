package com.del.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.demo.entity.OrderItem;

public interface ItemRepo extends JpaRepository<OrderItem,Integer>{
    
}
