package searchedmotors.dogpile;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import searchedmotors.dogpile.steps.DogPileUSer;

@RunWith(SerenityRunner.class)
public class WhenExecuteSearch {

    @Steps
    DogPileUSer bot;

    @Managed
    WebDriver webDriver;

    @Test
    public void should_be_see_Expected_results() {
        bot.go_to_dog_pile();

        bot.search_by("hip hop");

        bot.should_be_have_results("hip");

    }

    @Test
    public void search_result_from_wikipedia_with_correct_result() {
        bot.go_to_dog_pile();

        bot.search_by("Drohne – Wikipedia");

        bot.should_be_have_wikipedia_results("Drohne - Wiktionary",
                "Complete with Selfie Camera · #1 Rated Beginner's Drone · Anyone Can Fly");

    }

}
