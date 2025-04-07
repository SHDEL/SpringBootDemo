package com.del.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.demo.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment,Integer>{
    
}
