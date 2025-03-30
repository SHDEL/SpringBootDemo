package com.del.demo.repository;

import java.util.List;

import com.del.demo.entity.User;

public interface UserDAO {
    void save(User user);
    void delete(int id);
    List<User> findAll();
}
