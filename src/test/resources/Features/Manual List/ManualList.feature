Feature: Login to the seller Home page for manual list job
  Description: User should able to login successfully to the seller Home page with valid credentials
  Scenario: Login with valid username and password for seller
    Given Open browser and Login with seller for Manuallist job
    When Navigate to Manuallist job tab and Click on Add project Button
    And Enter all the Mandatory Field for Manuallist job and click submit
    And Verify the created job and logout from Seller
    Then Seller should able to Create successfully manuallist job