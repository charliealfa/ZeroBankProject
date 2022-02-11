@aspage
Feature: Account Summary Page

  Scenario: Title Verify
    Given the user on the login page
    And user type "username" "password"
    Then user should be logged in
    And verify page title "Zero - Account Summary"


  Scenario: Verify Account Types
    Given the user on the login page
    And user type "username" "password"
    Then user should be logged in
    And verify account types
    |Cash Accounts|
    |Investment Accounts|
    |Credit Accounts|
    |Loan Accounts|


  Scenario: Verify Table Columns
    Given the user on the login page
    And user type "username" "password"
    Then user should be logged in
    And verify table columns
      |Account|
      |Credit Card|
      |Balance|



