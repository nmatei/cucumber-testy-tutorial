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

  Scenario: Login with no password
    Given I access the login page
    When I enter "eu@fast.com"/"" credentials
    And I click on the login button
    Then I check if the invalid credentials error message is displayed

    #Then I expect "Please enter your password!" message

  Scenario Outline: Failed login
    Given I access the login page
    When I enter "<email>"/"<pass>" credentials
    And I click on the login button
    Then I expect "<message>" error message
    Examples:
      | email | pass | message |
      | eu@fast.com | eu.pass |  |
      | email | pass | message |
      | email | pass | message |
      | email | pass | message |








