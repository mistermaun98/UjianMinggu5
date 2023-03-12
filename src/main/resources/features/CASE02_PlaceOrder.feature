Feature: Add product to cart
  Scenario: Add single product with complete option to cart
    Given User in Shop page
    When User click picture of any items
    And User choose color
    And User choose size
    And User click Add To Cart button
    Then User get confirmation message