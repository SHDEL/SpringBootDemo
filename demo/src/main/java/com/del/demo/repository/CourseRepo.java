package com.del.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.demo.entity.Course;

public interface CourseRepo extends JpaRepository<Course,Integer>{
    
}
