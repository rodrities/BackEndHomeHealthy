Feature: session feature

  Scenario: A user gets the session
    Given the following session
      | name                 | description   |
      | Diet Session         | Example       |
      | Routine Session      | Example2      |
    When the user request all the sessions
    Then all the sessions are returned

  Scenario: A user post a new session
    When a user posts a new session FirstSession with description Example
    Then it is in the database
    And it has an id