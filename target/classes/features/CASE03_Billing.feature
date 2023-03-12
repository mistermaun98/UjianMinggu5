Feature: Product Checkout and Billing test
  @NeedFormReset
  Scenario: An United Kingdom user placing order
    When User filled the form with correct UK credentials
    And User clicked Terms and Conditions agreements
    And User clicked Place Order button
    Then User receieve an Order Receieved message