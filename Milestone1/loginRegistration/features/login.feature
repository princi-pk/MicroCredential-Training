
Feature: Login functionality

	Scenario: Successful login 
		Given I set post login endpoint
	  	When I enter the user id 101, password "pass" 
	  	Then "Login successful" message appears on the screen

	Scenario: Unsuccessful login due to incorrect password
		Given I set POST HTTP request
		When I enter the user id 101, password "aaaa" and submit
		Then I should get "Incorrect password"
		
	Scenario: Unsuccessful login as user doesn't exist
		Given I set post end point
		When User id is 66 and password is "pass"
		Then I expect "User id doesn't exist"