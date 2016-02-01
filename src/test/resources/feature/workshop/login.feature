@screen
Feature: Login

  Scenario: Successful Login
    Given I access login page
    And I insert "eu@fast.com"/"eu.pass" credentials
    When I click login button
    Then I check if user was logged in

  Scenario Outline: Failed login
    Given I access login page
    When I enter "<email>"/"<pass>" credentials
    And I click login button
    Then I expect "<message>" error message
    Examples:
      | email            | pass         | message                     |
      |                  | eu.pass      | Please enter your email!    |
      | eu@fast.com      |              | Please enter your password! |
      |                  |              | Please enter your email!    |
      | invalid@fast.com | invalid.pass | Invalid user or password!   |