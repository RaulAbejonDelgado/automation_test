package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaShoppingCart {

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']//span")
    WebElement summaryProceedToCheckOut;

    @FindBy(xpath = "//button[@name='processAddress']//span")
    WebElement addressProceedToCheckOut;

    @FindBy(xpath = "//input[@id='cgv']")
    WebElement checkShippingProceedToCheckOut;

    @FindBy(xpath = "//button[@name='processCarrier']//span")
    WebElement shippingProceedToCheckOut;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement paymentProceedToCheckOut;

    @FindBy(xpath = "//p[@id='cart_navigation']//span")
    WebElement confirmOrder;

    @FindBy(xpath = "//strong[contains(text(),'Your order on My Store is complete.')]")
    WebElement orderResult;


    public PaginaShoppingCart(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);

    }

    public String navigate(){
        summaryProceedToCheckOut.click();
        addressProceedToCheckOut.click();
        checkShippingProceedToCheckOut.click();
        shippingProceedToCheckOut.click();
        paymentProceedToCheckOut.click();
        confirmOrder.click();
        return orderResult.getText();

    }

}
