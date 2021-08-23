package com.acme.homehealthy.Initialization.domain.model;

import com.sun.istack.NotNull;
import javax.persistence.*;

@Entity
@Table(name = "collaborators")
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    private String role;
    private Long phone;
    private String address;



    public Long getId() {
        return id;
    }

    public Collaborator setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRole() {
        return role;
    }

    public Collaborator setRole(String role) {
        this.role = role;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Collaborator setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Collaborator setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public Collaborator setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public Collaborator setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Collaborator setEmail(String email) {
        this.email = email;
        return this;
    }

    public Long getPhone() {
        return phone;
    }

    public Collaborator setPhone(Long phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Collaborator setAddress(String address) {
        this.address = address;
        return this;
    }
}
