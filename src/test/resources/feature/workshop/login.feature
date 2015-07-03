Feature: Login

  Scenario: Login successfully
    Given I access the login page
    And I insert valid credentials
    When I click login button
    Then I check if user was logged in

  Scenario: Login with wrong credentials
    Given I access the login page
    And I insert invalid credentials
    When I click login button
    Then I Expect invalid credential message

