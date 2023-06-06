

Feature: Add to cart functionality

  Background: 
    Given User is logged in

  Scenario: Verify that the user can add one product to the cart
    Given "Products" page is open
    When I add "Sauce Labs Backpack" to the cart
    Then I see that the shopping cart badge should show 1 item
    When I click on "shoppingCart" button
   Then I verify that "Sauce Labs Backpack" product is displayed

   Scenario: Verify that the user can remove product from Shopping cart
    Given "Products" page is open
    When I add "Sauce Labs Backpack" to the Shopping cart
    When I add "Sauce Labs Bike Light" to the Shopping cart
    When I add "Sauce Labs Onesie" to the Shopping cart
    When I click on "shoppingCart" button
    When I remove "Sauce Labs Backpack" product from the Shopping cart
    Then I verify that "Sauce Labs Backpack" product is not displayed

@test
Scenario: Verify that user can add one product to cart with index
    Given "Products" page is open
    When I add product with index 2 in the cart
    Then I see that the shopping cart badge should show 1 item
    When I click on "shoppingCart" button
    Then I verify that the correct product should be in the cart