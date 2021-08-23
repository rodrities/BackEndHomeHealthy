package com.acme.cucumber;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.model.Session;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.repository.RutineRepository;
import com.acme.homehealthy.Meeting.domain.repository.SessionRepository;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SessionStepDefs {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Session> expectedSessions;

    private List<Session> actualSessions;

    @Before
    public void setup()
    {

    }

    @Given("^the following session")
    public void givenTheFollowingRoutines(final List<Session> sessions)
    {

    }

    @When("^the user request all the sessions")
    public void whenTheUserRequestAllTheSessions() throws JsonProcessingException
    {

    }

    @Then("^all the sessions are returned$")
    public void thenAllTheSessionsAreReturned()
    {
        validateSessions();
    }

    @When("^a user posts a new session (.*) with description (.*)$")
    public void whenANutritionistPostsANewRoutine(final String name, final String description)
    {
    }

    @Then("^it is in the database$")
    public void thenItIsInTheDatabase()
    {

    }

    @And("^it has an id$")
    public void andItHasAnId()
    {

    }


    private void validateSessions()
    {

    }

    private void validateSession(final Session expected, final Session actual)
    {

    }
}