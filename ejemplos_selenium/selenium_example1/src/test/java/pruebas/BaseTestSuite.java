package pruebas;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageobjects.PaginaLogin;
import pageobjects.PaginaPrincipal;
import pageobjects.PaginaShoppingCart;
import pageobjects.PaginaTshirts;


public class BaseTestSuite {
    protected WebDriver firefoxDriver ;
    protected PaginaLogin paginaLogin;
    protected PaginaPrincipal paginaPrincipal;
    protected PaginaTshirts paginaTshirts;
    protected PaginaShoppingCart paginaShoppingCart;

    protected String EXPECTED_MSG_PO_SUCCESS = "Your order on My Store is complete.";
    protected String USER = "drohne@gmail.com";
    protected String CONTR = "automation";

    private void initPageLogin(WebDriver webDriver){
        paginaLogin = new PaginaLogin(webDriver);
    }
    private void initPageMain(WebDriver webDriver){
        paginaPrincipal = new PaginaPrincipal(webDriver);
    };
    private void initPageTshrits(WebDriver webDriver){ paginaTshirts = new PaginaTshirts(webDriver);}
    private void paginaShoppingCart(WebDriver webDriver){ paginaShoppingCart = new PaginaShoppingCart(webDriver);}

    @Before
    public void openDriver(){

        firefoxDriver = new FirefoxDriver();
        initPageLogin(firefoxDriver);
        initPageMain(firefoxDriver);
        initPageTshrits(firefoxDriver);
        paginaShoppingCart(firefoxDriver);
    }

    @After
    public void closeDrive() {
        firefoxDriver.close();

    }
}
