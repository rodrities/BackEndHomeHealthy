package com.acme.homehealthy.Initialization.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;


public class SaveCustomerResource {

    @NotNull
    @Size(max = 20)
    private String username;
    @NotNull
    @Size(max = 20)
    private String password;
    @NotNull
    @Size(max = 20)
    private String name;
    @NotNull
    @Size(max = 20)
    private String lastname;
    @NotNull
    @Size(max = 50)
    private String email;
    @NotNull
    private Long phone;
    @NotNull
    @Size(max = 50)
    private String address;

    public String getUsername() {
        return username;
    }

    public SaveCustomerResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveCustomerResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveCustomerResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveCustomerResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveCustomerResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public SaveCustomerResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveCustomerResource setAddress(String address) {
        this.address = address;
        return this;
    }
}