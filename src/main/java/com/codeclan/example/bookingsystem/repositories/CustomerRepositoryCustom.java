package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    public List<Customer> findByCourseId(Long id);
}
