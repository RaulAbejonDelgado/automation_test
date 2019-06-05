package store.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MainPage {

    public static final Target CATEGORY_WOMEN = Target.the("Boton category womens")
            .located(By.xpath("//a[@title='Women']"));

    public static final Target CATEGORY_DRESSES = Target.the("Boton category dresses")
            .located(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[2]/a[1]"));
}
