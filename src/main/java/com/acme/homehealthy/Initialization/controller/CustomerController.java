package com.acme.homehealthy.Initialization.controller;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.acme.homehealthy.Initialization.domain.service.CustomerService;
import com.acme.homehealthy.Initialization.resource.CollaboratorResource;
import com.acme.homehealthy.Initialization.resource.CustomerResource;
import com.acme.homehealthy.Initialization.resource.SaveCustomerResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Customers", description = "Initialization API")
@RestController
@RequestMapping("api/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Find all customers")
    @GetMapping("/customers")
    public Page<CustomerResource> getAllCustomers(Pageable pageable){
        Page<Customer> customers = customerService.getAllCustomers(pageable);
        List<CustomerResource> resources = customers.stream().map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Find customer by Id")
    @GetMapping("/customer/{customerId}")
    public CustomerResource getCustomerById(@Valid @PathVariable(value = "customerId") Long customerId) {
        return convertToResource(customerService.getCustomerById(customerId));

    }

    @Operation(summary = "Find customer by username and password")
    @GetMapping("/customers/{username}/{password}")
    public CustomerResource getCustomerByUsernameAndPassword(@Valid @PathVariable(value = "username") String username,
                                                             @Valid @PathVariable(value = "password") String password) {
        return convertToResource(customerService.getCustomerByUsernameAndPassword(username, password));
    }

    @Operation(summary = "Create a new customer")
    @PostMapping("/customers")
    public CustomerResource createCustomer(@Valid @RequestBody SaveCustomerResource resource) {
        Customer customer = convertToEntity(resource);
        return convertToResource(customerService.createCustomer(customer));
    }

    @Operation(summary = "Update a customer")
    @PutMapping("/customers/{customerId}")
    public CustomerResource updateCustomer(@Valid @PathVariable(value = "customerId") Long customerId,
                                           @Valid @RequestBody SaveCustomerResource resource) {
        Customer customer = convertToEntity(resource);
        return convertToResource(customerService.updateCustomer(customerId, customer));
    }

    @Operation(summary = "Delete a customer")
    @DeleteMapping("/customers/{username}")
    public ResponseEntity<?> deleteCustomer(@Valid @PathVariable(value = "username") String username) {
        return customerService.deleteCustomer(username);
    }

    private Customer convertToEntity(SaveCustomerResource resource) {
        return mapper.map(resource, Customer.class);
    }

    private CustomerResource convertToResource(Customer customer) {
        return mapper.map(customer, CustomerResource.class);
    }
}
