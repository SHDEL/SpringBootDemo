package com.del.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.demo.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{
    User findByEmail(String email);
    
}
