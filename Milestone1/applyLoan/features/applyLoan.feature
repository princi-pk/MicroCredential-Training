Feature: Apply Loan

	Scenario: Loan applied successfully
		Given I set post http request for applying loan
		When I give all the loan details 
		Then I get "Loan details of customer saved successfully" message
	
	Scenario: User is not found
		Given I pass the correct url
		When I pass all details in json format
		Then Message "User not found" is received 