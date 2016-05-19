@screen
Feature: Customer I can login to web site

  Scenario: Successfully login
    Given I open url "file:///C:/Producs/Testy/src/test/functional/app-demo/login.html"
    When I login with "eu@fast.com"/"eu.passx"
    Then I click on link with text "Logout"