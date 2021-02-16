Feature: As a user, I should be able to login
  @wip @librarianParameter
  Scenario: Login as a librarian 62
    Given I am on the login page
    When I enter username "librarian62@library"
    And I enter password "DdZ8SHvz"
    And I click to the sign in button
    Then dashboard should be displayed
    And there should be "2841" users

  @wip @librarianParameter
  Scenario: Login as a librarian 62 in same line
    Given I am on the login page
    When I enter username "librarian62@library" and "DdZ8SHvz"
    Then dashboard should be displayed
    And there should be "2841" users

  @wip @studentParameter
  Scenario: Login as a student 66
    Given I am on the login page
    When I enter username "student66@library"
    And I enter password "Ys9e3SFW"
    And I click to the sign in button
    Then  books page should be displayed
