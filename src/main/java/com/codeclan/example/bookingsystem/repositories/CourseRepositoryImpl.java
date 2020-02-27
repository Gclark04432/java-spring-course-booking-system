package com.codeclan.example.bookingsystem.repositories;

import com.codeclan.example.bookingsystem.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RepositoryRestResource
public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> findByCustomer(String customerName) {
        List<Course> result = null;
        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Course.class);
            criteria.createAlias("bookings", "bookingAlias");
            criteria.createAlias("bookingAlias.customer", "customerAlias");
            criteria.add(Restrictions.eq("customerAlias.name", customerName));

            result = criteria.list();
        } catch (HibernateException ex){
            ex.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }
}