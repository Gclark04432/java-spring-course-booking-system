package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    public List<Course> findByCustomer(String customerName);
}
