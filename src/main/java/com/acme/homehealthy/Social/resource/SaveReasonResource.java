package com.acme.homehealthy.Social.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveReasonResource {
    @NotNull
    @Size(max = 50)
    private String description;

    public String getDescription() {
        return description;
    }

    public SaveReasonResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
