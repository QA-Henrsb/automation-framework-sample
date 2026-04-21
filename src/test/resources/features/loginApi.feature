@api
Feature: Login API

  Scenario Outline: Login API scenarios
    Given user sets API endpoint "/auth/login"
    When user sends POST request with username "<username>" and password "<password>"
    Then response status should be <status>

    Examples:
      | username | password    | status |
      | emilys   | emilyspass  | 200    |
      | wrongUser| wrongPass   | 400    |