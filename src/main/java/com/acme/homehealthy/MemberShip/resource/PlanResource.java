package com.acme.homehealthy.MemberShip.resource;

public class PlanResource {
    private Long id;
    private String name;
    private String description;
    private Long maxSession;
    private Long price;

    public Long getId() {
        return id;
    }

    public PlanResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlanResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PlanResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getMaxSession() {
        return maxSession;
    }

    public PlanResource setMaxSession(Long maxSession) {
        this.maxSession = maxSession;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public PlanResource setPrice(Long price) {
        this.price = price;
        return this;
    }
}
