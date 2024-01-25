Feature: BID Job completed end to end flow
  Description: BID Job completed
  Scenario: BID Job completed end to end flow with individual buyer and Individual seller
    Given Open browser and Login with individual seller for Bid job flow
    When Click the Bid Job tab from the menubar
    And Click the Live BID job
    And Enter all the mandatory field in create quotation section and click place bid button
    And Logout from seller and login as buyer and navigate to all project page
    And click on the above BID job and click on AWARD button and click proceed from the popup window
    And complete the payment
    And navigate back to buyer homepage logout and login as seller
    And Click MyBid button from menu bar and click on the Bid job which already awarded
    And Click on Sellerongoing button and complete the process
    And Logout from seller and login to Buyer again and navigate to my project and click on the sellerongoing BID job
    And click on workstart button
    And Logout from buyer and login as individual seller and My bid tab and click on the Work start project
    And Click on Mark complete button and complete the complete process and click next button
    And Logout from seller and login to Buyer to accept the bid completed job
    And Navigate to Your profile and click on buyer finance and verify the data
    And logout from buyer and login as seller
    And Navigate to Your profile and click on Seller finance and verify the data
    Then BID Job completed