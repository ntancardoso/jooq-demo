/*
 * This file is generated by jOOQ.
*/
package com.the9o.demo.jooq.models.tables.daos;


import com.the9o.demo.jooq.models.tables.Customer;
import com.the9o.demo.jooq.models.tables.records.CustomerRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CustomerDao extends DAOImpl<CustomerRecord, com.the9o.demo.jooq.models.tables.pojos.Customer, Integer> {

    /**
     * Create a new CustomerDao without any configuration
     */
    public CustomerDao() {
        super(Customer.CUSTOMER, com.the9o.demo.jooq.models.tables.pojos.Customer.class);
    }

    /**
     * Create a new CustomerDao with an attached configuration
     */
    public CustomerDao(Configuration configuration) {
        super(Customer.CUSTOMER, com.the9o.demo.jooq.models.tables.pojos.Customer.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.the9o.demo.jooq.models.tables.pojos.Customer object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.the9o.demo.jooq.models.tables.pojos.Customer> fetchById(Integer... values) {
        return fetch(Customer.CUSTOMER.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.the9o.demo.jooq.models.tables.pojos.Customer fetchOneById(Integer value) {
        return fetchOne(Customer.CUSTOMER.ID, value);
    }

    /**
     * Fetch records that have <code>first_name IN (values)</code>
     */
    public List<com.the9o.demo.jooq.models.tables.pojos.Customer> fetchByFirstName(String... values) {
        return fetch(Customer.CUSTOMER.FIRST_NAME, values);
    }

    /**
     * Fetch records that have <code>last_name IN (values)</code>
     */
    public List<com.the9o.demo.jooq.models.tables.pojos.Customer> fetchByLastName(String... values) {
        return fetch(Customer.CUSTOMER.LAST_NAME, values);
    }
}
