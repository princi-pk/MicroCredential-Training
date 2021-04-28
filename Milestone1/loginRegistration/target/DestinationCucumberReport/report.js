$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/login.feature");
formatter.feature({
  "name": "Login functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful login",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I set post login endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginSteps.i_set_post_login_endpoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the user id 101, password \"pass\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginSteps.loginCredentials(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"Login successful\" message appears on the screen",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginSteps.successfulResult(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Unsuccessful login due to incorrect password",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I set POST HTTP request",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginSteps.posthttpRequest()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the user id 101, password \"aaaa\" and submit",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginSteps.inputUserdetails(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I should get \"Incorrect password\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginSteps.unsuccessfulResultAsIncorrectPassword(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Unsuccessful login as user doesn\u0027t exist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I set post end point",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.LoginSteps.setpostEndPoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User id is 66 and password is \"pass\"",
  "keyword": "When "
});
formatter.match({
  "location": "steps.LoginSteps.i_enter_user_id_password(int,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect \"User id doesn\u0027t exist\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.LoginSteps.unsuccessfulResultAsWrongUserId(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:features/updateDetails.feature");
formatter.feature({
  "name": "Account details update",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Successful updation of account details",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I set POST request for account update",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_set_POST_request_for_account_update()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter the user acccount details",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_enter_the_user_acccount_details()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I get \"Lily, your account details are updated successfully\" message",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_get_message(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User id does not exist",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I type the url for account update",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_type_the_url_for_account_update()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter invalid user id",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.enterInvalidUserId()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Error message appears: \"User id 33 doesn\u0027t exist\"",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.error_message_appears(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "User id does not match",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I give post endpoint",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_give_post_endpoint()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I pass wrong user id in user account details",
  "keyword": "When "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.userDetailsEntered()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I receive \"User id doesn\u0027t match\" notification",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.UpdateDetailsSteps.i_receive_notification(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
});