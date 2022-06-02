package ejercicio_thread_ddr_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_thread_DDR_2 {

    public static void main(String[] args) {

        //Creamos los objetos
        Contador c1 = new Contador("Contador 1", 40);
        Contador c2 = new Contador("Contador 2", 50);
        Contador c3 = new Contador("Contador 3", 20);
        Contador c4 = new Contador("Contador 4", 70);

        //Creamos los hilos
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c3);
        Thread t4 = new Thread(c4);

        //Iniciamos los hilos
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        //Esperamos a que acaben los hilos
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio_thread_DDR_2.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Fin
        System.out.println("Fin del programa");

    }

}
