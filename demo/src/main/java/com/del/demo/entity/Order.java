package com.del.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private int orderID;

    @Column(name = "totalAmount")
    private Double totalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "Order_OrderItem", // ตารางกลาง
        joinColumns = @JoinColumn(name = "orderid"),
        inverseJoinColumns = @JoinColumn(name = "orderItemid")
    )
    private List<OrderItem> itemsList = new ArrayList<>();

    public Order(){
        
    }

    public Order(int orderID, Double totalAmount, OrderItem items){
        this.orderID = orderID;
        this.totalAmount = totalAmount;
        this.status = "During Order";
        this.createdAt = LocalDateTime.now();
        this.itemsList.add(items);
    }
    public Order(Double totalAmount, OrderItem items){
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
    public void removeItem(OrderItem orderItem){
        itemsList.remove(orderItem);
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
    public void setOrderID(int orderID) {
        this.orderID = orderID;
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
