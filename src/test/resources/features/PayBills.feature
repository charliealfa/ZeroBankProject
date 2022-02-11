@pbpage
Feature: Verify Pay Bills feature

  Background:
    Given the user on the login page
    Then user type "username" "password"
    And user should be logged in
    Then navigate to "Pay Bills" page

  Scenario: verify pay bills page title
    And verify page title "Zero - Pay Bills"


  Scenario: verify pay bills page title
    And pay with the infos
    Then verify alert message "The payment was successfully submitted."


  Scenario: verify popup message without amount
    And pay without amount
    Then verify popup message for amount"Lütfen bu alanı doldurun."


  Scenario: verify popup message without date
    And pay without date
    Then verify popup message for date "Lütfen bu alanı doldurun."


  Scenario: verfy alphabetical inputs not accept for amount
    And pay with alphabetic chars at amount
    Then verify payment not accept


  Scenario: verfy alphabetical inputs not accept for date
    And pay with alphabetic chars at date