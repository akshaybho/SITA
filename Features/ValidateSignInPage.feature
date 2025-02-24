Feature: Validate Sign In and Register Button

  @regression
  Scenario: Verify sign in button is visible and functional
    Given I click on DIGIHUB on homepage
    Then I can able to see SignIn button
    When I click on SignIn button
    Then I landed onto SignIn page

    @sanity @regression
  Scenario: Verify Register button is visible and functional
    Given I click on DIGIHUB on homepage
    Then I should see the Register button
    When I click on the Register button
    Then I should be redirected to the registration form



