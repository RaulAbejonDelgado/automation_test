package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
    @FindBy(className = "login")
    private WebElement buttonSignIn;

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "passwd")
    private WebElement passBox;

    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;


    public PaginaLogin(WebDriver webDriver){
        PageFactory.initElements(webDriver,this);

    };

    public void loggin(String email, String password) {
        emailBox.sendKeys(email);
        passBox.sendKeys(password);
        submitButton.click();
    }

    public void isAssignIn(){
        buttonSignIn.click();
    }

}
