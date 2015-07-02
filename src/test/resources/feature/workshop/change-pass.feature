@screen
Feature:As a user I change my password

  Scenario: I successfully change my pass
    Given I open app
    And login into the app
    When I change my password
    Then my password is successfully changed
    And I login with "eu@fast.com"/"eu.new"
    And I'm logged in


  Scenario Outline: Nevative login steps
    Given I open app
    When I login with "<email>"/"<pass>"
    Then I get the error "<error>"
    Examples:
      | email        | pass  | error                       |
      | tuttu@xx.com | tutu  | Invalid user or password!   |
      | tuttu@xx.com |       | Please enter your password! |
      |              | tutut | Please enter your email!    |
      |              |       | Please enter your email!    |

