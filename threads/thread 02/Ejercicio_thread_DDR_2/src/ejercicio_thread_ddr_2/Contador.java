package ejercicio_thread_ddr_2;

public class Contador implements Runnable {

    //Atributos
    private int contador;
    private String nombre;
    private int limite;

    //Constructor
    public Contador(String nombre, int limite) {
        this.contador = 0;
        this.nombre = nombre;
        this.limite = limite;
    }

    @Override
    public void run() {

        //Recorremos los numeros
        while (contador <= limite) {
            System.out.println("Hilo " + nombre + ": " + contador);
            contador++;
        }

        //fin de hilo
        System.out.println("Hilo " + nombre + " ya ha acaado");
        
    }

}
