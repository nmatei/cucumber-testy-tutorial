Feature: First automated test using Testy and Cucumber
  
  Scenario: Simple clicks
    Given I open url "file:///C:/Cloud/Dropbox/Public/FastTrackIT/simple-webapp/index.html"
    When I click on About menu item
    Then breadcrumb text should be changed to "asta sunt eu"