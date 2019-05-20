package store.actionstasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Order implements Task {

    private  String order;

    public Order(String order){
        this.order = order;
    }

    public static Performable orderFromAtoZ(){
        return Instrumented
                .instanceOf(Order.class)
                .withProperties("Product Name: A to Z");
    }

    @Override
    @Step("{0} order by : #order ")
    public <T extends Actor> void performAs(T actor) {

        //First down scroll to look selector
        actor.attemptsTo(Scroll.to(By.id("selectProductSort")),
                SelectFromOptions.byVisibleText(order).from(By.id("selectProductSort")),
                Click.on("//span[@class='cat-name']"));

    }


}
