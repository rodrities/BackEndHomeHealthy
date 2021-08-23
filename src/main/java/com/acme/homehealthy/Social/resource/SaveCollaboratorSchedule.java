package com.acme.homehealthy.Social.resource;

import com.sun.istack.NotNull;

import java.util.Date;

public class SaveCollaboratorSchedule {

    @NotNull
    private Date date;

    public Date getDate() {
        return date;
    }

    public SaveCollaboratorSchedule setDate(Date date) {
        this.date = date;
        return this;
    }
}
