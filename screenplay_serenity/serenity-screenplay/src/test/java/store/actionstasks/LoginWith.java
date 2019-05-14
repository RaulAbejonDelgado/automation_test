package store.actionstasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import store.ui.PageLogin;

public class LoginWith implements Task {

    private final String user;
    private final String password;

    public LoginWith(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static LoginWithBuilder user(String user) {
        return new LoginWithBuilder(user);
    }

    @Override
    @Step("{0} do login with user : #user and password #password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(user).into(PageLogin.USER),
                Enter.theValue(password).into(PageLogin.PASSWORD),
                Click.on(PageLogin.BOTON_SIGN_IN));
    }

    public static class LoginWithBuilder{
        private String user ;

        public LoginWithBuilder(String user){
            this.user = user;

        }

        public Performable password(String password) {
            return Instrumented.instanceOf(LoginWith.class).withProperties(user, password);
        }



    }
}
