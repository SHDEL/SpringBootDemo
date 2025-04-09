package com.del.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.del.demo.entity.Course;
import com.del.demo.entity.Order;
import com.del.demo.entity.OrderItem;
import com.del.demo.entity.Payment;
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

    @PostMapping("/users/signup")
    public User addUser(@Validated @RequestBody User user) {
        user.setId(0);
        if (entityService.findUserByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Username นี้มีผู้ใช้แล้ว");
        }
        return entityService.saveUser(user);
    }
    @GetMapping("/users")
    public User loginUser() {
        return entityService.findUserByEmail("del2547.pv@gmail.com");
    }
    
        
    
    @GetMapping("/course")
    public List<Course> getAllCourse() {
        return entityService.findAllCourse();
    }
    @GetMapping("/course/{id}")
    public Course getCourse(@PathVariable int id) {
        return entityService.findCourse(id);
        
    }
    @PostMapping("/orderitem/{id}")
    public OrderItem addOrderItem(@RequestBody OrderItem item ,@PathVariable int id) {
        System.out.println("CourseID: " + id);
        Course c = entityService.findCourse(id);
        item.setId(0);
        item.setCourse(c);
        item.setPrice(c.getPrice());
        System.out.println("pass");
        return entityService.saveItem(item);
    }
    @PostMapping("/order/{itemid}")
    public Order createOrder(@RequestBody Order order, @PathVariable int itemid) {
        OrderItem item = entityService.findItem(itemid);
        order.setOrderID(0);
        order.setTotalAmount(0.0);
        order.addItem(item);
        System.out.println("from createOrder pass");
        return entityService.saveOrder(order);
    }
    @PostMapping("/order/{orderid}/{itemid}")
    public Order addItem(@PathVariable int orderId, int itemid) {
        Order order = entityService.findOrder(orderId);
        OrderItem item = entityService.findItem(itemid);
        order.addItem(item);
        return entityService.saveOrder(order);
    }
    @PostMapping("/payment/{orderid}/{userid}")
    public Payment createdPayment(@RequestBody Payment payment, @PathVariable int orderid, int userid) {
        System.out.println("userid: " + userid);
        Order order = entityService.findOrder(orderid);
        User user = entityService.findUserByID(userid);
        payment.setPaymentID(0);
        payment.setOrder(order);
        payment.setUser(user);
        System.out.println(payment);
        
        return entityService.savePayment(payment);

    }
    
    
    
    
    
    
    // @GetMapping("/userinfo")
    // public List<User> getAllUser(){
    //     return enitityRepo.findAll();
    // }

    

}
