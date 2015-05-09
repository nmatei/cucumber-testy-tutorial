@screen
Feature:As a user I change my password

  Scenario: I successfully change my pass
    Given I open app
    And login into the app
    When I change my password
    Then my password is successfully changed
