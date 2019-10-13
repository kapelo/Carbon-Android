## Test Case Scenarios
### Sign In
#### High Level Scenario: Ability to Sign In to app
#### Low Level Scenarios:
   1. 	Successful Login into app using valid username (phone number) and password (pin).
   2. 	An inactive user should not be able to Login successfully.
   3.   Unsuccessful Login to app using invalid username (phone number) and/or password (pin) and appropriate error message is displayed.
   4.   Successful Login with poor internet connection.
   4. 	Confirm that phone number field validates the correct count of phone number digits and does not accept more input.
   5.   Confirm that pin field validates the correct count of pin digits and does not accept more input.
   6.   Confirm that app displays an appropriate error message when device has no internet connection.
   7.   Confirm user cannot type text into phone number field.
   8.   Confirm user cannot type text into pin field.

### Airtime Recharge
#### High Level Scenario: Ability to recharge airtime
#### Low Level Scenarios:
   1.   Successful recharge of airtime using correct phone number and corresponding network and success message is displayed.
   2.   Unsuccessful recharge of airtime using correct phone number and wrong network.
   3.   Confirm user cannot type text into phone number field.
   4.   Confirm that app displays an appropriate error message when incorrect phone number format is entered.
   5.   Confirm that user cannot have a successful recharge if recharge amount is more than wallet account balance.
   6.   Confirm that user cannot have a successful recharge if recharge amount is more than ATM card account balance.
   7.   Confirm app fails gracefully when network is disconnected while airtime recharge is in progress i.e. user has clicked securely pay button.
   8.   Confirm user is prompted for pin before completing airtime recharge.
   9.   Confirm user cannot enter text into airtime amount field.
   10.  Confirm user can select a predefined amount.
   11.  Confirm phone number network is automatically selected when phone number has been fully entered.
   12.  Confirm user can successfully recharge airtime using "Buy more airtime" option.
   
### Fund Wallet
#### High Level Scenario: Ability to fund wallet using debit/ATM card
#### Low Level Scenarios:
   1.   Successful funding of wallet using saved debit/ATM card.
   2.   Successful funding of wallet using new debit/ATM card.
   3.   Confirm service charge is applied to total amount.
   4.   Confirm wallet balance is updated to reflect added amount.
   5.   Confirm user cannot type text into amount field.
   6.   Confirm app fails gracefully when network is disconnected while wallet funding is in progress i.e. user has clicked securely pay button.
   7.   Confirm user is prompted for pin before completing wallet funding.
   8.   Confirm app does not load indefinitely when network is turned off, user enters part of the pin, network is turned on and user enters the remaining part of the pin. After sometime app should terminate transaction and display appropriate message to user. But care should be taken whether transaction succeeded or not.

   
### View Wallet Transactions
#### High Level Scenario: Ability to view all wallet transactions
#### Low Level Scenarios:
   1.   Confirm user can filter transactions by wallet and that corresponding transactions are displayed.
   2.   Confirm user can filter transactions by wallet and date and that corresponding transactions are displayed.
   3.   Confirm user can filter transactions by date range.
   4.   Confirm user can filter transactions by "Last week".
   5.   Confirm user can filter transactions by "Last month".
   6.   Confirm user can filter transactions by "Last 3 months".
   7.   Confirm user can filter transactions by "All" transactions.
   8.   Confirm user can filter transactions by "Incoming" transactions.
   9.   Confirm user can filter transactions by "Outgoing" transactions.
   10.  Confirm user can filter transactions by any combination of filters.
   11.   Confirm user can scroll through transaction list.
   12.   Confirm user can select a transaction.
   13.   Confirm appropriate error message is displayed when connection is lost while loading wallet transactions.
