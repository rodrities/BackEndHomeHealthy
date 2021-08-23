package com.acme.homehealthy.Meeting.resource;

import java.util.Date;

public class SessionResource {

    private Long id;
    private Date startAt;
    private Date endAt;
    private String link;

    public Long getId() {
        return id;
    }

    public SessionResource setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartAt() {
        return startAt;
    }

    public SessionResource setStartAt(Date startAt) {
        this.startAt = startAt;
        return this;
    }

    public Date getEndAt() {
        return endAt;
    }

    public SessionResource setEndAt(Date endAt) {
        this.endAt = endAt;
        return this;
    }

    public String getLink() {
        return link;
    }

    public SessionResource setLink(String link) {
        this.link = link;
        return this;
    }
}
