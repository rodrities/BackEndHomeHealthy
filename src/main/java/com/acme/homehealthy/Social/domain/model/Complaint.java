package com.acme.homehealthy.Social.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotNull
    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reason_id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Reason reason;

    public Long getId() {
        return id;
    }

    public Complaint setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Complaint setDescription(String description) {
        this.description = description;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Complaint setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Reason getReason() {
        return reason;
    }

    public Complaint setReason(Reason reason) {
        this.reason = reason;
        return this;
    }
}
