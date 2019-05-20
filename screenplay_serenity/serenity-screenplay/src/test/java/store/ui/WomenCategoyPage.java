package store.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class WomenCategoyPage {
    public static Target FIRST_PRODUCT = Target.the("Title of first product")
            .located(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]"));
}
