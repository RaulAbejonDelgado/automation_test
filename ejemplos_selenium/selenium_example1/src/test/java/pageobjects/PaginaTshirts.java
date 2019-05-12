package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaTshirts {

    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    WebElement product;

    @FindBy(xpath = "//button[@name='Submit']")
    WebElement buttonAddToCard;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")
    WebElement modalProceedToCheckOut;

    public PaginaTshirts(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);

    }

    public void doWorkFlow(){
        product.click();
        buttonAddToCard.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        modalProceedToCheckOut.click();
    }

}
