Feature: Data Tables
  @showRecords @librarian @wip
  Scenario: Verify the default values in users page
    When I click on Users link
    Then show records default value should be 10
    And show records should have following options:
      |5  |
      |10 |
      |15 |
      |50 |
      |100|
      |200|
      |500|