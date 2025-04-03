package com.del.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.del.demo.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class EnitityRepo implements UserDAO {
    private EntityManager entityManager;
    
    @Autowired
    public EnitityRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public EnitityRepo(){

    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User u = entityManager.find(User.class, id);
        entityManager.remove(u);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("FROM User", User.class).getResultList();

    }
    @Override
    public void find(String email, String password) {
        entityManager.createQuery("FROM User WHERE email = :email AND password = :password", User.class)
        .setParameter("email", email)
        .setParameter("password", password)
        .getFirstResult();
        
    }
    
}
