package serenity.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;
import serenity.pageobjects.SearchPage;
import serenity.pageobjects.ResultsPage;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.Matchers;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class StepUser extends ScenarioActor {
    String actor;


    @Steps(shared = true) // this object will be shared by other class
    SearchPage duckDuckSearchPage;

    @Steps(shared = true) // this object will be shared by other class
    ResultsPage resultsPage = new ResultsPage();

    @Step("#actor navigate to duckduckgo")
    public void goToDuckDuck() {
        duckDuckSearchPage.setDefaultBaseUrl("https://duckduckgo.com/");
        duckDuckSearchPage.open();
    }

    @Step("#actor does search in duckduckgo of hip hop:{0}")
    public void searchBy(String searchString){
        duckDuckSearchPage.search(searchString);
        duckDuckSearchPage.pressButton();

    }

    @Step("#actor should see expected results containing: {0} text")
    public void shouldBeHaveResults(String expectedString){
        List<String> res = resultsPage.getResults();

        res.replaceAll(String::toLowerCase);

        assertThat(res, Matchers.everyItem((containsString(expectedString))));

    }

    @Step("#actor should see expected text : {0} in result with title: {1}")
    public void shouldBeHaveWikipediaResults(String resMessage, String resTitle ) {
        String text = resultsPage.getTextByTitle(resTitle);
        System.out.println(text);

        assertThat(text, containsString(resMessage));

    }
}
