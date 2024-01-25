Feature: Booking Job Cancelled by Buyer
  Description: Booking Job Cancelled
  Scenario: Booking Job cancelled flow with individual buyer and Individual seller
    Given Login with Buyer for Booking job
    When Click the service dropdown and book a booking list job
    And Logout from Buyer and login as seller to accept Booking job
    And Logout Seller and login as buyer to Award the booking job
    And Logout from Buyer and login seller for Cancel the booking job
    And Verify the transaction for seller and seller should get half refund
    And Logout from seller to check buyer transaction
    And Logout from seller and login as buyer to verify the transaction and buyer should get half
    Then Booking Job Cancelled by seller