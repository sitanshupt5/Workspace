Feature: Facebook Login Feature

  Scenario: Facebook Login Happy Path
    Given user is on the facebook landing page
    When user enters "sitanshupt5@gmail.com" and password
    And user clicks on login button
    Then user should be redirected to the HomePage
