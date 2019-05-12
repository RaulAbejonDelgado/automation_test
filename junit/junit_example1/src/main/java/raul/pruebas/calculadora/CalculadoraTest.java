package raul.pruebas.calculadora;

import static org.junit.Assert.*;

import org.junit.*;


public class CalculadoraTest {

    static Calculadora calcu;
    int resul;

    /**
     * only one execution, before than any unit test
     */
    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass() inicializamos calculadora");
        calcu = new Calculadora();
    }

    /**
     * execution before runs once before each test
     *
     */
    @Before
    public void before(){
        System.out.println("Before()");

        resul = calcu.getTotal();
    }

    /**
     * test sumar function from Calculadora
     */
    @Test
    public void sumar() {
        int esperado = 8;
        resul = calcu.sumar(5,3);
        System.out.println("Sumar - "+calcu.getTotal());
        assertEquals(esperado,resul);
    }

    /**
     * test sumarSobrecarga funtion from Calculadora
     */
    @Test
    public void sumarSobrecarga() {
        int esperado = 10;
        resul = calcu.sumar( 5,1);
        resul = calcu.sumar(4);
        System.out.println("sumarSobrecarga - "+calcu.getTotal());

        assertEquals(esperado,resul);
    }

    /**
     * test restar funtion from Calculadora
     */
    @Test
    public void restar() {
        int esperado = 7;
        resul = calcu.restar(10,3);
        System.out.println("restar - "+calcu.getTotal());
        assertEquals(esperado,resul);
    }

    /**
     * test restarSobrecarga funtion from Calculadora
     */
    @Test
    public void restarSobrecarga() {
        int esperado = 5;
        resul  = calcu.restar(10,2);
        resul = calcu.restar(3);
        System.out.println("restarSobrecarga - "+calcu.getTotal());
        assertEquals(esperado,resul);
    }

    /**
     * runs once after each test
     *
     */
    @After
    public void  after(){
        System.out.println("After() se ejecuta despues del test de cada metodo");
    }

    /**
     * runs once after finish all test
     *
     */
    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass()");
    }
}