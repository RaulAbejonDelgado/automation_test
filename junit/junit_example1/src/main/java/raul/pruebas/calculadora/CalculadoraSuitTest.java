package raul.pruebas.calculadora;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test managedment
 */
@RunWith(value = Suite.class)
@Suite.SuiteClasses({
        CalculadoraTest.class,
        CalculadoraParametroTest.class
})
public class CalculadoraSuitTest {

}