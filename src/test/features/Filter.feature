
Feature: As a user I want to be able to filter products

  Background: 
    Given User is logged in

  Scenario Outline: Filter items by <filterType>
    Given "Products" page is open
    When I filter items by "<filterType>"
    Then I veify that items are filtered by "<filterType>"

    Examples: 
      | filterType          |
      | Name (A to Z)       |
      | Name (Z to A)       |
      | Price (low to high) |
      | Price (high to low) |
