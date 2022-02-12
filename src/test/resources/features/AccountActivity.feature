@aapage @smoke
Feature: Account Activity Page
Background:
  Given the user on the login page
  When user type "username" "password"
  Then verify page title "Zero - Account Summary"
  And navigate to "Account Activity" page


  Scenario: Verify title
    Then verify page title "Zero - Account Activity"


  Scenario: Verify drop down default
    Then verify drop down default "Savings"


  Scenario: Verify drop down options
    Then verify drop down options
    |Savings|
    |Checking|
    |Loan|
    |Credit Card|
    |Brokerage|


  Scenario: Verify transactions table columns
    Then verify transactions table columns
      |Date|
      |Description|
      |Deposit|
      |Withdrawal|