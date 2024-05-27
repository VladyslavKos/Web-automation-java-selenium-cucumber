Feature: User details; add,modify remove

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

  @TC004 @log_in_test
  Scenario: As user, I want to log in, check my username, go to user details and change password, logout, login with new password, check username.
    Given TC004 user log in with valid credentials
    When TC004 user check username
    And TC004 user go to user details
    And TC004 user changes password
    And TC004 user logout
    Then TC004 user log in with new password
    And TC004 user check username again
