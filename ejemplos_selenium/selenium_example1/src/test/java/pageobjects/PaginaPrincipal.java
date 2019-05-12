package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pruebas.BaseTestSuite;

import javax.xml.xpath.XPath;

public class PaginaPrincipal extends BaseTestSuite {

    @FindBy(xpath = "//html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]")
    WebElement tShirtTab;

    public PaginaPrincipal(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);

    }

    public void navigateToTShirt() {
        tShirtTab.click();

    }
}
