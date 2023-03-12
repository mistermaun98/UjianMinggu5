Feature: Test Login Shop DemoQA

  Scenario: User login with invalid username
    Given User open browser and access MyAccount page
    And User enter invalid username and valid password
    And User click login button
    Then Error message shown to user

  Scenario: User login with invalid password
    When User enter valid username and invalid password
    And User click login button
    Then Error message shown to user

  Scenario: User login with valid credentials
    Given User open browser and access MyAccount page
    When User enter valid username and password
    And User click login button
    Then User redirected to MyAccount dashboard page













