package com.acme.homehealthy.Meeting.domain.model;

import com.acme.homehealthy.Initialization.domain.model.Collaborator;
import com.acme.homehealthy.Initialization.domain.model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="routines")
public class Rutine {

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

    private String firstExerciseMonday;
    private String secondExerciseMonday;
    private String thirdExerciseMonday;
    private String fourthExerciseMonday;
    private String fifthExerciseMonday;
    private String sixthExerciseMonday;

    private String firstExerciseTuesday;
    private String secondExerciseTuesday;
    private String thirdExerciseTuesday;
    private String fourthExerciseTuesday;
    private String fifthExerciseTuesday;
    private String sixthExerciseTuesday;

    private String firstExerciseWednesday;
    private String secondExerciseWednesday;
    private String thirdExerciseWednesday;
    private String fourthExerciseWednesday;
    private String fifthExerciseWednesday;
    private String sixthExerciseWednesday;

    private String firstExerciseThursday;
    private String secondExerciseThursday;
    private String thirdExerciseThursday;
    private String fourthExerciseThursday;
    private String fifthExerciseThursday;
    private String sixthExerciseThursday;

    private String firstExerciseFriday;
    private String secondExerciseFriday;
    private String thirdExerciseFriday;
    private String fourthExerciseFriday;
    private String fifthExerciseFriday;
    private String sixthExerciseFriday;

    private String firstExerciseSaturday;
    private String secondExerciseSaturday;
    private String thirdExerciseSaturday;
    private String fourthExerciseSaturday;
    private String fifthExerciseSaturday;
    private String sixthExerciseSaturday;

    private String firstExerciseSunday;
    private String secondExerciseSunday;
    private String thirdExerciseSunday;
    private String fourthExerciseSunday;
    private String fifthExerciseSunday;
    private String sixthExerciseSunday;

    public Long getId() {
        return id;
    }

    public Rutine setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Rutine setName(String name) {
        this.name = name;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Rutine setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public Rutine setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
        return this;
    }

    public String getFirstExerciseMonday() {
        return firstExerciseMonday;
    }

    public Rutine setFirstExerciseMonday(String firstExerciseMonday) {
        this.firstExerciseMonday = firstExerciseMonday;
        return this;
    }

    public String getSecondExerciseMonday() {
        return secondExerciseMonday;
    }

    public Rutine setSecondExerciseMonday(String secondExerciseMonday) {
        this.secondExerciseMonday = secondExerciseMonday;
        return this;
    }

    public String getThirdExerciseMonday() {
        return thirdExerciseMonday;
    }

    public Rutine setThirdExerciseMonday(String thirdExerciseMonday) {
        this.thirdExerciseMonday = thirdExerciseMonday;
        return this;
    }

    public String getFourthExerciseMonday() {
        return fourthExerciseMonday;
    }

    public Rutine setFourthExerciseMonday(String fourthExerciseMonday) {
        this.fourthExerciseMonday = fourthExerciseMonday;
        return this;
    }

    public String getFifthExerciseMonday() {
        return fifthExerciseMonday;
    }

    public Rutine setFifthExerciseMonday(String fifthExerciseMonday) {
        this.fifthExerciseMonday = fifthExerciseMonday;
        return this;
    }

    public String getSixthExerciseMonday() {
        return sixthExerciseMonday;
    }

    public Rutine setSixthExerciseMonday(String sixthExerciseMonday) {
        this.sixthExerciseMonday = sixthExerciseMonday;
        return this;
    }

    public String getFirstExerciseTuesday() {
        return firstExerciseTuesday;
    }

    public Rutine setFirstExerciseTuesday(String firstExerciseTuesday) {
        this.firstExerciseTuesday = firstExerciseTuesday;
        return this;
    }

    public String getSecondExerciseTuesday() {
        return secondExerciseTuesday;
    }

    public Rutine setSecondExerciseTuesday(String secondExerciseTuesday) {
        this.secondExerciseTuesday = secondExerciseTuesday;
        return this;
    }

    public String getThirdExerciseTuesday() {
        return thirdExerciseTuesday;
    }

    public Rutine setThirdExerciseTuesday(String thirdExerciseTuesday) {
        this.thirdExerciseTuesday = thirdExerciseTuesday;
        return this;
    }

    public String getFourthExerciseTuesday() {
        return fourthExerciseTuesday;
    }

