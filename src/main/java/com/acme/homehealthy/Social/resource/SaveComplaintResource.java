package com.acme.homehealthy.Social.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveComplaintResource {
    @NotNull
    @Size(max = 50)
    private String description;

    public String getDescription() {
        return description;
    }

    public SaveComplaintResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
