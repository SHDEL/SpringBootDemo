package com.del.demo.repository;

import com.del.demo.entity.Enrollments;
import com.del.demo.entity.OrderItem;

public interface ItemDAO {
    void saveItem(OrderItem orderItem);
    void deleteItem(int id);
}