    public Rutine setFourthExerciseTuesday(String fourthExerciseTuesday) {
        this.fourthExerciseTuesday = fourthExerciseTuesday;
        return this;
    }

    public String getFifthExerciseTuesday() {
        return fifthExerciseTuesday;
    }

    public Rutine setFifthExerciseTuesday(String fifthExerciseTuesday) {
        this.fifthExerciseTuesday = fifthExerciseTuesday;
        return this;
    }

    public String getSixthExerciseTuesday() {
        return sixthExerciseTuesday;
    }

    public Rutine setSixthExerciseTuesday(String sixthExerciseTuesday) {
        this.sixthExerciseTuesday = sixthExerciseTuesday;
        return this;
    }

    public String getFirstExerciseWednesday() {
        return firstExerciseWednesday;
    }

    public Rutine setFirstExerciseWednesday(String firstExerciseWednesday) {
        this.firstExerciseWednesday = firstExerciseWednesday;
        return this;
    }

    public String getSecondExerciseWednesday() {
        return secondExerciseWednesday;
    }

    public Rutine setSecondExerciseWednesday(String secondExerciseWednesday) {
        this.secondExerciseWednesday = secondExerciseWednesday;
        return this;
    }

    public String getThirdExerciseWednesday() {
        return thirdExerciseWednesday;
    }

    public Rutine setThirdExerciseWednesday(String thirdExerciseWednesday) {
        this.thirdExerciseWednesday = thirdExerciseWednesday;
        return this;
    }

    public String getFourthExerciseWednesday() {
        return fourthExerciseWednesday;
    }

    public Rutine setFourthExerciseWednesday(String fourthExerciseWednesday) {
        this.fourthExerciseWednesday = fourthExerciseWednesday;
        return this;
    }

    public String getFifthExerciseWednesday() {
        return fifthExerciseWednesday;
    }

    public Rutine setFifthExerciseWednesday(String fifthExerciseWednesday) {
        this.fifthExerciseWednesday = fifthExerciseWednesday;
        return this;
    }

    public String getSixthExerciseWednesday() {
        return sixthExerciseWednesday;
    }

    public Rutine setSixthExerciseWednesday(String sixthExerciseWednesday) {
        this.sixthExerciseWednesday = sixthExerciseWednesday;
        return this;
    }

    public String getFirstExerciseThursday() {
        return firstExerciseThursday;
    }

    public Rutine setFirstExerciseThursday(String firstExerciseThursday) {
        this.firstExerciseThursday = firstExerciseThursday;
        return this;
    }

    public String getSecondExerciseThursday() {
        return secondExerciseThursday;
    }

    public Rutine setSecondExerciseThursday(String secondExerciseThursday) {
        this.secondExerciseThursday = secondExerciseThursday;
        return this;
    }

    public String getThirdExerciseThursday() {
        return thirdExerciseThursday;
    }

    public Rutine setThirdExerciseThursday(String thirdExerciseThursday) {
        this.thirdExerciseThursday = thirdExerciseThursday;
        return this;
    }

    public String getFourthExerciseThursday() {
        return fourthExerciseThursday;
    }

    public Rutine setFourthExerciseThursday(String fourthExerciseThursday) {
        this.fourthExerciseThursday = fourthExerciseThursday;
        return this;
    }

    public String getFifthExerciseThursday() {
        return fifthExerciseThursday;
    }

    public Rutine setFifthExerciseThursday(String fifthExerciseThursday) {
        this.fifthExerciseThursday = fifthExerciseThursday;
        return this;
    }

    public String getSixthExerciseThursday() {
        return sixthExerciseThursday;
    }

    public Rutine setSixthExerciseThursday(String sixthExerciseThursday) {
        this.sixthExerciseThursday = sixthExerciseThursday;
        return this;
    }

    public String getFirstExerciseFriday() {
        return firstExerciseFriday;
    }

    public Rutine setFirstExerciseFriday(String firstExerciseFriday) {
        this.firstExerciseFriday = firstExerciseFriday;
        return this;
    }

    public String getSecondExerciseFriday() {
        return secondExerciseFriday;
    }

    public Rutine setSecondExerciseFriday(String secondExerciseFriday) {
        this.secondExerciseFriday = secondExerciseFriday;
        return this;
    }

    public String getThirdExerciseFriday() {
        return thirdExerciseFriday;
    }

