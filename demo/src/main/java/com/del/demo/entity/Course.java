package com.del.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseID")
    private int courseID;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "isFree")
    private boolean isFree;

    @OneToOne
    @JoinColumn(name = "userid")
    private User instructor;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "status")
    private String status;

    @Column(name = "totalStudent")
    private int totalStudent;

    @Column(name = "coursePictureURL")
    private String pictureURL;

    public Course(int coureid, String title, String description, Double price, User instructor){
        this.courseID = coureid;
        this.title = title;
        this.description = description;
        this.price = price;
        this.instructor = instructor;
        this.createdAt = LocalDateTime.now();
    }
    public Course(String title, String description, Double price, User instructor, String pictureURL){
        this.title = title;
        this.description = description;
        this.price = price;
        this.instructor = instructor;
        this.createdAt = LocalDateTime.now();
        this.totalStudent = 0;
        this.pictureURL = pictureURL;
        if (price >= 0){
            this.isFree = false;
        }
        else{
            this.isFree = true;
        }
    }
    public Course(){

    }

    public int getCourseID() {
        return courseID;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public boolean isFree() {
        return isFree;
    }
    public User getInstructor() {
        return instructor;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public String getStatus() {
        return status;
    }
    public int getTotalStudent() {
        return totalStudent;
    }
    public String getPictureURL() {
        return pictureURL;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setFree(boolean isFree) {
        this.isFree = isFree;
    }
    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTotalStudent(int totalStudent) {
        this.totalStudent = totalStudent;
    }
    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }
    public String getCourseDetails() {
        String format = "| %-10s | %-20s | %-20s | %-25s | %-15s | %-10s | %-20s |\n";
        String separator = "+------------+----------------------+----------------------+---------------------------+-----------------+------------+----------------------+\n";

        StringBuilder sb = new StringBuilder();
        sb.append(separator);
        sb.append(String.format(format, "Course ID", "Title", "Decription", "Price", "isFree", "Instructor", "Created At"));
        sb.append(separator);
        sb.append(String.format(format, courseID, title, description, price, isFree, instructor.getName(), createdAt));
        sb.append(separator);

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Course [courseID=" + courseID + ", title=" + title + ", description=" + description + ", price=" + price
                + ", isFree=" + isFree + ", instructor=" + instructor + ", createdAt=" + createdAt + ", status="
                + status + ", totalStudent=" + totalStudent + "]";
    }
    
    
    

    

    


}
