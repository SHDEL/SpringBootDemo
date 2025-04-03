package com.del.demo.entity;

public class OrderItem {
    private int itemID;
    private Course course;
    private Double price;

    public OrderItem(int itemID, Course course, Double price){
        this.itemID = itemID;
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
