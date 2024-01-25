Feature: LEAD Job completed end to end flow
  Description: LEAD Job completed
Scenario: LEAD Job completed end to end flow with individual buyer and Individual seller
  Given Open browser and Login with individual buyer
  When Click on POST A JOB Button
  And Enter all the Mandatory Field for LEAD job and click submit
  And Logout the individual Buyer and login as individual seller
  And Click on Lead job tab from the bar
  And Click on show details from the first lead job
  And Click on Pay Now from the LEAD job details page
  And Click on Yes from the Confirmation popup
  And Click on Sellerongoing button
  And Logout and Login as Individual Buyer
  And Click on All project option and click on first LEAD job
  And Click on Work Start button
  And Click on Job Done
  And Click on Yes from the Job done confirmation popup
  And Click on close rating popup
  Then Buyer should able to Complete successfully A LEAD job end to end flow
