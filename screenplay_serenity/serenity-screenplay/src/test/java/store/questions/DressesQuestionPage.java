package store.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import store.ui.DressesCategoryPage;

public class DressesQuestionPage {

    public static Question<String> firstProductTitle(){
        return actor -> Text.of(DressesCategoryPage.FIRST_PRODUCT)
                .viewedBy(actor)
                .asString();
    };
}
