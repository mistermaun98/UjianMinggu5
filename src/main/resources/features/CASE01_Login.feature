Feature: Test Login Shop DemoQA
Scenario: User login with valid credentials
  Given User open browser and access MyAccount page
  When User enter valid username and password
  And User click login button
  Then User redirected to MyAccount dashboard page