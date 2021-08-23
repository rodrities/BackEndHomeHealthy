Feature: diet feature

  Scenario Outline: A user gets the diet
    Given the following diet
    When the user request all the diets
    Then all the diets are returned
    Examples:
      | name            | description |
      | Vegetarian Diet | Example     |
      | Vegan Diet      | Example2    |

  Scenario: A nutritionist post a new diet
    When a nutritionist posts a new diet MuscularDiet with description Example
    Then it is in the database
    And it has an id


