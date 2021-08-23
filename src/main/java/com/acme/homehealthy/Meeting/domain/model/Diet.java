package com.acme.homehealthy.Meeting.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="diets")
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "collaborator_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Collaborator collaborator;

    private String mondayEarlyMorning;
    private String mondayBreakfast;
    private String mondayMidMorning;
    private String mondayLunch;
    private String mondayMidNoon;
    private String mondayDinner;

    private String tuesdayEarlyMorning;
    private String tuesdayBreakfast;
    private String tuesdayMidMorning;
    private String tuesdayLunch;
    private String tuesdayMidNoon;
    private String tuesdayDinner;

    private String wednesdayEarlyMorning;
    private String wednesdayBreakfast;
    private String wednesdayMidMorning;
    private String wednesdayLunch;
    private String wednesdayMidNoon;
    private String wednesdayDinner;

    private String thursdayEarlyMorning;
    private String thursdayBreakfast;
    private String thursdayMidMorning;
    private String thursdayLunch;
    private String thursdayMidNoon;
    private String thursdayDinner;

    private String fridayEarlyMorning;
    private String fridayBreakfast;
    private String fridayMidMorning;
    private String fridayLunch;
    private String fridayMidNoon;
    private String fridayDinner;

    private String saturdayEarlyMorning;
    private String saturdayBreakfast;
    private String saturdayMidMorning;
    private String saturdayLunch;
    private String saturdayMidNoon;
    private String saturdayDinner;

    private String sundayEarlyMorning;
    private String sundayBreakfast;
    private String sundayMidMorning;
    private String sundayLunch;
    private String sundayMidNoon;
    private String sundayDinner;

    public Long getId() {
        return id;
    }

    public Diet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diet setName(String name) {
        this.name = name;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Diet setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public Diet setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
        return this;
    }

    public String getMondayEarlyMorning() {
        return mondayEarlyMorning;
    }

    public Diet setMondayEarlyMorning(String mondayEarlyMorning) {
        this.mondayEarlyMorning = mondayEarlyMorning;
        return this;
    }

    public String getMondayBreakfast() {
        return mondayBreakfast;
    }

    public Diet setMondayBreakfast(String mondayBreakfast) {
        this.mondayBreakfast = mondayBreakfast;
        return this;
    }

    public String getMondayMidMorning() {
        return mondayMidMorning;
    }

    public Diet setMondayMidMorning(String mondayMidMorning) {
        this.mondayMidMorning = mondayMidMorning;
        return this;
    }

    public String getMondayLunch() {
        return mondayLunch;
    }

    public Diet setMondayLunch(String mondayLunch) {
        this.mondayLunch = mondayLunch;
        return this;
    }

    public String getMondayMidNoon() {
        return mondayMidNoon;
    }

    public Diet setMondayMidNoon(String mondayMidNoon) {
        this.mondayMidNoon = mondayMidNoon;
        return this;
    }

    public String getMondayDinner() {
        return mondayDinner;
    }

    public Diet setMondayDinner(String mondayDinner) {
        this.mondayDinner = mondayDinner;
        return this;
    }

    public String getTuesdayEarlyMorning() {
        return tuesdayEarlyMorning;
    }

    public Diet setTuesdayEarlyMorning(String tuesdayEarlyMorning) {
        this.tuesdayEarlyMorning = tuesdayEarlyMorning;
        return this;
    }

    public String getTuesdayBreakfast() {
        return tuesdayBreakfast;
    }

    public Diet setTuesdayBreakfast(String tuesdayBreakfast) {
        this.tuesdayBreakfast = tuesdayBreakfast;
        return this;
    }

    public String getTuesdayMidMorning() {
        return tuesdayMidMorning;
    }

    public Diet setTuesdayMidMorning(String tuesdayMidMorning) {
        this.tuesdayMidMorning = tuesdayMidMorning;
        return this;
    }

    public String getTuesdayLunch() {
        return tuesdayLunch;
    }

    public Diet setTuesdayLunch(String tuesdayLunch) {
        this.tuesdayLunch = tuesdayLunch;
        return this;
    }

    public String getTuesdayMidNoon() {
        return tuesdayMidNoon;
    }

    public Diet setTuesdayMidNoon(String tuesdayMidNoon) {
        this.tuesdayMidNoon = tuesdayMidNoon;
        return this;
    }

    public String getTuesdayDinner() {
        return tuesdayDinner;
    }

    public Diet setTuesdayDinner(String tuesdayDinner) {
        this.tuesdayDinner = tuesdayDinner;
        return this;
    }

    public String getWednesdayEarlyMorning() {
        return wednesdayEarlyMorning;
    }

    public Diet setWednesdayEarlyMorning(String wednesdayEarlyMorning) {
        this.wednesdayEarlyMorning = wednesdayEarlyMorning;
        return this;
    }

    public String getWednesdayBreakfast() {
        return wednesdayBreakfast;
    }

    public Diet setWednesdayBreakfast(String wednesdayBreakfast) {
        this.wednesdayBreakfast = wednesdayBreakfast;
        return this;
    }

    public String getWednesdayMidMorning() {
        return wednesdayMidMorning;
    }

    public Diet setWednesdayMidMorning(String wednesdayMidMorning) {
        this.wednesdayMidMorning = wednesdayMidMorning;
        return this;
    }

    public String getWednesdayLunch() {
        return wednesdayLunch;
    }

    public Diet setWednesdayLunch(String wednesdayLunch) {
        this.wednesdayLunch = wednesdayLunch;
        return this;
    }

    public String getWednesdayMidNoon() {
        return wednesdayMidNoon;
    }

    public Diet setWednesdayMidNoon(String wednesdayMidNoon) {
        this.wednesdayMidNoon = wednesdayMidNoon;
        return this;
    }

    public String getWednesdayDinner() {
        return wednesdayDinner;
    }

    public Diet setWednesdayDinner(String wednesdayDinner) {
        this.wednesdayDinner = wednesdayDinner;
        return this;
    }

    public String getThursdayEarlyMorning() {
        return thursdayEarlyMorning;
    }

    public Diet setThursdayEarlyMorning(String thursdayEarlyMorning) {
        this.thursdayEarlyMorning = thursdayEarlyMorning;
        return this;
    }

    public String getThursdayBreakfast() {
        return thursdayBreakfast;
    }

    public Diet setThursdayBreakfast(String thursdayBreakfast) {
        this.thursdayBreakfast = thursdayBreakfast;
        return this;
    }

    public String getThursdayMidMorning() {
        return thursdayMidMorning;
    }

    public Diet setThursdayMidMorning(String thursdayMidMorning) {
        this.thursdayMidMorning = thursdayMidMorning;
        return this;
    }

    public String getThursdayLunch() {
        return thursdayLunch;
    }

    public Diet setThursdayLunch(String thursdayLunch) {
        this.thursdayLunch = thursdayLunch;
        return this;
    }

    public String getThursdayMidNoon() {
        return thursdayMidNoon;
    }

    public Diet setThursdayMidNoon(String thursdayMidNoon) {
        this.thursdayMidNoon = thursdayMidNoon;
        return this;
    }

    public String getThursdayDinner() {
        return thursdayDinner;
    }

    public Diet setThursdayDinner(String thursdayDinner) {
        this.thursdayDinner = thursdayDinner;
        return this;
    }

    public String getFridayEarlyMorning() {
        return fridayEarlyMorning;
    }

    public Diet setFridayEarlyMorning(String fridayEarlyMorning) {
        this.fridayEarlyMorning = fridayEarlyMorning;
        return this;
    }

    public String getFridayBreakfast() {
        return fridayBreakfast;
    }

    public Diet setFridayBreakfast(String fridayBreakfast) {
        this.fridayBreakfast = fridayBreakfast;
        return this;
    }

    public String getFridayMidMorning() {
        return fridayMidMorning;
    }

    public Diet setFridayMidMorning(String fridayMidMorning) {
        this.fridayMidMorning = fridayMidMorning;
        return this;
    }

    public String getFridayLunch() {
        return fridayLunch;
    }

    public Diet setFridayLunch(String fridayLunch) {
        this.fridayLunch = fridayLunch;
        return this;
    }

    public String getFridayMidNoon() {
        return fridayMidNoon;
    }

    public Diet setFridayMidNoon(String fridayMidNoon) {
        this.fridayMidNoon = fridayMidNoon;
        return this;
    }

    public String getFridayDinner() {
        return fridayDinner;
    }

    public Diet setFridayDinner(String fridayDinner) {
        this.fridayDinner = fridayDinner;
        return this;
    }

    public String getSaturdayEarlyMorning() {
        return saturdayEarlyMorning;
    }

    public Diet setSaturdayEarlyMorning(String saturdayEarlyMorning) {
        this.saturdayEarlyMorning = saturdayEarlyMorning;
        return this;
    }

    public String getSaturdayBreakfast() {
        return saturdayBreakfast;
    }

    public Diet setSaturdayBreakfast(String saturdayBreakfast) {
        this.saturdayBreakfast = saturdayBreakfast;
        return this;
    }

    public String getSaturdayMidMorning() {
        return saturdayMidMorning;
    }

    public Diet setSaturdayMidMorning(String saturdayMidMorning) {
        this.saturdayMidMorning = saturdayMidMorning;
        return this;
    }

    public String getSaturdayLunch() {
        return saturdayLunch;
    }

    public Diet setSaturdayLunch(String saturdayLunch) {
        this.saturdayLunch = saturdayLunch;
        return this;
    }

    public String getSaturdayMidNoon() {
        return saturdayMidNoon;
    }

    public Diet setSaturdayMidNoon(String saturdayMidNoon) {
        this.saturdayMidNoon = saturdayMidNoon;
        return this;
    }

    public String getSaturdayDinner() {
        return saturdayDinner;
    }

    public Diet setSaturdayDinner(String saturdayDinner) {
        this.saturdayDinner = saturdayDinner;
        return this;
    }

    public String getSundayEarlyMorning() {
        return sundayEarlyMorning;
    }

    public Diet setSundayEarlyMorning(String sundayEarlyMorning) {
        this.sundayEarlyMorning = sundayEarlyMorning;
        return this;
    }

    public String getSundayBreakfast() {
        return sundayBreakfast;
    }

    public Diet setSundayBreakfast(String sundayBreakfast) {
        this.sundayBreakfast = sundayBreakfast;
        return this;
    }

    public String getSundayMidMorning() {
        return sundayMidMorning;
    }

    public Diet setSundayMidMorning(String sundayMidMorning) {
        this.sundayMidMorning = sundayMidMorning;
        return this;
    }

    public String getSundayLunch() {
        return sundayLunch;
    }

    public Diet setSundayLunch(String sundayLunch) {
        this.sundayLunch = sundayLunch;
        return this;
    }

    public String getSundayMidNoon() {
        return sundayMidNoon;
    }

    public Diet setSundayMidNoon(String sundayMidNoon) {
        this.sundayMidNoon = sundayMidNoon;
        return this;
    }

    public String getSundayDinner() {
        return sundayDinner;
    }

    public Diet setSundayDinner(String sundayDinner) {
        this.sundayDinner = sundayDinner;
        return this;
    }
}
/*
    @NotNull
    private String description;

    private String duration;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Session session;

    public Long getId() {
        return id;
    }

    public Diet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Diet setName(String name) {
        this.name = name;
        return this;
    }


    public String getDuration() {
        return duration;
    }

    public Diet setDuration(String duration) {
        this.duration = duration;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public Diet setDescription(String description) {
        this.description = description;
        return this;
    }

    public Session getSession() {
        return session;
    }

    public Diet setSession(Session session) {
        this.session = session;
        return this;
    }
}*/
