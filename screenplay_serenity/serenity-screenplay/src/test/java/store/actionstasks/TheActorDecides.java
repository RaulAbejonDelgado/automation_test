package store.actionstasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import store.constan.Constan;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TheActorDecides implements Task {


    public TheActorDecides(){}

    public static Performable goToWeb() {
        return instrumented(TheActorDecides.class);
    }


    @Override
    @Step("{0} decides do login with his account")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Navigate.toWeb(Constan.PAGINA_LOG_IN)); //try


    }
}
