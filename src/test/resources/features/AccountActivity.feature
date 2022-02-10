Feature: Account Activity Page
  @test
  Scenario: Verify title
    Given the user on the login page
    When user type "username" "password"
    Then verify page title "Zero - Account Summary"
    And navigate to "Account Activity" page
    Then verify page title "Zero - Account Activity"