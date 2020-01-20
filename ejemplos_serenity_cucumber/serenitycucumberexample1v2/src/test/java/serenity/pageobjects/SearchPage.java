package serenity.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://duckduckgo.com/")
public class SearchPage extends PageObject {

    @FindBy(xpath = "//form[@id='search_form_homepage_top']//input[@name='q']")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//form[@id='search_form_homepage_top']//input[contains(@class,'js-search-button')]")
    private WebElementFacade buttonSearch;

    public void search(String searchString) {
        searchInput.type(searchString);

    }

    public void pressButton() {
        buttonSearch.click();
    }

}
