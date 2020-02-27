package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    public List<Customer> findByCourseId(Long id);

    public List<Customer> findByTownAndCourseId(String town, Long id);

    public List<Customer> findByTownAndCourseIdOverAge(String town, Long id, int age);

}
