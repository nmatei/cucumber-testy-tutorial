@screen
Feature: First automated test using Testy and Cucumber
  
  Scenario: Simple clicks
    Given I open url "file:///C:/Cloud/Dropbox/Public/FastTrackIT/simple-webapp/index.html"
    When I click on About menu item
    Then breadcrumb text should be changed to "asta sunt eu"

  Scenario: click on sub menu
    Given I open url "https://fuel-3d.com/"
    When I mouse over on element with text "Product"
    And I click on link with text "Compare"
    Then I should see an element with text "Sweeping laser line:"
    And I should be on url "https://fuel-3d.com/compare/"
    
