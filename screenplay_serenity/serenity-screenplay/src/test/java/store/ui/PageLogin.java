package store.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageLogin {
    public static Target USER = Target.the("User input").located(By.id("email"));
    public static Target PASSWORD = Target.the("Password input").located(By.id("passwd"));
    public static Target BOTON_SIGN_IN = Target.the("Login button").located(By.id("SubmitLogin"));
}
