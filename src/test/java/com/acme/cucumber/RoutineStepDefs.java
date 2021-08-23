package com.acme.cucumber;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.model.Rutine;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
import com.acme.homehealthy.Meeting.domain.repository.RutineRepository;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RoutineStepDefs {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private RutineRepository rutineRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Rutine> expectedRoutines;

    private List<Rutine> actualRoutines;

    @Before
    public void setup()
    {
        expectedRoutines = new ArrayList<>();
        actualRoutines = new ArrayList<>();
        rutineRepository.deleteAll();
    }

    @Given("^the following routine")
    public void givenTheFollowingRoutines(final List<Rutine> rutines)
    {
        expectedRoutines.addAll(rutines);
        rutineRepository.saveAll(rutines);
    }

    @When("^the user request all the routines")
    public void whenTheUserRequestAllTheRoutines() throws IOException {
        actualRoutines.addAll(Arrays.asList(
                objectMapper.readValue(
                        testRestTemplate.getForEntity("/api/routines/all", String.class).getBody(), Rutine[].class)));
    }

    @Then("^all the routines are returned$")
    public void thenAllTheRoutinesAreReturned()
    {
        validateRoutines();
    }

    @When("^a trainer posts a new routine (.*) with description (.*)$")
    public void whenANutritionistPostsANewRoutine(final String name, final String description)
    {
        final Rutine expected = new Rutine();
        expected.setName(name);
        //expected.setDescription(description);
        expectedRoutines.add(expected);
        testRestTemplate.postForEntity("/api/routines/new", expected, Rutine.class);
    }

    @Then("^it is in the database$")
    public void thenItIsInTheDatabase()
    {
        actualRoutines.addAll(rutineRepository.findAll());
        validateRoutines();
    }

    @And("^it has an id$")
    public void andItHasAnId()
    {
        Assertions.assertNotNull(actualRoutines.get(0).getId());
    }


    private void validateRoutines()
    {
        Assertions.assertEquals(expectedRoutines.size(), actualRoutines.size());
        IntStream.range(0, actualRoutines.size())
                .forEach(index -> validateRoutine(expectedRoutines.get(index), actualRoutines.get(index)));
    }

    private void validateRoutine(final Rutine expected, final Rutine actual)
    {
        Assertions.assertEquals(expected.getName(), actual.getName());
        //Assertions.assertEquals(expected.getDescription(), actual.getDescription());
    }
}

