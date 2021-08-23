package com.acme.homehealthy.Initialization.resource;


public class CollaboratorResource {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String email;
    private String role;
    private Long phone;
    private String address;


    public Long getId() {
        return id;
    }

    public CollaboratorResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CollaboratorResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CollaboratorResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public CollaboratorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public CollaboratorResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CollaboratorResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getRole() {
        return role;
    }

    public CollaboratorResource setRole(String role) {
        this.role = role;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public CollaboratorResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CollaboratorResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
