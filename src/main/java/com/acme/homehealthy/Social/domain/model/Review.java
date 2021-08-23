package com.acme.homehealthy.Social.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collaborator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Collaborator collaborator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "score_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Score score;

    @NotNull
    @Lob
    private String description;

    public Customer getCustomer() {
        return customer;
    }

    public Review setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public Review setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public Review setScore(Score score) {
        this.score = score;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Review setDescription(String description) {
        this.description = description;
        return this;
    }
}
