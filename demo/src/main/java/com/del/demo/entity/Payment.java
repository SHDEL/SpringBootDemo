package com.del.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity
// @Table(name = "Payment")
public class Payment {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentID;
    private User user;
    private Order order;
    private Double amount;
    private LocalDateTime paymentDate;
    private String paymentMethod;
    private String status;

    public Payment(User user, Order order, Double price, String method){
        this.user = user;
        this.order = order;
        this.amount = price;
        this.paymentDate = LocalDateTime.now();
        this.paymentMethod = method;
        this.status = "waiting for payment";

    }
    
    public int getPaymentID() {
        return paymentID;
    }

    public User getUser() {
        return user;
    }

    public Order getOrder() {
        return order;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean processPayment(){
        System.out.println("**************Payment Process**************");
        try {
            Thread.sleep(2000);
            System.out.println("Payment Success");
            return true;
        } catch (InterruptedException e) {
            System.out.println("Payment not success");
            this.status = "Payment not success";
            return false;
        }
    }

    public String getPaymentDetails() {
        String format = "| %-10s | %-20s | %-20s | %-25s | %-15s | %-10s | %-20s |\n";
        String separator = "+------------+----------------------+----------------------+---------------------------+-----------------+------------+----------------------+\n";
        
        StringBuilder sb = new StringBuilder();
        sb.append(separator);
        sb.append(String.format(format, "PaymentID", "UserID", "UserName", "TotalAmount", "PaymentDate", "PaymentMethod", "Status"));
        sb.append(separator);
        sb.append(String.format(format, paymentID, user.getId(), user.getName(), amount, paymentDate, paymentMethod, status));
        sb.append(separator);

        return sb.toString();
    }
    


    
}
