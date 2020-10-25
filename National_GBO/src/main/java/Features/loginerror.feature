Feature: Facebook Login Feature

  Scenario Outline: Facebook Login Happy Path
    Given user is on the facebook landing page
    When user enters "<username>" and "<password>"
    And user clicks on login button
    Then user should be redirected to the HomePage

    Examples:
    |username|password|
    |sitanshupt5.com| abcd123|
    |adbkhb@jdk.com| sjdcn12|