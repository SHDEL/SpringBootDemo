package com.del.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItemid")
    private int itemID;

    @OneToOne
    @JoinColumn(name = "courseid")
    private Course course;

    @Column(name = "price")
    private Double price;

    public OrderItem(){
        
    }
    
    public OrderItem(int itemID, Course course, Double price){
        this.itemID = itemID;
        this.course = course;
        this.price = price;
    }
    public OrderItem(Course course, Double price){
        this.course = course;
        this.price = price;
    }
    public void setCourse(Course course) {
        this.course = course;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getItemID() {
        return itemID;
    }
    public Course getCourse() {
        return course;
    }
    public Double getPrice() {
        return price;
    }
    public String getOrderItemDetails() {
        return "OrderItem [itemID=" + itemID + ", Course=" + course + ", price=" + price + "]";
    }
    
    

    
}
