package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/search/findByCustomer")
    public List<Course> findByCustomer(@RequestParam String name){
        return courseRepository.findByCustomer(name);
    }
}
