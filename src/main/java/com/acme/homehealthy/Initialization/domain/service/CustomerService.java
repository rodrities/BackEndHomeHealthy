package com.acme.homehealthy.Initialization.domain.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    Page<Customer> getAllCustomers(Pageable pageable);
    Customer getCustomerById(Long id);
    Customer getCustomerByUsernameAndPassword(String username, String password);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    ResponseEntity<?> deleteCustomer(String username);
}
