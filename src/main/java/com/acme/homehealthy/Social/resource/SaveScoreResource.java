package com.acme.homehealthy.Social.resource;

import com.sun.istack.NotNull;

import javax.validation.constraints.Size;

public class SaveScoreResource {
    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    private Long value;

    public String getName() {
        return name;
    }

    public SaveScoreResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public SaveScoreResource setValue(Long value) {
        this.value = value;
        return this;
    }
}
