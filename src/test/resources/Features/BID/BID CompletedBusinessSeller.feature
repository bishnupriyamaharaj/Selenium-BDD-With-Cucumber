Feature: BID Job completed end to end flow for business seller
  Description: BID Job completed for business seller
  Scenario: BID Job completed end to end flow with for business seller
    Given Open browser and Login with for business seller
    When Click the Bid Job tab from the menubar and click the LIVE BID job
    And Enter all the mandatory field and click place bid button
    And Logout from seller and login as buyer and navigate to all project page to award the BID JOB
    And complete the payment as buyer
    And buyer logout and login as seller and Click on Sellerongoing button and complete the process
    And Logout from seller and login to Buyer again and click on workstart button
    And Logout from buyer and login as seller to Click on Mark complete button
    And Logout from seller and login to Buyer to accept the bid completed job and verify the buyer finance
    And logout from buyer and login as seller and verify the Seller finance
    Then BID Job completed and close the window