package com.acme.homehealthy.Initialization.service;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.repository.CustomerRepository;
import com.acme.homehealthy.Initialization.domain.service.CustomerService;
import com.acme.homehealthy.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getCustomerById(Long id) {

        return customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","Id",id));
    }

    @Override
    public Customer getCustomerByUsernameAndPassword(String username, String password) {
        return customerRepository.findCustomerByUsernameAndPassword(username,password)
                .orElseThrow(()->new ResourceNotFoundException("Customer","Username or Password",username + " " + password));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        Customer existingUsername = customerRepository.findCustomerByUsername(customer.getUsername()).orElse(null);
        if(existingUsername != null){
            throw new ResourceNotFoundException("This username is begin used by another user");
        }

        Customer existingEmail = customerRepository.findCustomerByEmail(customer.getEmail()).orElse(null);
        if(existingEmail != null){
            throw new ResourceNotFoundException("This email is begin used by another user");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {

        Customer existingCustomer = customerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer","Id",id));

        if(customer.getEmail() != existingCustomer.getEmail()) {
            Customer existingEmail = customerRepository.findCustomerByEmail(customer.getEmail()).orElse(null);
            if (existingEmail != null) {
                throw new ResourceNotFoundException("This email is begin used by another user");
            }
        }
        return customerRepository.save(
                existingCustomer.setAddress(customer.getAddress())
                .setBirthday(customer.getBirthday())
                .setEmail(customer.getEmail())
                .setAddress(customer.getAddress())
                .setLastname(customer.getLastname())
                .setName(customer.getName())
                .setPassword(customer.getPassword())
                .setPhone(customer.getPhone())
        );
    }

    @Override
    public ResponseEntity<?> deleteCustomer(String username) {
        Customer customer = customerRepository.findCustomerByUsername(username).orElseThrow(()->new ResourceNotFoundException("Customer","Username",username));
        customerRepository.delete(customer);
        return ResponseEntity.ok().build();
    }
}
