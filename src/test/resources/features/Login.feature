@login
Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User has navigated to login page
When User enters valid email address <username> and valid password <password>
And User clicks on Login button
Then User should get logged in successfully
Examples:
|username							|password|
|nsbsankar05@gmail.com|12345|
|nsbsankar06@gmail.com|12345|
|nsbsankar07@gmail.com|12345|

Scenario: Login with invalid credentials
Given User has navigated to login page
When User enters invalid email address and invalid password "123456"
And User clicks on Login button
Then User should get proper warning message

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email address "nsbsankar05@gmail.com" and invalid password "123456"
And User clicks on Login button
Then User should get proper warning message

Scenario: Login with invalid email address and valid password
Given User has navigated to login page
When User enters invalid email address and valid password "12345"
And User clicks on Login button
Then User should get proper warning message

Scenario: Login without providing any credentials
Given User has navigated to login page
When User dont enter email address and password
And User clicks on Login button
Then User should get proper warning message
