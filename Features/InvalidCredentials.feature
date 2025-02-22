Feature: Login with Invalid Credentials

  Background:
    Given I click on DIGIHUB on homepage
    Then I can able to see SignIn button
    When I click on SignIn button
    Then I landed onto SignIn page

  Scenario Outline: User tries to login with invalid credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And clicks on the login button
    Then user should see an error message

    Examples:
    |username | password |
    |akshay@sita.com   | abc@13   |
    |saloni@sita.com   | def@456  |
