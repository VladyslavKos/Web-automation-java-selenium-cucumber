Feature: Search for products, add/remove from cart, go through buying flow
  @TC003
  Scenario: Search for product, add to cart, remove from cart, add to cart, finish flow
    Given TC003 logged in user on main page
    When TC003 user click logo and click product 2
    And TC003 user provide number of products
    And TC003 user click add to cart button
    And TC003 user click on proceed to checkout
    And TC003 user click on PROCEED TO CHECKOUT
    And TC003 user chose shipment address
    And TC003 user chose self pick up option
    And TC003 user chose Pay by Bank option
    And TC003 user finalize order
    Then TC003 user check success message
    And TC003 user take screenshot of confirmed order
