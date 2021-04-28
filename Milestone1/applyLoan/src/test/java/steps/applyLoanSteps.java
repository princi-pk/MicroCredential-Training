package steps;

import com.bankmanagemtsystem.applyLoan.controller.ApplyloanController;
import com.bankmanagemtsystem.applyLoan.model.LoanDetails;
import com.bankmanagemtsystem.applyLoan.model.UserLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class applyLoanSteps {
	
	ApplyloanController alc1;
	ApplyloanController alc2;
	
	LoanDetails loan1=new LoanDetails(101, "abcd" , "Home loan", 400000, 5, 43);
	LoanDetails loan2=new LoanDetails(303, "wwww" , "Home loan", 400000, 5, 43);
	UserLogin user1=new UserLogin(101,"abcd");
	UserLogin user2=new UserLogin(303,"wwww");
	
	String output1="";
	String output2="";

	@Given("I set post http request for applying loan")
	public void i_set_post_http_request_for_applying_loan() {
	    alc1=new ApplyloanController();
	}

	@When("I give all the loan details")
	public void i_give_all_the_loan_details() {
	    output1=alc1.applyLoanForRegisteredUsers(loan1, user1);
	}

	@Then("I get {string} message")
	public void i_get_message(String message1) {
	    assertEquals(output1, message1);
	}

	@Given("I pass the correct url")
	public void i_pass_the_correct_url() {
	    alc2=new ApplyloanController();
	}

	@When("I pass all details in json format")
	public void i_pass_all_details_in_json_format() {
	    output2=alc2.applyLoanForRegisteredUsers(loan2, user2);
	}

	@Then("Message {string} is received")
	public void message_is_received(String message2) {
	    assertEquals(output2, message2);
	}

}
