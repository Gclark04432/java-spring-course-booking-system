package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {

    public List<Booking> findByDate(String date);
}
