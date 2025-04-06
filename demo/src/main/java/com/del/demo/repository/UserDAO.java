package com.del.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.del.demo.entity.User;

public interface UserDAO {
    void saveUser(User user);
    void deleteUser(int id);
    User findUser(int id);
    List<User> findAll();
    void update(User user);
}
