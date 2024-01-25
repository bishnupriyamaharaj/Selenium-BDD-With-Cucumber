Feature: Login to the Business seller Home page
  Description: User should able to login successfully to the Business seller Home page with valid credentials
Scenario: Login with valid username and password
  Given Open Browser
  When Enter the url
  And Click on Seller login Button
  And Enter valid username and password
  And click on submit button
  Then User should successfully login to the Home page
