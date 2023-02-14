@all
Feature: Registration functionality

Scenario: Register with only mandatory fields
Given User navigates to Register account page
When User enters details into below fields
|firstname|Bhavani|
|lastname|Sankar|
|telephone|9876543210|
|password|12345|
And User selects privacy policy and clicks on continue button
Then User account should get created successfully

Scenario: Register with all fields
Given User navigates to Register account page
When User enters details into below fields
|firstname|Bhavani|
|lastname|Sankar|
|telephone|9876543210|
|password|12345|
And User selects yes for newsletter
And User selects privacy policy and clicks on continue button
Then User account should get created successfully

Scenario: Register with duplicate email address
Given User navigates to Register account page
When User enters details into below fields with duplicate email
|firstname|Bhavani|
|lastname|Sankar|
|email|nsbsankar05@gmail.com|
|telephone|9876543210|
|password|12345|
And User selects privacy policy and clicks on continue button
Then User should get a proper warning message about duplicate email

Scenario: Register without providing any details
Given User navigates to Register account page
When User dont enter any details into fields
And Clicks on continue button
Then User should get proper warning messages for every mandatory fields

