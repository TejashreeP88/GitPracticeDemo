Feature: Search and Place the order
  I want to use this template for my feature file
@offersPage
  Scenario Outline: Search Experience for the product search in both home and pffers page
    Given User is on Greenkart landing page
    When User search with shortname <Name> and extract the actual name of the product
    Then User go and search for the shortname <Name> in offers page 
    And Validate if product name in offer page matches with landing page
    
    Examples:
    |Name|
    |Tom|
    |Beet|
