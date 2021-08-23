package com.acme.cucumber;

import com.acme.homehealthy.Meeting.domain.model.Diet;
import com.acme.homehealthy.Meeting.domain.repository.DietRepository;
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

public class DietStepDefs {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Diet> expectedDiets;

    private List<Diet> actualDiets;

    @Before
    public void setup()
    {
        expectedDiets = new ArrayList<>();
        actualDiets = new ArrayList<>();
        dietRepository.deleteAll();
    }

    @Given("^the following diet$")
    public void givenTheFollowingDiets(final List<Diet> diets)
    {
        expectedDiets.addAll(diets);
        dietRepository.saveAll(diets);
    }

    @When("^the user request all the diets$")
    public void whenTheUserRequestAllTheDiets() throws IOException {
        actualDiets.addAll(Arrays.asList(
                objectMapper.readValue(
                        testRestTemplate.getForEntity("/api/diets/all", String.class).getBody(), Diet[].class)));
    }

    @Then("^all the diets are returned$")
    public void thenAllTheDietsAreReturned()
    {
        validateDiets();
    }

    @When("^a nutritionist posts a new diet (.*) with description (.*)$")
    public void whenANutritionistPostsANewDiet(final String name, final String description)
    {
        final Diet expected = new Diet();
        expected.setName(name);
       // expected.setDescription(description);
        expectedDiets.add(expected);
        testRestTemplate.postForEntity("/api/diets/new", expected, Diet.class);
    }

    @Then("^it is in the database$")
    public void thenItIsInTheDatabase()
    {
        actualDiets.addAll(dietRepository.findAll());
        validateDiets();
    }

    @And("^it has an id$")
    public void andItHasAnId()
    {
        Assertions.assertNotNull(actualDiets.get(0).getId());
    }


    private void validateDiets()
    {
        Assertions.assertEquals(expectedDiets.size(), actualDiets.size());
        IntStream.range(0, actualDiets.size())
                .forEach(index -> validateDiet(expectedDiets.get(index), actualDiets.get(index)));
    }

    private void validateDiet(final Diet expected, final Diet actual)
    {
        Assertions.assertEquals(expected.getName(), actual.getName());
        //Assertions.assertEquals(expected.getDescription(), actual.getDescription());
    }
}
