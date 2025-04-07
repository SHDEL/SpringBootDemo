package com.del.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.del.demo.entity.Course;
import com.del.demo.entity.User;
import com.del.demo.repository.EntityService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private EntityService entityService;

    @GetMapping("/display")
    public String display(){
        return "Hello World";
    }
    @GetMapping("/aboutus")
    public String about(){
        return "About Us";
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setId(0);
        return entityService.saveUser(user);
    }
    
    @GetMapping("/course")
    public List<Course> getAllCourse() {
        return entityService.findAllCourse();
    }
    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable int id) {
        return entityService.findCourse(id);
        
    }
    
    
    // @GetMapping("/userinfo")
    // public List<User> getAllUser(){
    //     return enitityRepo.findAll();
    // }

    

}
