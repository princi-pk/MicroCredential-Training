package steps;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.bankmanagementsystem.loginRegistration.controller.CustomerController;
import com.bankmanagementsystem.loginRegistration.model.Customer;
import com.bankmanagementsystem.loginRegistration.model.UserLogin;
import com.bankmanagementsystem.loginRegistration.service.CustomerService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	CustomerService cs1;
	CustomerService cs2;
	CustomerController cc;
	String result1 = "";
	String result2 = "";
	String result3 = "";

	@Given("I set post login endpoint")
	public void i_set_post_login_endpoint() {
		cs1 = new CustomerService();
	}

	@When("I enter the user id {int}, password {string}")
	public void loginCredentials(int id1, String password1) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d1 = sdf.parse("1990-02-02");
		Customer cust1 = new Customer(101, "Lily", "pass", "101/1afs", "India", "TamilNadu", "lily@gmail.com",
				"ABCDE00101", 1111111111L, d1, "savings");
		result1 = cs1.userIdAndPasswordIsCorrect(cust1, id1, password1);
	}

	@Then("{string} message appears on the screen")
	public void successfulResult(String msg1) {
		assertEquals(result1, msg1);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Given("I set POST HTTP request")
	public void posthttpRequest() {
		cs2 = new CustomerService();
	}

	@When("I enter the user id {int}, password {string} and submit")
	public void inputUserdetails(int id2, String password2) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d2 = sdf.parse("1990-01-01");
		Customer cust2 = new Customer(101, "Julie", "pass", "102/2afs", "India", "Kerala", "julie@gmail.com",
				"ABCDE00102", 2222222222L, d2, "savings");
		result2 = cs2.userIdAndPasswordIsCorrect(cust2, id2, password2);
	}

	@Then("I should get {string}")
	public void unsuccessfulResultAsIncorrectPassword(String msg2) {
		assertEquals(result2, msg2);
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Given("I set post end point")
	public void setpostEndPoint() {
		cc = new CustomerController();
	}

	@When("User id is {int} and password is {string}")
	public void i_enter_user_id_password(int id3, String password3) throws ParseException {
		UserLogin user3 = new UserLogin(id3, password3);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d3 = sdf.parse("1990-01-01");
		Customer cust3 = new Customer(101, "Julie", "pass", "102/2afs", "India", "Kerala", "julie@gmail.com",
				"ABCDE00102", 2222222222L, d3, "savings");
		result3 = cc.loginExistingUser(user3, cust3);
	}

	@Then("I expect {string}")
	public void unsuccessfulResultAsWrongUserId(String msg3) {
		assertEquals(result3, msg3);
	}

}
