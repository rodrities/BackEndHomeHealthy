package com.acme.homehealthy.Social.resource;

import com.sun.istack.NotNull;

import javax.persistence.Lob;

public class SaveReviewResource {

    @NotNull
    @Lob
    private String description;

    public String getDescription() {
        return description;
    }

    public SaveReviewResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
