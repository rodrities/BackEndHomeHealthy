package com.acme.homehealthy.Social.resource;

import java.util.Date;

public class CollaboratorScheduleResource {

    private Long id;
    private Date date;

    public Long getId() {
        return id;
    }

    public CollaboratorScheduleResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public CollaboratorScheduleResource setDate(Date date) {
        this.date = date;
        return this;
    }
}
