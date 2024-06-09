Feature: User details, addresses; add,modify remove

  @TC002 @user_details
  Scenario: As user, I want to log in to store, and change personal data
    Given TC002 user log in with valid credentials
    When TC002 user go to information page
    And TC002 user make changes in accordance with following data:
      | First name | Last name |
      | Jan        | Pawel     |
    Then TC002 user get success message
    And TC002 user desktop info has been changed in accordance with following data:
      | First name | Last name |
      | Jan        | Pawel     |

  @TC004 @log_in_test @change_password
  Scenario: As user, I want to log in, check my username, go to user details and change password, logout, login with new password, check username.
    Given TC004 user log in with valid credentials
    When TC004 user check username
    And TC004 user go to user details
    And TC004 user changes password
    And TC004 user logout
    Then TC004 user log in with new password
    And TC004 user check username again

  @TC005 @user_details
  Scenario: User logs in, adds a new address, and verifies the address details
    Given TC005 user logs in with valid credentials
    And TC005 user clicks on the "Addresses" button
    And TC005 user clicks on the  Create new address button
    And TC005 user fills in the New Address form with the following details:
      | Alias      | Address         | City   | Zip/Postal Code | Phone      |
      | My Address | 123 Main Street | MyCity | 12345           | 1234567890 |

    And TC005 user submits the form
    Then TC005 user should see a success message
    And TC005 user verifies that the added address details are correct:
      | Alias      | Address         | City   | Zip/Postal Code | Phone      |
      | My Address | 123 Main Street | MyCity | 12345           | 1234567890 |

  @TC006 @create_account
  Scenario: User create account, log in and check if user data is correct
    When TC006 user create account using data
    And TC006 user log in
    Then TC006 user check if user data is correct