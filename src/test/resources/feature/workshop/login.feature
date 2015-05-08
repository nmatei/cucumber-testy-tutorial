@screen
Feature: As a user I can login into app

#  Scenario: I successfully login with valid user and pass
#    Given I open login page
#    When I enter email "eu@fast.com"

  Scenario: As a user I can login
    Given I open app
    When login into the app
    Then I'm logged in

  Scenario: Not being an user of app I can't login
    Given I open app
    When I insert invalid credentials
    Then I won't be logged in
