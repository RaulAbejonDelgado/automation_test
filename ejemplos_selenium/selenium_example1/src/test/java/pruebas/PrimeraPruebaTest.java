package pruebas;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


/**
 * This is a example of Seleniun combined with Junit.
 * This test will check one value from wikipedia page
 */
public class PrimeraPruebaTest extends BaseTestSuite {

    @Test
    public void search(){


        firefoxDriver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

        firefoxDriver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("toteking");
        firefoxDriver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys(Keys.ENTER);
        firefoxDriver.findElement(By.xpath("//a[contains(text(),'Giro de Italia')]")).click();

        String element = firefoxDriver.findElement(By.xpath("//div[@class='mw-parser-output']//table[2]//tbody[1]//tr[5]//td[2]")).getText();

        String EXPECTED_STAGES = "21";
        assert(element.equals(EXPECTED_STAGES));

    }

}
