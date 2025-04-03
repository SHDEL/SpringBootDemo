package com.del.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Order {
    
    private int orderID;
    private Double totalAmount;
    private String status;
    private LocalDateTime createdAt;
    private List<OrderItem> itemsList = new ArrayList<>();

    public Order(int orderID, Double totalAmount, OrderItem items){
        this.orderID = orderID;
        this.totalAmount = totalAmount;
        this.status = "During Order";
        this.createdAt = LocalDateTime.now();
        this.itemsList.add(items);
        
    }
    public Order(int orderID, Double totalAmount,List<OrderItem> items){
        this.orderID = orderID;
        this.totalAmount = totalAmount;
        this.status = "During Order";
        this.createdAt = LocalDateTime.now();
        this.itemsList = items;
        
    }
    public void addItem(OrderItem item){
        itemsList.add(item);
        this.totalAmount += item.getPrice();
    }
    public int getOrderID() {
        return orderID;
    }
    public Double getTotalAmount() {
        return totalAmount;
    }
    public String getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public List<OrderItem> getItemsList() {
        return itemsList;
    }
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setItemsList(List<OrderItem> itemsList) {
        this.itemsList = itemsList;
    }
    public String getOrderDetails() {
        return "Order [orderID=" + orderID + ", totalAmount=" + totalAmount + ", status=" + status + ", createdAt="
                + createdAt + ", itemsList=" + itemsList.toString() + "]";
    }
    
    

    
    
}
