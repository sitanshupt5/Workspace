$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("D:/WorkSpace/National_GBO/src/main/java/Features/loginerror.feature");
formatter.feature({
  "line": 1,
  "name": "Facebook Login Feature",
  "description": "",
  "id": "facebook-login-feature",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Facebook Login Happy Path",
  "description": "",
  "id": "facebook-login-feature;facebook-login-happy-path",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user is on the facebook landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user should be redirected to the HomePage",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "facebook-login-feature;facebook-login-happy-path;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 10,
      "id": "facebook-login-feature;facebook-login-happy-path;;1"
    },
    {
      "cells": [
        "sitanshupt5.com",
        "abcd123"
      ],
      "line": 11,
      "id": "facebook-login-feature;facebook-login-happy-path;;2"
    },
    {
      "cells": [
        "adbkhb@jdk.com",
        "sjdcn12"
      ],
      "line": 12,
      "id": "facebook-login-feature;facebook-login-happy-path;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Facebook Login Happy Path",
  "description": "",
  "id": "facebook-login-feature;facebook-login-happy-path;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user is on the facebook landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters \"sitanshupt5.com\" and \"abcd123\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user should be redirected to the HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginErrorStepDefinition.user_is_on_the_facebook_landing_page()"
});
formatter.result({
  "duration": 19562833249,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sitanshupt5.com",
      "offset": 13
    },
    {
      "val": "abcd123",
      "offset": 35
    }
  ],
  "location": "LoginErrorStepDefinition.user_enters_email_id_and_password(String,String)"
});
formatter.result({
  "duration": 800816420,
  "status": "passed"
});
formatter.match({
  "location": "LoginErrorStepDefinition.user_clicks_on_login_button()"
});
formatter.result({
  "duration": 166135432,
  "status": "passed"
});
formatter.match({
  "location": "LoginErrorStepDefinition.user_should_be_redirected_to_the_HomePage()"
});
formatter.result({
  "duration": 10413634877,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//body/div[@class \u003d \u0027core\u0027]/h1\"}\n  (Session info: chrome\u003d83.0.4103.116)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-E8NP0Q4\u0027, ip: \u0027192.168.225.218\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.116, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\BLACKG~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:54647}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 1db3861f89468e766538d2cbb075367f\n*** Element info: {Using\u003dxpath, value\u003d//body/div[@class \u003d \u0027core\u0027]/h1}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat errorStepDefinitions.LoginErrorStepDefinition.user_should_be_redirected_to_the_HomePage(LoginErrorStepDefinition.java:37)\r\n\tat ✽.Then user should be redirected to the HomePage(D:/WorkSpace/National_GBO/src/main/java/Features/loginerror.feature:7)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 12,
  "name": "Facebook Login Happy Path",
  "description": "",
  "id": "facebook-login-feature;facebook-login-happy-path;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user is on the facebook landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user enters \"adbkhb@jdk.com\" and \"sjdcn12\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "user clicks on login button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "user should be redirected to the HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginErrorStepDefinition.user_is_on_the_facebook_landing_page()"
});
formatter.result({
  "duration": 12424813800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "adbkhb@jdk.com",
      "offset": 13
    },
    {
      "val": "sjdcn12",
      "offset": 34
    }
  ],
  "location": "LoginErrorStepDefinition.user_enters_email_id_and_password(String,String)"
});
formatter.result({
  "duration": 643679638,
  "status": "passed"
});
formatter.match({
  "location": "LoginErrorStepDefinition.user_clicks_on_login_button()"
});
formatter.result({
  "duration": 178651255,
  "status": "passed"
});
formatter.match({
  "location": "LoginErrorStepDefinition.user_should_be_redirected_to_the_HomePage()"
});
formatter.result({
  "duration": 10029889742,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"xpath\",\"selector\":\"//body/div[@class \u003d \u0027core\u0027]/h1\"}\n  (Session info: chrome\u003d83.0.4103.116)\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-E8NP0Q4\u0027, ip: \u0027192.168.225.218\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 83.0.4103.116, chrome: {chromedriverVersion: 83.0.4103.39 (ccbf011cb2d2b..., userDataDir: C:\\Users\\BLACKG~1\\AppData\\L...}, goog:chromeOptions: {debuggerAddress: localhost:54686}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 3d64ca3376a4ac535d87a7ba38209184\n*** Element info: {Using\u003dxpath, value\u003d//body/div[@class \u003d \u0027core\u0027]/h1}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\r\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat errorStepDefinitions.LoginErrorStepDefinition.user_should_be_redirected_to_the_HomePage(LoginErrorStepDefinition.java:37)\r\n\tat ✽.Then user should be redirected to the HomePage(D:/WorkSpace/National_GBO/src/main/java/Features/loginerror.feature:7)\r\n",
  "status": "failed"
});
});