package com.acme.homehealthy.Initialization.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveCollaboratorResource {
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
    @NotNull
    private  String role;


    public String getRole() {
        return role;
    }

    public SaveCollaboratorResource setRole(String role) {
        this.role = role;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public SaveCollaboratorResource setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SaveCollaboratorResource setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveCollaboratorResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public SaveCollaboratorResource setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SaveCollaboratorResource setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public SaveCollaboratorResource setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SaveCollaboratorResource setAddress(String address) {
        this.address = address;
        return this;
    }
}
