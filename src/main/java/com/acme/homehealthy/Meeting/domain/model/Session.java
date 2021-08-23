package com.acme.homehealthy.Meeting.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sessions")
public class Session{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name ="start_at")
    private Date startAt;

    @NotNull
    @Column(name = "end_at")
    private Date endAt;

    @NotNull
    private String link;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "collaborator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Collaborator collaborator;


    public Long getId() {
        return id;
    }

    public Session setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartAt() {
        return startAt;
    }

    public Session setStartAt(Date startAt) {
        this.startAt = startAt;
        return this;
    }

    public Date getEndAt() {
        return endAt;
    }

    public Session setEndAt(Date endAt) {
        this.endAt = endAt;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Session setLink(String link) {
        this.link = link;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Session setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public Session setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
        return this;
    }
}