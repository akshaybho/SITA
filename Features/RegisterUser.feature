Feature: User register for an account

  Background:
    Given I click on DIGIHUB on homepage
    Then I should see the Register button
    When I click on the Register button
    Then I should be redirected to the registration form

  @regression
    Scenario: User tries to register on SITA
      Given the user is on register page
      When the user fills the details
      And user clicks on the proceed button
      Then user should able to see message of registration
