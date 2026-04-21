@login
Feature: Login functionality

  Background:
  Given user is on login page

  @smoke @regression
  Scenario Outline: Login success
    When user enters username "<username>" and password "<password>"
    And user clicks submit button
    Then user should see "<result>"

    Examples:
      | username      | password          | result                  |
      | student       | Password123       | success                 |


  @regression
  Scenario Outline: Login invalid attempts
    When user enters username "<username>" and password "<password>"
    And user clicks submit button
    Then user should see "<result>"

    Examples:
      | username      | password          | result                  |
      | incorrectUser | Password123       | invalid username        |
      | student       | incorrectPassword | invalid password        |