Feature: BID Job Created
  Description: BID Job Created successfully
  Scenario: BID Job created successfully with buyer
    Given Open browser and Login with individual buyer for Bid job
    When Click on POST A JOB Button for Bid job
    And Enter all the Mandatory Field for BID job and click submit
    And Logout the individual Buyer
    Then Buyer should able to Create successfully BID job