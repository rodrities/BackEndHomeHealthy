package com.acme.homehealthy.MemberShip.resource;

import com.sun.istack.NotNull;

import javax.persistence.Lob;
import javax.validation.constraints.Size;

public class SavePlanResource {
    @NotNull
    @Size(max = 15)
    private String name;

    @NotNull
    @Lob
    private String description;

    @NotNull
    private Long maxSession;
    @NotNull
    private Long price;

    public String getName() {
        return name;
    }

    public SavePlanResource setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SavePlanResource setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getMaxSession() {
        return maxSession;
    }

    public SavePlanResource setMaxSession(Long maxSession) {
        this.maxSession = maxSession;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public SavePlanResource setPrice(Long price) {
        this.price = price;
        return this;
    }
}
