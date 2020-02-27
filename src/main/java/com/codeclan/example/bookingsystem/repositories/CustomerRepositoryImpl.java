package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.controllers.CustomerController;
import com.codeclan.example.bookingsystem.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    public List<Customer> findByCourseId(Long id){
        List<Customer> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Customer.class);

            criteria.createAlias("bookings", "bookingAlias");
            criteria.createAlias("bookingAlias.course", "courseAlias");
            criteria.add(Restrictions.eq("courseAlias.id", id));

            result = criteria.list();

        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }
}
