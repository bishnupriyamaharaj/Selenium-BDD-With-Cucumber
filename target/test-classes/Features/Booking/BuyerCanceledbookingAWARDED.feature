Feature: Booking Job Cancelled by Buyer
  Description: Booking Job Cancelled
  Scenario: Booking Job cancelled flow with individual buyer and Individual seller
    Given Open browser and Login with individual Buyer for Booking job flow
    When Click the service dropdown from the menubar
    And Book a plumbing job for individual seller
    And Logout from Buyer and login as seller to accept the Booking list job
    And Logout from Seller and login as buyer to Award the booking list job
    And Cancel the booking list job
    And Verify the transaction for buyer and buyer should get half refund
    And Logout from buyer to check seller transaction
    And Logout from buyer and login as seller to verify the transaction and seller should get half
    Then Booking Job Cancelled