package com.del.demo.repository;

import com.del.demo.entity.Course;
import com.del.demo.entity.Order;

public interface OrderDAO {
    void saveOrder(Order order);
    void deleteOrder(int id);
}
