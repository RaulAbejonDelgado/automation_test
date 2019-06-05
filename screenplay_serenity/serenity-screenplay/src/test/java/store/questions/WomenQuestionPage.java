package store.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import store.ui.WomenCategoyPage;

public class WomenQuestionPage {

    public static Question<String> firstProductTitle(){
        return actor -> Text.of(WomenCategoyPage.FIRST_PRODUCT)
                .viewedBy(actor)
                .asString();
    };
}
