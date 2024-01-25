Feature: Booking Job Cancelled by Seller
  Description: Booking Job Cancelled
  Scenario: Booking Job cancelled flow with individual buyer and Individual seller
    Given Open browser and Login with individual Buyer for Booking job cancelled flow
    When Click the service dropdown from the buyer menubar
    And Book a Bookinglist job for seller
    And Logout from Buyer and login as seller to accept the Booking job
    And Logout from Seller and login as buyer to Award the booking job
    And Logout from Buyer and login as Seller to Cancel the booking job
    And Verify the transaction for Seller and seller should get half refund
    And Logout from Seller to check Buyer transaction
    And Logout from Seller and login as Buyer to verify the transaction and Buyer should get half
    Then Booking Job cancelled by seller