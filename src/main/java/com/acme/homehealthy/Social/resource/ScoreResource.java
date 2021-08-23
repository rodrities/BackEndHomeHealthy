package com.acme.homehealthy.Social.resource;

public class ScoreResource {
    private Long id;
    private String name;
    private Long value;

    public Long getId() {
        return id;
    }

    public ScoreResource setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ScoreResource setName(String name) {
        this.name = name;
        return this;
    }

    public Long getValue() {
        return value;
    }

    public ScoreResource setValue(Long value) {
        this.value = value;
        return this;
    }
}
