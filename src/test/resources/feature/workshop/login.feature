Feature: Login

  Scenario: Login Successfully

    Given I access the login page
    And I insert valid credentials
    When I click on the login button
    Then I check if the user is logged in

  Scenario: Login with the wrong credentials
    Given I access the login page
    And I insert invalid credentials
    When I click on the login button
    Then I check if the invalid credentials error message is displayed






