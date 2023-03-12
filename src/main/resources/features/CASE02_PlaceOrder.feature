Feature: Place Order Test
  Scenario: Add single product with complete option to cart
    Given User in Shop page
    When User click picture of any items
    And User choose color
    And User choose size
    And User click Add To Cart button
    Then User get confirmation message

  Scenario: Checkout product through cart icon in main page
    Given User in main page
    When User click Cart button
    And User click Proceed To Checkout button
    Then User redirected to Checkout page
