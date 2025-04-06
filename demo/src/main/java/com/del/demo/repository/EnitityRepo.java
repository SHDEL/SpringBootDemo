package com.del.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.del.demo.entity.Course;
import com.del.demo.entity.Enrollments;
import com.del.demo.entity.Order;
import com.del.demo.entity.OrderItem;
import com.del.demo.entity.Payment;
import com.del.demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class EnitityRepo implements UserDAO, EnrollDAO, CourseDAO, OrderDAO, ItemDAO, PaymentDAO{
    private EntityManager entityManager;

    @Autowired
    public EnitityRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void deleteUser(int id) {
        User u = entityManager.find(User.class, id);
        if (u != null){
            entityManager.remove(u);
        }
    }
    @Override
    public User findUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }
    
    // Payment
    @Override
    @Transactional
    public void savePayment(Payment payment) {
        entityManager.persist(payment);
    }
    @Override
    public void deletePayment(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePayment'");
    }

    // OrderItem
    @Override
    @Transactional
    public void saveItem(OrderItem orderItem) {
        entityManager.persist(orderItem);
    }
    @Override
    public void deleteItem(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteItem'");
    }

    // Order
    @Override
    @Transactional
    public void saveOrder(Order order) {
        entityManager.persist(order);
    }
    @Override
    public void deleteOrder(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrder'");
    }

    // Course
    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }
    @Override
    public void deleteCourse(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
    }
    @Override
    public List<Course> getAllCourse(){
        return entityManager.createQuery("FROM Course", Course.class).getResultList();
    }

    // Enrollments
    @Override
    @Transactional
    public void saveEnroll(Enrollments enrollments) {
        entityManager.persist(enrollments);
    }
    @Override
    public void deleteEnroll(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEnroll'");
    }
    


    // @Override
    // @Transactional
    // public void delete(int id) {
    //     User u = entityManager.find(User.class, id);
    //     entityManager.remove(u);
    // }

    // @Override
    // public List<User> findAll() {
    //     return entityManager.createQuery("FROM User", User.class).getResultList();

    // }
    // @Override
    // public void find(String email, String password) {
    //     entityManager.createQuery("FROM User WHERE email = :email AND password = :password", User.class)
    //     .setParameter("email", email)
    //     .setParameter("password", password)
    //     .getFirstResult();
        
    // }   
}
