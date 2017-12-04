package com.the9o.demo.jooq.controllers;

import static com.the9o.demo.jooq.models.Tables.CUSTOMER;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.the9o.demo.jooq.models.tables.daos.CustomerDao;
import com.the9o.demo.jooq.models.tables.pojos.Customer;

@RestController
@RequestMapping(path = "/customers", produces = { "application/json" })
public class CustomerController {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    DSLContext dsl;

    @GetMapping
    ResponseEntity<?> list() {

        return ResponseEntity.ok(customerDao.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<?> get(@PathVariable("id") Integer id) {

        // Sample using generated DAO
        return ResponseEntity.ok(customerDao.findById(id));
    }

    @PostMapping()
    ResponseEntity<?> post(@RequestBody Customer customer) {

        if (customer.getId() != null && customerDao.existsById(customer.getId()))
            return put(customer.getId(), customer);

        // Excluded ID for sequence generation
        return ResponseEntity.ok(dsl.insertInto(CUSTOMER).columns(CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME)
                .values(customer.getFirstName(), customer.getLastName()).returning().fetch().into(Customer.class));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> put(@PathVariable("id") Integer id, @RequestBody Customer customer) {
        customer.setId(id);
        int updated_records = dsl.executeUpdate(dsl.newRecord(CUSTOMER,customer));
            
        return ResponseEntity.ok(updated_records>0?"Record Updated":"Record not updated");
    }
    

    @DeleteMapping("/{id}")
    ResponseEntity<?> put(@PathVariable("id") Integer id) {

        customerDao.deleteById(id);

        if (customerDao.existsById(id))
            return ResponseEntity.ok("Deleted");

        return new ResponseEntity("Failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
