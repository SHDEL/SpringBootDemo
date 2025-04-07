package com.del.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.demo.entity.Enrollments;

public interface EnrollRepo extends JpaRepository<Enrollments,Integer>{
    
}
