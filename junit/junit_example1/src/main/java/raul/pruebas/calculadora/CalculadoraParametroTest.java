package raul.pruebas.calculadora;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Parameterized.class -> managed parameterized test need
 * Cuando se ejecuta junit con este runner @RunWith(value = Parameterized.class)
 * va a buscar todo lo que tenga la anotacion @Parameterized.Parameters
 */
@RunWith(value = Parameterized.class)
public class CalculadoraParametroTest {

    private int a, b, exp;

    @Parameterized.Parameters
    public static  Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][]{
            {5,7,12},
            {1,1,2},
            {1,2,3}
        });

    }

    /**
     *
     * @param a
     * @param b
     * @param exp
     */

    public CalculadoraParametroTest(int a, int b, int exp){

        this.a = a;
        this.b = b;
        this.exp = exp;
    }

    @Test
    public void testAdd(){
        Calculadora calculadora = new Calculadora();
        int resul = calculadora.sumar(a,b);
        assertEquals(exp,resul);
    }

}