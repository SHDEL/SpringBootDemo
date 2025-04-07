package com.del.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;

@Entity
@Table(name="Enrollments")
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollmentid")
    private int enrollmentID;

    @OneToOne
    @JoinColumn(name = "userid")
    private User user;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "enrollmentsCourses", // ตารางกลาง
        joinColumns = @JoinColumn(name = "enrollmentid"),
        inverseJoinColumns = @JoinColumn(name = "courseid")
    )
    private List<Course> courseList;

    @Column(name = "enrolledAt")
    private LocalDateTime enrolledAt;

    public Enrollments (){

    }
    public Enrollments(User user){
        this.user = user;
        courseList = new ArrayList<>();
        enrolledAt = LocalDateTime.now();
    }

    public int getEnrollmentsID() {
        return enrollmentID;
    }
    public User getUser() {
        return user;
    }
    
    @JsonIgnore
    public List<Course> getCourseList() {
        return courseList;
    }
    public LocalDateTime getEnrolledAt() {
        return enrolledAt;
    }
    public void setUser(User user) {
        this.user = user;
    }
    @JsonIgnore
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    public void setEnrolledAt(LocalDateTime enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
    public void enrollCourse(Course course, Payment payment){
        if (payment.getStatus().equals("Payment Success")){
            this.courseList.add(course);
            System.out.println("enroll successful");
        }
        else{
            System.out.println("enroll failed your payment is not success");
        }
    }
    public String getEnrollmentsDetails() {
        StringBuilder sb = new StringBuilder();
        String format = "| %-15s | %-50s |\n";  // กำหนดความกว้างของคอลัมน์
        String separator = "+-----------------+----------------------------------------------------+\n";
        
        // เพิ่มข้อมูลพื้นฐานของ Enrollment
        sb.append(String.format(format, "Enroll ID", enrollmentID));
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