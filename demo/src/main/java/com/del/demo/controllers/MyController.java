package com.del.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.del.demo.entity.User;
import com.del.demo.repository.EnitityRepo;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private EnitityRepo enitityRepo;

    @GetMapping("/display")
    public String display(){
        return "Hello World";
    }
    @GetMapping("/aboutus")
    public String about(){
        return "About Us";
    }
    // @GetMapping("/userinfo")
    // public List<User> getAllUser(){
    //     return enitityRepo.findAll();
    // }
    

}
