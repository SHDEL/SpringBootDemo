package com.del.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// @Entity
// @Table(name="Enrollments")
public class Enrollments {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name = "enrollmentsid")
    private int enrollmentsID;

    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    private List<Course> courseList;

    // @Column(name = "enrolledAt")
    private LocalDateTime enrolledAt;

    public Enrollments (){

    }
    public Enrollments(User user){
        this.user = user;
        courseList = new ArrayList<>();
        enrolledAt = LocalDateTime.now();
        System.out.println("Enroll Success");
    }

    public int getEnrollmentsID() {
        return enrollmentsID;
    }
    public User getUser() {
        return user;
    }
    public List<Course> getCourseList() {
        return courseList;
    }
    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
    public void enrollCourse(Course course, boolean isPaid){
        if (isPaid){
            courseList.add(course);
        }
        else{
            System.out.println("enroll failed your payment is not success");
        }
    }
    public String getEnrollmentsDetails() {
        StringBuilder sb = new StringBuilder();
        String format = "| %-15s | %-50s |\n";  // กำหนดความกว้างของคอลัมน์
        String separator = "+-----------------+----------------------------------------------------+\n";
    
        // // เพิ่ม Header
        // sb.append(separator);
        // sb.append(String.format(format, "Field", "Details"));
        // sb.append(separator);
        
        // เพิ่มข้อมูลพื้นฐานของ Enrollment
        sb.append(String.format(format, "Enroll ID", enrollmentsID));
        sb.append(String.format(format, "User ID", user.getId()));
        sb.append(String.format(format, "UserName", user.getUserName()));
        sb.append(String.format(format, "Enrolled At", enrolledAt));
        
        // เพิ่ม Course List แบบหลายบรรทัด
        sb.append(String.format(format, "Courses", ""));
        for (Course course : courseList) {
            sb.append(String.format("| %-15s | %-50s |\n", "", course.getTitle())); // แสดง Course ต่อกันในคอลัมน์ที่ 2
        }
        
        sb.append(separator);
        return sb.toString();
    } 
}