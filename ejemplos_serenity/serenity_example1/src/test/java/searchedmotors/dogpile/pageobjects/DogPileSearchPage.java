package searchedmotors.dogpile.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://duckduckgo.com/")
public class DogPileSearchPage extends PageObject {

    @FindBy(xpath = "//input[@id='search_form_input_homepage']")
    private WebElementFacade searchInput;

    @FindBy(xpath = "//input[@id='search_button_homepage']")
    private WebElementFacade buttonSearch;

//    public DogPileSearchPage(WebDriver webDriver){
//        PageFactory.initElements(webDriver,this);
//
//    };

    public void search(String searchString) {
        searchInput.type(searchString);
        buttonSearch.click();
    }

}
