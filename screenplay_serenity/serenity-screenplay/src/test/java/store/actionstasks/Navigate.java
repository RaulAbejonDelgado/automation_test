package store.actionstasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class Navigate implements Interaction {

    private final String url;

    public Navigate(String url){
        this.url = url;

    };

    @Override
    @Step("{0} go to web shop")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.url(url));

    }

    /**
     *
     * @param url
     * @return a instance of navigate with url 'clase instrumented'
     * when return we will execute content of the method
     */
    public  static Performable toWeb(String url){
        return Instrumented.instanceOf(Navigate.class).withProperties(url);


    }

}
