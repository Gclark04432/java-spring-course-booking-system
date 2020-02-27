package com.codeclan.example.bookingsystem.controllers;

import com.codeclan.example.bookingsystem.models.Customer;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/search/findByCourseId")
    public List<Customer> findByCourseId(@RequestParam Long id){
        return customerRepository.findByCourseId(id);
    }

    @GetMapping("/search/findByTownAndCourseId")
    public List<Customer> findByTownAndCourseId(@RequestParam String town, Long id){
        return customerRepository.findByTownAndCourseId(town, id);
    }

    @GetMapping("/search/findByTownAndCourseIdOverAge")
    public List<Customer> findByTownAndCourseIdOverAge(@RequestParam String town, Long id, int age){
        return customerRepository.findByTownAndCourseIdOverAge(town, id, age);
    }

}
