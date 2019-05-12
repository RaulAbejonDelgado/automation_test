package com.raul.rest.cucumber.assure.definition;

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
	UserAPISteps loginAPI;

	//@Given("^I provide user \"([^\"]*)\" and \"([^\"]*)\"$")
	/*-----------Get-----------*/
	@Given("^Get users$")
    public void i_get_users() {
		loginAPI.sendGetUsers();
	}

	@When("^i haves res i process data on User")
	public void i_haves_res_i_process_data_on_user() {
		loginAPI.processResponse();
	}

	@Then("^i do operations over res data (.*) (.*) (.*)")
	public void i_do_operations_over_res_data(String position, String name, String password) {
		loginAPI.checkUser(position,name,password);

	}
	/*-----------Post-----------*/
	@Given("i want post the next object with this values (.*) (.*)$")
	public void i_want_post_the_next_object_with_this_values(String name, String password) {
		loginAPI.procesingData(name, password);
	}

	@When("^data is alright to do post$")
	public void data_is_alright_to_do_post() {
		loginAPI.postUser();
	}

	@Then("^i check http response and i verify the new data with the given data (.*) (.*)$")
	public void i_check_http_response_and_i_verify_the_new_data(String name, String password){
		loginAPI.verifyData(name,password);
	}
}
