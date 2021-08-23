package com.acme.homehealthy.Social.resource;

public class ComplaintResource {
    private Long id;
    private String description;

    public Long getId() {
        return id;
    }

    public ComplaintResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ComplaintResource setDescription(String description) {
        this.description = description;
        return this;
    }
}
