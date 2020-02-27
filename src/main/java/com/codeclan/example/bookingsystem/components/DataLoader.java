package com.codeclan.example.bookingsystem.components;

import com.codeclan.example.bookingsystem.models.Booking;
import com.codeclan.example.bookingsystem.models.Course;
import com.codeclan.example.bookingsystem.models.Customer;
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

        Customer ross = new Customer("Ross", "Musselburgh", 2678);
        customerRepository.save(ross);

        Customer cody = new Customer("Cody Abbotty", "Edinburgh", 27);
        customerRepository.save(cody);

        Customer stephen = new Customer("Stephen Ramsay", "Moscow", 32);
        customerRepository.save(stephen);

        Booking booking1 = new Booking("27-02-20", course2, stephen);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("28-02-20", course1, ross);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("28-02-20",  course1, cody);
        bookingRepository.save(booking3);

    }
}
