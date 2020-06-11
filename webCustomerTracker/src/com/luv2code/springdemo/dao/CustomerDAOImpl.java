package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Repository //catch persistence specific exceptions and rethrow them as one of Spring’s unified unchecked exception.
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query ... sort by last name
        Query theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);

        //execute query and get result list
        List<Customer> customers = theQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        //get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save the customer
        //if id is not null it will call update, if id is null it will call save
        currentSession.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //now retrieve/read from database using primary key
        Customer theCustomer = currentSession.get(Customer.class, theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Customer where id=:theCustomerId");
        theQuery.setParameter("theCustomerId", theId);

        theQuery.executeUpdate();
    }
}
