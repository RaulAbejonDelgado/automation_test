package store;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import store.actionstasks.GoToCategoy;
import store.actionstasks.LoginWith;
import store.actionstasks.Order;
import store.actionstasks.TheActorDecides;
import store.questions.WomenQuestionPage;

import static java.time.temporal.ChronoUnit.SECONDS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class WhenUserProductOrderBy {
    Actor actor ;

    //serenity managed live workflow
    @Managed
    WebDriver webDriver;

    @Before
    public void prepareScenario(){
        actor = Actor.named("Tester Bot");

        actor.can(BrowseTheWeb.with(webDriver));
    }

    /**
     * The actor will go to web shop
     * The actor will do login in her account
     * The actor will check the 'My account'msg
     */
    @Test
    public void productOrderBy() {

        //If the actor cant find out any element, he will wait 5 seconds to retry
        BrowseTheWeb.as(actor).setImplicitTimeout(5, SECONDS);

        //given
        actor.has(TheActorDecides.goToWeb());

        //when
        actor.attemptsTo(LoginWith.user("drohne@gmail.com").password("automation"));

        //when
        actor.attemptsTo(GoToCategoy.women());

        //second when
        actor.attemptsTo(Order.orderFromAtoZ());

        //then
        actor.should(seeThat("First result is :", WomenQuestionPage.firstProductTitle(),equalTo("Faded Short Sleeve T-shirts")));
    }
}
