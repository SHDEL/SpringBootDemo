package com.del.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.del.demo.entity.Course;
import com.del.demo.entity.Enrollments;
import com.del.demo.entity.Order;
import com.del.demo.entity.OrderItem;
import com.del.demo.entity.Payment;
import com.del.demo.entity.User;

@Service
public class EntityService{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired 
    private EnrollRepo enrollRepo;

    public User saveUser(User user){
        return userRepo.save(user);
    }
    public User findUserByID(int id){
        Optional<User> result = userRepo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("ไม่พบอข้อมูล Course " + id);
        }
    }
    public User findUserByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public Course saveCourse(Course course){
        return courseRepo.save(course);
    }
    public Course findCourse(int id){
        Optional<Course> result = courseRepo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("ไม่พบอข้อมูล Course " + id);
        }
    }
    public List<Course> findAllCourse(){
        return courseRepo.findAll();
    }
    public OrderItem saveItem(OrderItem item){
        return itemRepo.save(item);
    }
    public OrderItem findItem(int id){
        Optional<OrderItem> result = itemRepo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("ไม่พบอข้อมูล OrderItem" + id);
        }
    }
    public Order saveOrder(Order order){
        return orderRepo.save(order);
    }
    public Order findOrder(int id){
        Optional<Order> result = orderRepo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        else{
            throw new RuntimeException("ไม่พบอข้อมูล OrderItem" + id);
        }
    }
    
    public Payment savePayment(Payment payment){
        return paymentRepo.save(payment);
    }
    public Enrollments saveEnroll(Enrollments enrollments){
        return enrollRepo.save(enrollments);
    }
    
}
