package store.actionstasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import store.ui.MainPage;

public class GoToCategoy implements Task {

    private Target categoryTarget;
    private static String selectedCategory;

    public GoToCategoy(Target category) {

        this.categoryTarget = category;


    }

    @Override
    @Step("{0} decide select go to women category")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(this.categoryTarget));

    }

    public static Performable women(){
        selectedCategory = "Category women";
        return Instrumented
                .instanceOf(GoToCategoy.class)
                .withProperties(MainPage.CATEGORY_WOMEN);

    }

    public static Performable dresses() {
        selectedCategory = "Category dresses";
        return Instrumented
                .instanceOf(GoToCategoy.class)
                .withProperties(MainPage.CATEGORY_DRESSES);
    }
}
