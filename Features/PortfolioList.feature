Feature: Validate portfolio list

  @regression
  Scenario: User verifies the portfolio expected list with actual list
    Given User landed on home page
    And User can able to see "Portfolio spotlight" on home page
    Then User verifies the Portfolio spotlight list matches the expected list