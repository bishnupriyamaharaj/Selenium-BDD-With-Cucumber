Feature: Add Quotation to accounting
  Description: Add Quotation to accounting
  Scenario: Add Quotation to accounting
    Given Open browser and Login with Seller and navigate to Accounting panel to add Quotation
    When Click on Quotation tab
    And Enter all the Mandatory Field and click submit for Quotation
    Then Verify that Quotation added successfully
