package com.raul.rest.cucumber.assure.definition;

import com.raul.rest.cucumber.assure.pojo.User;
import com.raul.rest.cucumber.assure.steps.UserAPISteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;

import org.junit.runner.RunWith;



@RunWith(SerenityRunner.class)
public class UserCrudStepDefn {

	@Before
	public void setup()
	{
    	RestAssured.baseURI = "http://localhost:3000/";

	}
	
	@After
	public void tearDown()
	{
        RestAssured.reset();
	}

	@Steps(shared = true)
	UserAPISteps userAPISteps;

	//@Given("^I provide user \"([^\"]*)\" and \"([^\"]*)\"$")
	/*-----------Get-----------*/
	@Given("^Get users$")
    public void i_get_users() {
		userAPISteps.sendGetUsers();
	}

	@When("^i haves res i process data on User")
	public void i_haves_res_i_process_data_on_user() {
		userAPISteps.processResponse();
	}

	@Then("^i do operations over res data (.*) (.*) (.*)")
	public void i_do_operations_over_res_data(String position, String name, String password) {
		userAPISteps.checkUser(position,name,password);

	}
	/*-----------Post-----------*/
	@Given("i want post the next object with this values (.*) (.*)$")
	public void i_want_post_the_next_object_with_this_values(String name, String password) {
		userAPISteps.procesingData(name, password);
	}

	@When("^data is alright to do post$")
	public void data_is_alright_to_do_post() {
		userAPISteps.postUser();
	}

	@Then("^i check http response and i verify the new data with the given data (.*) (.*)$")
	public void i_check_http_response_and_i_verify_the_new_data(String name, String password){
		userAPISteps.verifyData(name,password);
	}


	@Given("^I will delete a user sending delete action by id (.*)$")
	public void i_will_delete_a_user_by_given_id(int id) {
		userAPISteps .deleteUserById(id);

	}

	@When("^after i will check the http response$")
	public void after_i_will_check_the_http_response() {
		userAPISteps.afterIWillCheckTheHttpResponse();
	}


	@Then("^the response status should be (.*)$")
	public void the_response_status_should_be_status(String status) {
		userAPISteps.theResponseStatusShouldBeStatus(status);
	}

	@Given("^i will update a user by id (.*) with name (.*) and password (.*)$")
	public void i_will_update_a_user_by_id(int id, String name, String password) {
		User u = new User(name,password);
		userAPISteps.iWillUpdateAUserByIdId(id, u);
	}

	@When("^after i send update action i will process the response$")
	public void afterISendUpdateActionIWillProcessTheResponse() {

		userAPISteps.afterISendUpdateActionIWillProcessTheResponse();
	}
}
