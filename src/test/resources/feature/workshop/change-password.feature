@screan

Feature: As logged in user I can change my password

  Scenario: Change password successfully
    Given I successfully login
    When I click on Preferences button
    And I input current password
    And I input new password
    And I confirm the new password
    And I click on Save button
    Then I should see "Your password has been successfully changed." message
    And I close Preferences window
    And I expect to re-loging with new credentials