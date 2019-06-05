package store;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import store.actionstasks.*;
import store.questions.DressesQuestionPage;
import store.questions.TheMyAccountPage;
import store.questions.WomenQuestionPage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class WhenUserGoToDresses {

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
    public void checkDresses() {
        //given
        actor.has(TheActorDecides.goToWeb());

        //when
        actor.attemptsTo(LoginWith.user("drohne@gmail.com").password("automation"));

        //when
        actor.attemptsTo(GoToCategoy.dresses());

        //second when
        actor.attemptsTo(Order.orderFromAtoZ());

        //then
        actor.should(seeThat("First result is :", DressesQuestionPage.firstProductTitle(),equalTo("Printed Dress")));

    }
}
