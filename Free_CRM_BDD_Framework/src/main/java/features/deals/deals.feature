Feature: Deals Page Testing

  //Scenario: Navigate to deals page
  //  Given homepage is open
  //  When deals option is clicked
  //  Then Deals page is opened
  //  And deals header is displayed


  Scenario: Navigate back to homepage from deals page
    Given deals page is open
    When home option is clicked
    Then homepage is opened
    And username is displayed

  Scenario: logout from deals page
    Given deals page is open
    When logout button is clicked
    Then login page is displayed

