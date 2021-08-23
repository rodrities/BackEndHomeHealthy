package com.acme.homehealthy.Social.domain.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "scores")
public class Score {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    private Long value;


    public Long getId() {
        return id;
    }

    public Score setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Score setName(String name) {
        this.name = name;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public Score setValue(Long value) {
        this.value = value;
        return this;
    }
}
