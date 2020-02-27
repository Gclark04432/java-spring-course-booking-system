package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {
    public List<Course> findByRating(int rating);
    public List<Course> findByCustomer(String customerName);
}
