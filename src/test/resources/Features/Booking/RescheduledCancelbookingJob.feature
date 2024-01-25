Feature: Reschedule and cancel booking job
  Description: Reschedule and cancel booking job
  Scenario: Reschedule and cancel booking job
    Given Open browser and Login with individual Buyer for Reschedule and cancel booking job
    When Click the service dropdown and Book a Bookinglist job for seller
    And Logout from Buyer and login as seller to accept the Reschedule Booking job
    And Logout from Seller and login as buyer to Award the Reschedule booking job
    And Reschedule the booking list job and click cancel
    And Verify the transaction for buyer and Buyer should get half refund
    And Logout from Buyer and login as Seller to check the transaction
   And Reschedule and cancel booking job
    Then logout and close