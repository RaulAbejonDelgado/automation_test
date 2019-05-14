package store.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageMyAccount {
    public static final Target SUBTITLE = Target.the("subtitle of my account page")
            .located(By.cssSelector(".info-account"));
}
