package com.del.demo.repository;

import com.del.demo.entity.Course;
import com.del.demo.entity.Enrollments;

public interface CourseDAO {
    void saveCourse(Course course);
    void deleteCourse(int id);
}
