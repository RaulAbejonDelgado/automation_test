package serenity.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import serenity.pageobjects.ResultsPage;
import serenity.steps.StepUser;

public class StepDefinitionUser {

    @Steps(shared = true) // this object will be shared by other class
            StepUser bot;

    @Steps
    ResultsPage resultsPage = new ResultsPage();

    @Given("^(.*) navigate to duckduckgo$")
    public void go_to_duck_duck(String userName) {
        bot.isCalled(userName);
        bot.goToDuckDuck();
    }

    @When("^(.*) does search in duckduckgo of hip hop: (.*)$")
    public void search_by(String userName, String searchString){
        bot.isCalled(userName);
        bot.searchBy(searchString);
    }

    @Then("^(.*) should see expected results containing: (.*) text$")
    public void should_be_have_results(String userName, String expectedString){
        bot.isCalled(userName);
        bot.shouldBeHaveResults(expectedString);
    }

    @Then("^should see expected text : (.*) in result with title: (.*)$")
    public void should_be_have_wikipedia_results(String resMessage, String resTitle ) {
        bot.shouldBeHaveWikipediaResults(resMessage,resTitle);
    }
}

