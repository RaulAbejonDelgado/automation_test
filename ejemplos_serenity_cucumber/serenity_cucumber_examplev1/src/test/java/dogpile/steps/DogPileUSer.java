package dogpile.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dogpile.pageobjects.SearchPage;
import dogpile.pageobjects.ResultsPage;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class DogPileUSer  {
    String actor;


    @Steps
    SearchPage dogPileSearchPage;

    @Steps
    ResultsPage resultsPage = new ResultsPage();

    @Given("The user navigate to duckduckgo")
    public void go_to_dog_pile() {
        dogPileSearchPage.setDefaultBaseUrl("https://duckduckgo.com/");
        dogPileSearchPage.open();
    }

    @When("The user does search in duckduckgo of hip hop: (.*)")
    public void search_by(String searchString){
        dogPileSearchPage.search(searchString);
        dogPileSearchPage.pressButton();

    }

    @Then("^The user should see expected results containing: (.*) text$")
    public void should_be_have_results(String expectedString){
        List<String> res = resultsPage.getResults();

        res.replaceAll(String::toLowerCase);

        assertThat(res, Matchers.everyItem((containsString(expectedString))));

    }

    @Then("^should see expected text : (.*) in result with title: (.*)$")
    public void should_be_have_wikipedia_results(String resMessage, String resTitle ) {
        String text = resultsPage.getTextByTitle(resTitle);
        System.out.println(text);

        assertThat(text, containsString(resMessage));

    }
}
