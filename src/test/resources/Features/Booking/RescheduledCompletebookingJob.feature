Feature: Reschedule and complete booking job
  Description: Reschedule and complete booking job
  Scenario: Reschedule and complete booking job
    Given Open browser and Login with individual Buyer for Reschedule and complete booking job
    When Click the service dropdown and Book a Bookinglist job
    And Logout from Buyer and login as seller to accept the job
    And Logout from Seller and login as buyer to Award the job
    And Reschedule the booking list job
    And Logout from Buyer and login to seller to change the status SellerongoingBuyerArrived
    And Logout from Seller and login to Buyer to verify the status SellerongoingBuyerArrived and click work start
    And Logout buyer and login seller to complete the job
    And Logout from seller and login as buyer to approve the job
    And Verify the transaction for buyer
    And Logout from Buyer and login as Seller
    And Verify the transaction for Seller
    Then logout seller and close