package com.acme.homehealthy.Meeting.resource;

import com.sun.istack.NotNull;

import java.util.Date;

public class SaveSessionResource {

    @NotNull
    private Date startAt;
    @NotNull
    private Date endAt;
    @NotNull
    private String link;

    public Date getStartAt() {
        return startAt;
    }

    public SaveSessionResource setStartAt(Date startAt) {
        this.startAt = startAt;
        return this;
    }

    public Date getEndAt() {
        return endAt;
    }

    public SaveSessionResource setEndAt(Date endAt) {
        this.endAt = endAt;
        return this;
    }

    public String getLink() {
        return link;
    }

    public SaveSessionResource setLink(String link) {
        this.link = link;
        return this;
    }
}