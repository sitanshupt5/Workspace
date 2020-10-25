Feature: Free CRM Website Login

  Scenario: Free CRM Login Happy Path
    Given login page is open
    When username and password are entered
    And login button is clicked
    Then home page is opened

  Scenario: Free CRM Login Invalid Credentials
    Given login page is open
    When invalid username and password are entered
    |sitanshupt5@gmail.com| akjhabklk|

    And login button is clicked
    Then login error message is displayed