
Feature: Checkout functionality

  Background: 
    Given User is logged in
    Given "Products" page is open

 
  Scenario: Verify that user is able to purchase item
    When I add "Sauce Labs Backpack" to the cart
    Then I see that the shopping cart badge should show 1 item
    When I click on "shoppingCart" button
    Then I verify that "Sauce Labs Backpack" product is displayed
    When I click on "checkout" button
    When I fill in firstName field with "test" value
    When I fill in lastName field with "test" value
    When I fill in postalCode field with "test" value
    When I click on "continue" button
    Then I verify that "Sauce Labs Backpack" product is displayed
    When I click on "finish" button
    Then I should see the succsessfuly message "Thank you for your order!"
