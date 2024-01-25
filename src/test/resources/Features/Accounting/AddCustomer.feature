Feature: Add customer to accounting
  Description: Add customer to accounting
  Scenario: Add customer to accounting
    Given Open browser and Login with Seller and navigate to Accounting panel
    When Click on customer vendor tab
    And Enter all the Mandatory Field and click submit
    Then Verify that customer added successfully
