@shoestore
Feature Searching brand shoe from shoe store
  Background:
    Given I am on home page of shoe store
  @brandshoesearch
  Scenario: Verify brand search for the shoe
    When I click Chose a brand dropdown button
    And I select Jimmy Choo from the list
    And I click on Search button
    Then I verify Jimmy Choo's Shoes are displayed
    And I click Remind me on new shoes Email Address Input Box
    And I enter slpm146@gmail.com as email address
    And I click Submit button
    Then I verify Thanks! email notification message is displayed
