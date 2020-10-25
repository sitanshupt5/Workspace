Feature: Free CRM Login Tests

  Scenario: Login Happy Path Test
    Given login page is open
    When username and password are entered and login is clicked
    Then HomePage is Opened