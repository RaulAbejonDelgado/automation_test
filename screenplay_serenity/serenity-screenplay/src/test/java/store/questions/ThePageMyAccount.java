package store.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import store.ui.PageMyAccount;

public class ThePageMyAccount {
    public static  Question<String> subtitle() {
        return actor -> Text.of(PageMyAccount.SUBTITLE)
                .viewedBy(actor)
                .asString();
    }
}
