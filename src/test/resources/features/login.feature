@feature @login
Feature: Login feature

  Background:
    Given I am on home page

  @feature-1
  Scenario: Verify Invalid Login
    When I enter mamun@gmail.com into username text fields on home screen
    And I enter test1234 into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am an invalid login page

  @feature-2
  Scenario: Verify Invalid Login two
    When I enter khan@gmail.com into username text fields on home screen
    And I enter abc1234 into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am an invalid login page
    And I see number 12 in text field

  @feature-3
  Scenario Outline: Verify Invalid Login for multiple users
    When I enter <username> into username text fields on home screen
    And I enter <password> into password text fields on home screen
    And I click on login button on home screen
    Then I verify that i am an invalid login page

    Examples:
      | username        | password |
      | mamun@gmail.com | test1234 |
      | khan@gmail.com  | abc123   |