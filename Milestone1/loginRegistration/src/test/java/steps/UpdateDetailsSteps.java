package steps;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.bankmanagementsystem.loginRegistration.controller.CustomerController;
import com.bankmanagementsystem.loginRegistration.model.Customer;
import com.bankmanagementsystem.loginRegistration.service.CustomerService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateDetailsSteps {

	CustomerService cs1;
	CustomerService cs2;
	CustomerController cc;
	String result1 = "";
	String result2 = "";
	String result3 = "";

	@Given("I set POST request for account update")
	public void i_set_POST_request_for_account_update() {
		cs1 = new CustomerService();
	}

	@When("I enter the user acccount details")
	public void i_enter_the_user_acccount_details() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d1 = sdf.parse("1990-02-02");
		Customer cust1 = new Customer(101, "Lily", "pass", "101/1afs", "India", "TamilNadu", "lily@gmail.com",
				"ABCDE00101", 1111111111L, d1, "savings");
		Customer cust2 = new Customer(101, "Lily", "pass", "101/1afs", "India", "Himachal Pradesh", "lily@gmail.com",
				"ABCDE00101", 1111111111L, d1, "current");
		result1 = cs1.updateAccount(cust2, cust1);
	}

	@Then("I get {string} message")
	public void i_get_message(String msg1) {
		assertEquals(result1, msg1);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////

	@Given("I type the url for account update")
	public void i_type_the_url_for_account_update() {
		cc = new CustomerController();
	}

	@When("I enter invalid user id")
	public void enterInvalidUserId() throws ParseException {
		int userid = 33;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d3 = sdf.parse("1990-01-01");
		Customer cust3 = new Customer(101, "Julie", "pass", "102/2afs", "India", "Kerala", "julie@gmail.com",
				"ABCDE00102", 2222222222L, d3, "savings");
		result2 = cc.updateAccountDetails(userid, cust3);
	}

	@Then("Error message appears: {string}")
	public void error_message_appears(String msg2) {
		assertEquals(result2, msg2);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Given("I give post endpoint")
	public void i_give_post_endpoint() {
		cs2 = new CustomerService();
	}

	@When("I pass wrong user id in user account details")
	public void userDetailsEntered() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d1 = sdf.parse("1990-02-02");
		Customer cust1 = new Customer(101, "Lily", "pass", "101/1afs", "India", "TamilNadu", "lily@gmail.com",
				"ABCDE00101", 1111111111L, d1, "savings");
		Customer cust2 = new Customer(103, "Lily", "pass", "101/1afs", "India", "Himachal Pradesh", "lily@gmail.com",
				"ABCDE00101", 1111111111L, d1, "current");
		result3 = cs2.updateAccount(cust2, cust1);
	}

	@Then("I receive {string} notification")
	public void i_receive_notification(String msg3) {
		assertEquals(result3, msg3);
	}
}
