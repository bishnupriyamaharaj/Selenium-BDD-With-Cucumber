Feature: complete booking job
  Description: complete booking job
  Scenario: complete booking job
    Given Open browser and Login with individual Buyer for complete booking job
    When Click the service dropdown and Book a Booking job
    And Logout from Buyer and login as seller to accept
    And Logout from Seller and login as buyer to Award
    And Logout from Buyer and login to seller to make the status SellerongoingBuyerArrived
    And Logout from Seller and login to Buyer to make work start
    And Logout buyer and login seller to complete the booking job
    And Logout from seller and login as buyer to approve the booking job
    And Verify the buyer transaction
    And Logout Buyer and login as Seller
    And  Verify the Seller transaction
    Then logout seller and close the app