Feature: Search bar feature


  Scenario: Verify that the user should be able to click on the Amazon search box or not
    Given  the user navigates to the home page
    When the user click on search box
    Then  search box should be clickable
  Scenario: Verify that the user can able to search a product
    Given  the user navigates to the home page
    When the user enter the product name
    Then the product results should be displayed


  Scenario: Verify that the user is able to select an option from the suggested product or not
    Given the user navigates to the home page
    When the user click on search bar then suggested product list show
    Then the user should be able to select product from suggested list


  Scenario: Verify that when the user selects an option from the suggested product list the search result should be displayed on a search page
    Given the user navigates to the home page
    And the user click on search bar then suggested product list show
    When the user select an option from the suggested list
    Then product should be displayed on search page

  Scenario Outline: Verify that the user can able to search a product
      Given  the user navigates to the home page
      When the user enter the product "<name>"
      Then the product "<name>" should be displayed
      Examples:
        |  name   |
        | Shoes   |
        | Jackets |
        | Jeans  |


  Scenario: Verify that the Ajio search box height is as per specification
    Given the user navigates to the home page
    Then search box height should be as per specification

  Scenario: Verify that the Ajio search box width is as per specification
    Given the user navigates to the home page
    Then search box width should be as per specification

  Scenario: Verify that placeholder is properly displayed or not
    Given the user navigates to the home page
    Then placeholder should be properly display

  Scenario: Verify that the categories dropdown is properly attached to the search box or not
    Given the user navigates to the home page
    When chick on search bar
    Then the categories dropdown should be properly attached to the search box


