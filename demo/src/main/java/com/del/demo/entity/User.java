package com.del.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.del.demo.repository.EnitityRepo;
import com.del.demo.repository.EntityService;
import com.del.demo.repository.PaymentDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Persistence;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userid;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "usertype")
    private UserType userType;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "enrollmentsid")
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
    public User(String username, String name, String email, String passwd){
        this.username = username;
        this.name = name; 
        this.email = email;
        this.password = passwd;
        this.createdAt = LocalDateTime.now();
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

    public void setEnrollments(Enrollments enrollments) {
        this.enrollments = enrollments;
    }
    public Enrollments getEnrollments() {
        return enrollments;
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
    public void purchaseOrder(Order order, EntityService entityService){
        System.out.println("**************Create Payment already**************");

        order.setStatus("Order Confirm");

        Payment payment = new Payment(this, order, order.getTotalAmount(), "Credit Card" );
        entityService.savePayment(payment);
        System.out.println(payment.getPaymentDetails());
        
        this.enrollments = payment.processPayment(entityService);
        if (this.enrollments != null){ 
            entityService.updateUser(this);
            System.out.println("**************Enrollments Details**************");
            System.out.println(enrollments.getEnrollmentsDetails());
        }
        else{
            System.out.println("Can't purchase: \n" + order.getOrderDetails());
            
        }
    }
    @JsonIgnore
    public List<Course> getEnrolledCourse(){
        return enrollments.getCourseList();
    }

    
    

}
