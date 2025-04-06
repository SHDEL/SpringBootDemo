package com.del.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.del.demo.entity.Course;
import com.del.demo.entity.Enrollments;
import com.del.demo.entity.Order;
import com.del.demo.entity.OrderItem;
import com.del.demo.entity.Payment;
import com.del.demo.entity.User;

@Service
public class EntityService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CourseDAO courseDAO;

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private PaymentDAO paymentDAO;

    @Autowired EnrollDAO enrollDAO;

    public void saveUser(User user){
        userDAO.saveUser(user);
    }

    public void saveCourse(Course course){
        courseDAO.saveCourse(course);
    }

    public void saveItem(OrderItem item){
        itemDAO.saveItem(item);
    }

    public void saveOrder(Order order){
        orderDAO.saveOrder(order);
    }
    public void savePayment(Payment payment){
        paymentDAO.savePayment(payment);
    }
    public void saveEnroll(Enrollments enrollments){
        enrollDAO.saveEnroll(enrollments);
    }
    
}
