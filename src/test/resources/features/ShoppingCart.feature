Feature: Shopping cart functionality

  Scenario: Add Product to the Shopping Cart
    Given empty Shopping Cart
    And a Product, "Dove Soap" with unit Price "39.99"
    When The user adds 5 "Dove Soap" to the shopping cart
    Then The shopping cart should contain 5 "Dove Soap" each with a unit price of "39.99"
    And the shopping cart’s total price should equal "199.95"


  Scenario: Add additional products of the same type to the shopping cart
    Given empty Shopping Cart
    And a Product, "Dove Soap" with unit Price "39.99"
    When The user adds 5 "Dove Soap" to the shopping cart
    And The user adds 3 "Dove Soap" to the shopping cart
    Then The shopping cart should contain 8 "Dove Soap" each with a unit price of "39.99"
    And the shopping cart’s total price should equal "319.92"


  Scenario: Calculate the tax rate of the shopping cart with multiple items
    Given empty Shopping Cart
    And a Product, "Dove Soap" with unit Price "39.99"
    And a Product, "Axe Deo" with unit Price "99.99"
    And a Tax Rate of "12.5"%
    When The user adds 2 "Dove Soap" to the shopping cart
    And The user adds 2 "Axe Deo" to the shopping cart
    Then The shopping cart should contain 2 "Dove Soap" each with a unit price of "39.99"
    And The shopping cart should contain 2 "Axe Deo" each with a unit price of "99.99"
    And The total Tax amount should equal to "35.00"
    And the shopping cart’s total price should equal "314.96"




