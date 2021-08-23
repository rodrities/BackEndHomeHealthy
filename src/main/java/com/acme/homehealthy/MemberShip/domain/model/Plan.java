package com.acme.homehealthy.MemberShip.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Lob
    private String description;

    @NotNull
    private Long maxSession;

    @NotNull
    private Long price;

    public Long getId() {
        return id;
    }

    public Plan setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Plan setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Plan setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getMaxSession() {
        return maxSession;
    }

    public Plan setMaxSession(Long maxSession) {
        this.maxSession = maxSession;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Plan setPrice(Long price) {
        this.price = price;
        return this;
    }
}
