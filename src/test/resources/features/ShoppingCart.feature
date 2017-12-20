Feature: Shopping cart functionality

  Scenario: Add Product to the Shopping Cart
    Given empty Shopping Cart
    And a Product, "Dove Soap" with unit Price "39.99"
    When The user adds 5 "Dove Soap" to the shopping cart
    Then The shopping cart should contain 5 "Dove Soap" each with a unit price of "39.99"
    And the shopping cart’s total price should equal "199.95"



