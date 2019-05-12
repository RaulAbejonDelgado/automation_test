package dogpile.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://duckduckgo.com/")
public class SearchPage extends PageObject {

    @FindBy(xpath = "//input[@id='search_form_input_homepage']")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//input[@id='search_button_homepage']")
    private WebElementFacade buttonSearch;

    public void search(String searchString) {
        searchInput.type(searchString);

    }

    public void pressButton() {
        buttonSearch.click();
    }

}
