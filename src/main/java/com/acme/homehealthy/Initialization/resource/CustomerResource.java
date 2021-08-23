package com.acme.homehealthy.Initialization.resource;

public class CustomerResource {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private Long phone;
    private String address;

    public Long getId() {
        return id;
    }

    public CustomerResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CustomerResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CustomerResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CustomerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CustomerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public CustomerResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
