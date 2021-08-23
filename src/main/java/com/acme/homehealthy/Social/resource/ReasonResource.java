package com.acme.homehealthy.Social.resource;

public class ReasonResource {

    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public ReasonResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ReasonResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
