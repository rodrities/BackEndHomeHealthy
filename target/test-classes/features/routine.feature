Feature: routine feature

  Scenario: A user gets the routine
    Given the following routine
      | name                 | description   |
      | Muscular Routine     | Example       |
      | Fitness Routine      | Example2      |
    When the user request all the routines
    Then all the routines are returned

  Scenario: A trainer post a new routine
    When a trainer posts a new routine HomeRoutine with description Example
    Then it is in the database
    And it has an id