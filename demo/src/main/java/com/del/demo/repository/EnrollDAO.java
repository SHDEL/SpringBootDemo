package com.del.demo.repository;

import java.util.List;

import com.del.demo.entity.Enrollments;
import com.del.demo.entity.User;

public interface EnrollDAO {
    void saveEnroll(Enrollments enrollments);
    void deleteEnroll(int id);
}
