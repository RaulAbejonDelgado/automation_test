package searchedmotors.dogpile.pageobjects;

import net.serenitybdd.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends PageObject {
    public static final String EXPECTED_TITLE_RES = "result__a";

    public List<String> getResults() {
        return findAll(EXPECTED_TITLE_RES)
                .stream()
                .map(elemnt -> elemnt.getAttribute("textContent"))
                .collect(Collectors.toList());
    }

    public String getTextByTitle(String resTitle) {
        return findBy("//a[contains(@class, 'result__a') and contains(.,'{0}')]", resTitle)
                .then().findBy("//div[contains(@class, 'result__snippet js-result-snippet')]")
                .then().getText();
    }
}
