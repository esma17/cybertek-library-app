Feature: As a user, I should be able to login
@librarian @wip
  Scenario: Login as a librarian
    Given I am on the login page
    When I login as a librarian
    Then dashboard should be displayed
@student @wip
Scenario: Login as a student
  Given I am on the login page
  When I login as a student
  Then  books page should be displayed