Feature: Navigation using action buttons
@TC001 @Basic_layout_test
Scenario: As a user, I want to log in to the web store,and navigate to the Clothes,Accessories and Art pages.
  When TC001 User log in with walid credentials
  And TC001 User go to Clothes page
  And TC001 User go to Accessories page
  And TC001 User go to Art page
  And TC001 User click on store logo
