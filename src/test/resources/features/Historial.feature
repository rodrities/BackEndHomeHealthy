Feature: historial feature

  Scenario: The user wants to see the history and he can to do it
    Given the user are inside the platform and enter to the menu
    When he enter the platform
    And select "View History"
    Then he can view his transaction history

  Scenario: The user wants to see the history and cannot do so because they are not logged in
    Given the user are inside the platform and enter to the menu
    When he enter the platform
    And select "View History"
    Then he will not be able to see his history and you will get the message "First you must log in"


