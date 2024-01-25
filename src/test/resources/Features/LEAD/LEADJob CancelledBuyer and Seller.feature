Feature: LEAD Job cancelled end to end flow
  Description: LEAD Job cancelled
Scenario: LEAD Job cancelled end to end flow
  Given Open browser and Login with buyer
  When Click on POST A JOB Button and Enter all the Mandatory Field for LEAD job and click submit
  And Logout the Buyer and login as Seller
  And Click on Lead job tab from the menubar and Click on show details from the first lead job
  And Click on Pay Now from the LEAD job details page and Click on Yes from the Confirmation popup
  And enter amount and select cancel from the dropdown and click on submit button
  And Get the text from the page to verify the status
  And logout from seller and Login as Buyer
  And Click on All project option and Search the previous LEAD project
  And Verify the status
  Then Logout from the Buyer and close the webpage
