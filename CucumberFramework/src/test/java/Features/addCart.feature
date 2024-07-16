Feature: Search and Add to the Cart
  I want to use this template for my feature file

  @addtotheCart
  Scenario Outline: Search the product, Add multiple quatities and proceed with Checkout
    Given User is on Greenkart landing page
    When User search with shortname <Name> and extract the actual name of the product
    Then User add quantities <Quantity> of the searched product
    And Add the product into the cart
    Then User Proceeds to the checkout page
    And Verify the product details <Name> and other information on checkout page

    Examples: 
      | Name   | Quantity |
      | Tomato |        4 |
