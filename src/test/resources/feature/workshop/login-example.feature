@screen
Feature: As a valid user a can login into application

  Scenario: I successfully login with valid user and pass
    Given I open login page
    When I enter email "eu@fast.com"
