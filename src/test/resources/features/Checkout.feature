@checkout
Feature: Checkout Dashboard

  Background:
    Given user is logged in the shopping area

  Scenario Outline: Order Checkout
    When user clicks on item with name "<Item>"
    And user clicks on the add to cart button
    And user clicks on the shopping cart button
    And user clicks on the checkout button
    And user enters the order information as "<FirstName>","<LastName>","<ZipCode>"
    And user clicks on the continue button
    Then user sees the item name matches that of the "<Item>"

    Examples:
      | Item                     | FirstName  | LastName | ZipCode |
      | Sauce Labs Backpack      | Michael    | Smith    | 07058   |
      | Sauce Labs Bike Light    | Adam       | More     | 10213   |
      | Sauce Labs Fleece Jacket | Alex       | Lore     | 10213   |