package searchedmotors.dogpile.steps;

import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import searchedmotors.dogpile.pageobjects.DogPileSearchPage;
import searchedmotors.dogpile.pageobjects.ResultsPage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class DogPileUSer {
    String actor;

    DogPileSearchPage dogPileSearchPage;
    ResultsPage resultsPage = new ResultsPage();

    @Step("#actor go to dogfile")
    public void go_to_dog_pile() {
        dogPileSearchPage.open();
    }

    @Step("#actor does a search of {0} and click over search button ")
    public void search_by(String searchString) {
        dogPileSearchPage.search(searchString);

    }

    @Step("#actor should see results containing {0}")
    public void should_be_have_results(String expectedString) {
        List<String> res = resultsPage.getResults();

        res.replaceAll(String::toLowerCase);

        assertThat(res, Matchers.everyItem((containsString(expectedString))));

    }

    @Step("#actor should see expected text : {1}  in result with title: {0}")
    public void should_be_have_wikipedia_results(String resTitle, String resMessage) {
        String text = resultsPage.getTextByTitle(resTitle);
        System.out.println(text);

        assertThat(text, containsString(resMessage));

    }
}
