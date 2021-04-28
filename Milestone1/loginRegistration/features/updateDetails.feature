Feature: Account details update

Scenario: Successful updation of account details
		Given  I set POST request for account update
  	When I enter the user acccount details
  	Then I get "Lily, your account details are updated successfully" message 

	Scenario: User id does not exist
		Given I type the url for account update
		When I enter invalid user id 
		Then Error message appears: "User id 33 doesn't exist"
		
	Scenario: User id does not match
		Given I give post endpoint
		When I pass wrong user id in user account details
		Then I receive "User id doesn't match" notification