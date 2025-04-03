package com.del.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// @Entity
// @Table(name="user")
public class User {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "userID")
    private int userid;

    // @Column(name = "username")
    private String username;

    // @Column(name = "name")
    private String name;

    // @Column(name = "email")
    private String email;

    // @Column(name = "password")
    private String password;

    // @Enumerated(EnumType.STRING)
    // @Column(name = "usertype")
    private UserType userType;

    // @Column(name = "createdAt")
    private LocalDateTime createdAt;

    private Enrollments enrollments;

    public User(){
        
    }
    public User(String username){
        this.username = username;
    }
    public User(int userid ,String username, String name, String email, String passwd){
        this.userid = userid;
        this.username = username;
        this.name = name; 
        this.email = email;
        this.password = passwd;
    }

    public int getId() {
        return userid;
    }

    public String getUserName() {
        return username;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return password;
    }

    public UserType getType() {
        return userType;
    }

    public void setId(int id) {
        this.userid = id;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswd(String passwd) {
        this.password = passwd;
    }

    public void setType(UserType type) {
        this.userType = type;
    }
    
    @Override
    public String toString() {
        String format = "| %-10s | %-20s | %-20s | %-25s | %-15s | %-10s | %-20s |\n";
        String separator = "+------------+----------------------+----------------------+---------------------------+-----------------+------------+----------------------+\n";

        StringBuilder sb = new StringBuilder();
        sb.append(separator);
        sb.append(String.format(format, "User ID", "Username", "Name", "Email", "Password", "User Type", "Created At"));
        sb.append(separator);
        sb.append(String.format(format, userid, username, name, email, password, userType, createdAt));
        sb.append(separator);

        return sb.toString();
    }
    public void purchaseOrder(Order order){
        System.out.println("**************Create Payment already**************");
        Payment payment = new Payment(this, order, order.getTotalAmount(), "Credit Card" );
        System.out.println(payment.getPaymentDetails());
        boolean isPaid = false;
        if (payment.processPayment()){
            isPaid = true;
            enrollments = new Enrollments(this);
            for (OrderItem item : order.getItemsList()){
                this.enrollments.enrollCourse(item.getCourse(), isPaid);
            }
            
            System.out.println("**************Enrollments Details**************");
            System.out.println(enrollments.getEnrollmentsDetails());
        }
        else{
            System.out.println("Can't purchase: \n" + order.getOrderDetails());
        }
    }
    public void getMyEnrolledCourse(User user){
        for (Course course : user.enrollments.getCourseList()){
            System.out.println(course.getCourseDetails()); 
        }        
    }

    
    

}
