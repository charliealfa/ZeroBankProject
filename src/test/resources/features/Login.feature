@Login-123
Feature: Login Feature

  Scenario: Login with valid credantials
    Given the user on the login page
    When user type "username" "password"
    Then user should be logged in
    And verify Account Summary page opened


  Scenario: Login with wrong username
    Given the user on the login page
    When user type wrong "wrusername" valid "password"
    Then user should not be logged in


  Scenario: Login with wrong password
    Given the user on the login page
    When user type valid "username" wrong "wrpassword"
    Then user should not be logged in


  Scenario: Login with blank input
    Given the user on the login page
    When user click login without inputs
    Then user should not be logged in


  Scenario: Login wrong username error message
    Given the user on the login page
    When user type wrong "wrusername" valid "password"
    Then user should not be logged in
    And error message displayed


  Scenario: Login wrong password error message
    Given the user on the login page
    When user type valid "username" wrong "wrpassword"
    Then user should not be logged in
    And error message displayed