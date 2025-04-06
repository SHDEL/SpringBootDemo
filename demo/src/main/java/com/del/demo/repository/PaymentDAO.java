package com.del.demo.repository;

import com.del.demo.entity.OrderItem;
import com.del.demo.entity.Payment;

public interface PaymentDAO {
    void savePayment(Payment payment);
    void deletePayment(int id);
}
