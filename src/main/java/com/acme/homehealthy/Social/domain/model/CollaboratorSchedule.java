package com.acme.homehealthy.Social.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "collaboratorSchedules")
public class CollaboratorSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "collaborator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Collaborator collaborator;

    public Long getId() {
        return id;
    }

    public CollaboratorSchedule setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public CollaboratorSchedule setDate(Date date) {
        this.date = date;
        return this;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public CollaboratorSchedule setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
        return this;
    }
}
