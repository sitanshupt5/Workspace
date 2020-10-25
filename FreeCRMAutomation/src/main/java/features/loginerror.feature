Feature: Free CRM Website Login Error Validation

  Scenario: Free CRM Login Invalid Credentials
    Given login page is open
    When invalid username and password are entered
      |username             | password |
      |sitanshupt5@gmail.com| akjhabklk|
      |sjhhdvbhbk           | asjdvnjnl|

    And login button is clicked
    Then login error message is displayed