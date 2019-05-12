package raul.pruebas.calculadora;

public class Calculadora {

    private int total;

    public Calculadora() {
        this.total = 0;
    }

    public int sumar(int a){

        this.total +=a;
        return this.total;

    }

    public int restar(int a){

        this.total -=a;
        return this.total;

    }


    public int sumar(int a, int b){

        this.total = a + b;
        return this.total;

    }

    public int restar(int a, int b){

        this.total = a - b;
        return this.total;
    }

    public int getTotal() {
        return total;
    }
}
