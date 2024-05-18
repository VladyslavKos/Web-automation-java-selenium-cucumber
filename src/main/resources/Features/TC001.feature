Feature: User can log in to the web store and check for products
@TC001
#  As a user, I want to log in to the web store, navigate to the clothes page, and check if there are any products listed.
Scenario: User logs in and checks for products in clothes men/women pages
  Given User on store home web page
  When User log in with walid credentials

