@screen
Feature: Customer I can login to web site

  Scenario: Fail login detailed
    Given I open url "http://www.fasttrackit.org/OnlineLibrary/"
    When I click on link with text "Log In"
    And I type "no@login.eu" into text field with label "Username or email address"
    And I click on fake Password field
    And I type "badpass" into text field with label "Password"
    And I click on input button with text "Login"
    Then I should see web element with text "A user could not be found with this email address."
    
  Scenario: Fail login
    Given I open url "http://www.fasttrackit.org/OnlineLibrary/"
    When I click on Login button from top navigation menu
    And I login using "no@login.eu"/"badpass"
    Then login should fail


  Scenario: Successfully login detailed
    Given I open url "http://www.fasttrackit.org/OnlineLibrary/"
    When I click on link with text "Log In"
    And I type "admin" into text field with label "Username or email address"
    And I click on fake Password field
    And I type "library" into text field with label "Password"
    And I click on input button with text "Login"
    Then I should see web element with text "Log Out"
    And I should see following web elements with texts "Recent Orders, My Addresses, Billing Address, Shipping Address"
    And I click on link with text "Log Out"
    
  Scenario: Successfully login
    Given I open url "http://www.fasttrackit.org/OnlineLibrary/shortcodes/my-account/"
    When I login using "admin"/"library"
    Then I click on link with text "Log Out"
    
  Scenario: User has correct Billing Address
    Given I open url "http://www.fasttrackit.org/OnlineLibrary/shortcodes/my-account/"
    When I login using "admin"/"library"
    And I click on link with text "Edit"
    And text field with label "Email Address" should have value "em_mihai@yahoo.com"
    And I click on link with text "Log Out"