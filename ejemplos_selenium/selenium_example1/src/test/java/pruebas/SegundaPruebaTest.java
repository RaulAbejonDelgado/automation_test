package pruebas;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SegundaPruebaTest extends BaseTestSuite {
    ArrayList<String> codeLogic = new ArrayList<>() ;

    @Test
    public void getCode() {
        firefoxDriver.get("https://twitter.com/electrikfc?lang=en");

       WebElement content = firefoxDriver.findElement(By.cssSelector(".u-lg-size2of3:nth-child(2)"));

        ArrayList<String> codigos = processText(content.getText()) ;

        //codigos.forEach(System.out::println);
        //codeLogic.forEach(System.out::println);
        for(int i= 0; i < codigos.size() ; i++ ){
            System.out.println(codigos.get(i) + " -> "+ codeLogic.get(i));
        }
    }

    /**
     *
     * @param pageText page Content text
     * @return String with codes string
     */
    private ArrayList<String> processText(String pageText ){
        ArrayList<String> codigos = new ArrayList<>() ;
        String[] tweets;
        tweets = pageText.split("\n");

        codigos = getCodeLines(tweets);


        return processCodeLines(codigos);
    }

    private ArrayList<String> processCodeLines(ArrayList<String> codigos) {
        ArrayList<String> code = new ArrayList<>() ;
        ArrayList<String> codeOnly = new ArrayList<>() ;

        for(String c : codigos){
            int to = c.indexOf(" ");
            code.add(c.substring(to));


        }

        for(String c : code){
            //if the first character of string is " " we replace it to "" else its ok
            c = (c.indexOf(" ") == 0 ) ? c.substring(1) : c ;
            int toSecondEmptyChar = c.indexOf(" ");
            codeOnly.add(c.substring(0,toSecondEmptyChar));
            codeLogic.add(c.substring(toSecondEmptyChar));
        }

        return codeOnly;

    }

    private ArrayList<String> getCodeLines(String[] tweets) {
        ArrayList<String> codigos = new ArrayList<>() ;

        for (String tweet : tweets) {
            if(tweet.contains("Código")) {
                int from = tweet.indexOf("Código");
                int to = tweet.indexOf("http");
                codigos.add(tweet.substring(from, to));
            }
        }

        return codigos;

    }
}
