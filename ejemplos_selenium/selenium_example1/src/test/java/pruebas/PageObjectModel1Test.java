package pruebas;

import org.junit.Test;

import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class PageObjectModel1Test extends BaseTestSuite {

    @Test
    public void doPurchasePageObj() {
        firefoxDriver.get("http://automationpractice.com/index.php");

        //login
        paginaLogin.isAssignIn();
        paginaLogin.loggin("drohne@gmail.com","automation");
        paginaPrincipal.navigateToTShirt();
        paginaTshirts.doWorkFlow();
        String res = paginaShoppingCart.navigate();

        assert(res.equals(EXPECTED_MSG_PO_SUCCESS));
        Logger.getLogger(PageObjectModel1Test.class.getName()).log(INFO,"Exito");

    }

}
