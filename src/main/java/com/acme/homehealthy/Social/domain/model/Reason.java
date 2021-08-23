package com.acme.homehealthy.Social.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reasons")
public class Reason {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    @Size(max = 50)
    private String description;

    public Long getId() {
        return id;
    }

    public Reason setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Reason setDescription(String description) {
        this.description = description;
        return this;
    }
}
