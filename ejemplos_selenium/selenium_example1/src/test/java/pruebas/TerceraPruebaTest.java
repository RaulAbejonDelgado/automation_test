package pruebas;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This test will check purchese item ui navigation workflow with out page object model
 */
public class TerceraPruebaTest  {

        FirefoxDriver firefoxDriver = new FirefoxDriver();

        @Test
        public void doPurchase(){
            firefoxDriver.get("http://automationpractice.com/index.php");

            //login
            WebElement clickLogin = firefoxDriver.findElement(By.className("login"));
            clickLogin.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement setUser = firefoxDriver.findElement(By.cssSelector("#email"));
            setUser.sendKeys("drohne@gmail.com");
            WebElement setpass = firefoxDriver.findElement(By.cssSelector("#passwd"));
            setpass.sendKeys("automation");
            WebElement buttonLoging = firefoxDriver.findElement(By.id("SubmitLogin"));
            buttonLoging.click();

            //nagigation to t-shirt section
            firefoxDriver.findElement(
                    By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[3]/a[1]"))
                    .click();

        }
}
