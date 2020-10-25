$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/WorkSpace/FreeCRMAutomation/src/main/java/features/loginerror.feature");
formatter.feature({
  "line": 1,
  "name": "Free CRM Website Login Error Validation",
  "description": "",
  "id": "free-crm-website-login-error-validation",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Free CRM Login Invalid Credentials",
  "description": "",
  "id": "free-crm-website-login-error-validation;free-crm-login-invalid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "login page is open",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "invalid username and password are entered",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 6
    },
    {
      "cells": [
        "sitanshupt5@gmail.com",
        "akjhabklk"
      ],
      "line": 7
    },
    {
      "cells": [
        "sjhhdvbhbk",
        "asjdvnjnl"
      ],
      "line": 8
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "login button is clicked",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "login error message is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginErrorStepDefinitions.login_page_is_open()"
});
formatter.result({
  "duration": 25290563760,
  "status": "passed"
});
formatter.match({
  "location": "LoginErrorStepDefinitions.invalid_username_and_password_are_entered(DataTable)"
});
formatter.result({
  "duration": 1206542231,
  "status": "passed"
});
formatter.match({
  "location": "LoginErrorStepDefinitions.login_button_is_clicked()"
});
formatter.result({
  "duration": 358812481,
  "status": "passed"
});
formatter.match({
  "location": "LoginErrorStepDefinitions.login_error_message_is_displayed()"
});
formatter.result({
  "duration": 2098519907,
  "status": "passed"
});
});