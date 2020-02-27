package com.codeclan.example.bookingsystem.components;

import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.repositories.BookingRepository;
import com.codeclan.example.bookingsystem.repositories.CourseRepository;
import com.codeclan.example.bookingsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course1 = new Course("Extreme Knitting", "Edinburgh", 2);
        courseRepository.save(course1);

        Course course2 = new Course("Mundane Basejumping", "Dunfermline", 3);
        courseRepository.save(course2);

        Booking booking1 = new Booking("27-02-20", course2);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("28-02-20", course1);
        bookingRepository.save(booking2);

    }
}