    public Rutine setThirdExerciseFriday(String thirdExerciseFriday) {
        this.thirdExerciseFriday = thirdExerciseFriday;
        return this;
    }

    public String getFourthExerciseFriday() {
        return fourthExerciseFriday;
    }

    public Rutine setFourthExerciseFriday(String fourthExerciseFriday) {
        this.fourthExerciseFriday = fourthExerciseFriday;
        return this;
    }

    public String getFifthExerciseFriday() {
        return fifthExerciseFriday;
    }

    public Rutine setFifthExerciseFriday(String fifthExerciseFriday) {
        this.fifthExerciseFriday = fifthExerciseFriday;
        return this;
    }

    public String getSixthExerciseFriday() {
        return sixthExerciseFriday;
    }

    public Rutine setSixthExerciseFriday(String sixthExerciseFriday) {
        this.sixthExerciseFriday = sixthExerciseFriday;
        return this;
    }

    public String getFirstExerciseSaturday() {
        return firstExerciseSaturday;
    }

    public Rutine setFirstExerciseSaturday(String firstExerciseSaturday) {
        this.firstExerciseSaturday = firstExerciseSaturday;
        return this;
    }

    public String getSecondExerciseSaturday() {
        return secondExerciseSaturday;
    }

    public Rutine setSecondExerciseSaturday(String secondExerciseSaturday) {
        this.secondExerciseSaturday = secondExerciseSaturday;
        return this;
    }

    public String getThirdExerciseSaturday() {
        return thirdExerciseSaturday;
    }

    public Rutine setThirdExerciseSaturday(String thirdExerciseSaturday) {
        this.thirdExerciseSaturday = thirdExerciseSaturday;
        return this;
    }

    public String getFourthExerciseSaturday() {
        return fourthExerciseSaturday;
    }

    public Rutine setFourthExerciseSaturday(String fourthExerciseSaturday) {
        this.fourthExerciseSaturday = fourthExerciseSaturday;
        return this;
    }

    public String getFifthExerciseSaturday() {
        return fifthExerciseSaturday;
    }

    public Rutine setFifthExerciseSaturday(String fifthExerciseSaturday) {
        this.fifthExerciseSaturday = fifthExerciseSaturday;
        return this;
    }

    public String getSixthExerciseSaturday() {
        return sixthExerciseSaturday;
    }

    public Rutine setSixthExerciseSaturday(String sixthExerciseSaturday) {
        this.sixthExerciseSaturday = sixthExerciseSaturday;
        return this;
    }

    public String getFirstExerciseSunday() {
        return firstExerciseSunday;
    }

    public Rutine setFirstExerciseSunday(String firstExerciseSunday) {
        this.firstExerciseSunday = firstExerciseSunday;
        return this;
    }

    public String getSecondExerciseSunday() {
        return secondExerciseSunday;
    }

    public Rutine setSecondExerciseSunday(String secondExerciseSunday) {
        this.secondExerciseSunday = secondExerciseSunday;
        return this;
    }

    public String getThirdExerciseSunday() {
        return thirdExerciseSunday;
    }

    public Rutine setThirdExerciseSunday(String thirdExerciseSunday) {
        this.thirdExerciseSunday = thirdExerciseSunday;
        return this;
    }

    public String getFourthExerciseSunday() {
        return fourthExerciseSunday;
    }

    public Rutine setFourthExerciseSunday(String fourthExerciseSunday) {
        this.fourthExerciseSunday = fourthExerciseSunday;
        return this;
    }

    public String getFifthExerciseSunday() {
        return fifthExerciseSunday;
    }

    public Rutine setFifthExerciseSunday(String fifthExerciseSunday) {
        this.fifthExerciseSunday = fifthExerciseSunday;
        return this;
    }

    public String getSixthExerciseSunday() {
        return sixthExerciseSunday;
    }

    public Rutine setSixthExerciseSunday(String sixthExerciseSunday) {
        this.sixthExerciseSunday = sixthExerciseSunday;
        return this;
    }

    /*
    @NotNull
    private String description;

    private String duration;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "session_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Session session;

    public Long getId() {
        return id;
    }

    public Rutine setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Rutine setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Rutine setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public Rutine setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public Session getSession() {
        return session;
    }

    public Rutine setSession(Session session) {
        this.session = session;
        return this;
    }*/
}
